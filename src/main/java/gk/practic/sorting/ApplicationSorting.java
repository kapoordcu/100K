package gk.practic.sorting;

public class ApplicationSorting {
    public static void main(String[] args) {
        ApplicationSorting sorting = new ApplicationSorting();
        int[] arr = {1, 12, 13, 5, 16};

        sorting.quickSort(arr, 0, arr.length - 1);
        for (Integer i: arr) {
            System.out.print(i + " ");
        }
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = placePivotPartitioned(arr, left, right);
            quickSort(arr, left, pivot - 1); // Correct sorting for left subarray
            quickSort(arr, pivot + 1, right); // Correct sorting for right subarray
        }
    }

    private int placePivotPartitioned(int[] arr, int low, int high) {
        //12, 11, 13, 5, 6
        int pivot = arr[low];
        int start = low - 1;
        for (int i = low; i <= high; i++) {
            if(arr[i] < pivot) {
                start++;
                swap(arr, i, start);
            }
        }
        return start + 1;
    }


    private void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int mid = left + (right-left)/2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid+1, right);
            mergeAfterDivision(arr, left, mid, right);
        }
    }

    private void mergeAfterDivision(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];
        for (int li = 0; li < n1; li++) {
            L[li] = arr[li+left];
        }
        for (int ri = 0; ri < n2; ri++) {
            R[ri] = arr[mid+1 +ri];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if(L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
                k++;
            } else {
                arr[k] = R[j];
                j++;
                k++;
            }
        }
        while(i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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
