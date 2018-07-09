package leetcode.success.array;

/**
 * https://leetcode.com/contest/weekly-contest-92/problems/transpose-matrix/
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class TransposeMatrix {
    public int[][] transpose(int[][] A) {
        if(A==null){
            return null;
        }
        int rLen=A.length;
        if(rLen==0){
            return new int[][]{};
        }
        int cLen=A[0].length;
        if(cLen==0){
            return new int[][]{{}};
        }

        int[][] output=new int[cLen][rLen];

        for(int i=0;i<rLen;i++){
            for(int j=0;j<cLen;j++){
                output[j][i]=A[i][j];
            }
        }

        return output;
    }
}
