package leetcode.pending;

import org.junit.Test;

import static common.Util.verifyUnsort;

public class KeyboardRowTest {
    @Test
    public void test1() {
        KeyboardRow s = new KeyboardRow();

        String[] words;
        String[] expect;
        String[] output;

        words = new String[]{"Hello", "Alaska", "Dad", "Peace"};
        expect = new String[]{"Alaska", "Dad"};
        output = s.findWords(words);
        verifyUnsort(expect, output, 1);

    }
}
