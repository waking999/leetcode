package leetcode.success.tree;

import leetcode.success.comm.NormalBinaryTreeNode;
import leetcode.success.comm.TreeNode;
import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    List<Integer> rightSideLst;


    public List<Integer> rightSideView(TreeNode root) {

        rightSideLst=new ArrayList<>();

        preOrder(root,0);
        return rightSideLst;
    }

    private void preOrder(TreeNode node,int level){
        if(node==null){
            return;
        }
        if(level == rightSideLst.size()){
            rightSideLst.add(node.val);
        }
        preOrder(node.right,level+1);
        preOrder(node.left,level+1);
    }

    @Test
    public void testrightSideView() {
        BinaryTreeRightSideView s = new BinaryTreeRightSideView();

        int[] nums;
        int[] parentIdxs;
        int[] childrenPosition;
        TreeNode root;
        int[] expect;
        List<Integer> output;
        int seq = 1;

        nums = new int[]{1, 2, 3, 5, 4};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1, 2};
        childrenPosition = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1, 1};
        expect = new int[]{1, 3, 4};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPosition);
        output = s.rightSideView(root);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2, 5};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        childrenPosition = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        expect = new int[]{1, 2, 5};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPosition);
        output = s.rightSideView(root);
        Util.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2, 3, 4};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1};
        childrenPosition = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1};
        expect = new int[]{1, 3, 4};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPosition);
        output = s.rightSideView(root);
        Util.verifyUnsort(expect, output, seq++);
    }
}
