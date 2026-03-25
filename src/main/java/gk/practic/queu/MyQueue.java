package gk.practic.queu;

import java.util.*;

public class MyQueue {
    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
//        while (!s1.isEmpty()) {
//            s2.push(s1.pop());
//        }
//        return s2.isEmpty() ? -1 : s2.pop();
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }

    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.isEmpty() ? -1 : s2.peek();
    }

    public boolean empty() {
        return s2.isEmpty() && s1.isEmpty();
    }

    public static void main(String[] args) {
//        MyQueue queue = new MyQueue();
//        System.out.println(queue.pop());
//        queue.push(5);
//        queue.push(7);
//        queue.push(2);
//        System.out.println(queue.pop());
//        queue.push(14);
//        queue.push(13);
//        System.out.println(queue.pop());
//        System.out.println(queue.pop());
//        System.out.println(queue.peek());
//        System.out.println(queue.pop());
//        System.out.println(queue.peek());
        int[] arr = {1,1,1,2,2,3};
        MyQueue queue = new MyQueue();
        //System.out.println(queue.findKthLargest(arr, 2));
        System.out.println(queue.topKFrequent(arr, 2));

    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] topK = new int[k];
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparing(freqMap::get));
        for(Integer key: freqMap.keySet()) {
            queue.add(key);
            if(queue.size() > k) {
                queue.remove();
            }
        }
        for (int i = 0; i <= queue.size(); i++) {
            topK[i] = queue.poll();
        }
        return topK;
    }

//
//    public void levelOrder(TreeNode root) {
//        Queue<Integer> queue = new LinkedList<>();
//        traverseTreeLevelWise(queue, root);
//        for(Integer val: queue.stream().toList()) {
//            System.out.println(val);
//        }
//    }

    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(!queue.isEmpty() && queue.size() > k) {
                queue.remove();
            }
        }
        return k > nums.length ? -1: queue.peek();
    }

    public List<List<Integer>> levelOrder(TreeNode node) {

        List<List<Integer>> result = new LinkedList<>();
        if (node == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                levelList.add(poll.val);
                if(poll.left != null) {
                    queue.add(poll.left);
                }
                if(poll.right != null) {
                    queue.add(poll.right);
                }
            }
            result.add(levelList);
        }
        return result;
    }

    private void  traverseTreeLevelWise(Queue<Integer> queue, TreeNode node) {
        if(node == null) {
            return;
        } else {
            queue.add(node.val);
        }
        traverseTreeLevelWise(queue, node.left);
        traverseTreeLevelWise(queue, node.right);
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */