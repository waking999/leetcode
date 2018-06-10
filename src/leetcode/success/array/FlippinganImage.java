package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return null;
        }
        int rowLen = A.length;
        if (rowLen == 0) {
            return A;
        }
        int colLen = A[0].length;
        if (colLen == 0) {
            return A;
        }

        //reverseAndInvert
        for (int[] aA : A) {
            reverseAndInvert(aA);
        }

        return A;
    }

    private void reverseAndInvert(int[] array) {
        int arrayLen = array.length;
        int mid = arrayLen / 2;
        for (int i = 0; i < mid; i++) {
            int tmp = 1-array[i];
            array[i] = 1-array[arrayLen - 1 - i];
            array[arrayLen - 1 - i] = tmp;
        }
        if(arrayLen%2!=0){
            array[mid]=1-array[mid];
        }

    }




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
        Util.verify(expect, output, seq++);


        A = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        expect = new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}};
        output = s.flipAndInvertImage(A);
        Util.verify(expect, output, seq++);
    }
}
