package edu.eci.arsw.math;

public class PiDigitThread extends  Thread {
    private long  liminf;
    private int count;
    private byte[] digits;
    private static int DigitsPerSum = 8;
    private static double Epsilon = 1e-17;

    public PiDigitThread(long liminf,int count){
        this.liminf=liminf;
        this.count = count;
        digits=new byte[count];
    }

    public byte[] getDigits() {
        return digits;
    }


    @Override
    public  void run() {
        System.out.println("aaaaa");
        double sum = 0;

        for (int i = 0; i < count; i++) {
            if (i % DigitsPerSum == 0) {
                sum = 4 * sum(1, liminf)
                        - 2 * sum(4, liminf)
                        - sum(5, liminf)
                        - sum(6, liminf);

                liminf += DigitsPerSum;
            }

            sum = 16 * (sum - Math.floor(sum));
            digits[i]=(byte)sum;
        }
        System.out.println("bbbbb");
        //System.out.println(digits.length);

    }


    private static double sum(long m, long n) {
        double sum = 0;
        long d = m;
        long power = n;

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
    private static int hexExponentModulo(long p, long m) {
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
