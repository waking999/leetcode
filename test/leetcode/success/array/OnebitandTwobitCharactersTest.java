package leetcode.success.array;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class OnebitandTwobitCharactersTest {
    @Test
    public void test1() {
        OnebitandTwobitCharacters s = new OnebitandTwobitCharacters();

        int[] bits;
        boolean expect;
        boolean output;
        int seq = 0;

        bits = new int[]{1, 0, 0};
        expect = true;
        output = s.isOneBitCharacter(bits);
        verify(expect, output, seq++);

        bits = new int[]{1, 1, 1, 0};
        expect = false;
        output = s.isOneBitCharacter(bits);
        verify(expect, output, seq++);

    }
}
