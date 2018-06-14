package leetcode.attempt;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int sLen = s.length();
        if (sLen <= 1) {
            return sLen;
        }
        int longCount = 0;
        for (int start = 0; start < sLen - 1; start++) {
            int end = start + 1;
            int repeatPos = start;
            for (; end < sLen; end++) {
                boolean noRepeat = true;
                for (int i = start; i < end; i++) {
                    if (s.charAt(i) == s.charAt(end)) {
                        repeatPos = i;
                        noRepeat = false;
                        break;
                    }
                }
                if (!noRepeat) {
                    break;
                }
            }
            longCount = Math.max(longCount, end - start);
            start = repeatPos;

        }


        return longCount;
    }


}
