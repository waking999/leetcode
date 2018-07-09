package leetcode.pending.dp;

import common.Util;
import leetcode.pending.dp.PalindromePartitioning;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PalindromePartitioningTest {
    @Test
    public void test1() {
        PalindromePartitioning s = new PalindromePartitioning();

        String str;
        String[][] expect;
        List<List<String>> output;
        int seq = 1;

        str = "aab";
        expect = new String[][]{{"a", "a", "b"}, {"aa", "b"}};
        output = s.partition(str);
        Util.verifyUnsort(expect, output, seq++);


        str = "cbbbcc";

    }
}
