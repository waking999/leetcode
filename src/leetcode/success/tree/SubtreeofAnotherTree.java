package leetcode.success.tree;

import common.TreeNode;

public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null)
            return false;
        if (t == null)
            return true;
        if (isSameTree(s, t))
            return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null && q != null) {
            return false;
        } else if (p != null && q == null) {
            return false;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }


}
