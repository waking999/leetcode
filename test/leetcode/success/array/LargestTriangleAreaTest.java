package leetcode.success.array;

import common.Util;
import org.junit.Test;

public class LargestTriangleAreaTest {
    @Test
    public void testTriangleArea() {
        LargestTriangleArea s = new LargestTriangleArea();

        int[][] points;
        double expect;
        double output;
        int seq = 0;


        points = new int[][]{{0, 0}, {0, 1}, {1, 0}};
        expect = 0.5;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);


        points = new int[][]{{0, 0}, {1, 1}, {3, -1}};
        expect = 2;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);


        points = new int[][]{{1, 0}, {0, 0}, {0, 1}};
        expect = 0.5;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);


        points = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        expect = 5.5;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);

        points = new int[][]{{9, 4}, {5, 8}, {6, 1}};
        expect = 12;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);


        points = new int[][]{{9, 7}, {6, 10}, {1, 10}};
        expect = 7.5;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);

        points = new int[][]{{9, 7}, {1, 10}, {2, 7}};
        expect = 12;
        output = s.triangleArea(points);
        Util.verify(expect, output, seq++);
    }


    @Test
    public void testLargestTriangleArea() {
        LargestTriangleArea s = new LargestTriangleArea();

        int[][] points;
        double expect;
        double output;
        int seq = 0;

        points = new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}};
        expect = 2;
        output = s.largestTriangleArea(points);
        Util.verify(expect, output, seq);


        points = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        expect = 5.5;
        output = s.largestTriangleArea(points);
        Util.verify(expect, output, seq);


        points = new int[][]{{9, 4}, {5, 8}, {6, 1}};
        expect = 12;
        output = s.largestTriangleArea(points);
        Util.verify(expect, output, seq++);


        points = new int[][]{{9, 7}, {6, 10}, {1, 10}, {2, 7}};
        expect = 10.5;
        output = s.largestTriangleArea(points);
        Util.verify(expect, output, seq++);

        points = new int[][]{{2,5},{7,7},{10,8},{10,10},{1,1}};
        expect = 14.5;
        output = s.largestTriangleArea(points);
        Util.verify(expect, output, seq++);

    }
}
