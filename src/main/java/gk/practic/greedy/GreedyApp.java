package gk.practic.greedy;

public class GreedyApp {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for (int i = 0; i < nums.length; i++) {
            if(maxJump < i) {
                return false;
            }
            maxJump = Math.max(maxJump, nums[i]+i);
            if(maxJump >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        GreedyApp greedyApp = new GreedyApp();
        System.out.println(greedyApp.canJump(nums)); // true
        int[] nums2 = {3,2,1,0,4};
        System.out.println(greedyApp.canJump(nums2)); // flase
    }
}
