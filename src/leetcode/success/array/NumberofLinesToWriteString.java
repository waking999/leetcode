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

}
