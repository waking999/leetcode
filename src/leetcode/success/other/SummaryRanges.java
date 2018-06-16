package leetcode.success.other;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {

        List<String> summary = new ArrayList<>();
        if (nums.length == 0) {
            return summary;
        }

        int start = nums[0];
        int end = nums[0];
        int pointer = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] - nums[pointer]) == 1) {
                end = nums[i];
                pointer++;
            } else {
                String s;
                if (start == end) {
                    s = Integer.toString(start);
                } else {
                    s = start + "->" + end;
                }
                summary.add(s);

                start = nums[i];
                end = nums[i];
                pointer = i;
            }

        }
        String s;
        if (start == end) {
            s = Integer.toString(start);
        } else {
            s = start + "->" + end;
        }
        summary.add(s);
        return summary;
    }


}
