package leetcode.success.tree;

import leetcode.success.comm.BinarySearchTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

public class MinimumDistanceBetweenBSTNodes {

    int minDiff;
    Integer prev;

    public int minDiffInBST(TreeNode root) {
        minDiff = Integer.MAX_VALUE;
        prev = null;
        inorder(root);
        return minDiff;
    }

   private void inorder(TreeNode node){
        if(node==null){
            return;
        }
        inorder(node.left);
        if(prev!=null){
            minDiff=Math.min(minDiff, node.val-prev);
        }
        prev=node.val;
        inorder(node.right);
   }




    @Test
    public void testMinDiffInBST() {
        MinimumDistanceBetweenBSTNodes s = new MinimumDistanceBetweenBSTNodes();

        int[] nodes;
        BinarySearchTreeNode root;
        int expect;
        int output;
        int seq = 0;

        nodes = new int[]{4, 2, 6, 1, 3};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.minDiffInBST(root);
        Util.verifyUnsort(expect, output, seq++);

        nodes = new int[]{90, 69, 49, 89, 52};
        root = BinarySearchTreeNode.constructTreeNode(nodes);
        expect = 1;
        output = s.minDiffInBST(root);
        Util.verifyUnsort(expect, output, seq++);


    }
}
