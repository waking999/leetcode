package common;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NormalBinaryTreeNode extends TreeNode {

    private static TreeNode targetNode;

    public NormalBinaryTreeNode(int x) {
        super(x);
    }

    public static TreeNode constructTreeNode(Integer[] nodes) {
        int nodesLen = nodes.length;
        if (nodesLen == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);

        Queue<TreeNode> parent = new LinkedList<>();
        parent.add(root);
        for (int i = 1; i < nodesLen; i++) {
            TreeNode c = null;
            if (i % 2 != 0) {
                if (nodes[i] != null) {
                    c = new TreeNode(nodes[i]);
                    parent.add(c);
                    TreeNode t = parent.peek();
                    t.left = c;
                }
            } else {
                if (nodes[i] != null) {
                    c = new TreeNode(nodes[i]);
                    parent.add(c);
                    TreeNode t = parent.poll();
                    t.right = c;
                } else {
                    parent.poll();
                }
            }


        }

        return root;
    }

    public static TreeNode constructTreeNode(int[] nodes, int[] parentIdxs, int[] childrenPosition) {
        int nodesLen = nodes.length;
        if (nodesLen == 0) {
            return null;
        }
        TreeNode root = new TreeNode(nodes[0]);
        for (int i = 1; i < nodesLen; i++) {
            TreeNode node = findParentNode(root, nodes, parentIdxs, childrenPosition, parentIdxs[i]);
            int pos = childrenPosition[i];
            if (pos == 0) {
                if (nodes[i] != IMPOSSIBLE_VALUE) {
                    node.left = new TreeNode(nodes[i]);
                }
            } else {
                if (nodes[i] != IMPOSSIBLE_VALUE) {
                    node.right = new TreeNode(nodes[i]);
                }
            }
        }

        return root;

    }

    public static TreeNode findNode(TreeNode root, int targetVal) {
        targetNode = null;
        findNodeHelper(root, targetVal);
        return targetNode;
    }

    private static void findNodeHelper(TreeNode node, int targetVal) {
        if (node == null) {
            return;
        }
        if (node.val == targetVal) {
            targetNode = node;
            return;
        }
        if (targetNode == null) {
            findNodeHelper(node.left, targetVal);
        }
        if (targetNode == null) {
            findNodeHelper(node.right, targetVal);
        }

    }


    private static TreeNode findParentNode(TreeNode root, int[] nodes, int[] parents, int[] children, int parentIdx) {
        Stack<int[]> backTrackStack = new Stack<>();
        while (parents[parentIdx] != IMPOSSIBLE_VALUE) {
            backTrackStack.push(new int[]{nodes[parentIdx], children[parentIdx]});
            parentIdx = parents[parentIdx];
        }

        TreeNode node = root;
        while (!backTrackStack.isEmpty()) {
            int[] tmpInfo = backTrackStack.pop();
            int val = tmpInfo[0];
            int child = tmpInfo[1];

            if (child == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            assert (node.val == val) : "wrong node";
        }

        return node;

    }

    // private static TreeNode dfs(TreeNode root, int val ) {
    // Stack<TreeNode> s = new Stack<TreeNode>();
    //
    // s.push(root);
    // while (!s.isEmpty()) {
    // TreeNode node = s.pop();
    // if (node == null) {
    // continue;
    // }
    // if (node.val == val) {
    // if(node.left==null||node.right==null){
    // return node;
    // }else{
    // continue;
    // }
    //
    // } else {
    // TreeNode left = (TreeNode)node.left;
    // TreeNode right = (TreeNode)node.right;
    // s.push(right);
    // s.push(left);
    // }
    // }
    // return null;
    // }

}