package leetcode.success.bit;

import common.Util;
import leetcode.success.bit.MaximumProductofWordLengths;
import org.junit.jupiter.api.Test;

public class MaximumProductofWordLengthsTest {
    @Test
    public void test1(){
        MaximumProductofWordLengths s=new MaximumProductofWordLengths();

        String[] words;
        int expect;
        int output;
        int seq=1;

        words=new String[]{"abcw","baz","foo","bar","xtfn","abcdef"};
        expect=16;
        output=s.maxProduct(words);
        Util.verify(expect,output,seq++);

        words=new String[]{"a","ab","abc","d","cd","bcd","abcd"};
        expect=4;
        output=s.maxProduct(words);
        Util.verify(expect,output,seq++);

        words=new String[]{"a","aa","aaa","aaaa"};
        expect=0;
        output=s.maxProduct(words);
        Util.verify(expect,output,seq++);


    }
}
