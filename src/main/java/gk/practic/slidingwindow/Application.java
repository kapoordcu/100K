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
        int currentSum = 0;
        int maxSum  = 0;
        for (int right = 0; right < nums.length; right++) {
            while (set.contains(nums[right]) || set.size()==k) {
                set.remove(nums[left]);
                currentSum = currentSum - nums[left];
                left++;
            }
            currentSum += nums[right];
            set.add(nums[right]);
            if(set.size() == k) {
                maxSum = Math.max(maxSum, currentSum);
            }
        }
        return maxSum;
    }
}
