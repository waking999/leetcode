package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class ShortestCompletingWordTest {
    @Test
    public void test1() {
        ShortestCompletingWord s = new ShortestCompletingWord();

        String licensePlate;
        String[] words;
        String expect;
        String output;
        int seq = 1;

        licensePlate = "1s3 PSt";
        words = new String[]{"step", "steps", "stripe", "stepple"};
        expect = "steps";
        output = s.shortestCompletingWord(licensePlate, words);
        Util.verify(expect, output, seq++);

        licensePlate = "1s3 456";
        words = new String[]{"looks", "pest", "stew", "show"};
        expect = "pest";
        output = s.shortestCompletingWord(licensePlate, words);
        Util.verify(expect, output, seq++);


    }
}
