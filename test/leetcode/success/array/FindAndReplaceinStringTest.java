package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class FindAndReplaceinStringTest {
    @Test
    public void test1() {
        FindAndReplaceinString s = new FindAndReplaceinString();

        String S;
        int[] indexes;
        String[] sources;
        String[] targets;
        String expect;
        String output;
        int seq = 1;

        S = "abcd";
        indexes = new int[]{0, 2};
        sources = new String[]{"a", "cd"};
        targets = new String[]{"eee", "ffff"};
        expect = "eeebffff";
        output = s.findReplaceString(S, indexes, sources, targets);
        Util.verify(expect, output, seq++);


        S = "abcd";
        indexes = new int[]{0, 2};
        sources = new String[]{"ab", "ec"};
        targets = new String[]{"eee", "ffff"};
        expect = "eeecd";
        output = s.findReplaceString(S, indexes, sources, targets);
        Util.verify(expect, output, seq++);


        S = "vmokgggqzp";
        indexes = new int[]{3, 5, 1};
        sources = new String[]{"kg", "ggq", "mo"};
        targets = new String[]{"s", "so", "bfr"};
        expect = "vbfrssozp";
        output = s.findReplaceString(S, indexes, sources, targets);
        Util.verify(expect, output, seq++);




        S = "cizokxcijwbyspcfcqws";
        indexes = new int[]{17,1,14,3,9,11};
        sources = new String[]{"qw","iz","cf","okxc","wb","ysp"};
        targets = new String[]{"m","rq","hc","ymfy","mt","drn"};
        expect = "crqymfyijmtdrnhccms";
        output = s.findReplaceString(S, indexes, sources, targets);
        Util.verify(expect, output, seq++);

    }
}
