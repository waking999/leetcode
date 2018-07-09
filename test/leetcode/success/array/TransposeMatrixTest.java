package leetcode.success.array;

import common.Util;
import leetcode.success.array.TransposeMatrix;
import org.junit.jupiter.api.Test;

public class TransposeMatrixTest {
    @Test
    public void test1(){
        TransposeMatrix s=new TransposeMatrix();

        int[][] A;
        int[][] expect;
        int[][] output;
        int seq=1;

        A=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        expect=new int[][]{{1,4,7},{2,5,8},{3,6,9}};
        output=s.transpose(A);
        Util.verifyUnsort(expect, output, seq++);

        A=new int[][]{{1,2,3},{4,5,6}};
        expect=new int[][]{{1,4},{2,5},{3,6}};
        output=s.transpose(A);
        Util.verifyUnsort(expect, output, seq++);
    }
}
