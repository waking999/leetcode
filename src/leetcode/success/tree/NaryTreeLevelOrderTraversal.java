package leetcode.success.tree;

import common.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/n-ary-tree-level-order-traversal/description/
 * Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * We should return its level order traversal:
 * <p>
 * [
 * [1],
 * [3,2,4],
 * [5,6]
 * ]
 * <p>
 * <p>
 * Note:
 * <p>
 * The depth of the tree is at most 1000.
 * The total number of nodes is at most 5000.
 */
public class NaryTreeLevelOrderTraversal {
    private int maxLevel;

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> rtn = new ArrayList<>();

        if (root == null) {
            return rtn;
        }

        maxLevel = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> line0 = new ArrayList<>();
        line0.add(root.val);
        map.put(0, line0);

        helper(root, 0, map);

        for (int i = 0; i <= maxLevel; i++) {
            List<Integer> line = map.get(i);
            if (line != null && line.size() > 0) {
                rtn.add(line);
            }
        }


        return rtn;
    }

    private void helper(Node node, int level, Map<Integer, List<Integer>> map) {
        List<Integer> line = null;
        List<Node> children = node.children;
        if (children == null) {
            return;
        }
        if (maxLevel < level + 1) {
            maxLevel = level + 1;
        }
        if (map.containsKey(level + 1)) {
            line = map.get(level + 1);
        } else {
            line = new ArrayList<>();
            map.put(level + 1, line);
        }
        for (Node child : children) {
            line.add(child.val);
            helper(child, level + 1, map);
        }

    }


}
