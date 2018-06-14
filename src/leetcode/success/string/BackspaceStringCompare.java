package leetcode.success.string;

public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        }

        if (S == null || T == null) {
            return false;
        }

        String s1 = processStrWithSharp(S);
        String t1 = processStrWithSharp(T);

        return s1.equals(t1);
    }

    private String processStrWithSharp(String str) {
        StringBuilder sb = new StringBuilder();
        int sLen = str.length();
        for (int i = 0; i < sLen; i++) {
            char c = str.charAt(i);
            if (c == '#') {
                int sbLen = sb.length();
                sbLen--;
                if (sbLen < 0) {
                    sbLen = 0;
                }

                sb.setLength(sbLen);
            } else {
                sb.append(c);
            }
        }


        return sb.toString();
    }


}
