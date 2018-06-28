package lintcode.google.level1.other;

import common.Util;
import org.junit.jupiter.api.Test;

public class FirstUniqueCharacterinaStringTest {
    @Test
    public void test1(){
        FirstUniqueCharacterinaString s=new FirstUniqueCharacterinaString();

        String str;
        char expect;
        char output;
        int seq=1;

        str="abaccdeff";
        expect='b';
        output=s.firstUniqChar(str);
        Util.verify(expect,output, seq++);


    }
}
