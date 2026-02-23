package gk.practic.greedy;

import gk.practic.Arrays;

import java.util.stream.IntStream;

public class GreedyApp {

    public int jump(int[] nums) {
        int maxJump = 0;
        int end = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            maxJump = Math.max(maxJump, nums[i]+i);
            if(maxJump >= nums.length - 1) {
                ans++;
                return ans;
            }
            if(i==end) {
                ans++;
                end = maxJump;
            }
        }
        return ans;
    }

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
        //System.out.println(greedyApp.canJump(nums)); // true
        System.out.println(greedyApp.jump(nums)); // 2
        int[] nums2 = {3,2,1,0,4};
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(greedyApp.canCompleteCircuit(gas, cost));
        // System.out.println(greedyApp.canJump(nums2)); // flase
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sumGas = IntStream.of(gas).sum();
        int sumCost = IntStream.of(cost).sum();
        if(sumCost > sumGas) { return -1;}
        int start = 0;
        int remainingGas = 0;
        for (int i = 0; i < gas.length; i++) {
            remainingGas += gas[i]-cost[i];
            if(remainingGas < 0) {
                start = i + 1;
                remainingGas = 0;
            }
        }
        return start;
    }
}
