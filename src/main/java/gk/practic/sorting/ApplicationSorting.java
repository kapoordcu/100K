package gk.practic.sorting;

public class ApplicationSorting {
    public static void main(String[] args) {
        ApplicationSorting sorting = new ApplicationSorting();
        int[] unsortedArray = {12, 11, 13, 5, 6};

        sorting.insertionSort(unsortedArray);
        for (Integer i: unsortedArray) {
            System.out.print(i + " ");
        }
    }

    private void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swap = false;
        for (int i = 0; i < len-1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if(arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap) {
                break;
            }
        }
    }

    //{12, 11, 13, 5, 6};
    private void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >=0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //{12, 11, 13, 5, 6};
    private void selectionSort(int[] arr) {
        int len = arr.length;
        int minIndx = 0;
        for (int i = 0; i < len; i++) {
            minIndx = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j] < arr[minIndx]) {
                    minIndx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndx];
            arr[minIndx] = temp;
        }
    }

}
