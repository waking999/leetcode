package history;

import common.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LowestCommonAncestorOfBinarySearchTreeTest {
    @Test
    public void test1() {
        LowestCommonAncestorOfBinarySearchTree x = new LowestCommonAncestorOfBinarySearchTree();

        TreeNode n01 = new TreeNode(6);
        TreeNode n02 = new TreeNode(2);
        TreeNode n03 = new TreeNode(8);
        TreeNode n04 = new TreeNode(0);
        TreeNode n05 = new TreeNode(4);
        TreeNode n06 = new TreeNode(7);
        TreeNode n07 = new TreeNode(9);
        TreeNode n08 = new TreeNode(3);
        TreeNode n09 = new TreeNode(5);

        n01.left = n02;
        n01.right = n03;

        n02.left = n04;
        n02.right = n05;

        n03.left = n06;
        n03.right = n07;

        n05.left = n08;
        n05.right = n09;

        TreeNode a = x.lowestCommonAncestor(n01, n05, n02);
        Assertions.assertEquals(n02.val, a.val);

        a = x.lowestCommonAncestor(n01, n02, n03);
        Assertions.assertEquals(n01.val, a.val);

        a = x.lowestCommonAncestor(n01, n09, n06);
        Assertions.assertEquals(n01.val, a.val);

        a = x.lowestCommonAncestor(n01, n09, n04);
        Assertions.assertEquals(n02.val, a.val);


    }
}
