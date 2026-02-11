package gk.practic.heap;

import java.util.Arrays;

public class HeapApplication {

        /*
                   30

             23          19

          18   20      16    24

       9    11
         */

    public static void main(String[] args) {
        HeapApplication application = new HeapApplication();

        int[] arr = {30, 23, 19, 18, 20, 16, 24, 9, 11};
        int[] newArray = application.addElem(arr, 22);
        for (int v: newArray) {
            System.out.print(v + " ");
        }
        int[] afterRemoveal = application.remove(newArray);
        System.out.println("----------");
        for (int v: afterRemoveal) {
            System.out.print(v + " ");
        }

    }

    private int[] remove(int[] arr) {
        // 30 23 19 18 22 16 24 9 11 20
        int[] ret = Arrays.copyOf(arr, arr.length -1);
        ret[0] = arr[arr.length-1];
        for (int i = 1; i < arr.length - 1; i++) {
            ret[i] = arr[i];
        }
        int i = 0;
        while (i < ret.length) {
            //  left and right child
            if(2*i+1<ret.length && 2*i+2<ret.length) {
                int max = ret[2*i+1] > ret[2*i+2] ? 2*i+1 : 2*i+2;
                if(ret[i] < ret[max]) {
                    swapNumbers(ret, i, max);
                    i = max;
                } else {
                    break;
                }
            } else if(2*i+1<ret.length) {
                if(ret[i] < ret[2*i+1]) {
                    swapNumbers(ret, i, 2*i+1);
                    i = 2*i+1;
                } else {
                    break;
                }
            } else {
                break;
            }
        }
        return ret;
    }

    public  int[] addElem(int[] array, int val) {
        // {30, 23, 19, 18, 20, 16, 24, 9, 11}; // 9 size
        int[] ret = new int[array.length+1]; //  10 size
        for (int j = 0; j < array.length ; j++) { // 9
            ret[j] = array[j];
        }
        ret[array.length] = val;
        // {30, 23, 19, 18, 20, 16, 24, 9, 11, 22};
        int i = array.length;
        while (i >= 0) {
            int parent = (i-1)/2;
            if(ret[i] > ret[parent]) {
                swapNumbers(ret, i, parent);
                i = parent;
            } else {
                break;
            }
        }
        return ret;
    }

    private void swapNumbers(int[] ret, int child, int parent) {
        int temp = ret[child];
        ret[child] = ret[parent];
        ret[parent] = temp;
    }

}
