package leetcode.success.array;

/**
 * https://leetcode.com/problems/diagonal-traverse/description/
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output:  [1,2,4,7,5,3,6,8,9]
 * Explanation:
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix==null){
            return null;
        }
        int m = matrix.length;
        if(m==0){
            return new int[0];
        }
        int n = matrix[0].length;
        if(n==0){
            return new int[0];
        }
        int len = m * n;
        int[] rtn = new int[len];

        int level = 0;
        int rtnSize = 0;
        int mn = m < n ? m : n;
        boolean isDown = true;
        //calculate the first half
        while (level < mn) {
            int i = 0;
            int j = level;
            isDown = !isDown;

            while ((i >= 0 && i < m) && (j >= 0 && j < n)) {
                rtn[rtnSize++] = isDown ? matrix[i][j] : matrix[j][i];
                i++;
                j--;
            }
            level++;
        }


        //calculate the middle
        int repeat = Math.abs(Math.min((mn - m), (mn - n)));
        int time = 0;


        while (time < repeat) {
            isDown = !isDown;


            int i = 0;
            int j = level;

            boolean useWhichIsDown = m < n ? !isDown : isDown;
            if (useWhichIsDown) {
                i = level - mn + 1;
                j = mn - 1;
            }

            boolean flag = (m < n ? isDown : !isDown) ? (i >= 0 && i < mn && j >= time && j <= level) : (j >= 0 && j < mn && i >= time && i <= level);

            while (flag) {
                rtn[rtnSize++] = isDown ? matrix[i][j] : matrix[j][i];
                i++;
                j--;
                flag = (m < n ? isDown : !isDown) ? (i >= 0 && i < mn && j >= time && j <= level) : (j >= 0 && j < mn && i >= time && i <= level);
            }
            time++;
            level++;


        }

        //calculat the later half
        int d= Math.abs(m-n)+1;
        int sum=m + n - 2;
        int start = 1;

        while (level <= (sum)) {

            isDown = !isDown;

            int a = start;
            int b = level - a;

            int i, j;
            if (m < n) {
                i = Math.min(a, b);
                if (!isDown) {
                    i +=sum - level;
                }
                j = level - i;
            } else {
                j = Math.min(a, b);
                if (isDown) {
                    j += sum - level;
                }
                i = level - j;
            }

            boolean flag = m < n ? (i >= start && i < mn && j >=d && j < n) : (j >= start && j < mn && i >= d && i < m);
            while (flag) {
                rtn[rtnSize++] = matrix[i][j];
                if (isDown) {
                    i++;
                    j--;
                } else {
                    i--;
                    j++;
                }
                flag = m < n ? (i >= start && i < mn && j >= d && j < n) : (j >= start && j < mn && i >= d && i < m);
            }

            start++;
            level++;

        }

        return rtn;
    }
}
