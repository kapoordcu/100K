package gk.practic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        long val = Application.maximumSubarraySum(nums, k);
        System.out.println(val);

        int[] nums2 = {4, 4, 4};
        int k2 = 3;
        long val2 = Application.maximumSubarraySum(nums2, k2);
        System.out.println(val2);
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> uniqueSet = new HashSet<>();
        int left = 0;
        int right = 0;
        int maxSum  = 0;
        int currentLength = 0;
        int len = nums.length -1;
        while(right < len || left < len -k) {
            maxSum += nums[right];
            currentLength++;
            if(currentLength <= k) {
                right++;
            } else {
                maxSum -= nums[left];
                left++;
                right++;
            }

        }
        return maxSum;
    }
}
