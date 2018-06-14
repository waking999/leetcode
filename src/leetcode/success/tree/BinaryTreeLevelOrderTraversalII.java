package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        dfs(root, map, 0);

        int mapSize = map.size();
        for (int i = mapSize - 1; i >= 0; i--) {
            ret.add(map.get(i));
        }

        return ret;
    }

    private void dfs(TreeNode node, Map<Integer, List<Integer>> map, int level) {
        if (node == null) {
            return;
        }

        List<Integer> row;
        if (!map.containsKey(level)) {
            row = new ArrayList<>();
            map.put(level, row);
        } else {
            row = map.get(level);
        }
        row.add(node.val);
        dfs(node.left, map, level + 1);
        dfs(node.right, map, level + 1);
    }


}
