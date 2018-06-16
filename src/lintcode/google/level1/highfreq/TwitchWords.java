package lintcode.google.level1.highfreq;

/**
 * Twitch Words
 * Our normal words do not have more than two consecutive letters. If there are three or more consecutive letters, this is a tics. Now give a word, from left to right, to find out the starting point and ending point of all tics.
 * <p>
 * Example
 * Given str = "whaaaaatttsup", return [[2,6],[7,9]].
 * <p>
 * Explanation:
 * "aaaa" and "ttt" are twitching letters, and output their starting and ending points.
 * Given str = "whooooisssbesssst", return [[2,5],[7,9],[12,15]].
 * <p>
 * Explanation:
 * "ooo", "sss" and "ssss" are twitching letters, and output their starting and ending points.
 */
public class TwitchWords {
    /**
     * @param str: the origin string
     * @return: the start and end of every twitch words
     */
    public int[][] twitchWords(String str) {
        if(str==null){
            return null;
        }
        int strLen=str.length();
        if(strLen<=2){
            return null;
        }
        int[][] tmpArray=new int[strLen][];

        int start=0;
        int end=1;

        int rtnPointer=0;

        while(start<strLen&&end<strLen&&start<end){
            if(str.charAt(end)!=str.charAt(start)){
                if((end-start)>=3){
                    int[]  range=new int[]{start,end-1};
                    tmpArray[rtnPointer]=range;
                    rtnPointer++;

                }
                start=end;
            }
            end++;
        }

        if((end-start)>=3){
            int[]  range=new int[]{start,end-1};
            tmpArray[rtnPointer]=range;
            rtnPointer++;

        }

        int[][] rtn=new int[rtnPointer][2];
        for(int i=0;i<rtnPointer;i++){
            rtn[i]=tmpArray[i];
        }

        return rtn;
    }
}

