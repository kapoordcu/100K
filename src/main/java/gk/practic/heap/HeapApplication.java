package gk.practic.heap;

import java.util.*;

public class HeapApplication {

    public static void main(String[] args) {
//        int[] arr = {24, 16, 18, 11, 14, 15, 10};
//        int[] arr = {10, 30, 50, 20, 35, 15};
//        int[] miniArray = {20, 10, 35};
        HeapApplication application = new HeapApplication();
//        int len = arr2.length;
//        for (int i = len/2 ; i >=0 ; i--) {
//            application.heapify(arr2, len, i);
//        }
//        int[] a = application.insertInMaxHeap(arr,20);
//       for (Integer s: a) {
//           System.out.print(s + " ");
//       }
//       application.removeFromMaxHeap(a);
        //application.printInHeapSort(arr, arr.length);
//        application.heapSort(arr, arr.length);
//        for (int i: arr) {
//            System.out.print(i + " ");
//        }
       int[] nums = {1, 0, 0};
       int k = 2;
        int[] ints = application.topKFrequent(nums, k);
        for (int i  : ints) {
            System.out.print(i + " ");
        }
    }


    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mapFreq = new HashMap<>();
        for (Integer num: nums) {
            mapFreq.put(num, mapFreq.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparing(mapFreq::get));
        for (Integer key: mapFreq.keySet()) {
            queue.add(key);
            if(queue.size() > k) {
                queue.poll();
            }
        }
        int[] result = new int[k];
        for (int i = 0; i <= queue.size(); i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private void heapSort(int[] arr, int len) {
        printInHeapSort(arr, len);
        for (int i = len-1; i >0 ; i--) {
            swapArrayNumbers(arr, i, 0);
            heapify(arr, len -1, 0);
        }
    }


    private void printInHeapSort(int[] arr, int length) {
        for (int i = length/2; i >=0 ; i--) {
            heapify(arr, length, i);
        }
    }

    public void heapify(int[] arr, int len, int i) {
        int largest = i;
        int left = 2*i+1;
        int right=2*i+2;
        if(left < len && arr[left] > arr[largest]) {
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if(largest != i) {
            swapArrayNumbers(arr, i, largest);
            heapify(arr, len, largest);
        }
    }

    public int[] insertInMaxHeap(int[] arr, int val) {
        int[] newArray;
        if(arr == null) {
            arr = new int[1];
            arr[0] = val;
            return arr;
        } else {
            newArray = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
            }
            newArray[arr.length] = val;
            int i = newArray.length - 1;
            while (i > 0) {
                int parent = (i-1)/2;
                if(newArray[parent] < newArray[i]) {
                    swapArrayNumbers(newArray, i, parent);
                    i = parent;
                } else {
                    break;
                }
            }
        }
        return newArray;
    }

    public int[] removeFromMaxHeap(int[] arr) {
        int[] newA = new int[arr.length-1];
        for (int i = 0; i < arr.length - 2; i++) {
            newA[i+1] = arr[i + 1];
        }
        newA[0] = arr[arr.length -1];
        int i = 0;

        int len = newA.length;
        int larger = 0;
        while (i < len) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < len && right < len) {
                if(newA[left] < newA[right]) {
                    larger = 2 * i + 2;
                } else {
                    larger = 2 * i + 1;
                }
                if(newA[i] < newA[larger]) {
                    swapArrayNumbers(newA, i, larger);
                    i = larger;
                } else {
                    break;
                }
            } else if(left < len) {
                if(newA[i] < newA[left]) {
                    swapArrayNumbers(newA, i, left);
                    i = left;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return arr;
    }

    private void swapArrayNumbers(int[] newArray, int child, int parent) {
        int temp = newArray[child];
        newArray[child] = newArray[parent];
        newArray[parent] = temp;
    }
}
