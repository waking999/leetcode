package leetcode.attempt;

import common.Util;
import org.junit.jupiter.api.Test;

public class ShortestPathtoGetAllKeysTest {

    @Test
    public void test1() {
        ShortestPathtoGetAllKeys s = new ShortestPathtoGetAllKeys();

        String[] grid;
        int expect;
        int output;
        int seq = 1;

        grid = new String[]{"@.a.#", "###.#", "b.A.B"};
        expect = 8;
        output = s.shortestPathAllKeys(grid);
        Util.verify(expect, output, seq++);

        grid = new String[]{"@..aA", "..B#.", "....b"};
        expect = 6;
        output = s.shortestPathAllKeys(grid);
        Util.verify(expect, output, seq++);

        grid = new String[]{"@Aa"};
        expect = -1;
        output = s.shortestPathAllKeys(grid);
        Util.verify(expect, output, seq++);

        grid = new String[]{"@...a",".###A","b.BCc"};
        expect = 10;
        output = s.shortestPathAllKeys(grid);
        Util.verify(expect, output, seq++);

    }

}
