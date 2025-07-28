package gk.practic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class Arrays {

    public int mooreVotingAlgorithm(int[] arr) {
        return arr[arr.length-1];
    }

    public int bfUsingMap(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int element: arr) {
            freq.put(element, freq.getOrDefault(element, 0) + 1);
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
        assertTrue(bf(arr2)==-1);
        assertTrue(bfUsingMap(arr2)==-1);
    }
}
