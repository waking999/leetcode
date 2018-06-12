package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PositionsofLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        int start=0;
        int end=0;
        int sLen=S.length();
        List<List<Integer>> rtn=new ArrayList<>();

        char startCh=S.charAt(start);

        for(end=1;end<sLen;end++){
            char tmpCh=S.charAt(end);
            if(tmpCh!=startCh){
                int dist=end-start;
                if(dist>=3){
                    List<Integer> range=new ArrayList<>();
                    range.add(start);
                    range.add(end-1);
                    rtn.add(range);
                }
                start=end;
                startCh=S.charAt(start);
            }
        }

        if((end-start)>=3){
            List<Integer> range=new ArrayList<>();
            range.add(start);
            range.add(end-1);
            rtn.add(range);
        }

        return  rtn;
    }

    @Test
    public void test1() {
        PositionsofLargeGroups s = new PositionsofLargeGroups();
        String S;
        int[][] expect;
        List<List<Integer>> output;
        int seq = 0;

        S="abbxxxxzzy";
        expect= new int[][]{{3,6}};
        output=s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);

        S="abc";
        expect= new int[][]{};
        output=s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);

        S="abcdddeeeeaabbbcd";
        expect= new int[][]{{3,5},{6,9},{12,14}};
        output=s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);


        S="aaa";
        expect= new int[][]{{0,2}};
        output=s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);


    }
}
