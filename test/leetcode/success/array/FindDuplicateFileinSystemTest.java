package leetcode.success.array;

import common.Util;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FindDuplicateFileinSystemTest {
    @Test
    public void test1() {
        FindDuplicateFileinSystem s = new FindDuplicateFileinSystem();



        String[] paths;
        List<List<String>> output;
        String[][] expect;
        int seq = 1;

        paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        output = s.findDuplicate(paths);
        expect = new String[][]{{"root/a/2.txt", "root/c/d/4.txt", "root/4.txt"}, {"root/a/1.txt", "root/c/3.txt"}};
        Util.verifySortedInOut(expect, output, seq++);

        paths = new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh)","root/c 3.txt(abdfcd)","root/c/d 4.txt(efggdfh)"};
        output = s.findDuplicate(paths);
        expect = new String[][]{};
        Util.verifySortedInOut(expect, output, seq++);

    }

}
