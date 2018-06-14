package history;

import org.junit.Assert;
import org.junit.Test;

public class NimGameTest {
    @Test
    public void test1() {
        NimGame s=new NimGame();

        int n = 4;
        boolean actual = s.canWinNim(n);
        boolean expected = false;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test2() {
        NimGame s=new NimGame();

        int n = 1;
        boolean actual = s.canWinNim(n);
        boolean expected = true;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test3() {
        NimGame s=new NimGame();

        int n = 16;
        boolean actual = s.canWinNim(n);
        boolean expected = false;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void test4() {
        NimGame s=new NimGame();

        int n = 17;
        boolean actual = s.canWinNim(n);
        boolean expected = true;
        Assert.assertEquals(expected, actual);

    }
}
