package leetcode.success.combination;

import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class LetterCombinationsOfAPhoneNumberTest {
    @Test
    public void test1() {

        LetterCombinationsOfAPhoneNumber s = new LetterCombinationsOfAPhoneNumber();

        String digits;
        String[] expect;

        List<String> output;
        int seq = 1;

        digits = "23";
        expect = new String[]{"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};

        output = s.letterCombinations(digits);
        verifyUnsort(expect, output, seq++);

    }
}
