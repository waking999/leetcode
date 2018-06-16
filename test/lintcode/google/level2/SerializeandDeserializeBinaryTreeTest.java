package lintcode.google.level2;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import org.junit.jupiter.api.Test;

import static common.Util.verify;
import static common.Util.verifyUnsort;

public class SerializeandDeserializeBinaryTreeTest {
    @Test
    public void testserialize() {
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();

        int[] nums;
        int[] parentIdxs;
        int[] childrenPos;
        TreeNode root;
        String expect;
        String output;
        int seq = 1;

        nums = new int[]{3, 9, 20, 15, 7};
        parentIdxs = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 0, 2, 2};
        childrenPos = new int[]{TreeNode.IMPOSSIBLE_VALUE, 0, 1, 0, 1};
        root = NormalBinaryTreeNode.constructTreeNode(nums, parentIdxs, childrenPos);
        expect = "3,9,#,#,20,15,#,#,7,#,#,";
        output = s.serialize(root);
        verify(expect, output, seq++);
    }


    @Test
    public void testdeserialize() {
        SerializeandDeserializeBinaryTree s = new SerializeandDeserializeBinaryTree();

        String data;
        TreeNode outputNode;
        int[] output;
        int[] expect;

        int seq = 1;

        data = "3,9,#,#,20,19,#,#,7,#,#,";
        outputNode = s.deserialize(data);
        output = NormalBinaryTreeNode.unconstructTreeNode(outputNode);
        expect = new int[]{3, 9, 20, 15, 7};
        verifyUnsort(expect, output, seq++);
    }
}
