package leetcode.pending;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int r = 1;
        for (int i = 1; i * i <= area; i++) {
            if (area % i == 0) {
                r = i;
            }
        }
        return new int[]{area / r, r};
    }


}
