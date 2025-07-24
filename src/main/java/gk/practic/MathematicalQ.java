package gk.practic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
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

    public int numberOfTrailingZeroesInFactorial(int n) {
        int res = 0;
        for (int i = 5; i <= n; i*=5) {
            res += n/i;
        }
        return res;
    }

    public boolean palindromeOrNotFirst(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append(n);
        String v1 = sb.toString();
        String v2 = sb.reverse().toString();
        return v1.equals(v2);
    }

    public boolean palindromeOrNot2(int n) {
        int originalnumber = n;
        int reverse = 0;
        while (n % 10 != 0) {
            reverse = reverse * 10 + n % 10;
            n = n / 10;
        }
        return reverse == originalnumber;
    }

    @Test
    public void testpalindromeOrNot() {
        assertTrue(palindromeOrNot2(121));
        assertFalse(palindromeOrNot2(13));
        assertTrue(palindromeOrNot2(3));
    }

    @Test
    public void testnumberOfTrailingZeroesInFactorial() {
        int tw = numberOfTrailingZeroesInFactorial(12);
        assertTrue(tw==2);
        tw = numberOfTrailingZeroesInFactorial(26);
        assertTrue(tw==6);
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
