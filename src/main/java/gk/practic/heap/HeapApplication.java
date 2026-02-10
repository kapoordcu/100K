package gk.practic.heap;

import gk.practic.Arrays;

public class HeapApplication {

    public  int[] addElem(int[] array, int val) {
        int newSize = array.length + 1;
        int[] newArray = new int[newSize];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        newArray[array.length] = val;
        int start = newArray.length;
        int i = start;
        while (i>0) {
            int parent = (i-1)/2;
            if(newArray[parent] < newArray[i-1]) {
                swapParentChild(newArray, parent, i-1);
                i = parent;
            }
        }
        return newArray;
    }

    private void swapParentChild(int[] newArray, int parent, int child) {
        int temp = newArray[parent];
        newArray[parent] = newArray[child];
        newArray[child] = temp;
    }

    public int removeElem() {
        return 0;
    }


    public static void main(String[] args) {
        HeapApplication application = new HeapApplication();

        int[] arr = {50, 40, 45, 30, 20, 35, 10};
        int[] newArray = application.addElem(arr, 60);
        System.out.println(newArray);

    }
}
