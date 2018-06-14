package leetcode.success.string;

import leetcode.success.comm.Util;
import org.junit.Test;

public class GoatLatin {
    public String toGoatLatin(String S) {
        /*
        The rules of Goat Latin are as follows:

        If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
        For example, the word 'apple' becomes 'applema'.

        If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
        For example, the word "goat" becomes "oatgma".

        Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
        For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
        */
        StringBuilder sb=new StringBuilder();
        String[] words=S.split(" ");
        int wordsLen=words.length;

        for(int i=0;i<wordsLen;i++){
            String word=words[i];

            //rule 1
            char c=word.charAt(0);
            if((c=='a')||(c=='e')||(c=='i')||(c=='o')||(c=='u')||(c=='A')||(c=='E')||(c=='I')||(c=='O')||(c=='U')){
                sb.append(word).append("ma");
            }else{
                sb.append(word.substring(1)).append(c).append("ma");
            }

            for(int j=0;j<=i;j++){
                sb.append("a");
            }
            sb.append(" ");
        }

        sb.setLength(sb.length()-1);
        return sb.toString();
    }



}
