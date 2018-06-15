package leetcode.success.array;


public class RotateImage {
    public void rotate(int[][] matrix) {
        int rLen = matrix.length;
        if (rLen < 2) {
            return;
        }

        int[] array = convertMartixToArray(matrix);
        int k = 0;
        for (int j = rLen - 1; j >= 0; j--) {
            for (int i = 0; i < rLen; i++) {
                matrix[i][j] = array[k];
                k++;
            }
        }

    }

    private int[] convertMartixToArray(int[][] matrix) {
        int rLen = matrix.length;
        int cLen = matrix[0].length;
        int len = rLen * cLen;
        int[] rtn = new int[len];
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                int idx = i * rLen + j;
                rtn[idx] = matrix[i][j];
            }
        }
        return rtn;
    }


}
