package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class NumberofLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        if((S==null)||(S.length()==0)){
            return new int[]{0,0};
        }
        int[] rtn=new int[2];

        int lineCount=1;
        int currentLenCount=0;
        char[] chs=S.toCharArray();

        for(char ch: chs){
            int chLen=widths[ch-'a'];
            if(currentLenCount+chLen<=100){
                currentLenCount+=chLen;
            }else{
                lineCount++;
                currentLenCount=chLen;
            }
        }

        rtn[0]=lineCount;
        rtn[1]=currentLenCount;

        return rtn;
    }
    @Test
    public void testNumberOfLines(){
        NumberofLinesToWriteString s=new NumberofLinesToWriteString();
        int[] widths;
        String S;
        int[] expect;
        int[] output;
        int seq=0;

        widths = new int[]{10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        S = "abcdefghijklmnopqrstuvwxyz";
        expect=new int[]{3, 60};
        output=s.numberOfLines(widths,S);
        Util.verifyUnsort(expect,output,seq++);




        widths = new int[]{4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
        S = "bbbcccdddaaa";
        expect=new int[]{2, 4};
        output=s.numberOfLines(widths,S);
        Util.verifyUnsort(expect,output,seq++);

    }
}
