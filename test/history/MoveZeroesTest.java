package history;

import org.junit.Assert;
import org.junit.Test;

public class MoveZeroesTest {
    @Test
    public void test1() {
        MoveZeroes a = new MoveZeroes();

        int[] nums = {0, 1, 0, 3, 12};
        int[] expecteds = {1, 3, 12, 0, 0};

        a.moveZeroes(nums);
        Assert.assertArrayEquals(expecteds, nums);

    }

    @Test
    public void test2() {
        MoveZeroes a = new MoveZeroes();

        int[] nums = {0, 0, 1};
        int[] expecteds = {1, 0, 0};

        a.moveZeroes(nums);
        Assert.assertArrayEquals(expecteds, nums);

    }
}
