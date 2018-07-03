package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * We are given a binary tree (with root node root), a target node, and an integer value `K`.
 * <p>
 * Return a list of the values of all nodes that have a distance K from the target node.  The answer can be returned in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * Output: [7,4,1]
 * Explanation:
 * The nodes that are a distance 2 from the target node (with value 5)
 * have values 7, 4, and 1.
 * <p>
 * Note that the inputs "root" and "target" are actually TreeNodes.
 * The descriptions of the inputs above are just serializations of these objects.
 * <p>
 * Note:
 * <p>
 * The given tree is non-empty.
 * Each node in the tree has unique values 0 <= node.val <= 500.
 * The target node is a node in the tree.
 * 0 <= K <= 1000.
 */
public class AllNodesDistanceKinBinaryTree {
    private TreeNode targetNode;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> rtn = new ArrayList<>();
        if (K == 0) {
            rtn.add(target.val);
            return rtn;
        }

        if (root == null) {
            return rtn;
        }

        //find grand-children
        grantChildrenHelper(target, K, rtn);

        /*
         * find sibling tree's children
         * 1. rotate: p1:target, p2:target.parent, p3:parent.parent
         * 2. repeat: i) p1.left(right)=p2; ii) p2.left(right)=null if p1 is p2.left(right); iii) p1=p2,p2=p3, p3=p3.parent; until p3 is null
         * 3. if p2 is not null, i) p1.left(right)=p2; ii) p2.left(right)=null if p1 is p2.left(right);
         */
        target.left = null;
        target.right = null;

        TreeNode p1 = target;
        TreeNode p2 = findParentNode(root, p1.val);
        TreeNode p3 = null;
        if (p2 != null) {
            p3 = findParentNode(root, p2.val);
        }
        System.out.println();

        while (p2 != null && p3 != null) {
            if (p1.left == null) {
                p1.left = p2;
            } else {
                p1.right = p2;
            }

            if (p2.left == p1) {
                p2.left = null;
            } else {
                p2.right = null;
            }

            p1 = p2;
            p2 = p3;
            p3 = findParentNode(root, p3.val);
        }

        if (p2 != null) {
            if (p1.left == null) {
                p1.left = p2;
            } else {
                p1.right = p2;
            }

            if (p2.left == p1) {
                p2.left = null;
            } else {
                p2.right = null;
            }
        }


        //find grand-children
        grantChildrenHelper(target, K, rtn);


        return rtn;
    }

    private void grantChildrenHelper(TreeNode node, int distance, List
            <Integer> result) {
        if (node == null) {
            return;
        }
        if (distance < 0) {
            return;
        }
        if (distance == 0) {
            result.add(node.val);
        }
        grantChildrenHelper(node.left, distance - 1, result);
        grantChildrenHelper(node.right, distance - 1, result);
    }

    public TreeNode findParentNode(TreeNode root, int targetVal) {
        targetNode = null;
        findParentNodeHelper(root, targetVal);
        return targetNode;
    }

    private void findParentNodeHelper(TreeNode node, int targetVal) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.val == targetVal) {
            targetNode = node;
            return;
        }
        if (node.right != null && node.right.val == targetVal) {
            targetNode = node;
            return;
        }
        if (targetNode == null) {
            findParentNodeHelper(node.left, targetVal);
        }
        if (targetNode == null) {
            findParentNodeHelper(node.right, targetVal);
        }

    }
}
