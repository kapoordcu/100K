package gk.practic.dp;

import java.util.Arrays;

public class DynamicApp {

    public static void main(String[] args) {
        int value =7;
        int[] dp = new int[value+1];
        Arrays.fill(dp,-1);
        DynamicApp dynamicApp = new DynamicApp();
        //System.out.println(dynamicApp.fibonacciBottomsUpSpaceOptimization(value));
        int[] nums = {2,7,9,3,1};
        System.out.println(dynamicApp.robOn2(nums));
        System.out.println(dynamicApp.rob(nums));
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
        return 0;
    }

    public int robOn2(int[] nums) {
        int maxRob = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            maxRob = Math.max(maxRob, findMaxRobFromI(nums, i));
        }
        return maxRob;
    }

    private int findMaxRobFromI(int[] nums, int start) {
        int max = 0;
        for (int i = start; i < nums.length; i+=2) {
            if(i < nums.length) {
                max = max + nums[i];
            }
        }
        return max;
    }
}
