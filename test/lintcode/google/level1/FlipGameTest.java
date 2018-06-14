package lintcode.google.level1;

import org.junit.Test;

import java.util.List;

import static common.Util.*;


public class FlipGameTest {
    @Test
    public void testGeneratePossibleNextMoves() {
        FlipGame s = new FlipGame();

        String str;
        String[] expect;
        List<String> output;
        int seq = 1;

        str = "++++";
        expect = new String[]{"--++", "+--+", "++--"};
        output = s.generatePossibleNextMoves(str);
        verifyUnsort(expect, output, seq++);


        str = "";
        expect = new String[]{};
        output = s.generatePossibleNextMoves(str);
        verifyUnsort(expect, output, seq++);
    }
}
