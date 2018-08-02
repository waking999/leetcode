package leetcode.success.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        if (s == null) {
            return null;
        }
        int sLen = s.length();
        if (sLen <= 2) {
            return s;
        }

        char[] chs = s.toCharArray();

        int[] count = new int[128];
        Arrays.fill(count, 0);

        for (char ch : chs) {
            count[ch]++;
        }
        TreeSet<Wrap> set = new TreeSet<>();
        for (int i = 0; i < 128; i++) {
            if (count[i] > 0) {
                set.add(new Wrap(((char) (i)), count[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Wrap w : set) {
            int wCount = w.count;
            char wCh = w.ch;
            for (int i = 0; i < wCount; i++) {
                sb.append(wCh);
            }
        }

        return sb.toString();
    }

    class Wrap implements Comparable<Wrap> {
        char ch;
        int count;

        Wrap(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }


        @Override
        public int compareTo(Wrap w) {
            if (this.ch == w.ch) {
                return 0;
            }
            if (this.count == w.count) {
                return this.ch - w.ch;
            }
            return w.count - this.count;
        }
    }
}
