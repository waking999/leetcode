package leetcode.success.array;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class ShortestDistancetoaCharacterTest {
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
        verifyUnsort(expect, output, seq++);


        S = "aaba";
        C = 'b';
        expect = new int[]{2, 1, 0, 1};
        output = s.shortestToChar(S, C);
        verifyUnsort(expect, output, seq++);

    }
}
