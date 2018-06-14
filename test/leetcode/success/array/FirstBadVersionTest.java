package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class FirstBadVersionTest {


    @Test
    public void test1() {
        FirstBadVersion s = new FirstBadVersion();

        int expect;
        int output;
        int seq = 1;

        s.badVersions = new boolean[]{false, true, true, true, true};
        expect = 1;
        output = s.firstBadVersion(4);
        Util.verify(expect, output, seq++);

    }
}
