package leetcode.success.array;

public class FlippinganImage {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null) {
            return null;
        }
        int rowLen = A.length;
        if (rowLen == 0) {
            return A;
        }
        int colLen = A[0].length;
        if (colLen == 0) {
            return A;
        }

        //reverseAndInvert
        for (int[] aA : A) {
            reverseAndInvert(aA);
        }

        return A;
    }

    void reverseAndInvert(int[] array) {
        int arrayLen = array.length;
        int mid = arrayLen / 2;
        for (int i = 0; i < mid; i++) {
            int tmp = 1 - array[i];
            array[i] = 1 - array[arrayLen - 1 - i];
            array[arrayLen - 1 - i] = tmp;
        }
        if (arrayLen % 2 != 0) {
            array[mid] = 1 - array[mid];
        }

    }


}
