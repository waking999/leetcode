package leetcode.success.string;

import org.junit.Test;

import static common.Util.verify;

public class MagicDictionaryTest {
    @Test
    public void test1() {
        MagicDictionary s = new MagicDictionary();

        String[] dict;
        boolean expect;
        boolean output;

        dict = new String[]{"hello", "leetcode"};
        s.buildDict(dict);
        expect = false;
        output = s.search("hello");
        verify(expect, output, 1);
        expect = true;
        output = s.search("hhllo");
        verify(expect, output, 1);
        expect = false;
        output = s.search("hell");
        verify(expect, output, 1);
        expect = false;
        output = s.search("leetcoded");
        verify(expect, output, 1);

    }
}
