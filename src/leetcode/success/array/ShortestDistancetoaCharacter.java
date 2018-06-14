package leetcode.success.array;

import java.util.Arrays;

public class ShortestDistancetoaCharacter {
    public int[] shortestToChar(String S, char C) {

        int lPos = S.indexOf(C);
        if (lPos == -1) {
            return null;
        }

        int sLen = S.length();
        int[] rtn = new int[sLen];
        Arrays.fill(rtn, 0);

        for (int i = 0; i < lPos; i++) {
            rtn[i] = lPos - i;
        }

        int rPos = S.indexOf(C, lPos + 1);
        while (rPos < sLen && rPos != -1) {
            for (int i = lPos + 1; i < rPos; i++) {
                rtn[i] = Math.min(i - lPos, rPos - i);
            }
            lPos = rPos;
            rPos = S.indexOf(C, lPos + 1);
        }

        if (rPos == -1 && lPos < sLen - 1) {
            for (int i = lPos + 1; i < sLen; i++) {
                rtn[i] = i - lPos;
            }
        }

        return rtn;
    }


}