package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class VerifyPreorderSerializationofaBinaryTreeTest {
    @Test
    public void test1(){
        VerifyPreorderSerializationofaBinaryTree s=new VerifyPreorderSerializationofaBinaryTree();
        String preorder;
        boolean expect;
        boolean output;
        int seq=1;

        preorder="9,3,4,#,#,1,#,#,2,#,6,#,#";
        expect=true;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="1,#";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);


        preorder="9,#,#,1";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="#";
        expect=true;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="#,#,#";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="1";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="#,#,3,5,#";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

        preorder="7,2,#,2,#,#,#,6,#";
        expect=false;
        output=s.isValidSerialization(preorder);
        Util.verify(expect,output,seq++);

    }
}
