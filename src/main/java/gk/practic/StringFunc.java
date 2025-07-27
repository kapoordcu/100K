package gk.practic;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class StringFunc {

    //Power Set of String
    public List<String> findPowerSetOfString(String str) {
        List<String> objects = new ArrayList<>();
        findPowerSetOfString(str, 0, "", objects);
        return objects;
    }

    private void findPowerSetOfString(String str, int index, String current, List<String> answers) {
        if(index == str.length()) {
            answers.add(current);
            return;
        }
        findPowerSetOfString(str, index+1, current + str.charAt(index), answers);
        findPowerSetOfString(str, index+1, current, answers);
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
        List<String> objects = new ArrayList<>();

        return objects;
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
