package gk.practic;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MathematicalQ {

    public int factorialNormal(int n) {
        if(n==0 || n==1) {
            return 1;
        }
        return n * factorialNormal(n-1);
    }

    public int factorialDP(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
           dp[i] = dp[i-1]*i;
        }
        return dp[n];
    }

    @Test
    public void testfactorial() {
        int factorial = factorialNormal(5);
        int factorialDP = factorialDP(5);
        int factorialDP2 = factorialDP(12);
        assertTrue(factorial==120);
        assertTrue(factorialDP==120);
    }
}
