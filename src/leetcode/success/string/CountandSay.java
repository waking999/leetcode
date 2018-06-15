package leetcode.success.string;

public class CountandSay {
    public String countAndSay(int n) {
        if (n < 1) {
            return null;
        }
        String res = "1";
        int i = 1;
        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            int resLen = res.length();
            char[] resChars = res.toCharArray();
            for (int j = 1; j < resLen; j++) {
                if (resChars[j] == resChars[j - 1]) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(resChars[j - 1]);
                    count = 1;
                }
            }
            sb.append(count);
            sb.append(resChars[resLen - 1]);
            res = sb.toString();
            i++;
        }
        return res;
    }


}
