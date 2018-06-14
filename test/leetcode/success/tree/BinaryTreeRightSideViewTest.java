package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.VerifyUtil;
import org.junit.Test;

import java.util.List;

public class BinaryTreeRightSideViewTest {
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
        VerifyUtil.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2, 5};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        childrenPosition = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1};
        expect = new int[]{1, 2, 5};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPosition);
        output = s.rightSideView(root);
        VerifyUtil.verifyUnsort(expect, output, seq++);

        nums = new int[]{1, 2, 3, 4};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 1};
        childrenPosition = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 1};
        expect = new int[]{1, 3, 4};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPosition);
        output = s.rightSideView(root);
        VerifyUtil.verifyUnsort(expect, output, seq++);
    }
}
