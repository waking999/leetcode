package leetcode.success.string;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class LongestWordinDictionaryTest {
    @Test
    public void test1() {
        LongestWordinDictionary s = new LongestWordinDictionary();

        String[] words;
        String expect;
        String output;
        int seq = 0;

        words = new String[]{"w", "wo", "wor", "worl", "world"};
        expect = "world";
        output = s.longestWord(words);
        verify(expect, output, seq++);

        words = new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"};
        expect = "apple";
        output = s.longestWord(words);
        verify(expect, output, seq++);

        words = new String[]{"m", "mo", "moc", "moch", "mocha", "l", "la", "lat", "latt", "latte", "c", "ca", "cat"};
        expect = "latte";
        output = s.longestWord(words);
        verify(expect, output, seq++);

    }

}
