package leetcode.attempt;

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
        int m = matrix.length;
        int n = matrix[0].length;
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

            boolean useWhichIsDown=m < n ? !isDown : isDown;
            if(useWhichIsDown){
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


        int start =  1;

        while (level <= (m + n - 2)) {

            isDown = !isDown;

            int i =  level%2!=0 ?start:mn-1;
            int j = level - i;
            if(start%2==0){
                i=j;
                j=level-i;
            }
            boolean flag = (start%2!=0) ? (i >= start && i < mn && j <n  && j >= mn+repeat-2) : (j >= start && j < mn && i <n && i >  mn+repeat-2);
            while (flag) {
                rtn[rtnSize++] = start%2!=0 ? matrix[i][j] : matrix[j][i];
                i++;
                j--;
                flag = (start%2!=0) ? (i >= start && i < mn && j <n  && j >= mn+repeat-2) : (j >= start && j < mn && i <n && i >  mn+repeat-2);

            }

            start++;
            level++;

        }

        return rtn;
    }
}
