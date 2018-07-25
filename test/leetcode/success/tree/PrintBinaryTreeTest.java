package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PrintBinaryTreeTest {
    @Test
    public void test1() {
        PrintBinaryTree s = new PrintBinaryTree();

        Integer[] nodes;
        TreeNode root;
        List<List<String>> output;
        String[][] expect;
        int seq = 1;

        nodes = new Integer[]{1, 2};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        output = s.printTree(root);
        expect = new String[][]{{"", "1", ""},
                {"2", "", ""}};
        Util.verifyUnsort(expect, output, seq++);

        nodes = new Integer[]{1, 2, 3, null, 4};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        output = s.printTree(root);
        expect = new String[][]{{"", "", "", "1", "", "", ""},
                {"", "2", "", "", "", "3", ""},
                {"", "", "4", "", "", "", ""}};
        Util.verifyUnsort(expect, output, seq++);

        nodes = new Integer[]{1, 2, 5, 3, null, null, null, 4};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        output = s.printTree(root);
        expect = new String[][]{{"", "", "", "", "", "", "", "1", "", "", "", "", "", "", ""},
                {"", "", "", "2", "", "", "", "", "", "", "", "5", "", "", ""},
                {"", "3", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"4", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}};
        Util.verifyUnsort(expect, output, seq++);

        nodes = new Integer[]{3, null, 30, 10, null, null, 15, null, 45};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        output = s.printTree(root);
        expect = new String[][]{{"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "3", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "30", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "10", "", "", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "15", "", "", "", "", "", "", "", "", ""},
                {"", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "45", "", "", "", "", "", "", "", ""}};
        Util.verifyUnsort(expect, output, seq++);

        nodes = new Integer[]{5, 3, 6, 2, 4, null, 7};
        root = NormalBinaryTreeNode.constructTreeNode(nodes);
        output = s.printTree(root);
        expect = new String[][]{{"", "", "", "5", "", "", ""}, {"", "3", "", "", "", "6", ""}, {"2", "", "4", "", "", "", "7"}};
        Util.verifyUnsort(expect, output, seq++);
    }

}
