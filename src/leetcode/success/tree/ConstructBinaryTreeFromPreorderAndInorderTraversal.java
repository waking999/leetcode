package leetcode.success.tree;

import common.TreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int inorderLen = inorder.length;
        int preorderLen = preorder.length;
        if (inorderLen == 0) {
            return null;
        }
        if (preorderLen == 0) {
            return null;
        }

        if (inorderLen != preorderLen) {
            return null;
        }
        int root = preorder[0];
        int rootInorderPos = rootInorderPosition(inorder, root);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, rootInorderPos);
        int[] rightInorder = Arrays.copyOfRange(inorder, rootInorderPos + 1, inorderLen);

        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootInorderPos + 1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootInorderPos + 1, inorderLen);

        TreeNode node = new TreeNode(root);
        node.left = buildTree(leftPreorder, leftInorder);
        node.right = buildTree(rightPreorder, rightInorder);

        return node;

    }


    private int rootInorderPosition(int[] order, int root) {
        int orderLen = order.length;
        if (orderLen == 0) {
            return -1;
        }
        if (orderLen == 1) {
            return 0;
        }
        for (int i = 0; i < orderLen; i++) {
            if (order[i] == root) {
                return i;
            }
        }
        return -1;
    }


}
