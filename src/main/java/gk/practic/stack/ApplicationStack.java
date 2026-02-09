package gk.practic.stack;

import java.util.*;
import java.util.stream.IntStream;

public class ApplicationStack {
    public static void main(String[] args) {
        ApplicationStack stack = new ApplicationStack();
//        String s = "()[]{}";
//        System.out.println(stack.isValid(s)); // true
//        s = "(]";
//        System.out.println(stack.isValid(s)); // false
//        s = "([)]";
//        System.out.println(stack.isValid(s)); // false
//        int[] nums1 = {4,1,2};
//        int[] nums2 = {1,3,4,2, 6};
//        stack.nextGreaterElement(nums1, nums2);
        String path = "/.../a/../b/c/../d/./";
        String output = "/home/user/Pictures";
        String answer = stack.simplifyPath(path);
    }


    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        //     "/.../a/../b/c/../d/./";
        for(String dir: dirs) {
            if(dir.equals("") || dir.equals(".")) {
                continue;
            }
            if(dir.equals("..")) {
                if(!stack.isEmpty()) {stack.pop(); }
            } else {
                stack.push(dir);
            }
        }
        if(stack.isEmpty()) {
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for (String p: stack) {
            builder.append("/").append(p);
        }
        return builder.toString();
    }
    
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character ch: s.toCharArray()) {
            if(ch =='(') {
                stack.push(')');
            } else if(ch =='[') {
                stack.push(']');
            } else if(ch =='{') {
                stack.push('}');
            } else if(stack.isEmpty() || stack.pop() != ch) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        return result;
    }

    public int[] nextGreaterElementBF(int[] nums1, int[] nums2) {
        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        boolean found = false;
        for (int i = 0; i < nums2.length; i++) {
            found = false;
            for (int j = i+1; j < nums2.length; j++) {
                if(nums2[j] > nums2[i]) {
                    nextGreaterMap.put(nums2[i], nums2[j]);
                    found = true;
                    break;
                }
            }
            if(!found) {
                nextGreaterMap.put(nums2[i], -1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            result.add(nextGreaterMap.get(nums1[i]));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

}
