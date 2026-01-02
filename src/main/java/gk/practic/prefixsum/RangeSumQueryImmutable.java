package gk.practic.prefixsum;


public class RangeSumQueryImmutable {
    private int[] prefixSumArray;

    public RangeSumQueryImmutable() {}

    public RangeSumQueryImmutable(int[] array) {
        for (int k = 1; k < array.length; k++) {
            array[k] += array[k-1];
        }
        this.prefixSumArray = array;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8};
        int sumOpt = RangeSumQueryImmutable.rangeSumQueryOn(0, 5, array);
        System.out.println("Sum using BF: " + sumOpt);
        // LEET CODE: 303
        RangeSumQueryImmutable pre = new RangeSumQueryImmutable(array);
        int sumPrefixSum = pre.rangeSumQueryPerfixSum(0, 5);
        System.out.println("Sum using Prefix Sum: " + sumPrefixSum);
    }

    private static int rangeSumQueryOn(int i, int j, int[] array) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += array[k];
        }
        return sum;
    }

    private int rangeSumQueryPerfixSum(int i, int j) {
        if(i==0) {
            return prefixSumArray[j];
        }
        return this.prefixSumArray[j] - this.prefixSumArray[i-1];
    }
}
