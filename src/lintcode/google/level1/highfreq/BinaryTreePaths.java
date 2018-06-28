package lintcode.google.level1.highfreq;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * inary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Example
 * Given the following binary tree:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * All root-to-leaf paths are:
 * <p>
 * [
 * "1->2->5",
 * "1->3"
 * ]
 */
public class BinaryTreePaths {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> rtn = new ArrayList<>();
        String str = "";
        dfs(root, rtn, str);
        return rtn;
    }

    private void dfs(TreeNode node, List<String> rtn, String str) {
        if(node==null){
            return;
        }

        str = str + node.val;
        if (node.left == null && node.right == null) {
            rtn.add(str);
            return;
        } else {


            if (node.left != null) {
                dfs(node.left, rtn, str + "->");
            }
            if (node.right != null) {
                dfs(node.right, rtn, str + "->");
            }
        }


    }
}
