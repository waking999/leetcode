package lintcode.google.level2.required;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Kth Smallest Element in a BST
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * Example
 * Given root = {1,#,2}, k = 2, return 2.
 *
 * Challenge
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class KthSmallestElementinaBST {


    /**
     * @param root: the given BST
     * @param k:    the given k
     * @return the kth smallest element in BST
     */
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> nums=new ArrayList<>();

        inorder(root,nums);


        return nums.get(k-1);
    }

    private void inorder(TreeNode root,List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left,nums);
        nums.add(root.val);
        inorder(root.right,nums);

    }


}
