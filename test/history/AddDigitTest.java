package history;

import org.junit.Assert;
import org.junit.Test;

public class AddDigitTest {
    @Test
    public void test1() {
        AddDigit s=new AddDigit();

        int n = 38;
        int actual = s.addDigits(n);
        int expected = 2;
        Assert.assertEquals(expected, actual);

    }
}
