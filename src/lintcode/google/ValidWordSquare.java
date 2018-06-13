package lintcode.google;

import leetcode.success.comm.Util;
import org.junit.Test;

public class ValidWordSquare {
    /**
     * A sequence of words forms a valid word square if the k^th row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).
     *
     * @param words: a list of string
     * @return: a boolean
     */
    public boolean validWordSquare(String[] words) {
        if(words==null){
            return true;
        }
        int wordsLen=words.length;
        if(wordsLen<=1){
            return true;
        }


        for(int i=0;i<wordsLen;i++){
            String word=words[i];
            int wordLen=word.length();
            for(int j=0;j<wordLen;j++){
                if(word.charAt(j)!=words[j].charAt(i)){
                    return false;
                }
            }
        }



        return true;
    }

    @Test
    public void testValidWordSquare() {
        ValidWordSquare s = new ValidWordSquare();

        String[] words;
        boolean expect;
        boolean output;
        int seq = 0;


        words = new String[]{"abcd", "bnrt", "crmy", "dtye"};
        expect = true;
        output = s.validWordSquare(words);
        Util.verify(expect, output, seq++);

        words = new String[]{"abcd", "bnrt", "crm", "dt"};
        expect = true;
        output = s.validWordSquare(words);
        Util.verify(expect, output, seq++);


        words = new String[]{"ball", "area", "read", "lady"};
        expect = false;
        output = s.validWordSquare(words);
        Util.verify(expect, output, seq++);


    }

}
