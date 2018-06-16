package leetcode.pending;

import org.junit.jupiter.api.Test;

import java.util.List;

import static common.Util.verifySort;

public class FindAllAnagramsinAStringTest {
    @Test
    public void test1() {
        FindAllAnagramsinAString s = new FindAllAnagramsinAString();

        String str1;
        String str2;
        int[] expect;
        List<Integer> output;

        str1 = "cbaebabacd";
        str2 = "abc";
        expect = new int[]{0, 6};
        output = s.findAnagrams(str1, str2);
        verifySort(expect, output, 1);

        str1 = "abab";
        str2 = "ab";
        expect = new int[]{0, 1, 2};
        output = s.findAnagrams(str1, str2);
        verifySort(expect, output, 2);


    }
}
