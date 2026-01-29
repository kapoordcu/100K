package gk.practic.slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
//        int[] nums = {1,5,4,2,9,9,9};
//        int k = 3;
//        long val = Application.maximumSubarraySum(nums, k);
//        System.out.println(val);
//
//        int[] nums2 = {4, 4, 4};
//        int k2 = 3;
//        long val2 = Application.maximumSubarraySum(nums2, k2);
//        System.out.println(val2);
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        Application app = new Application();
        System.out.println(app.minSubArrayLen(target, nums)); //2
    }

    public static int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        int n = s.length();
        Set<Character> uniqueCharSet = new HashSet<>();

        for (int right = 0; right < n; right++) {
            while (uniqueCharSet.contains(s.charAt(right))) {
                uniqueCharSet.remove(s.charAt(left));
                left++;
            }
            uniqueCharSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
    
    public static long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int left = 0;
        int currSum = 0;
        int maxSum  = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right]) || set.size()==k) {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currSum += nums[right];
            if(set.size() == k) {
                maxSum = Math.max(currSum, maxSum);
            }
        }
        return maxSum;
    }


    public int minSubArrayLen(int target, int[] nums) {
        //{2,3,1,2,4,3};
        int minSubLength = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            while (currSum >= target) {
                minSubLength = Math.min(minSubLength, right - left + 1);
                currSum -= nums[left];
                left++;
            }
        }
        return minSubLength != Integer.MAX_VALUE ? minSubLength : 0;
    }
}
