package gk.practic.BDFS;


import gk.practic.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthDeapthApp {

    public static void main(String[] args) {
        TreeNode third1 = new TreeNode(6);
        TreeNode second0 = new TreeNode(5, null, third1);
        TreeNode second1 = new TreeNode(7);
        TreeNode second2 = new TreeNode(10);
        TreeNode first0 = new TreeNode(9, second0, second1);
        TreeNode first1 = new TreeNode(13, second2, null);
        TreeNode root = new TreeNode(11, first0, first1);
        BreadthDeapthApp app = new BreadthDeapthApp();
        app.levelOrder(root);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        boolean leftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(leftToRight) { level.addLast(node.val);}
                if(!leftToRight) { level.addFirst(node.val);}
                if(node.left != null) { queue.add(node.left); }
                if(node.right != null) {queue.add(node.right);}
            }
            leftToRight = !leftToRight;
            result.add(level);
        }
        return result;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.val);
            }
            result.add(level);
        }
        return result;
    }

    public void BFS(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
