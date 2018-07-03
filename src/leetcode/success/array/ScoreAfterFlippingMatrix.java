package leetcode.success.array;

/**
 * We have a two dimensional matrix A where each value is 0 or 1.
 *
 * A move consists of choosing any row or column, and toggling each value in that row or column: changing all 0s to 1s, and all 1s to 0s.
 *
 * After making any number of moves, every row of this matrix is interpreted as a binary number, and the score of the matrix is the sum of these numbers.
 *
 * Return the highest possible score.
 *
 *
 *
 * Example 1:
 *
 * Input: [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
 * Output: 39
 * Explanation:
 * Toggled to [[1,1,1,1],[1,0,0,1],[1,1,1,1]].
 * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
 *
 *
 * Note:
 *
 * 1 <= A.length <= 20
 * 1 <= A[0].length <= 20
 * A[i][j] is 0 or 1.
 */
public class ScoreAfterFlippingMatrix {
    private int sum;
    public int matrixScore(int[][] A) {
        sum=0;
        if(A==null){
            return 0;
        }
        int rLen=A.length;
        if(rLen==0){
            return 0;
        }
        int cLen=A[0].length;
        if(cLen==0){
            return 0;
        }

        //let each row start from 1
        for(int i=0;i<rLen;i++){
            if(A[i][0]==0){
                toggleRow(A,i,cLen);
            }
        }

        sum+=rLen*(int)Math.pow(2,cLen-1);

        for(int i=1;i<cLen;i++){
            int count=countOfOne(A,i,rLen);
            if(count>=rLen-count) {
                sum += count * (int) (Math.pow(2, cLen - 1 - i));
            }else{
                sum +=  (rLen-count) * (int) (Math.pow(2, cLen - 1 - i));
            }
        }


        return sum;
    }

    private void toggleRow(int[][] A,int rowIdx,int cLen){
        for(int i=0;i<cLen;i++){
            if(A[rowIdx][i]==1){
                A[rowIdx][i]=0;
            }else{
                A[rowIdx][i]=1;
            }
        }
    }


    private int countOfOne(int[][] A,int colIdx,int rLen){
        int count=0;
        for(int i=0;i<rLen;i++){
            if(A[i][colIdx]==1){
                count++;
            }
        }
        return count;
    }
}
