package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

import java.util.List;

public class PositionsofLargeGroupsTest {
    @Test
    public void test1() {
        PositionsofLargeGroups s = new PositionsofLargeGroups();
        String S;
        int[][] expect;
        List<List<Integer>> output;
        int seq = 0;

        S = "abbxxxxzzy";
        expect = new int[][]{{3, 6}};
        output = s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);

        S = "abc";
        expect = new int[][]{};
        output = s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);

        S = "abcdddeeeeaabbbcd";
        expect = new int[][]{{3, 5}, {6, 9}, {12, 14}};
        output = s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);


        S = "aaa";
        expect = new int[][]{{0, 2}};
        output = s.largeGroupPositions(S);
        Util.verifyUnsort(expect, output, seq++);


    }
}
