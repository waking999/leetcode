package leetcode.success.other;

import common.Util;
import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class SummaryRangesTest {
    @Test
    public void test1() {
        SummaryRanges s = new SummaryRanges();
        int seq = 1;

        int[] input = {0, 1, 2, 4, 5, 7};
        String[] expect = {"0->2", "4->5", "7"};
        List<String> output = s.summaryRanges(input);
        verifyUnsort(expect, output, seq++);

        input = new int[]{0, 2, 3, 4, 6, 8, 9};
        expect = new String[]{"0", "2->4", "6", "8->9"};
        output = s.summaryRanges(input);
        verifyUnsort(expect, output, seq++);

        input = new int[]{};
        expect = new String[]{};
        output = s.summaryRanges(input);
        verifyUnsort(expect, output, seq++);
    }
}
