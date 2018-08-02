package leetcode.success.tree;

import common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-bst/description/
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeandDeserializeBST {
    private final static String SEP = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                sb.append(node.val).append(SEP);
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null || right != null) {
                    q.add(left);
                    q.add(right);
                }

            }

        }

        if (sb.length() > 1) {

            return sb.substring(0, sb.length() - 1);
        }
        return "";
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        if(data.length()==0){
            return null;
        }

        String[] nodeStrs = data.split(SEP);

        int nodesLen = nodeStrs.length;
        if (nodesLen == 0) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(nodeStrs[0]));

        for (int i = 1; i < nodesLen; i++) {
            add(root, Integer.parseInt(nodeStrs[i]));
        }

        return root;
    }

    private void add(TreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                add(node.left, value);
            } else {

                node.left = new TreeNode(value);
            }
        } else if (value > node.val) {
            if (node.right != null) {
                add(node.right, value);
            } else {

                node.right = new TreeNode(value);
            }
        }
    }


}
