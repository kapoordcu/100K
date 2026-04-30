package gk.practic.ownds;

import java.util.Stack;
class MinNode {
    int val;
    int minAtThisLevel;

    public MinNode(int val, int minAtThisLevel) {
        this.val = val;
        this.minAtThisLevel = minAtThisLevel;
    }
}

public class MinStack {
    Stack<MinNode> stack = null;

    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        MinNode node = null;
        if(stack.isEmpty()) {
            node = new MinNode(val, val);
        } else {
            int peekVal = stack.peek().val;
            node = new MinNode(val, Math.min(val, peekVal));
        }
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().minAtThisLevel;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}



/**
 * Your MinStack object will be instantiated and called as such:

 */