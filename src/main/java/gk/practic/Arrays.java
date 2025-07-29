package gk.practic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Arrays {

    public int kadaneOn(int[] arr) {
        //  {-5, 4,6,-3, 4,-1};
        int maxSum = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            if(currSum > maxSum) {
                maxSum = currSum;
            }
            if(currSum < 0) {
                currSum = 0;
            }
        }
        return maxSum;
    }
    public int kadaneBR(int[] arr) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sum = Math.max(sum, sumupto(arr, i, j));
            }
        }
        return sum;
    }

    private int sumupto(int[] arr, int i, int j) {
       int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public int mooreVotingAlgorithm(int[] arr) {
        int element = arr[0];
        int count = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            if(count==0) {
                count = 1;
                element = arr[i];
            } else if(arr[i] != element) {
                count--;
            } else {
                count++;
            }

        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==element) {
                counter++;
            }
        }
        return counter > arr.length/2 ? element : -1;
    }

    public int bfUsingMap(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
        }
        return freq.entrySet()
                .stream().max(Map.Entry.comparingByValue())
                .filter(v -> v.getValue() > arr.length/2)
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public int bf(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int freq = 0;
            for (int j = 0; j <arr.length ; j++) {
                if(arr[j]==element) {
                    freq++;
                }
            }
            if(freq > arr.length/2) {
                return element;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int[] arr = {5, 1,4,1,1};
        int[] arr2 = {5, 4,4,1,1};
        assertTrue(bf(arr)==1);
        assertTrue(bfUsingMap(arr)==1);
        assertTrue(mooreVotingAlgorithm(arr)==1);
        assertTrue(bf(arr2)==-1);
        assertTrue(bfUsingMap(arr2)==-1);
        assertTrue(mooreVotingAlgorithm(arr2)==-1);
    }

    @Test
    public void testKadane() {
        int[] arr = {-5, 4,6,-3, 4,-1};
        int[] arr2 = {5, -4,-2,6,-1};
        assertTrue(kadaneBR(arr)==11);
       // assertTrue(kadaneOn(arr)==11);
        assertTrue(kadaneOn(arr2)==6);
    }
}
