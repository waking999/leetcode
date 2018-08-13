package leetcode.success.string;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/uncommon-words-from-two-sentences/description/
 * We are given two sentences A and B.  (A sentence is a string of space separated words.  Each word consists only of lowercase letters.)
 * <p>
 * A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
 * <p>
 * Return a list of all uncommon words.
 * <p>
 * You may return the list in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "this apple is sweet", B = "this apple is sour"
 * Output: ["sweet","sour"]
 * Example 2:
 * <p>
 * Input: A = "apple apple", B = "banana"
 * Output: ["banana"]
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A and B both contain only spaces and lowercase letters.
 */
public class UncommonWordsfromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {

        Map<String, Integer> map = new HashMap();

        String[] aStr = A.split(" ");
        String[] bStr = B.split(" ");

        for (String str : aStr) {
            map.compute(str, (k, v) -> (v == null) ? 1 : v + 1);
        }
        for (String str : bStr) {
            map.compute(str, (k, v) -> (v == null) ? 1 : v + 1);
        }
        List<String> rtnLst = map.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getKey()).collect(Collectors.toList());
        int rtnLen=rtnLst.size();
        String[] rtn = new String[rtnLen];
        rtn = rtnLst.toArray(rtn);

        return rtn;
    }
}
