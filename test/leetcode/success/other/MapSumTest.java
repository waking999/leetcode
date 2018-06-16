package leetcode.success.other;

import org.junit.Test;

import static common.Util.verify;

public class MapSumTest {
    @Test
    public void test1() {
        MapSum s;
        int expect;
        int output;

        s = new MapSum();
        s.insert("apple", 3);
        expect = 3;
        output = s.sum("ap");
        verify(expect, output, 1);

        s.insert("app", 2);
        expect = 5;
        output = s.sum("ap");
        verify(expect, output, 1);


        s = new MapSum();
        s.insert("a", 3);
        expect = 0;
        output = s.sum("ap");
        verify(expect, output, 2);
        s.insert("b", 2);
        expect = 3;
        output = s.sum("a");
        verify(expect, output, 2);


        s = new MapSum();
        s.insert("aa", 3);
        expect = 3;
        output = s.sum("a");
        verify(expect, output, 3);
        s.insert("aa", 2);
        expect = 2;
        output = s.sum("a");
        verify(expect, output, 3);


    }
}
