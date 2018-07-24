package leetcode.success.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/leaf-similar-trees/description/
 * Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 *
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Note:
 *
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null&&root2==null){
            return true;
        }
        if((root1==null&&root2!=null)||(root1!=null&&root2==null)){
            return false;
        }

        List<Integer> leaves1=new ArrayList<>();
        List<Integer> leaves2=new ArrayList<>();

        getLeaf(root1,leaves1);
        getLeaf(root2,leaves2);

        int leavs1Len=leaves1.size();
        int leavs2Len=leaves2.size();
        if(leavs1Len!=leavs2Len){
            return false;
        }
        for(int i=0;i<leavs1Len;i++){
            int a=leaves1.get(i);
            int b=leaves2.get(i);
            if(a!=b){
                return false;
            }
        }

        return true;
    }

    private void getLeaf(TreeNode root,List<Integer> leaves) {
         if(root==null){
             return ;
         }

         if(root.left==null&&root.right==null){
             leaves.add(root.val);
             return;
         }
         if(root.left!=null){
             getLeaf(root.left,leaves);
         }
         if(root.right!=null){
             getLeaf(root.right,leaves);
         }


    }

}
