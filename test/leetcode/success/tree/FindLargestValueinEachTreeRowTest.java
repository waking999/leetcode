package leetcode.success.tree;

import common.NormalBinaryTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindLargestValueinEachTreeRowTest {
    @Test
    public void test1(){
        FindLargestValueinEachTreeRow s=new FindLargestValueinEachTreeRow();

        Integer[] nodes;
        TreeNode root;
        int[] expect;
        List<Integer> output;
        int seq=1;


        nodes=new Integer[]{1,3,2,5,3,null,9};
        root= NormalBinaryTreeNode.constructTreeNode(nodes);
        expect=new int[]{1,3,9};
        output=s.largestValues(root);
        Util.verifyUnsort(expect,output,seq++);


    }
}
