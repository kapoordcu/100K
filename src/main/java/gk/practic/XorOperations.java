package gk.practic;

import org.junit.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class XorOperations {
    public int findOnlyNonRepeatingElementInOtherRepeating(int[] number) {
        int nonreapeating = 0;
        for (int i = 0; i < number.length; i++) {
            nonreapeating = nonreapeating ^ number[i];
        }
        return nonreapeating;
    }

    private int findnonRepeatingAllOtherKTimesMe(int[] numbers, int k) {
        int maxBits = 0;
        for (int i = 0; i < numbers.length; i++) {
            maxBits = Math.max(maxBits, Integer.toBinaryString(numbers[i]).length());

        }
        int[] arrOfBits = sumNumberBitwise(numbers, maxBits);
        StringBuffer s = new StringBuffer();
        for (int i = 0; i < arrOfBits.length; i++) {
            s.append(arrOfBits[i] % k);
        }
        return Integer.parseInt(s.reverse().toString(), 2);
    }

    private int[] sumNumberBitwise(int[] numbers, int maxBits) {
        int[] arrOfBits = new int[maxBits];
        for (int i = 0; i < maxBits; i++) {
            for (int j = 0; j < numbers.length; j++) {
                int num = numbers[j];
                if((num & (1 << i)) != 0) {
                    arrOfBits[i]++;
                }
            }
        }
        return arrOfBits;
    }

    private int[] findnonRepeatingTwoElementInOtherRepeatingEmpty(int[] nums) {
        //  3, 1, 8, 4, 7, 1, 4, 7 -> 3, 8
        // Step 1: XOR all elements → result is x ^ y (the two unique elements)
        int xorAll = 0;
        for (int num : nums) {
            xorAll ^= num;
        }

        // Step 2: Find a rightmost set bit (differs between x and y)
        int rightmostSetBit = xorAll & -xorAll;

        // Step 3: Divide elements into two groups based on the set bit
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & rightmostSetBit) != 0) {
                x ^= num; // One unique number
            } else {
                y ^= num; // The other unique number
            }
        }

        // Output the result
        System.out.println("The two non-repeating elements are: " + x + " and " + y);
        int []res = new int[2];
        res[0] = x;
        res[1] = y;
        return res;
    }



    @Test
    public void testfindnonRepeatingAllOtherKTimes() {
        int []arr = { 3, 6, 1, 3, 6, 3, 6};
        int nonreapeating = findnonRepeatingAllOtherKTimesMe(arr, 3);

        assertTrue(nonreapeating==1);
    }

    @Test
    public void testfindnonRepeatingAllOtherKTimes2() {
        int []arr = { 3,7,1,5,1,7,3,1,3,7};
        int nonreapeating = findnonRepeatingAllOtherKTimesMe(arr, 3);

        assertTrue(nonreapeating==5);
    }

    @Test
    public void nonRepeatingElementInOtherRepeating() {
        int []arr = { 3, 6, 1, 5, 6, 3, 5};
        int nonreapeating = findOnlyNonRepeatingElementInOtherRepeating(arr);

        assertTrue(nonreapeating==1);
    }

    @Test
    public void nonRepeatingTwoElementInOtherRepeatingEmpty() {
        int []arr = { 3, 1, 8, 4, 7, 1, 4, 7};
        int[] result = findnonRepeatingTwoElementInOtherRepeatingEmpty(arr);
        List<Integer> collect = Arrays.stream(result).boxed().toList();
        assertTrue(collect.contains(3) &&
                collect.contains(8) &&
                collect.size()==2);
    }

    @Test
    public void nonRepeatingTwoElementInOtherRepeatingEmpty2() {
        int []arr = { 1,6,2,8,6,1};
        int[] result = findnonRepeatingTwoElementInOtherRepeatingEmpty(arr);
        List<Integer> collect = Arrays.stream(result).boxed().toList();
        assertTrue(collect.contains(2) &&
                collect.contains(8) &&
                collect.size()==2);
    }

}
