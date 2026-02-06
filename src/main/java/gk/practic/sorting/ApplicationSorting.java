package gk.practic.sorting;

public class ApplicationSorting {
    public static void main(String[] args) {
        ApplicationSorting sorting = new ApplicationSorting();
        int[] unsortedArray = {6, 2, 5, 7};
        //sorting.bubbleSort(unsortedArray);
        sorting.selectionSort(unsortedArray);
        System.out.println();
    }

    private void bubbleSort(int[] unsortedArray) {
        int len = unsortedArray.length;
        boolean swapped = false;
        for (int outer = 0; outer < len-1; outer++) {
            for (int inner = 0; inner < len - 1 - outer; inner++) {
                if(unsortedArray[inner] > unsortedArray[inner + 1]) {
                    int temp = unsortedArray[inner];
                    unsortedArray[inner] = unsortedArray[inner+1];
                    unsortedArray[inner+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) {
                break;
            }
        }
    }

    private void selectionSort(int[] array) {
        int len = array.length;
        int minIndex = 0;
        for (int i = 0; i < len-1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
    }

}
