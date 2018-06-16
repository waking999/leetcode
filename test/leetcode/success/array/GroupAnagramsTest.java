package leetcode.success.array;

import org.junit.jupiter.api.Test;

import java.util.List;

public class GroupAnagramsTest {
    @Test
    public void testgroupAnagrams() {
        GroupAnagrams s = new GroupAnagrams();

        String[] strs;
        String[][] expect;
        List<List<String>> output;
        int seq = 0;

        strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        expect = new String[][]
                {
                        {"ate", "eat", "tea"},
                        {"nat", "tan"},
                        {"bat"}
                };
        output = s.groupAnagrams(strs);

        System.out.print(seq++);

    }
}
