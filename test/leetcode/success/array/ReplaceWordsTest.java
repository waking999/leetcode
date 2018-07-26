package leetcode.success.array;

import common.Util;
import leetcode.success.array.ReplaceWords;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ReplaceWordsTest {
    @Test
    public void test1() {
        ReplaceWords s = new ReplaceWords();


        String[] dictStr;
        List<String> dict;
        String sentence;
        String output;
        String expect;
        int seq = 1;

        dictStr = new String[]{"cat", "bat", "rat"};
        dict = Arrays.asList(dictStr);
        sentence = "the cattle was rattled by the battery";
        expect = "the cat was rat by the bat";
        output=s.replaceWords(dict,sentence);
        Util.verify(expect,output,seq++);

        dictStr = new String[]{"cat", "bat", "rat"};
        dict = Arrays.asList(dictStr);
        sentence = "the cattle was rattled by the battery catttle";
        expect = "the cat was rat by the bat cat";
        output=s.replaceWords(dict,sentence);
        Util.verify(expect,output,seq++);

        dictStr = new String[]{"a", "aa", "aaa", "aaaa"};
        dict = Arrays.asList(dictStr);
        sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        expect = "a a a a a a a a bbb baba a";
        output=s.replaceWords(dict,sentence);
        Util.verify(expect,output,seq++);





    }
}
