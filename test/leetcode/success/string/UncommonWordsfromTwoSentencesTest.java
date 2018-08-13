package leetcode.success.string;

import common.Util;
import org.junit.jupiter.api.Test;

public class UncommonWordsfromTwoSentencesTest {
    @Test
    public void test1(){
        UncommonWordsfromTwoSentences s=new UncommonWordsfromTwoSentences();
        /*
         *
         * Input: A = "this apple is sweet", B = "this apple is sour"
         * Output: ["sweet","sour"]
         * Example 2:
         *
         * Input: A = "apple apple", B = "banana"
         * Output: ["banana"]
         */
        String A;
        String B;
        String[] expect;
        String[] output;
        int seq=1;

        A = "this apple is sweet";
        B = "this apple is sour";
        expect=new String[]{"sweet","sour"};
        output=s.uncommonFromSentences(A,B);
        Util.verifySort(expect,output,seq++);

        A = "apple apple";
        B = "banana";
        expect=new String[]{"banana"};
        output=s.uncommonFromSentences(A,B);
        Util.verifySort(expect,output,seq++);

        A = "apple apple";
        B = "apple banana";
        expect=new String[]{"banana"};
        output=s.uncommonFromSentences(A,B);
        Util.verifyUnsort(expect,output,seq++);

    }
}
