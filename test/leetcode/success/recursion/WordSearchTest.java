package leetcode.success.recursion;

import common.Util;
import leetcode.success.recrusion.WordSearch;
import org.junit.jupiter.api.Test;

public class WordSearchTest {
    @Test
    public void test1() {
        WordSearch s = new WordSearch();

        char[][] board;
        String word;
        boolean expect;
        boolean output;
        int seq = 1;

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCCED";
        expect = true;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "SEE";
        expect = true;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCB";
        expect = false;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);


        board = new char[][]{{'a'}};
        word = "a";
        expect = true;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'a', 'a'}};
        word = "aa";
        expect = true;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'a', 'a'}};
        word = "ab";
        expect = false;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        word = "aaaaaaaaaaaaa";
        expect = false;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

        board = new char[][]{{'a','a','a'},{'a','b','b'},{'a','b','b'},{'b','b','b'},{'b','b','b'},{'a','a','a'},{'b','b','b'},{'a','b','b'},{'a','a','b'},{'a','b','a'}};
        word = "aabaaaabbb";
        expect = false;
        output = s.exist(board, word);
        Util.verify(expect, output, seq++);

    }
}
