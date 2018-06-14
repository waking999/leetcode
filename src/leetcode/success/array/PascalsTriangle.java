package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            result.add(row);
            row.add(1);
            if (i == 0) {
                continue;
            }
            List<Integer> lastRow = result.get(i - 1);

            for (int j = 1; j <= i - 1; j++) {
                row.add(j, lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
        }


        return result;
    }

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
