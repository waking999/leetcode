package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AllNodesDistanceKinBinaryTreeTest {
    @Test
    public void test1(){
        AllNodesDistanceKinBinaryTree s=new AllNodesDistanceKinBinaryTree();

        int[] nodes;
        int[] parentIdx;
        int[] childrenPos;
        TreeNode root;
        TreeNode target;
        int K;
        int[] expect;
        List<Integer> output;
        int seq=1;



        nodes=new int[]{1};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,1);
        K=3;
        expect=new int[]{};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);


        nodes=new int[]{3,5,1,6,2,0,8,7,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,1,1,2,2,4,4};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,5);
        K=2;
        expect=new int[]{7,4,1};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);



        //target is left of parent, parent is left of parent.parent
        nodes=new int[]{12,10,13,3,11,5,1,6,2,0,8,7,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,1,1,3,3,5,5,6,6,8,8};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1,0,1,0,1,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,5);
        K=2;
        expect=new int[]{7,4,1,10};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);


        //target is left of parent, parent is right of parent.parent
        nodes=new int[]{12,13,10,3,11,5,1,6,2,0,8,7,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,2,2,3,3,5,5,6,6,8,8};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1,0,1,0,1,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,5);
        K=2;
        expect=new int[]{7,4,1,10};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);


        //target is right of parent, parent is left of parent.parent
        nodes=new int[]{12,10,13,3,11,1,5,0,8,6,2,7,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,1,1,3,3,5,5,6,6,10,10};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1,0,1,0,1,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,5);
        K=2;
        expect=new int[]{7,4,1,10};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);


        //target is right of parent, parent is left of parent.parent
        nodes=new int[]{12,13,10,3,11,1,5,0,8,6,2,7,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,0,2,2,3,3,5,5,6,6,10,10};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,0,1,0,1,0,1,0,1,0,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,5);
        K=2;
        expect=new int[]{7,4,1,10};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);




        nodes=new int[]{0,1,2,3,4};
        parentIdx=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,2,3};
        childrenPos=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1,1,1};
        root=NormalBinaryTreeNode.constructTreeNode(nodes,parentIdx,childrenPos);
        target=NormalBinaryTreeNode.findNode(root,3);
        K=0;
        expect=new int[]{3};
        output=s.distanceK(root,target,K);
        Util.verifySort(expect,output,seq++);

    }
}
