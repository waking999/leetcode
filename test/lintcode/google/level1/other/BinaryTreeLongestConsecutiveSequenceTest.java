package lintcode.google.level1.other;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class BinaryTreeLongestConsecutiveSequenceTest {
    @Test
    public void test1(){
        BinaryTreeLongestConsecutiveSequence s=new BinaryTreeLongestConsecutiveSequence();

        int[] nodes;
        int[] parentIdxs;
        int[] childrenPos;
        TreeNode root;
        int expect;
        int output;
        int seq=1;


        nodes=new int[]{1,3,2,4,5};
        parentIdxs=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,1,3};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,1,0,1,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdxs,childrenPos);
        expect=3;
        output=s.longestConsecutive(root);
        Util.verify(expect,output,seq++);



        nodes=new int[]{2,3,2,1};
        parentIdxs=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,2};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,1,0,0};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdxs,childrenPos);
        expect=2;
        output=s.longestConsecutive(root);
        Util.verify(expect,output,seq++);
    }
}
