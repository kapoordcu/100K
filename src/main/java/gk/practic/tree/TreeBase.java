package gk.practic.tree;

import gk.practic.TreeNode;

public class TreeBase {
    public static void main(String[] args) {

    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }


    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sum = 0;
        if(root.left != null && root.left.left ==  null && root.left.right ==  null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            if(targetSum == root.val) return true;
            return false;
        }
        int nextLevelSum = targetSum-root.val;
        return hasPathSum(root.left, nextLevelSum) || hasPathSum(root.right, nextLevelSum);
    }

    public int height(TreeNode node) {
        if(node==null) {
            return 0;
        }
        int heightL = height(node.left);
        int heightR = height(node.right);
        return Math.max(heightL, heightR) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int heightL = height(root.left);
        int heightR = height(root.right);
        if(Math.abs(heightL-heightR) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

}
