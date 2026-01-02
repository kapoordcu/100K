package gk.practic.prefixsum;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/*
Key Use Cases for Prefix Sum:
1. Subarray Sum Problems:
— In many problems, we’re asked to find the sum of elements in a subarray, or we may be asked to check for a subarray that satisfies a particular condition (e.g., the sum equals a target).
— Prefix sums help reduce the time complexity of finding the sum of any subarray from O(N) to O(1) by simply subtracting two precomputed values.

2. Subarrays with Target Sum:
— In problems where we need to find subarrays whose sum equals a specific target, we can use prefix sums combined with a hash map to track previously seen sums and quickly identify whether a subarray with the desired sum exists.
 */
public class FindSumFromItoJ {

    public static int[] findSubarraySumToK(int k, int[] array) {
        //int[] array = {1,-4, 6, 8, -4, 2, 5};
        int[] prefixSum = new int[array.length];
        prefixSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            prefixSum[i] = prefixSum[i-1] + array[i];
        }
        for (int i = 1; i < array.length; i++) {
            if(prefixSum[i] -prefixSum[i-1]==k) {
                return null;
            }
        }
        return null;
    }

    public static int findSubarraySumBF(int i, int j, int[] array) {
        if(i > array.length || j < 0 || i > j ) {
            return -1;
        }
        int sum = 0;
        for (int k = i; k <=j ; k++) {
            sum += array[k];
        }
        return sum;
    }

    public static int findSubarraySum(int i, int j, int[] array) {
        if(i > array.length || j < 0 || i > j ) {
            return -1;
        }
        for (int k = 1; k < array.length; k++) {
            array[k] += array[k-1];
        }

        return array[j] - array[i-1];
    }

    @Test
    public void getSum() {
        int[] array = {1,2,3,4,5,6,7,8};
//        int sumBF= findSubarraySumBF(3, 5, array);
//        assertTrue(sumBF==15);
        int sumOpt = findSubarraySum(3, 5, array);

        assertTrue(sumOpt==15);
    }

    @Test
    public void getSum2() {
        int[] array = {1,-4, 6, 8, -4, 2, 5};
//        int sumBF = findSubarraySumBF(1, 5, array);
//        assertTrue(sumBF==8);
        int sumOpt = findSubarraySumBF(1, 5, array);
        assertTrue(sumOpt==8);
    }

    @Test
    public void getSumK() {
        int[] array = {1,-4, 6, 8, -4, 2, 5};
//        int sumBF = findSubarraySumBF(1, 5, array);
//        assertTrue(sumBF==8);
        int[] sumOpt = findSubarraySumToK(10, array);
        assertTrue(sumOpt[0]==1);
        assertTrue(sumOpt[1]==3);
    }
}
