package gk.practic.k150;

public class Top150 {
    public static void main(String[] args) {
        int[] nums = {1, 2,3,4,5};
        Top150 app = new Top150();
        int result = app.maxProfitMultiple(nums);
        System.out.println(result);
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
