package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        int level = 0;
        dfs(root, level, ret);

        return ret;
    }

    private void dfs(TreeNode node, int level, List<List<Integer>> list) {
        if (node == null) {
            return;
        }
        int listSize = list.size();
        List<Integer> row;
        if (listSize <= level) {
            row = new ArrayList<>();
            list.add(row);
        } else {
            row = list.get(level);
        }

        row.add(node.val);
        dfs(node.left, level + 1, list);
        dfs(node.right, level + 1, list);
    }


}
