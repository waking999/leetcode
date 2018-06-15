package leetcode.success.array;

import org.junit.Test;

import static common.Util.verify;

public class RectangleOverlapTest {
    @Test
    public void testIsRectangleOverlap() {
        RectangleOverlap s = new RectangleOverlap();
        int[] rec1;
        int[] rec2;
        int seq = 0;
        boolean expect;
        boolean output;

        rec1 = new int[]{0, 0, 2, 2};
        rec2 = new int[]{1, 1, 3, 3};
        expect = true;
        output = s.isRectangleOverlap(rec1, rec2);
        verify(expect, output, seq++);

        rec1 = new int[]{0, 0, 1, 1};
        rec2 = new int[]{1, 0, 2, 1};
        expect = false;
        output = s.isRectangleOverlap(rec1, rec2);
        verify(expect, output, seq++);


        rec1 = new int[]{7, 8, 13, 15};
        rec2 = new int[]{10, 8, 12, 20};
        expect = true;
        output = s.isRectangleOverlap(rec1, rec2);
        verify(expect, output, seq++);


        rec1 = new int[]{4, 4, 14, 7};
        rec2 = new int[]{4, 3, 8, 8};
        expect = true;
        output = s.isRectangleOverlap(rec1, rec2);
        verify(expect, output, seq++);


        rec1 = new int[]{-687153884, -854669644, -368882013, -788694078};
        rec2 = new int[]{540420176, -909203694, 655002739, -577226067};
        expect = false;
        output = s.isRectangleOverlap(rec1, rec2);
        verify(expect, output, seq++);

    }
}
