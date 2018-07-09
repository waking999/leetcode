package leetcode.pending;

import common.Util;
import leetcode.pending.WordBreak;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class WordBreakTest {
    @Test
    public void test1() {
        WordBreak s = new WordBreak();

        String str;
        String[] words;
        List<String> wordList;
        boolean expect;
        boolean output;
        int seq = 1;

        str = "leetcode";
        words = new String[]{"leet", "code"};
        wordList = Arrays.asList(words);
        expect = true;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);

        str = "applepenapple";
        words = new String[]{"apple", "pen"};
        wordList = Arrays.asList(words);
        expect = true;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);


        str = "catsandog";
        words = new String[]{"cats", "dog", "sand", "and", "cat"};
        wordList = Arrays.asList(words);
        expect = false;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);


        str = "a";
        words = new String[]{};
        wordList = Arrays.asList(words);
        expect = false;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);

        str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        words = new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        wordList = Arrays.asList(words);
        expect = false;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);


        str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        words = new String[]{"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"};
        wordList = Arrays.asList(words);
        expect = false;
        output = s.wordBreak(str, wordList);
        Util.verify(expect, output, seq++);


    }
}