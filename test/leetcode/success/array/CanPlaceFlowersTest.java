package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class CanPlaceFlowersTest {
    @Test
    public void test1() {
        CanPlaceFlowers s = new CanPlaceFlowers();

        int[] flowerbed;
        int n;
        boolean expect;
        boolean output;

        flowerbed = new int[]{1, 0, 0, 0, 1};
        n = 1;
        expect = true;
        output = s.canPlaceFlowers(flowerbed, n);
        verify(expect, output, 1);

        flowerbed = new int[]{1, 0, 0, 0, 1};
        n = 2;
        expect = false;
        output = s.canPlaceFlowers(flowerbed, n);
        verify(expect, output, 2);

        flowerbed = new int[]{1, 0, 0, 0, 0, 0, 1};
        n = 2;
        expect = true;
        output = s.canPlaceFlowers(flowerbed, n);
        verify(expect, output, 3);

        flowerbed = new int[]{0};
        n = 1;
        expect = true;
        output = s.canPlaceFlowers(flowerbed, n);
        verify(expect, output, 4);


        flowerbed = new int[]{0, 0, 0, 0, 1};
        n = 2;
        expect = true;
        output = s.canPlaceFlowers(flowerbed, n);
        verify(expect, output, 5);
    }
}
