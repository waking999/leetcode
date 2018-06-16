package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Stack<Integer> path = new Stack<>();
        dfs(root, path, ret, sum);
        return ret;
    }

    private void dfs(TreeNode node, Stack<Integer> path, List<List<Integer>> result, int sum) {
        if (node == null) {
            return;
        }
        path.push(node.val);
        if (node.left == null && node.right == null && sumStack(path) == sum) {
            result.add(generatePath(path));
        } else {
            if (node.left != null) {
                dfs(node.left, path, result, sum);
                path.pop();
            }
            if (node.right != null) {
                dfs(node.right, path, result, sum);
                path.pop();
            }
        }
    }

    private List<Integer> generatePath(List<Integer> list) {
        return new ArrayList<>(list);
    }

    private int sumStack(Stack<Integer> s) {

        Iterator<Integer> it = s.iterator();
        int sum = 0;
        while (it.hasNext()) {
            sum += it.next();
        }
        return sum;
    }


}
