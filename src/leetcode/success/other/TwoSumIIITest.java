package leetcode.success.other;

import leetcode.success.comm.Util;
import org.junit.Test;

public class TwoSumIIITest {
    @Test
    public void test1(){
        TwoSumIII t=new TwoSumIII();
        int seq=1;

        t.add(1);
        t.add(3);
        t.add(5);

        Util.verify(true,t.find(4),seq++);
        Util.verify(false,t.find(7),seq++);

    }


}
