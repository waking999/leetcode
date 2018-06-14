package leetcode.pending;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int num) {
        List<String> ret = new ArrayList<>();
        int[][] hours = {{0}, {1, 2, 4, 8}, {3, 5, 9, 6, 10}, {7, 11}};
        int[][] minutes = {{0}, {1, 2, 4, 8, 16, 32}, {3, 5, 9, 17, 33, 6, 10, 18, 34, 12, 20, 36, 24, 40, 48},
                {7, 11, 19, 35, 13, 21, 37, 25, 41, 49, 14, 22, 38, 26, 42, 50, 28, 44, 52, 56},
                {15, 23, 39, 27, 43, 51, 29, 45, 53, 57, 30, 46, 54, 58}, {31, 47, 55, 59}};

        for (int k = 0; k <= num; ++k) {
            int t = num - k;
            if (k > 3 || t > 5)
                continue;
            for (int i = 0; i < hours[k].length; ++i) {
                for (int j = 0; j < minutes[t].length; ++j) {
                    String str = minutes[t][j] < 10 ? "0" + minutes[t][j] : "" + minutes[t][j];

                    ret.add(hours[k][i] + ":" + str);
                }
            }
        }
        return ret;
    }


}
