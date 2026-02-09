package gk.practic.stack;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        peek();
        return s2.pop();
    }

    public int peek() {
        if(s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(12);
        queue.push(13);
        queue.push(10);
        System.out.println(queue.pop()); // 12
        System.out.println(queue.peek()); // 13
        System.out.println(queue.pop()); // 13
        queue.push(15); //   10 15
        System.out.println(queue.pop()); // 10
    }
}
