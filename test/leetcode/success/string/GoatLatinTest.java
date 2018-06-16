package leetcode.success.string;


import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class GoatLatinTest {
    @Test
    public void test1() {
        GoatLatin s = new GoatLatin();
        String S;

        String expect;
        String output;
        int seq = 0;

        S = "I speak Goat Latin";
        expect = "Imaa peaksmaaa oatGmaaaa atinLmaaaaa";
        output = s.toGoatLatin(S);
        verify(expect, output, seq++);

        S = "The quick brown fox jumped over the lazy dog";
        expect = "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa";
        output = s.toGoatLatin(S);
        verify(expect, output, seq++);
    }
}
