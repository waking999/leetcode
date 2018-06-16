package history;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class AddDigitTest {
    @Test
    public void test1() {
        AddDigit s = new AddDigit();
        int seq = 1;

        int n = 38;
        int output = s.addDigits(n);
        int expected = 2;
        verify(expected, output, seq++);

    }
}
