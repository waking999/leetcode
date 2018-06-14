package history;

import org.junit.Assert;
import org.junit.Test;

public class RemoveElementTest {
    @Test
    public void test1() {
        RemoveElement a = new RemoveElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int actual = a.removeElement(nums, val);
        int expected = 2;
        Assert.assertEquals(expected, actual);

    }
}
