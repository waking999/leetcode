package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LargestTriangleArea {
    public double largestTriangleArea(int[][] points) {
        int pointsLen = points.length;
        if (pointsLen < 3) {
            return 0;
        }

        int potentialPointsLen = points.length;
        double maxArea = 0;
        int[][] tmpPoints = new int[3][2];
        for (int i = 0; i < potentialPointsLen - 2; i++) {
            int[] a = points[i];
            tmpPoints[0][0] = a[0];
            tmpPoints[0][1] = a[1];
            for (int j = i + 1; j < potentialPointsLen - 1; j++) {
                int[] b = points[j];
                tmpPoints[1][0] = b[0];
                tmpPoints[1][1] = b[1];
                for (int k = j + 1; k < potentialPointsLen; k++) {
                    int[] c = points[k];
                    tmpPoints[2][0] = c[0];
                    tmpPoints[2][1] = c[1];

                    double tmpArea = triangleArea(tmpPoints);
                    if (tmpArea > maxArea) {
                        maxArea = tmpArea;
                    }
                }
            }
        }

        return maxArea;


    }


    private double triangleArea(int[][] points) {

        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return Math.abs((x1 * y2 + y1 * x3 + x2 * y3) - (x1 * y3 + y2 * x3 + y1 * x2)) / 2.0;


    }

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
        Util.verifyUnsort(expect, output, seq++);


        points = new int[][]{{0, 0}, {1, 1}, {3, -1}};
        expect = 2;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);


        points = new int[][]{{1, 0}, {0, 0}, {0, 1}};
        expect = 0.5;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);


        points = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        expect = 5.5;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);

        points = new int[][]{{9, 4}, {5, 8}, {6, 1}};
        expect = 12;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);


        points = new int[][]{{9, 7}, {6, 10}, {1, 10}};
        expect = 7.5;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);

        points = new int[][]{{9, 7}, {1, 10}, {2, 7}};
        expect = 12;
        output = s.triangleArea(points);
        Util.verifyUnsort(expect, output, seq++);
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
        Util.verifyUnsort(expect, output, seq);


        points = new int[][]{{4, 6}, {6, 5}, {3, 1}};
        expect = 5.5;
        output = s.largestTriangleArea(points);
        Util.verifyUnsort(expect, output, seq);


        points = new int[][]{{9, 4}, {5, 8}, {6, 1}};
        expect = 12;
        output = s.largestTriangleArea(points);
        Util.verifyUnsort(expect, output, seq++);


        points = new int[][]{{9, 7}, {6, 10}, {1, 10}, {2, 7}};
        expect = 10.5;
        output = s.largestTriangleArea(points);
        Util.verifyUnsort(expect, output, seq++);

        points = new int[][]{{2,5},{7,7},{10,8},{10,10},{1,1}};
        expect = 14.5;
        output = s.largestTriangleArea(points);
        Util.verifyUnsort(expect, output, seq++);

    }
}
