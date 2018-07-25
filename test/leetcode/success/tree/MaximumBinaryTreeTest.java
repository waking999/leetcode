package leetcode.success.tree;

import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class MaximumBinaryTreeTest {
    @Test
    public void test1(){
        MaximumBinaryTree s=new MaximumBinaryTree();

        int[] nums;
        TreeNode outputNode;
        int[] output;
        int[] expect;
        int seq=1;

        nums=new int[]{3,2,1,6,0,5};
        outputNode=s.constructMaximumBinaryTree(nums);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{6,3,5,2,0,1};
        Util.verifyUnsort(expect,output,seq++);

    }
}
