package gk.practic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.*;

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

    public int gcd(int a, int b) {
        if (b==0) { return a; }
        return gcd(b, a%b);
    }

    public int catalanNumbersRecursive(int n) {
        int catalan = 0;
        if(n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            catalan += catalanNumbersRecursive(i) * catalanNumbersRecursive(n-i-1);
        }
        return catalan;
    }

    public int fastPower(int a, int b, int n) {
        // O(b) -> O(logb)
        // b % 2  = expensive operation -> b & 1 =
        // b = b /2 -> b >> 1
        int res = 1;
        while (b > 0) {
            if((b & 1) != 0) {
                res *= a;
            }
            a = a * a;
            b = b >> 1;
        }
        return res;
    }

    @Test
    public void testCatalanNumber() {
        int catalan = catalanNumbersRecursive(2);
        assertTrue(catalan==2);
        catalan = catalanNumbersDp(6);
        assertTrue(catalan==132);
        catalan = catalanNumbersRecursive(5);
        assertTrue(catalan==42);
        catalan = catalanNumbersDp(5);
        assertTrue(catalan==42);
    }

    private int catalanNumbersDp(int n) {
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i-j-1];
            }
        }
        return dp[n];
    }

    @Test
    public void testfastPower() {
        assertEquals(fastPower(2, 4, 5), 16);
        assertEquals(fastPower(3, 3, 5), 27);
        assertEquals(fastPower(3, 8, 5), 6561);
    }

    public boolean[] isPrime(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n ; i++) {
            if(isPrime[i]) {
                for (int j = i*i; j <= n; j = j+i) {
                    if(j % i == 0) {
                        isPrime[j] = false;
                    }
                }
            }
        }
        return isPrime;
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
    public void testgcd() {
        assertTrue(gcd(3, 12) == 3);
        assertTrue(gcd(12, 3) == 3);
        assertTrue(gcd(12, 15) == 3);
        assertTrue(gcd(15, 12) == 3);

    }

    @Test
    public void testisPrime() {
        boolean[] prime = isPrime(12);
        for (int i = 2; i < prime.length; i++) {
            if(prime[i]) {
                System.out.println("Number:"+ i);
            }
        }
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
