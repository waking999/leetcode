package leetcode.pending;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/word-break/description/
 *
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s==null){
            return true;
        }
        if(wordDict==null){
            return false;
        }
        int sLen=s.length();
        if(sLen==0){
            return true;
        }
        int wordDictLen=wordDict.size();
        if(wordDictLen==0){
            return false;
        }

        Set<Character> strSet=new HashSet<>();
        Set<Character> wordDictSet=new HashSet<>();
        char[] chars= s.toCharArray();
        for(char ch:chars){
            strSet.add(ch);
        }
        for(String word:wordDict){
            char[] wordChars=word.toCharArray();
            for(char ch:wordChars){
                wordDictSet.add(ch);
                if(!strSet.contains(ch)){
                   wordDict.remove(word);
                   break;
                }
            }
        }

        strSet.removeAll(wordDictSet);

        if(!strSet.isEmpty()){
            return false;
        }

        found=false;
        for(String word:wordDict){
            int wordLen=word.length();
            dfs(s,sLen,0,wordLen,wordDict,word);
            if(found){
                return true;
            }
        }

        return false;
    }

    private boolean found;



    private void dfs(String s,int sLen,int l, int r, List<String> wordDict,String word){
        if(r>=sLen+1){
            return;
        }
        if(!word.equals(s.substring(l,r))){
            return;
        }
        if(r>=sLen){
            found=true;
            return;
        }
        for(String word1:wordDict){
            int word1Len=word1.length();
            dfs(s,sLen,r,r+word1Len,wordDict,word1);
            if(found){
                break;
            }
        }
    }


}
