package leetcode.attempt;

import java.util.Arrays;

public class HIndex {
    public int hIndex(int[] citations) {
        if (citations == null) {
            return 0;
        }
        int citationLen = citations.length;
        if (citationLen == 0) {
            return citationLen;
        }

        Arrays.sort(citations);

        int[] citationCount = new int[citationLen + 1];
        for (int c : citations) {
            if (c >= citationLen) {
                citationCount[citationLen]++;
            } else {
                citationCount[c]++;
            }

        }
        int count = 0;
        for (int i = citationLen; i >= 0; i--) {
            count += citationCount[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }


}
