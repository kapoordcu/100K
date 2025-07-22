package gk.practic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BitWise {
    public int TwosComplement(int number) {
        return (~number + 1);
    }

    public static int findIthBitSetOrUnset(int number, int i) {
        int mask = 1 << i;
        int result = number & mask;
        return result == 0 ? 0 : 1;
    }

    public void setIthBit(int number, int i) {
        int mask = 1 << i;
        number = number | mask;
    }

    public void clearIthBit(int number, int i) {
        int mask  = ~(1 << i);
        number = number & mask;
    }

    public int convertAtoBNumberOfBits(int a, int b) {
        int xor = a ^ b;
        return numberOfBitsSet(xor);
    }

    private int numberOfBitsSet(int number) {
        int temp = number >> 1; // Keep shifting by one right and keep checking results -> Log n + 1
        int result = number;
        int bits = 0;
        while (result != 0) {
            number = number & (number-1);
            bits++;
            result = number;
        }
        return bits;
    }

    @Test
    public void TestSetBit() {
        int bits = numberOfBitsSet(13);
        assertTrue(bits==3);
        bits = numberOfBitsSet(15);
        assertTrue(bits==4);
    }

    @Test
    public void testTwosComplement() {
        int bits = TwosComplement(5);
        assertTrue(bits==-5);
    }
}
