package leetcode.success.array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            result.add(row);
            row.add(1);
            if (i == 0) {
                continue;
            }
            List<Integer> lastRow = result.get(i - 1);

            for (int j = 1; j <= i - 1; j++) {
                row.add(j, lastRow.get(j - 1) + lastRow.get(j));
            }
            row.add(1);
        }


        return result;
    }


}
