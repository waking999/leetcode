package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        int level = 0;
        dfs(root, level, ret);
        zigzag(ret);
        return ret;
    }

    private void zigzag(List<List<Integer>> list) {
        int listSize = list.size();
        for (int i = 1; i < listSize; i += 2) {
            List<Integer> tmpList = list.get(i);
            Collections.reverse(tmpList);
        }
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
