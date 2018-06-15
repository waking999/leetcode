package leetcode.pending;

import common.Util;
import org.junit.Test;

import static common.Util.*;

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
        verifySort(expect, output, 1);

    }
}
