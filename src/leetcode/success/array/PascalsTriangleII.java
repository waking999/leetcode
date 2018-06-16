package leetcode.success.array;

import java.util.Arrays;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row = new Integer[rowIndex + 1];
        Arrays.fill(row, 1);
        List<Integer> rowList = Arrays.asList(row);
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                rowList.set(j, rowList.get(j) + rowList.get(j - 1));
            }
        }
        return rowList;
    }


}
