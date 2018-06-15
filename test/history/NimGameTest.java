package history;

import org.junit.Test;

import static common.Util.verify;

public class NimGameTest {
    @Test
    public void test1() {
        NimGame s = new NimGame();
        int n;
        boolean ouptut;
        boolean expect;
        int seq = 1;

        n = 4;
        ouptut = s.canWinNim(n);
        expect = false;
        verify(expect, ouptut, seq++);


        n = 1;
        ouptut = s.canWinNim(n);
        expect = true;
        verify(expect, ouptut, seq++);


        n = 16;
        ouptut = s.canWinNim(n);
        expect = false;
        verify(expect, ouptut, seq++);


        n = 17;
        ouptut = s.canWinNim(n);
        expect = true;
        verify(expect, ouptut, seq++);

    }
}
