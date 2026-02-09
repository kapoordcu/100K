package gk.practic.queu;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class Application {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int sizeLevel = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < sizeLevel; i++) {
                TreeNode elem = queue.remove();
                levelList.add(elem.val);
                if(elem.left!=null) {
                    queue.add(elem.left);
                }
                if(elem.right!=null) {
                    queue.add(elem.right);
                }
            }
            results.add(levelList);
        }
        return results;
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < nums.length - k; i++) {
            queue.remove();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        Application queue = new Application();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(queue.findKthLargest(nums, k));
    }
}
