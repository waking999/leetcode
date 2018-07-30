package leetcode.success.tree;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-largest-value-in-each-tree-row/description/
 * You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
       List<Integer> rtn=new ArrayList<>();

        helper(root,rtn,0);
        return rtn;
    }

    private void helper(TreeNode node, List<Integer> list, int level){
        if(node==null){
            return;
        }
        if(level==list.size()){
            list.add(node.val);
        }else{
            int max=list.get(level);
            if(node.val>max){
                list.set(level,node.val);
            }
        }


        helper(node.left,list,level+1);
        helper(node.right,list,level+1);
    }


}
