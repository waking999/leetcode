package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

public class BullsandCowsTest {
    @Test
    public void test1() {
        BullsandCows s = new BullsandCows();

        String secret;
        String guess;
        String output;
        String expect;
        int seq = 1;

        secret = "1807";
        guess = "7810";
        expect = "1A3B";
        output = s.getHint(secret, guess);
        Util.verify(expect, output, seq++);

        secret = "1123";
        guess = "0111";
        expect = "1A1B";
        output = s.getHint(secret, guess);
        Util.verify(expect, output, seq++);

        secret = "1";
        guess = "0";
        expect = "0A0B";
        output = s.getHint(secret, guess);
        Util.verify(expect, output, seq++);

        secret = "1122"        ;
        guess ="1222";
        expect = "3A0B";
        output = s.getHint(secret, guess);
        Util.verify(expect, output, seq++);
    }
}
