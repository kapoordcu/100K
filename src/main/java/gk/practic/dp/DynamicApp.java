package gk.practic.dp;

import java.util.Arrays;

public class DynamicApp {

    public static void main(String[] args) {
        int value =7;
        int[] dp = new int[value+1];
        Arrays.fill(dp,-1);
        DynamicApp dynamicApp = new DynamicApp();
        //System.out.println(dynamicApp.fibonacciBottomsUpSpaceOptimization(value));
        int[] nums = {2,1,1,2};
        System.out.println(dynamicApp.rob(nums));
       // System.out.println(dynamicApp.rob(nums));
    }

    public int fibonacciTopDown(int[] dp, int n) {
        if(n==0 || n==1) { return n;}
        if(dp[n]!=-1) { return dp[n];}
        return fibonacciTopDown(dp, n-1) + fibonacciTopDown(dp, n-2);
    }

    public int fibonacciBottomsUpSpaceOptimization(int n) {
        int iMinusOne = 1;
        int iMinusTwo = 0;
        int current = 0;
        for (int i = 2; i <= n; i++) {
            current = iMinusOne + iMinusTwo;
            iMinusTwo = iMinusOne;
            iMinusOne = current;
        }
        return current;
    }

    public int fibonacciBottomsUp(int[] dp, int n) {
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public int rob(int[] nums) {
        int len = nums.length;
        if(len < 1) {
            return 0;
        }
        if(len == 1) {
            return nums[0];
        }
        if(len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int last = 0;
        int beforeLast = 0;
        last = nums[len-1];
        beforeLast = Math.max(nums[len-2], nums[len-1]);
        for(int i=len-3;i>=0;i--) {
            //rob
            int costRob = nums[i] + last;
            int skipRob = beforeLast;
            last = beforeLast;
            beforeLast = Math.max(costRob, skipRob);
        }
        return beforeLast;
    }

    public int robTopDown(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return findRobStrategy(0, nums, dp);
    }

    private int findRobStrategy(int i, int[] nums, int[] dp) {
        if(i >= nums.length) { return 0;}
        if(dp[i] != -1) { return dp[i];}
        int rob = nums[i] + findRobStrategy(i+2, nums, dp);
        int skip = findRobStrategy(i+1, nums, dp);
        return Math.max(rob,skip);
    }
}
