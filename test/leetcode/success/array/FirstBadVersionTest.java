package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

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
        verify(expect, output, seq++);

    }
}
