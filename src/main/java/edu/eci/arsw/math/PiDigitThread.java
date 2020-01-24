package edu.eci.arsw.math;

public class PiDigitThread extends  Thread {
    private int  liminf;
    private int count;
    private byte[] digits;
    private static int DigitsPerSum = 8;
    private static double Epsilon = 1e-17;

    public PiDigitThread(int liminf,int count){
        this.liminf=liminf;
        this.count = count;
        digits=new byte[count];
    }

    public byte[] getDigits() {
        return digits;
    }


    @Override
    public  void run() {
        double sum = 0;

        for (int i = 0; i < count; i++) {
            if (i % DigitsPerSum == 0) {
                sum = 4 * PiDigits.sum(1, liminf)
                        - 2 * PiDigits.sum(4, liminf)
                        - PiDigits.sum(5, liminf)
                        - PiDigits.sum(6, liminf);

                liminf += DigitsPerSum;
            }

            sum = 16 * (sum - Math.floor(sum));
            digits[i]=(byte)sum;
        }

    }


}
