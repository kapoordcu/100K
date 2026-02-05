package gk.practic.binaysearch;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//        int[] nums = {1,2,5,8, 11, 13};
//        int pivot = 4;
//        int index = app.findIndexOfElement(nums, pivot);
//        System.out.println(index); // -1
//        index = app.findIndexOfElement(nums, 8);
//        int[] nums2 = {-1,0,3,5,9,12};
//        int index = app.findIndexOfElement(nums2, 2);
//        System.out.println(index); //0
        int[] nums = {4,5,6,7,9,1,2};
        int target = 1;
        System.out.println(app.search(nums, target));

    }

    private int findIndexOfElement(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (right + left) / 2;
            if(nums[mid] > target) {
                right = mid-1;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left+right)/2;
            int elem = matrix[mid/n][mid%n];
            if(target == elem) {
                return true;
            } else if(target < elem) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public int search(int[] nums, int target) {
        //{4,5,6,7,0,1,2};
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        while (left <= right) {
            mid = (right + left)/2;
            if(nums[mid] == target) { return mid; }
            else if(nums[mid] >= nums[left]) { // left side is sorted
                if(target <= nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // right side is sorted
                if(target >= nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
