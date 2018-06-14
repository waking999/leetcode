package leetcode.success.other;


import org.junit.Test;

import static common.Util.verify;

public class TwoSumIIITest {
    @Test
    public void test1() {
        TwoSumIII t = new TwoSumIII();
        int seq = 1;

        t.add(1);
        t.add(3);
        t.add(5);

        verify(true, t.find(4), seq++);
        verify(false, t.find(7), seq++);

    }


}
