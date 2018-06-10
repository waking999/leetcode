package leetcode.success.string;

import leetcode.success.comm.Util;
import org.junit.Test;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if(S==null&&T==null){
            return true;
        }

        if(S==null || T==null){
            return false;
        }

        String s1=processStrWithSharp(S);
        String t1=processStrWithSharp(T);

        return s1.equals(t1);
    }

    private String processStrWithSharp(String str){
        StringBuilder sb=new StringBuilder();
        int sLen= str.length();
        for(int i=0;i<sLen;i++){
            char c=str.charAt(i);
            if(c=='#'){
                int sbLen=sb.length();
                sbLen--;
                if(sbLen<0){
                    sbLen=0;
                }

                sb.setLength(sbLen);
            }else{
                sb.append(c);
            }
        }



        return sb.toString();
    }

    @Test
    public void test1() {
        BackspaceStringCompare s = new BackspaceStringCompare();
        String S;
        String T;
        boolean expect;
        boolean output;
        int seq = 0;

        S = "ab#c";
        T = "ad#c";
        expect = true;
        output = s.backspaceCompare(S, T);
        Util.verify(expect, output, seq++);


        S = "ab##";
        T = "c#d#";
        expect = true;
        output = s.backspaceCompare(S, T);
        Util.verify(expect, output, seq++);


        S = "a##c";
        T = "#a#c";
        expect = true;
        output = s.backspaceCompare(S, T);
        Util.verify(expect, output, seq++);


        S = S = "a#c";
        T = "b";
        expect = false;
        output = s.backspaceCompare(S, T);
        Util.verify(expect, output, seq++);


    }


}
