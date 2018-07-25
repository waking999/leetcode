package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class InsertintoaBinarySearchTreeTest {
    @Test
    public void test1(){
        InsertintoaBinarySearchTree s=new InsertintoaBinarySearchTree();

        int[] nums;
        TreeNode root;
        int val;
        TreeNode outputNode;
        List<Integer> output;
        int[] expect;
        int seq=1;

        nums=new int[]{4,2,7,1,3};
        root=BinarySearchTreeNode.constructTreeNode(nums);
        val=5;
        expect=new int[]{4,2,7,1,3,5};
        outputNode=s.insertIntoBST(root,val);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        Util.verifyUnsort(expect,output,seq++);


        nums=new int[]{6,2,7,1,3};
        root=BinarySearchTreeNode.constructTreeNode(nums);
        val=5;
        expect=new int[]{6,2,7,1,3,5};
        outputNode=s.insertIntoBST(root,val);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        Util.verifyUnsort(expect,output,seq++);


    }
}
