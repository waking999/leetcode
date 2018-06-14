package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangleTest {

    @Test
    public void test1() {
        PascalsTriangle s = new PascalsTriangle();
        int numRows;
        int seq = 1;

        numRows = 5;
        List<List<Integer>> expect = new ArrayList<>();
        Integer[] row = new Integer[]{1};
        List<Integer> rowList = Arrays.asList(row);
        expect.add(rowList);
        row = new Integer[]{1, 1};
        rowList = Arrays.asList(row);
        expect.add(rowList);
        row = new Integer[]{1, 2, 1};
        rowList = Arrays.asList(row);
        expect.add(rowList);
        row = new Integer[]{1, 3, 3, 1};
        rowList = Arrays.asList(row);
        expect.add(rowList);
        row = new Integer[]{1, 4, 6, 4, 1};
        rowList = Arrays.asList(row);
        expect.add(rowList);
        List<List<Integer>> output = s.generate(numRows);
        Util.verifyUnsort(expect, output, seq++);

    }

}
