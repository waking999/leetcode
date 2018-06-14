package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class FlippinganImageTest {


    @Test
    public void testReverse() {
        FlippinganImage s = new FlippinganImage();

        int[] array;
        int[] expect;
        int seq = 0;


        array = new int[]{1, 1, 0};
        expect = new int[]{1, 0, 0};
        s.reverseAndInvert(array);
        Util.verifyUnsort(expect, array, seq++);
    }

    @Test
    public void testFlipAndInvertImage() {
        FlippinganImage s = new FlippinganImage();

        int[][] A;
        int[][] expect;
        int[][] output;
        int seq = 0;

        A = new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        expect = new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        output = s.flipAndInvertImage(A);
        Util.verifyUnsort(expect, output, seq++);


        A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        expect = new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}};
        output = s.flipAndInvertImage(A);
        Util.verifyUnsort(expect, output, seq++);
    }
}
