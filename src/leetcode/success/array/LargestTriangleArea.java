package leetcode.success.array;

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


    double triangleArea(int[][] points) {

        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];

        return Math.abs((x1 * y2 + y1 * x3 + x2 * y3) - (x1 * y3 + y2 * x3 + y1 * x2)) / 2.0;


    }


}
