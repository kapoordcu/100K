package gk.practic.sorting;

public class ApplicationSorting {
    public static void main(String[] args) {
        ApplicationSorting sorting = new ApplicationSorting();
        int[] unsortedArray = {6, 2, 5, 7};
        sorting.bubbleSort(unsortedArray);
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

}
