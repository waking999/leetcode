package history;

import org.junit.jupiter.api.Test;

import static common.Util.verify;

public class RemoveElementTest {
    @Test
    public void test1() {
        RemoveElement a = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int output = a.removeElement(nums, val);
        int expect = 2;
        verify(expect, output, 1);

    }
}
