package gk.practic.prefixsum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Application {

    public int subarraySum(int[] nums, int k) {
        // 2, 3, 5, -5, -5, 1, 4
        int total = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                total += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return total;
    }

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

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum  = 0;
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if(remainderMap.containsKey(remainder)) {
                if(i-remainderMap.get(remainder) > 1) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        Application prefixSumApp = new Application();
//        int[] nums = {1,7,3,6,5,6};
//        System.out.println(prefixSumApp.pivotIndex(nums)); // 3
        Application subarraySumApp = new Application();
        int[] nums2 = {2, 3, 5, -5, -5, 1, 4};
        System.out.println(subarraySumApp.subarraySum(nums2, 5));
//        Application subArraySum = new Application();
//        int[] nums3 = {23,2,4,6,7};
//        int k = 6;
//        System.out.println(subArraySum.checkSubarraySum(nums3, k));
    }
}
