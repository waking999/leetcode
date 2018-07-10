package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinaryTreePruningTest {
    @Test
    public void test1(){
        BinaryTreePruning s=new BinaryTreePruning();

        Integer[] nodes;
        TreeNode root;
        TreeNode outputNode;
        Integer[] expect;
        List<Integer> output;
        int seq=1;


        nodes=new Integer[]{1,null,0,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes);
        outputNode=s.pruneTree(root);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        expect=new Integer[]{1,null,0,null,1};
        Util.verifyUnsort(expect,output,seq++);

        nodes=new Integer[]{1,0,1,0,0,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes);
        outputNode=s.pruneTree(root);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        expect=new Integer[]{1,null,1,null,1};
        Util.verifyUnsort(expect,output,seq++);


        nodes=new Integer[]{1,1,0,1,1,0,1,0};
        root=NormalBinaryTreeNode.constructTreeNode(nodes);
        outputNode=s.pruneTree(root);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        expect=new Integer[]{1,1,0,1,1,null,1};
        Util.verifyUnsort(expect,output,seq++);

        nodes=new Integer[]{0,1,0,0,1,1,1,null,0,1,0,1,1,1,null,1,1,1,0,0,1,null,0,0,0,1,1,0,1,0,0,0,1,1,0,1,0,0,0,0,1,1,1,null,1,1,null,null,0,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null};
        root=NormalBinaryTreeNode.constructTreeNode(nodes);
        outputNode=s.pruneTree(root);
        output=TreeNode.unconstructTreeNodeList(outputNode);
        expect=new Integer[]{0,1,0,0,1,1,1,null,0,1,0,1,1,1,null,1,1,1,0,0,1,null,0,0,0,1,1,null,1,null,null,null,1,1,null,1,null,null,null,null,1,1,1,null,1,1};
        Util.verifyUnsort(expect,output,seq++);


    }
}
