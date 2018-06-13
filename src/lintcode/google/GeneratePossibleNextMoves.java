package lintcode.google;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GeneratePossibleNextMoves {
    public List<String> generatePossibleNextMoves(String s) {
        // write your code here
        if (s == null) {
            return null;
        }

        List<String> set = new ArrayList<>();
        int sLen = s.length();
        if (s.length() < 2) {
            return set;
        }

        for (int i = 0; i < sLen - 1; i++) {
            if (s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String newStr=s.substring(0,i)+"--"+s.substring(i+2);
                set.add(newStr);
            }
        }


        return set;
    }

    @Test
    public void testGeneratePossibleNextMoves() {
        GeneratePossibleNextMoves s = new GeneratePossibleNextMoves();

        String str;
        String[] expect;
        List<String> output;
        int seq = 1;

        str = "++++";
        expect = new String[]{"--++", "+--+", "++--"};
        output = s.generatePossibleNextMoves(str);
        Util.verifyUnsort(expect, output, seq++);


        str = "";
        expect = new String[]{""};
        output = s.generatePossibleNextMoves(str);
        Util.verifyUnsort(expect, output, seq++);
    }
}
