package leetcode.success.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * https://leetcode.com/problems/replace-words/description/
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * Note:
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */
public class ReplaceWords {
//    public String replaceWords(List<String> dict, String sentence) {
//        if (sentence == null || dict == null) {
//            return sentence;
//        }
//        int dictSize = dict.size();
//        int sentenceLen = sentence.length();
//        if (dictSize == 0 || sentenceLen == 0) {
//            return sentence;
//        }
//
//        sentence=" "+sentence;
//
//        for (String d : dict) {
//            String pattern = "[\\s]+"+d+"([\\w]+)";
//            sentence=sentence.replaceAll(pattern," "+d);
//        }
//
//        return sentence.substring(1);
//    }

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || dict == null) {
            return sentence;
        }
        int dictSize = dict.size();
        int sentenceLen = sentence.length();
        if (dictSize == 0 || sentenceLen == 0) {
            return sentence;
        }
        Set<String> dictSet=new HashSet<>();
        for(String d:dict){
            dictSet.add(d);
        }

        StringBuilder sb=new StringBuilder();
        String[] words=sentence.split(" ");
        for(String word:words){
            String prefix = "";
            for (int i = 1; i <= word.length(); i++) {
                prefix = word.substring(0, i);
                if (dict.contains(prefix)) {
                    break;
                }
            }
            sb.append(" " + prefix);
        }

        return sb.substring(1);

    }
}
