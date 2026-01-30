package gk.practic.prefixsum;

public class Application {
    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int leftSum  = 0;
        int rightSum  = 0;
        for (int i = 0; i < nums.length; i++) {
            rightSum = total - leftSum - nums[i];
            if(leftSum==rightSum) {
                return i;

            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        Application prefixSumApp = new Application();
        int[] nums = {1,7,3,6,5,6};
        System.out.println(prefixSumApp.pivotIndex(nums)); // 3
    }
}
