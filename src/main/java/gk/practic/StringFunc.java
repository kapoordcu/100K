package gk.practic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringFunc {

    //Power Set of String
    public List<String> findPowerSetOfString(String str) {
        List<String> superset = new ArrayList<>();
        findPowerSetOfString(str, 0, "", superset);
        return superset;
    }

    private void findPowerSetOfString(String str, int i, String current, List<String> superset) {
        if(str.length() == i) {
            superset.add(current);
            return;
        }
        findPowerSetOfString(str, i+1, current + str.charAt(i), superset);
        findPowerSetOfString(str, i+1, current, superset);
    }


    //Permutations of a String
    public boolean findPalidromicStringOrNot(String str) {
        for (int i = 0, j=str.length()-1; i < str.length() ; ) {
            while (i++ < j--) {
                if(str.charAt(i) != str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    //Permutations of a String | Recursion Algorithms on Strings | Power Set of String
    public List<String> findAllPermutationsOfString(String str) {
        List<String> permutations = new ArrayList<>();
        findAllPermutationsOfString(str, 0, str.length(), permutations);
        return permutations;
    }

    private void findAllPermutationsOfString(String str, int l, int r, List<String> permutations) {
        if(l==r) {
            permutations.add(str);
            return;
        }
        for (int i = l; i < r; i++) {
            str = swap(str, l, i);
            findAllPermutationsOfString(str, l+1, r, permutations);
            str = swap(str, l, i);
        }
    }

    private String swap(String str, int i1, int i2) {
        char f = str.charAt(i1);
        char s = str.charAt(i2);
        char[] charArray = str.toCharArray();
        charArray[i1] = s;
        charArray[i2] = f;
        return new String(charArray);
    }

    @Test
    public void testFindAllPermutationsOfString() {
        List<String> permutations = findAllPermutationsOfString("abc");
        assertTrue(permutations.size()==6);
        List<String> permutations2 = findAllPermutationsOfString("aa23");
        assertTrue(permutations2.size()==24);
    }

    @Test
    public void checkFindPowerSetOfString() {
        List<String>  ofString = findPowerSetOfString("abc");
        assertTrue(ofString.contains(""));
        assertTrue(ofString.contains("a"));
        assertTrue(ofString.contains("b"));
        assertTrue(ofString.contains("c"));
        assertTrue(ofString.contains("ab"));
        assertTrue(ofString.contains("bc"));
        assertTrue(ofString.contains("ac"));
        assertTrue(ofString.contains("abc"));
        assertTrue(ofString.size()==8);

        List<String>  ofStr2 = findPowerSetOfString("x");
        assertTrue(ofStr2.contains("x"));
        assertTrue(ofStr2.contains(""));
        assertTrue(ofStr2.size()==2);

    }

    @Test
    public void checkPalidromicStringOrNot() {
        assertTrue(findPalidromicStringOrNot("a"));
        assertTrue(findPalidromicStringOrNot("aba"));
        assertFalse(findPalidromicStringOrNot("abas"));
    }
}
