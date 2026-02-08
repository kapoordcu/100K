package gk.practic.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationHashImpl {
    public static void main(String[] args) {
        
        ApplicationHashImpl app = new ApplicationHashImpl();
        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(app.groupAnagrams(strs));
//        String s = "anagram";
//        String t = "nagarmm";
//        System.out.println(app.isAnagram(s, t));
////        String string = "ajdnjmdldlskd";
////        app.frequencyCount(string);
////        int[] nums = { 1, 4, 6, 8, -2, 3, 8};
////        int[] indices = app.targetSumUsingHash(nums, 2);
////        System.out.println(indices[0]);
////        System.out.println(indices[1]);
//        String words = "dog dog dog dog";
//        String pattern ="abba";
//        System.out.println(app.wordPattern(pattern, words)); //true
    }

        private int[] targetSumUsingHash(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length - 1; i++) {
                int value = target - nums[i];
                if (map.containsKey(value)) {
                    return new int[]{map.get(value), i};
                }
                map.put(nums[i], i);
            }
            return new int[2];
        }

    private void frequencyCount(String string) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (Character c : string.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        freqMap.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;
        for (int i = 0; i < words.length; i++) {
            if(patternMap.containsKey(pattern.charAt(i))) {
                String value = patternMap.get(pattern.charAt(i));
                if(!words[i].equals(value)) {
                    return false;
                }
            } else if(patternMap.containsValue(words[i])) {
                return false;
            }
            patternMap.put(pattern.charAt(i), words[i]);
        }
        return true;
    }

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> freqMap = new HashMap<>();
        if(s.length() != t.length()) return false;
        for (Character c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (Character c : t.toCharArray()) {
           if(!freqMap.containsKey(c) || freqMap.get(c)==0) {
               return false;
           }
            freqMap.put(c, freqMap.get(c) - 1);
        }
        return true;
    }

    //strs = ["eat","tea","tan","ate","nat","bat"]
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] frequencyArray = new int[26];
            StringBuilder binaryPattern = new StringBuilder();
            char[] chars = str.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int v = chars[i] - 'a';
                frequencyArray[v]++;
            }
            for (int i = 0; i < frequencyArray.length; i++) {
                binaryPattern.append("#");
                binaryPattern.append(frequencyArray[i]);
            }
            if(map.containsKey(binaryPattern.toString())) {
                map.get(binaryPattern.toString()).add(str);
            } else {
                ArrayList<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(binaryPattern.toString(), newList);
            }
        }
        return new ArrayList<>(map.values());
    }

}
