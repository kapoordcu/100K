package gk.practic.heap;

import gk.practic.Arrays;

public class HeapApplication {


    public static void main(String[] args) {
        HeapApplication application = new HeapApplication();

        int[] arr = {30, 23, 19, 18, 20, 16, 24, 9, 11};
        int[] newArray = application.addElem(arr, 22);
        System.out.println(newArray);

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

        /*
                   30

             23          19

          18   20      16    24

       9    11
         */
        return ret;
    }

    private void swapNumbers(int[] ret, int child, int parent) {
        int temp = ret[child];
        ret[child] = ret[parent];
        ret[parent] = temp;
    }


    public int removeElem() {
        return 0;
    }
}
