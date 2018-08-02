package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class DeleteNodeinaBSTTest {
    @Test
    public void test1(){
        DeleteNodeinaBST s=new DeleteNodeinaBST();

        int[] nodes;
        TreeNode root;
        int target;
        TreeNode outputNode;
        int[] output;
        int[] expect;
        int seq=1;

        nodes=new int[]{5,3,6,2,4,7};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        target=3;
        outputNode=s.deleteNode(root,target);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{5,2,6,4,7};
        Util.verifyUnsort(expect,output,seq++);



        nodes=new int[]{15,10,25,5,13,20,30,4,6,12,14,16,22,27,35,8,11,16};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        target=10;
        outputNode=s.deleteNode(root,target);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{15,5,25,4,6,20,30,8,16,22,27,35,13,12,14,11};
        Util.verifyUnsort(expect,output,seq++);


        nodes=new int[]{15,10,25,5,13,20,30,4,6,12,14,16,22,27,35,8,11,16};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        target=25;
        outputNode=s.deleteNode(root,target);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{15,10,20,5,13,16,22,4,6,12,14,30,8,11,27,35};
        Util.verifyUnsort(expect,output,seq++);


        nodes=new int[]{0};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        target=0;
        outputNode=s.deleteNode(root,target);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{};
        Util.verifyUnsort(expect,output,seq++);


        nodes=new int[]{1,2};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        target=2;
        outputNode=s.deleteNode(root,target);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{1};
        Util.verifyUnsort(expect,output,seq++);

    }
}
