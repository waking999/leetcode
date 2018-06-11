package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rtn=new ArrayList<>();
        inorder(root,rtn);
        return rtn;
    }

    private void inorder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);

    }


    @Test
    public void testinorderTraversal(){
        BinaryTreeInorderTraversal s=new BinaryTreeInorderTraversal();

        int[] nodes;
        int[] parents;
        int[] children;
        TreeNode root;
        int[] expect;
        List<Integer> output;
        int seq=0;

        nodes=new int[]{1,2,3};
        parents=new int[]{TreeNode.IMPOSSIBLE_VALUE,0,1};
        children=new int[]{TreeNode.IMPOSSIBLE_VALUE, 1,0};
        expect=new int[]{1,3,2};

        root=NormalBinaryTreeNode.constructTreeNode(nodes,parents,children);
        output=s.inorderTraversal(root);
        Util.verifyUnsort(expect,output,seq++);

    }
}
