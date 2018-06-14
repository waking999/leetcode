package leetcode.success.string;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (s == null) {
            return 0;
        }

        s = s.trim();
        int sLen = s.length();
        if (sLen <= 1) {
            return sLen;
        }
        String[] sArr = s.split(" ");
        int count = 0;
        for (String str : sArr) {
            if (!"".equals(str.trim())) {
                count++;
            }
        }

        return count;
    }


}
