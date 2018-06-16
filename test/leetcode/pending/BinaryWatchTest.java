package leetcode.pending;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static common.Util.verifyUnsort;

public class BinaryWatchTest {
    @Test
    public void test1() {
        BinaryWatch s = new BinaryWatch();

        int num;
        String[] expect;
        List<String> output;
        int seq = 1;

        num = 1;
        expect = new String[]{"1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"};
        Arrays.sort(expect);
        output = s.readBinaryWatch(num);
        verifyUnsort(expect, output, seq++);


    }
}
