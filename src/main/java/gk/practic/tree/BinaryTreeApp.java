package gk.practic.tree;

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreeApp {
    List<Integer> result = new ArrayList<>();
    boolean isSame = false;
    boolean isSymmetric = false;
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        return result;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    public List<Integer> inTraversal(TreeNode root) {
        if(root == null) {
            return result;
        }
        preorderTraversal(root.left);
        result.add(root.val);
        preorderTraversal(root.right);
        return result;
    }

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftH = maxDepth(root.left);
        int rightH = maxDepth(root.right);
        return Math.max(leftH, rightH) + 1;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }
        if( (p == null && q != null) ||
                (p != null && q == null) ||
                (p.val != q.val)) {
            return false;
        }
        isSame = isSameTree(p.left, q.left)  && isSameTree(p.right, q.right) ;
        return isSame;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isMirror(root.left, root.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }
}
