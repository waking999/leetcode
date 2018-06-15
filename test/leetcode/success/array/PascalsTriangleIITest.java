package leetcode.success.array;

import org.junit.Test;

import java.util.List;

import static common.Util.verifyUnsort;

public class PascalsTriangleIITest {
    @Test
    public void test1() {
        PascalsTriangleII s = new PascalsTriangleII();

        int seq = 1;

        int rowIndex = 0;
        int[] expect = new int[]{1};
        List<Integer> output = s.getRow(rowIndex);
        verifyUnsort(expect, output, seq++);


        rowIndex = 1;
        expect = new int[]{1, 1};

        output = s.getRow(rowIndex);
        verifyUnsort(expect, output, seq++);

        rowIndex = 2;
        expect = new int[]{1, 2, 1};
        output = s.getRow(rowIndex);
        verifyUnsort(expect, output, seq++);

        rowIndex = 3;
        expect = new int[]{1, 3, 3, 1};
        output = s.getRow(rowIndex);
        verifyUnsort(expect, output, seq++);

        rowIndex = 4;
        expect = new int[]{1, 4, 6, 4, 1};
        output = s.getRow(rowIndex);
        verifyUnsort(expect, output, seq++);

    }
}
