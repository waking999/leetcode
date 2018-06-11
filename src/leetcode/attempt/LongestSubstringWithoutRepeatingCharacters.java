package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        int sLen=s.length();
        if(sLen<=1){
            return sLen;
        }
        int longCount=0;
        for(int start=0;start<sLen-1;start++){
            int end=start+1;
            int repeatPos=start;
            for(;end<sLen;end++) {
                boolean noRepeat = true;
                for (int i = start; i < end; i++) {
                    if (s.charAt(i) == s.charAt(end)) {
                        repeatPos=i;
                        noRepeat = false;
                        break;
                    }
                }
                if(!noRepeat){
                    break;
                }
            }
            longCount=Math.max(longCount,end-start);
            start=repeatPos;

        }


        return longCount;
    }

    @Test
    public void testlengthOfLongestSubstring(){
        LongestSubstringWithoutRepeatingCharacters s=new LongestSubstringWithoutRepeatingCharacters();
        String str;
        int expect;
        int output;
        int seq=0;

        str= "abcabcbb";
        expect=3;
        output=s.lengthOfLongestSubstring(str);
        Util.verifyUnsort(expect,output,seq++);


        str= "bbbbb";
        expect=1;
        output=s.lengthOfLongestSubstring(str);
        Util.verifyUnsort(expect,output,seq++);


        str= "pwwkew";
        expect=3;
        output=s.lengthOfLongestSubstring(str);
        Util.verifyUnsort(expect,output,seq++);

        str= "cdd";
        expect=2;
        output=s.lengthOfLongestSubstring(str);
        Util.verifyUnsort(expect,output,seq++);

    }

}
