package leetcode.attempt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/description/
 * <p>
 * We are given a 2-dimensional grid. "." is an empty cell, "#" is a wall, "@" is the starting point, ("a", "b", ...) are keys, and ("A", "B", ...) are locks.
 * <p>
 * We start at the starting point, and one move consists of walking one space in one of the 4 cardinal directions.  We cannot walk outside the grid, or walk into a wall.  If we walk over a key, we pick it up.  We can't walk over a lock unless we have the corresponding key.
 * <p>
 * For some 1 <= K <= 6, there is exactly one lowercase and one uppercase letter of the first K letters of the English alphabet in the grid.  This means that there is exactly one key for each lock, and one lock for each key; and also that the letters used to represent the keys and locks were chosen in the same order as the English alphabet.
 * <p>
 * Return the lowest number of moves to acquire all keys.  If it's impossible, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["@.a.#","###.#","b.A.B"]
 * Output: 8
 * Example 2:
 * <p>
 * Input: ["@..aA","..B#.","....b"]
 * Output: 6
 * <p>
 * Note:
 * <p>
 * 1 <= grid.length <= 30
 * 1 <= grid[0].length <= 30
 * grid[i][j] contains only '.', '#', '@', 'a'-'f' and 'A'-'F'
 * The number of keys is in [1, 6].  Each key has a different letter and opens exactly one lock.
 */
public class ShortestPathtoGetAllKeys {

    private Map<Character, int[]> keyPoses;
    private Map<Character, int[]> roomPoses;
    private int[] startPos;
    private boolean found;
    private int shortestPath;
    private Set<Character> keysHeld;

    public int shortestPathAllKeys(String[] grid) {
        int rLen = grid.length;
        int cLen = grid[0].length();


        startPos = null;
        keyPoses = new HashMap();
        roomPoses = new HashMap();
        keysHeld = new HashSet<>();
        found = false;
        shortestPath = Integer.MAX_VALUE;

        boolean[][] canPass = new boolean[rLen][cLen];
        boolean[][] passed = new boolean[rLen][cLen];

        //scan map to get some information
        scanGrid(grid, rLen, cLen, canPass, passed);

        int currentKeyCount = 0;
        int expectKeyCount = keyPoses.size();


        int i = startPos[0];
        int j = startPos[1];


        dfs(grid, rLen, cLen, i, j, currentKeyCount, expectKeyCount, canPass, passed, 0);


        return found ? shortestPath : -1;
    }

//    private void initCanPass(boolean[][] canPass, int rLen) {
//        for (int i = 0; i < rLen; i++) {
//            Arrays.fill(canPass[i], true);
//        }
//    }


    private void dfs(String[] grid, int rLen, int cLen, int i, int j, int currentKeyCount, int expectKeyCount, boolean[][] canPass, boolean[][] passed, int path) {

        char ch = grid[i].charAt(j);
        //if it is a wall, return
        if (ch == '#') {
            found = false;
            return;
        }

        //if it is a key: 1) collect this key; 2) increase the number of holding keys; 3) set the room related to this key to be passable
        if (ch >= 'a' && ch <= 'f') {
            keysHeld.add(ch);
            int[] roomPos = roomPoses.get((char) (ch - 'a' + 'A'));
            canPass[roomPos[0]][roomPos[1]] = true;
            currentKeyCount++;
        }

        //if it is a room:
        if (ch >= 'A' && ch<='F'){
            if(!keysHeld.contains((char)(ch-'A'+'a'))) {
                found = false;
                canPass[i][j] = false;
                return;
            }
        }

        //if we got all keys, record the shortest path
        if (currentKeyCount == expectKeyCount) {
            found = true;
            if (shortestPath > path) {
                shortestPath = path;
            }
            return;
        }
        passed[i][j] = true;

        if (j < cLen - 1 && !found && canPass[i][j + 1] && !passed[i][j + 1]) {
            //to right
            dfs(grid, rLen, cLen, i, j + 1, currentKeyCount, expectKeyCount, canPass, passed, path + 1);
        }

        if (i < rLen - 1 && !found && canPass[i + 1][j] && !passed[i + 1][j]) {
            //to down
            dfs(grid, rLen, cLen, i + 1, j, currentKeyCount, expectKeyCount, canPass, passed, path + 1);
        }


        if (j >= 1 && !found && canPass[i][j - 1] && !passed[i][j - 1]) {
            //to left

            dfs(grid, rLen, cLen, i, j - 1, currentKeyCount, expectKeyCount, canPass, passed, path + 1);
        }

        if (i >= 1 && !found && canPass[i - 1][j] && !passed[i - 1][j]) {
            //to up
            dfs(grid, rLen, cLen, i - 1, j, currentKeyCount, expectKeyCount, canPass, passed, path + 1);
        }


        if (ch >= 'a' && ch <= 'f') {
            keysHeld.remove(ch);
            int[] roomPos = roomPoses.get((char) (ch - 'a' + 'A'));
            canPass[roomPos[0]][roomPos[1]] = false;
            currentKeyCount--;
        }

        passed[i][j] = false;

    }


    /**
     * do several things:
     * 1. get key count;
     * 2. initialize canPass=false if a cell is a wall(#) or a lock(A-F)
     *
     * @param grid,    the map
     * @param rLen,    width
     * @param cLen,    length
     * @param canPass, a flag map
     */
    private void scanGrid(String[] grid, int rLen, int cLen, boolean[][] canPass, boolean[][] passed) {
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                char ch = grid[i].charAt(j);
                canPass[i][j] = true;
                passed[i][j] = false;
                if (ch == '@') {
                    startPos = new int[]{i, j};
                }
                if (ch >= 'a' && ch <= 'f') {
                    keyPoses.put(ch, new int[]{i, j});
                }
                if (ch >= 'A' && ch <= 'F') {
                    roomPoses.put(ch, new int[]{i, j});
                    canPass[i][j] = false;
                }
                if (ch == '#') {
                    canPass[i][j] = false;
                }
            }
        }
    }
}
