/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.math;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 */
public class PiCalcTest {

    public PiCalcTest() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void piGenTest() throws Exception {

        byte[] expected = new byte[]{
            0x2, 0x4, 0x3, 0xF, 0x6, 0xA, 0x8, 0x8,
            0x8, 0x5, 0xA, 0x3, 0x0, 0x8, 0xD, 0x3,
            0x1, 0x3, 0x1, 0x9, 0x8, 0xA, 0x2, 0xE,
            0x0, 0x3, 0x7, 0x0, 0x7, 0x3, 0x4, 0x4,
            0xA, 0x4, 0x0, 0x9, 0x3, 0x8, 0x2, 0x2,
            0x2, 0x9, 0x9, 0xF, 0x3, 0x1, 0xD, 0x0,
            0x0, 0x8, 0x2, 0xE, 0xF, 0xA, 0x9, 0x8,
            0xE, 0xC, 0x4, 0xE, 0x6, 0xC, 0x8, 0x9,
            0x4, 0x5, 0x2, 0x8, 0x2, 0x1, 0xE, 0x6,
            0x3, 0x8, 0xD, 0x0, 0x1, 0x3, 0x7, 0x7,};

        for (int start = 0; start < expected.length; start++) {
            for (int count = 1; count < expected.length - start; count++) {
                byte[] digits = PiDigits.getDigits(start, count,1);
                assertEquals(count, digits.length);

                for (int i = 0; i < digits.length; i++) {
                    assertEquals(expected[start + i], digits[i]);
                }
            }
        }
    }

    @Test
    public void piGenTest2() throws Exception {

        byte[] expected = new byte[]{
                0x2, 0x4, 0x3, 0xF, 0x6, 0xA, 0x8, 0x8,
                0x8, 0x5, 0xA, 0x3, 0x0, 0x8, 0xD, 0x3,
                0x1, 0x3, 0x1, 0x9, 0x8, 0xA, 0x2, 0xE,
                0x0, 0x3, 0x7, 0x0, 0x7, 0x3, 0x4, 0x4,
                0xA, 0x4, 0x0, 0x9, 0x3, 0x8, 0x2, 0x2,
                0x2, 0x9, 0x9, 0xF, 0x3, 0x1, 0xD, 0x0,
                0x0, 0x8, 0x2, 0xE, 0xF, 0xA, 0x9, 0x8,
                0xE, 0xC, 0x4, 0xE, 0x6, 0xC, 0x8, 0x9,
                0x4, 0x5, 0x2, 0x8, 0x2, 0x1, 0xE, 0x6,
                0x3, 0x8, 0xD, 0x0, 0x1, 0x3, 0x7, 0x7,};

        for (int start = 0; start < expected.length; start++) {
            for (int count = 10; count < expected.length - start; count++) {
                byte[] digits = PiDigits.getDigits(start, count,9);
                assertEquals(count, digits.length);

                for (int i = 0; i < digits.length; i++) {
                    assertEquals(expected[start + i], digits[i]);
                }
            }
        }
    }

    @Test
    public void twoThreads() {
        byte[] oneThreads = PiDigits.getDigits(0, 500,1);
        byte[] twoThreads = PiDigits.getDigits(0, 500,2);
        System.out.println(oneThreads);
        System.out.println(twoThreads);
        assertEquals(oneThreads.length, twoThreads.length);
        for (int i=0;i<oneThreads.length;i++){
            assertEquals(oneThreads[i], twoThreads[i]);
        }
    }

    @Test
    public void fiveThreads() {
        byte[] oneThreads = PiDigits.getDigits(200, 550,1);
        byte[] fiveThreads = PiDigits.getDigits(200, 550,5);
        assertEquals(oneThreads.length, fiveThreads.length);

        for (int i=0;i<oneThreads.length;i++){
            assertEquals(oneThreads[i], fiveThreads[i]);
        }
    }

    @Test
    public void variousThreads() {
        byte[] oneThreads = PiDigits.getDigits(500, 70,1);
        byte[] fourThreads = PiDigits.getDigits(500, 70,5);
        byte[] sevenThreads = PiDigits.getDigits(500, 70,7);
        assertEquals(oneThreads.length, fourThreads.length);
        assertEquals(fourThreads.length, sevenThreads.length);

        for (int i=0;i<oneThreads.length;i++){
            assertEquals(oneThreads[i], fourThreads[i]);
            assertEquals(fourThreads[i], sevenThreads[i]);
        }
    }
}
