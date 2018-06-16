package leetcode.success.string;

public class DetectCapital {


    public boolean detectCapitalUse(String word) {
        if (word == null) {
            return true;
        }
        int wordLen = word.length();
        if (wordLen == 0) {
            return true;
        }

        int cnt = 0;
        char[] wordArr = word.toCharArray();
        for (char c : wordArr) {
            if ('Z' - c >= 0) {
                cnt++;
            }
        }
        return cnt == 0 || cnt == wordLen || (cnt == 1 && 'Z' - word.charAt(0) >= 0);


    }

}
