package leetcode.success.array;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        int start = 0;
        int end = 0;
        int sLen = S.length();
        List<List<Integer>> rtn = new ArrayList<>();

        char startCh = S.charAt(start);

        for (end = 1; end < sLen; end++) {
            char tmpCh = S.charAt(end);
            if (tmpCh != startCh) {
                int dist = end - start;
                if (dist >= 3) {
                    List<Integer> range = new ArrayList<>();
                    range.add(start);
                    range.add(end - 1);
                    rtn.add(range);
                }
                start = end;
                startCh = S.charAt(start);
            }
        }

        if ((end - start) >= 3) {
            List<Integer> range = new ArrayList<>();
            range.add(start);
            range.add(end - 1);
            rtn.add(range);
        }

        return rtn;
    }


}
