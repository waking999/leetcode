package leetcode.success.tree;

import common.BinarySearchTreeNode;
import common.TreeNode;
import common.Util;
import org.junit.jupiter.api.Test;

public class SerializeandDeserializeBSTTest {
    @Test
    public void testSerialize(){
        SerializeandDeserializeBST s=new SerializeandDeserializeBST();

        int[] nodes;
        TreeNode root;
        String output;
        String expect;
        int seq=1;

        nodes=new int[]{5,3,6,2,4,7};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        expect="5,3,6,2,4,7";
        output=s.serialize(root);
        Util.verify(expect,output,seq++);

        nodes=new int[]{};
        root= BinarySearchTreeNode.constructTreeNode(nodes);
        expect="";
        output=s.serialize(root);
        Util.verify(expect,output,seq++);
    }

    @Test
    public void testDeserialize(){
        SerializeandDeserializeBST s=new SerializeandDeserializeBST();

       String str;
        TreeNode outputNode;
        int[] output;
        int[] expect;
        int seq=1;



        str="5,3,6,2,4,7";
        outputNode=s.deserialize(str);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{5,3,6,2,4,7};
        Util.verifyUnsort(expect,output,seq++);


        str="";
        outputNode=s.deserialize(str);
        output=TreeNode.unconstructTreeNode(outputNode);
        expect=new int[]{};
        Util.verifyUnsort(expect,output,seq++);

    }
}
