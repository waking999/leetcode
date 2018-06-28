package lintcode.google.level1.highfreq;

public class ReverseVowelsofaString {
    /**
     * @param s: a string
     * @return: reverse only the vowels of a string
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chs = s.toCharArray();
        int chslen = chs.length;
        int start = 0;
        int end = chslen - 1;
        while (start < end) {
            while (start < end&&!isVowel(chs[start])) {
                start++;
            }
            while (start < end&&!isVowel(chs[end])) {
                end--;
            }
            if (isVowel(chs[start]) && isVowel(chs[end])) {
                char tmp = chs[start];
                chs[start] = chs[end];
                chs[end] = tmp;
                start++;
                end--;
            }
        }

        return new String(chs);
    }

    private boolean isVowel(char ch) {
        return ((ch == 'a') || (ch == 'e') || (ch == 'i') || (ch == 'o') || (ch == 'u')||(ch == 'A') || (ch == 'E') || (ch == 'I') || (ch == 'O') || (ch == 'U'));
    }
}
