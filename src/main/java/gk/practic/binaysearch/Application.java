package gk.practic.binaysearch;

public class Application {
    public static void main(String[] args) {
        Application app = new Application();
//        int[] nums = {1,2,5,8, 11, 13};
//        int pivot = 4;
//        int index = app.findIndexOfElement(nums, pivot);
//        System.out.println(index); // -1
//        index = app.findIndexOfElement(nums, 8);
        int[] nums2 = {-1,0,3,5,9,12};
        int index = app.findIndexOfElement(nums2, 2);
        System.out.println(index); //0
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
}
