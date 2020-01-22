package edu.eci.arsw.math;

import java.util.ArrayList;
import java.util.List;

///  <summary>
///  An implementation of the Bailey-Borwein-Plouffe formula for calculating hexadecimal
///  digits of pi.
///  https://en.wikipedia.org/wiki/Bailey%E2%80%93Borwein%E2%80%93Plouffe_formula
///  *** Translated from C# code: https://github.com/mmoroney/DigitsOfPi ***
///  </summary>
public class PiDigits {

    private static int DigitsPerSum = 8;
    private  static double Epsilon = 1e-17;

    
    /**
     * Returns a range of hexadecimal digits of pi.
     * @param start The starting location of the range.
     * @param count The number of digits to return
     * @return An array containing the hexadecimal digits.
     */
    public  static byte[] getDigits(int start, int count,int n) {
        if (start < 0) {
            throw new RuntimeException("Invalid Interval");
        }

        if (count < 0) {
            throw new RuntimeException("Invalid Interval");
        }
        if (n>count){
            throw  new RuntimeException("Invaid number of threads");
        }
        int step = count / n;
        int sobrante = count % n;

        List<PiDigitThread> threads = new ArrayList<>();
        for(int i=0; i<n; i++){
            PiDigitThread thread;
            if(i == n-1){
                thread = new PiDigitThread(start,step+sobrante);
                thread.run();


            }else {
                thread = new PiDigitThread(start, step);

                thread.run();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            start += step+1;
            threads.add(thread);
        }
        byte[] digitos = null;
        byte[] c = threads.get(0).getDigits();

        for(int i = 1; i<threads.size();i++){
            digitos = threads.get(i).getDigits();
            byte[] temp = new byte[c.length + digitos.length];
            //System.out.println(digitos);
            System.arraycopy(c , 0 ,temp , 0 , c.length);
            System.arraycopy(digitos , 0 ,temp , c.length , digitos.length);
            temp=new byte[temp.length];
            System.arraycopy(temp , 0 ,c , 0 , temp.length);
        }
        System.out.println(c + " ajfdjh");




        //PiDigitThread prueba=new PiDigitThread(start,count);
        //prueba.run();
        return c;
    }

    /// <summary>
    /// Returns the sum of 16^(n - k)/(8 * k + m) from 0 to k.
    /// </summary>
    /// <param name="m"></param>
    /// <param name="n"></param>
    /// <returns></returns>
    private static double sum(int m, int n) {
        double sum = 0;
        int d = m;
        int power = n;

        while (true) {
            double term;

            if (power > 0) {
                term = (double) hexExponentModulo(power, d) / d;
            } else {
                term = Math.pow(16, power) / d;
                if (term < Epsilon) {
                    break;
                }
            }

            sum += term;
            power--;
            d += 8;
        }

        return sum;
    }

    /// <summary>
    /// Return 16^p mod m.
    /// </summary>
    /// <param name="p"></param>
    /// <param name="m"></param>
    /// <returns></returns>
    private static int hexExponentModulo(int p, int m) {
        int power = 1;
        while (power * 2 <= p) {
            power *= 2;
        }

        int result = 1;

        while (power > 0) {
            if (p >= power) {
                result *= 16;
                result %= m;
                p -= power;
            }

            power /= 2;

            if (power > 0) {
                result *= result;
                result %= m;
            }
        }

        return result;
    }

}
