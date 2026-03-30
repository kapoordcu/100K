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

    }

}
