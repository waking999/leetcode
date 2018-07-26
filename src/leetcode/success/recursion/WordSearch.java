package leetcode.success.recursion;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/word-search/description/
 * <p>
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    private boolean found;

    public boolean exist(char[][] board, String word) {
        if (word == null) {
            return true;
        }
        int wordLen = word.length();
        if (wordLen == 0) {
            return true;
        }
        if (board == null) {
            return false;
        }
        int boardRLen = board.length;
        if (boardRLen == 0) {
            return false;
        }
        int boardCLen = board[0].length;
        if (boardCLen == 0) {
            return false;
        }
        if (wordLen > boardRLen * boardCLen) {
            return false;
        }

        char[] chars = word.toCharArray();
        if (wordLen == 1) {

            int[] pos = findNextPosition(board, boardRLen, boardCLen, 0, 0, chars, 0);
            if (pos != null) {
                return true;
            }
        }

        int charPos = 0;
        int[] pos = findNextPosition(board, boardRLen, boardCLen, 0, 0, chars, charPos);
        if (pos == null) {
            return false;
        }



        boolean[][] occupied = new boolean[boardRLen][boardCLen];
        resetOccupied(occupied,boardRLen);

        while (pos != null) {

            found = false;

            dfs(board, boardRLen, boardCLen, pos[0], pos[1], chars, charPos, occupied);
            if (found) {
                return true;
            }


            pos = findNextPosition(board, boardRLen, boardCLen, pos[0], pos[1] + 1, chars, charPos);
        }

        return false;
    }

    private void resetOccupied(boolean[][] occupied, int boardRLen) {
        for (int i = 0; i < boardRLen; i++) {
            Arrays.fill(occupied[i], false);
        }
    }



    private void dfs(char[][] board, int boardRLen, int boardCLen, int i, int j, char[] chars, int charPos, boolean[][] occupied) {
        if (board[i][j] != chars[charPos]) {
            found = false;
            return;
        }

        if (charPos + 1 == chars.length) {
            found = true;
            return;
        }

        occupied[i][j]=true;

        if (j < boardCLen - 1 && !found && !occupied[i][j+1]) {
            //to right
            dfs(board, boardRLen, boardCLen, i, j + 1, chars, charPos + 1, occupied);
        }
        if (i < boardRLen - 1 && !found && !occupied[i+1][j]) {
            //to down
            dfs(board, boardRLen, boardCLen, i + 1, j, chars, charPos + 1, occupied);
        }
        if (j >= 1 && !found && !occupied[i][j-1]) {
            //to left

            dfs(board, boardRLen, boardCLen, i, j - 1, chars, charPos + 1, occupied);
        }
        if (i >= 1 && !found && !occupied[i-1][j]) {
            //to up
            dfs(board, boardRLen, boardCLen, i - 1, j, chars, charPos + 1, occupied);
        }

        occupied[i][j]=false;
    }


    private int[] findNextPosition(char[][] board, int boardRLen, int boardCLen, int fromI, int fromJ, char[] chars, int charPos) {
        char ch = chars[charPos];
        for (int j = fromJ; j < boardCLen; j++) {
            if (board[fromI][j] == ch) {
                return new int[]{fromI, j};
            }
        }
        for (int i = fromI + 1; i < boardRLen; i++) {
            for (int j = 0; j < boardCLen; j++) {
                if (board[i][j] == ch) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
