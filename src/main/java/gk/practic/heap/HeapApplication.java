package gk.practic.heap;

import java.util.Arrays;

public class HeapApplication {

    public static void main(String[] args) {
        int[] arr = {24, 16, 18, 11, 14, 15, 10};
        int[] arr2 = {10, 30, 50, 20, 35, 15};
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
        application.heapSort(arr, arr.length);
    }

    public void heapSort(int[] arr, int n) {
        for (int i = n-1; i >=0 ; i--) {
            swapArrayNumbers(arr, i, 0);
            heapify(arr, i -1, 0);
        }
    }


    public void heapify(int[] arr, int n, int i) {
        int left = 2*i+1;
        int right = 2*i+2;
        int largest = i;
        int len = arr.length;
        if(left < len && arr[largest] < arr[left]) {
            largest = left;
        }
        if(right < len && arr[largest] < arr[right]) {
            largest = right;
        }
        if(largest != i) {
            swapArrayNumbers(arr, largest, i);
            heapify(arr, n, largest);
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
