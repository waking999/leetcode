package leetcode.success.array;


import leetcode.success.comm.Util;
import org.junit.Test;

public class ImageSmootherTest {
    @Test
    public void test1() {
        ImageSmoother s = new ImageSmoother();

        int[][] M;
        int[][] expect;
        int[][] output;
        int seq=1;

        M = new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        expect = new int[][] { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        output=s.imageSmoother(M);
        Util.verifyUnsort(expect, output, seq++);

        M = new int[][] { { 1 } };
        expect = new int[][] { { 1} };
        output=s.imageSmoother(M);
        Util.verifyUnsort(expect, output,seq++);

        M = new int[][] { { 2,3 } };
        expect = new int[][] { { 2,2} };
        output=s.imageSmoother(M);
        Util.verifyUnsort(expect, output,seq++);

        System.out.println("Finish");
    }
}
