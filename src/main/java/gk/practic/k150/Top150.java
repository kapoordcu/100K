package gk.practic.k150;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Top150 {
    Map<Character, Integer> romanMap = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );

    public static void main(String[] args) {
        int[] intervals = {1,3,4,2,2};
        Top150 app = new Top150();
        int s = app.findDuplicate(intervals);
        System.out.println(s);
    }

    public int findDuplicate(int[] nums) {
        // 1,3,4,2,2
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) {
                break;
            }
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
    }
    public int findDuplicate1(int[] nums) {
        //1,3,4,2,2
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if(nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }
        return -1;
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(a -> a[0]));
        int e = 0;
        // {{1,3 },{2,6 },{5,10 },{9, 15 }};
        for(int[] unit : intervals) { //
            if(unit[0] <= intervals[e][1]) {
                intervals[e][1] = Math.max(intervals[e][1], unit[1]);
            } else {
                e++;
                intervals[e][0] = unit[0];
                intervals[e][1] = unit[1];
            }
        }
        if(e==intervals.length-1) {
            return intervals;
        }
        return Arrays.copyOfRange(intervals, 0, e+1);
    }

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {
            int j = 0;
            while (j< needle.length() &&
                    needle.charAt(j) == haystack.charAt(i+j)) {
                j++;
            }
            if(j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        String first = strs[0];
        int count = 0;
        int countFinal = 0;
        int j = 0;
        for (int i = 1; i < strs.length; i++) {
            for(j = 0; j < strs[i].length(); j++) {
                if(first.charAt(j) != strs[i].charAt(j)) {
                    break;
                } else {
                    count++;
                }
            }
            countFinal = Math.min(count, j);
            count = 0;
        }
        return first.substring(0, countFinal);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int len = 0;
        for (int i = s.length(); i >=0; i--) {
            if(s.charAt(i) == ' ') {
                break;
            } else {
                len++;
            }
        }
        return len;
    }

    public int romanToInt(String s) {
        int num = 0;
        int prev = romanMap.get(s.charAt(0));
        int next = 0;
        for (int i = 1; i < s.length(); i++) {
            next = romanMap.get(s.charAt(i));
            if(next > prev) {
                num -= prev;
            } else {
                num += prev;
            }
            prev = next;
        }
        num += prev;
        return num;
    }

    public int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = height[0];
        right[n-1] = height[n-1];
        for (int i = 1; i < n-1; i++) {
            if(height[i] > left[i-1]) {
                left[i] = height[i];
            } else {
                left[i] = left[i-1];
            }
        }
        for (int i = n-2; i >=0 ; i--) {
            if(height[i] > right[i+1]) {
                right[i] = height[i];
            } else {
                right[i] = right[i+1];
            }
        }
        return water;
    }

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = candies[i-1] + 1;
            }
        }
        for (int i = n-2; i >=0 ; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i], candies[i+1]+1);
            }
        }
        return Arrays.stream(candies).sum();
    }

    public int[] productExceptSelf(int[] nums) {
        int size = nums.length;
        int[] prefix = new int[size];
        int[] suffix = new int[size];
        prefix[0] = 1;
        suffix[size-1] = 1;
        for (int i = 1; i < size; i++) {
            prefix[i] = prefix[i-1]*nums[i-1];
        }
        for (int i = size-2; i >= 0 ; i--) {
            suffix[i] = suffix[i+1]*nums[i+1];
        }
        for (int i = 0; i < size; i++) {
            nums[i] = prefix[i]*suffix[i];
        }
        return nums;
    }

    public int hIndex2(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for (int i = 0; i < n; i++) {
            if(citations[i]>=n) {
                buckets[n]++;
            } else {
                buckets[citations[i]]++;
            }
        }
        int count = 0;
        for (int i = n; i > 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return count;
            }
        }
        return count;
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if(citations[i] >= n-i) {
                return n-i;
            }
        }
        return 0;
    }

    public int jump(int[] nums) {
        int jumps = 0;
        int farthest = 0;
        int end = 0;
        int n = nums.length;
        for (int i = 0; i < n-1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if(farthest >= n-1) {
                jumps++;
                return jumps;
            }
            if(i == end) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }

    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int goal = len;
        for (int i = len-1; i >=0 ; i--) {
            if(i+nums[i] >= goal) {
                goal = i;
            }
        }
        if (goal == 0) return true;
        return false;
    }
    public int maxProfitMultiple(int[] prices) {
        int len = prices.length - 1;
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i <= len; i++) {
            if(prices[i] > buy) {
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return profit;
    }

    public int maxProfitSingle(int[] prices) {
        int len = prices.length - 1;
        int profit = 0;
        int buy = prices[0];
        for (int i = 1; i < len; i++) {
            if(prices[i] < buy) {
                buy = prices[i];
            } else if(prices[i] - buy > profit) {
                profit = prices[i] - buy;
            }

        }
        return profit;
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length-1;
        if(k > len) {
            k = k%len;
        }
        reverse(nums, 0, len);
        reverse(nums, 0, k-1);
        reverse(nums, k, len);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start<end) {
            int temp = nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num: nums) {
            if(count==0) {
                candidate=num;
            }
            if(candidate==num) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    public int removeDuplicatesV2(int[] nums) {
        int j = 2;
        int n = nums.length;
        for (int i = 2; i < n; i++) {
            if(nums[i] != nums[j-2]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicatesV1(int[] nums) {
        int j = 1;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if(nums[i] != nums[j-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
