package gk.practic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.Assert.assertTrue;

public class Arrays {

    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
            if(heap.size() > k) {
                heap.remove();
            }
        }
        return heap.peek();
    }

    @Test
    public void testKthLargest() {
       int[] arr = {2, 7, 4, 0, 1, 8, 13, 9};
       int num = findKthLargest(arr, 3);
       assertTrue(num==8);
        num = findKthLargest(arr, 4);
        assertTrue(num==7);
        num = findKthLargest(arr, 2);
        assertTrue(num==9);
    }

    public int[] sumOFSubarrayK(int[] a, int sum) {
        int[] resultIndex = new int[2];
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();

        for (int i = 0; i < a.length -1; i++) {
            currentSum += a[i];
            if(currentSum - sum == 0) {
                resultIndex[0] = 0;
                resultIndex[1] = i;
                return resultIndex;
            }

            if(sumMap.containsKey(currentSum - sum)) {
                resultIndex[0] = sumMap.get(currentSum - sum) + 1;
                resultIndex[1] = i;
                return resultIndex;
            }
            sumMap.put(currentSum, i);
        }
        return resultIndex;
    }

    public int[] sumOFSubarrayKLargest(int[] a, int sum) {
        int[] resultIndex = new int[2];
        int currentSum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        int largest = 0;
        for (int i = 0; i < a.length -1; i++) {
            currentSum += a[i];
            if(currentSum - sum == 0) {
                if (i + 1 > largest) {
                    largest = i + 1;
                    resultIndex[0] = 0;
                    resultIndex[1] = i;
                }
            }
            if(sumMap.containsKey(currentSum - sum)) {
                int start = sumMap.get(currentSum - sum) + 1;

                if(i - start + 1 > largest) {
                    largest = i - start + 1;
                    resultIndex[0] = start;
                    resultIndex[1] = i;
                }
            }
            sumMap.put(currentSum, i);
        }
        return resultIndex;
    }

    public int[] largestSubarryaWIthEqual0n1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 0) {
                a[i] = -1;
            }
        }
        int[] array = sumOFSubarrayKLargest(a, 0);
        return array;

    }

    @Test
    public void testsumOFSubarrayKLargest() {
        int[] arr = { 0, 1, 1, 0, 1, 0, 0};
        int[] result = largestSubarryaWIthEqual0n1(arr);
        assertTrue(result[0]==0);
        assertTrue(result[1]==5);
    }

    @Test
    public void testsumOFSubarrayK() {
        int[] arr = {10, 15, -5, 15, -10, 5};
        int[] tapped = sumOFSubarrayK(arr, 5);
        assertTrue(tapped[0]==3);
        assertTrue(tapped[1]==4);
    }

    public int calculateStockProfit(int[] arr) {
        int minSoFar = Integer.MAX_VALUE;
        int profitMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length-1; i++) {
            minSoFar = Math.min(minSoFar, arr[i]);
            profitMax = Math.max(profitMax, arr[i] - minSoFar);
        }
        return profitMax;
    }

    public int calculateStockProfitWithSpace(int[] arr) {
        int profit = 0;
        int[] maxArrayProfit = new int[arr.length];
        maxArrayProfit[arr.length - 1] = arr[arr.length - 1];
        for (int k = arr.length - 2; k >= 0; k--) {
           maxArrayProfit[k] = Math.max(arr[k], maxArrayProfit[k+1]);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            profit = Math.max(profit,maxArrayProfit[i] - arr[i]);
        }
        return profit;
    }

    @Test
    public void waterTap() {
        int[] arr = {3,1,2,4,0,1,3,2};
        int tapped = calculateTappedWater(arr);
        assertTrue(tapped==8);
    }

    private int calculateTappedWater(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        left[0]=arr[0];
        right[arr.length-1]=arr[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            left[i] = Math.max(arr[i], left[i-1]);
        }
        for (int i = arr.length - 2; i >= 0 ; i--) {
            right[i] = Math.max(arr[i], right[i+1]);
        }
        int water = 0;
        for (int i = 0; i < arr.length; i++) {
            water += Math.min(left[i], right[i]) - arr[i];
        }
        return water;
    }

    @Test
    public void singleStockProfile() {
        int[] arr = {3,5,1,7,4,9,3};
        int[] arr2 = {6, 7, 9, 3, 4, 1};
        int profit = calculateStockProfit(arr);
        assertTrue(profit==8);
        profit = calculateStockProfit(arr2);
        assertTrue(profit==3);
    }

    @Test
    public void multipleStockProfile() {
        int[] arr = {5,2,7,3,6,1,2,4};
        int profit = calculateStockProfitMulti(arr);
        assertTrue(profit==11);
        int[] arr2 = {5,2,7,3,16,1,2,4};
        profit = calculateStockProfitMulti(arr2);
        assertTrue(profit==21);

    }

    private int calculateStockProfitMulti(int[] arr) {
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i-1]) {
                profit += arr[i] - arr[i-1];
            }
        }
        return profit;
    }

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
