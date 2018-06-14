package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    List<Integer> rightSideLst;


    public List<Integer> rightSideView(TreeNode root) {

        rightSideLst = new ArrayList<>();

        preOrder(root, 0);
        return rightSideLst;
    }

    private void preOrder(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level == rightSideLst.size()) {
            rightSideLst.add(node.val);
        }
        preOrder(node.right, level + 1);
        preOrder(node.left, level + 1);
    }


}
