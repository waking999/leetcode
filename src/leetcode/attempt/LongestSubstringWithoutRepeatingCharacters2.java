package leetcode.attempt;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters2 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        int sLen=s.length();
        if(sLen<=1){
            return sLen;
        }
        int[] frequency=new int[256];
        int[] pre=new int[256];


        Arrays.fill(frequency,0);
        Arrays.fill(pre,-1);




        int maxDis=0;
        for(int i=0;i<sLen;i++){
            char c=s.charAt(i);
            frequency[c]++;
            if(frequency[c]==1){
                pre[c]=i;
            }else{
                int diff=i-pre[c];
                pre[c]=i;
                maxDis=Math.max(maxDis,diff);
            }
        }

        for(int i=0;i<256;i++){
            if(frequency[i]>0){
                if(frequency[i]==1){
                    int pos=pre[i];

                    int repeatStart=-1;
                    char repeatChar='a';
                    for(int j=pos+1;j<sLen;j++){
                        char c=s.charAt(j);
                        if(frequency[c]>1){
                            repeatStart= j;
                            repeatChar=c;
                            break;
                        }
                    }


                    if(repeatStart==-1||repeatStart==sLen-1){
                        int diff=sLen-pos;
                        maxDis=Math.max(maxDis,diff);
                    }else{

                        for(int j=repeatStart+1;j<sLen;j++){
                            char c=s.charAt(j);
                            if(c==repeatChar){
                                int diff=j-pos;
                                maxDis=Math.max(maxDis,diff);
                                break;
                            }
                        }
                    }

                    for(int j=pos-1;j>=0;j--){
                        char c=s.charAt(j);
                        if(frequency[c]>1){
                            repeatStart= j;
                            repeatChar=c;
                            break;
                        }
                    }

                    if(repeatStart==-1||repeatStart==0){
                        int diff=pos;
                        maxDis=Math.max(maxDis,diff);
                    }else{

                        for(int j=repeatStart-1;j>=0;j--){
                            char c=s.charAt(j);
                            if(c==repeatChar){
                                int diff=pos-j;
                                maxDis=Math.max(maxDis,diff);
                                break;
                            }
                        }
                    }
                }
            }
        }

        return maxDis;
    }



    @Test
    public void testlengthOfLongestSubstring(){
        LongestSubstringWithoutRepeatingCharacters2 s=new LongestSubstringWithoutRepeatingCharacters2();
        String str;
        int expect;
        int output;
        int seq=0;

        str= "abcabcbb";
        expect=3;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);


        str= "bbbbb";
        expect=1;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);


        str= "pwwkew";
        expect=3;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);

        str= "cdd";
        expect=2;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);

        str= "aab";
        expect=2;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);

        str= "abba";
        expect=2;
        output=s.lengthOfLongestSubstring(str);
        Util.verify(expect,output,seq++);

    }

}
