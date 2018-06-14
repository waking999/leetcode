package leetcode.pending;

import common.Util;
import org.junit.Test;

public class ConstructTheRectangleTest {
    @Test
    public static void main(String[] args) {
        ConstructTheRectangle s = new ConstructTheRectangle();

        int area;
        int[] expect;
        int[] output;

        area = 4;
        expect = new int[] { 2, 2 };
        output = s.constructRectangle(area);
        Util.verifySort(expect, output, 1);

    }
}
