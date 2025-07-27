package gk.practic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Recursion {

    public int sumOfNUsingRecur(int n) {
        if(n==1) {
            return 1;
        }
        return n + sumOfNUsingRecur(n-1);
    }

    public int aPowerb(int a, int b) {
        if(b==0) {
            return 1;
        }
        return a * aPowerb(a, b-1);
    }

    public int matrixStartToEndWays(int n, int m) {
        if(n==1 || m==1) {
            return 1;
        }
        return matrixStartToEndWays(n, m-1) +  matrixStartToEndWays(n-1, m);
    }

    public int josephusProblem(int n, int k) {
        if(n == 1) {
            return 0;
        }
        return (josephusProblem(n-1, k) + k) % n;
    }



    @Test
    public void test1() {
        assertTrue(sumOfNUsingRecur(5) == 15);
        assertTrue(aPowerb(3, 4) == 81);
    }

    @Test
    public void test2() {
        int ways = matrixStartToEndWays(4, 3);
        assertTrue(ways == 10);
    }

    @Test
    public void test3() {
        int saved = josephusProblem(5, 3);
        assertEquals(saved, 3);
    }


}
