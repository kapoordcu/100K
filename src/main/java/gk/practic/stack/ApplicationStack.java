package gk.practic.stack;

import java.util.Map;
import java.util.Stack;

public class ApplicationStack {
    public static void main(String[] args) {
        ApplicationStack stack = new ApplicationStack();
        String s = "()[]{}";
        System.out.println(stack.isValid(s)); // true
        s = "(]";
        System.out.println(stack.isValid(s)); // false
        s = "([)]";
        System.out.println(stack.isValid(s)); // false
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

}
