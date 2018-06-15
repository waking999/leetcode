package leetcode.success.string;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        int sLen = s.length();
        if (sLen <= 1) {
            return s;
        }

        String[] sArr = s.split(" ");
        List<String> newsArr = new ArrayList<>(sArr.length);

        for (String substr : sArr) {
            String tmp = reverseString(substr);
            newsArr.add(tmp);
        }
        return String.join(" ", newsArr);
    }

    private String reverseString(String s) {
        byte[] bytes = s.getBytes();
        int sLen = s.length();
        int half = 0;
        if (sLen % 2 == 0) {
            half = sLen / 2;
        } else {
            half = (sLen - 1) / 2;
        }

        for (int i = 0; i < half; i++) {
            byte tmp = bytes[i];
            int j = sLen - 1 - i;
            bytes[i] = bytes[j];
            bytes[j] = tmp;
        }

        return new String(bytes);
    }


}
