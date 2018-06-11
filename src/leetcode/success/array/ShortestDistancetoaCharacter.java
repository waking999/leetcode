package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.Arrays;

public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {

        int lPos=S.indexOf(C);
        if(lPos==-1){
            return null;
        }

        int sLen=S.length();
        int[] rtn=new int[sLen];
        Arrays.fill(rtn,0);

        for(int i=0;i<lPos;i++){
            rtn[i]=lPos-i;
        }

        int rPos = S.indexOf(C, lPos + 1);
        while(rPos<sLen&&rPos!=-1) {
            for (int i = lPos + 1; i < rPos; i++) {
                rtn[i] = Math.min(i - lPos, rPos - i);
            }
            lPos = rPos;
            rPos = S.indexOf(C, lPos + 1);
        }

        if(rPos==-1&&lPos<sLen-1){
            for(int i=lPos+1;i<sLen;i++){
                rtn[i]=i-lPos;
            }
        }

        return rtn;
    }

    @Test
    public void test1() {
        ShortestDistancetoaCharacter s = new ShortestDistancetoaCharacter();
        String S;
        char C;

        int[] expect;
        int[] output;
        int seq = 0;

        S = "loveleetcode";
        C = 'e';
        expect = new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0};
        output = s.shortestToChar(S, C);
        Util.verifyUnsort(expect, output, seq++);


        S = "aaba";
        C = 'b';
        expect = new int[]{2,1,0,1};
        output = s.shortestToChar(S, C);
        Util.verifyUnsort(expect, output, seq++);

    }
}