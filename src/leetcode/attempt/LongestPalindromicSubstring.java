package leetcode.attempt;


import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s==null){
            return null;
        }
        int sLen=s.length();
        if(sLen<2){
            return s;
        }
        char[] ch1=s.toCharArray();


        return null;
    }

//    private char[] reverse(char[] ch){
//        int chLen=ch.length;
//        char[] rtn=new char[chLen];
//        for(int i=chLen-1;i>=0;i--){
//            rtn[chLen-1-i]=ch[i];
//        }
//        return rtn;
//    }

    @Test
    public void testlongestPalindrome() {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();

        String str;
        String expect;
        String output;
        int seq = 0;

        str = "babad";
        expect = "bab";
        output = s.longestPalindrome(str);
        Util.verifyUnsort(expect, output, seq++);

        str = "cbbd";
        expect = "bb";
        output = s.longestPalindrome(str);
        Util.verifyUnsort(expect, output, seq++);


    }
}
