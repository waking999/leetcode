package leetcode.success.array;

public class RectangleOverlap {
    private boolean isLine(int[] rec) {
        return ((rec[0] == rec[2]) || (rec[1] == rec[3]));
    }

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        if (isLine(rec1)) {
            return false;
        }

        if (isLine(rec2)) {
            return false;
        }

        for (int i = Math.max(rec1[0], rec2[0]); i < Math.min(rec1[2], rec2[2]); i++) {
            for (int j = Math.max(rec1[1], rec2[1]); j < Math.min(rec1[3], rec2[3]); j++) {
                if (i < rec1[2] && j < rec1[3]) {
                    return true;
                }
            }
        }

        return false;
    }


}
