package lintcode.google.level2;

/**
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall is too strong to be destroyed.
 * <p>
 * Example
 * Given a grid:
 * <p>
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {
    /**
     * @param grid: Given a 2D grid, each cell is either 'W', 'E' or '0'
     * @return an integer, the maximum enemies you can kill using one bomb
     */

    public int maxKilledEnemies(char[][] grid) {
        if (grid == null) {
            return 0;
        }
        int rLen = grid.length;
        if (rLen == 0) {
            return 0;
        }
        int cLen = grid[0].length;
        if (cLen == 0) {
            return 0;
        }

        int[][] up = new int[rLen][cLen];
        int[][] down = new int[rLen][cLen];
        int[][] left = new int[rLen][cLen];
        int[][] right = new int[rLen][cLen];

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                up[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        up[i][j] = 1;
                    }

                    if (i - 1 >= 0) {
                        up[i][j] += up[i - 1][j];
                    }
                }
            }
        }

        for (int i = rLen - 1; i >= 0; i--) {
            for (int j = 0; j < cLen; j++) {
                down[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        down[i][j] = 1;
                    }

                    if (i + 1 <= rLen - 1) {
                        down[i][j] += down[i + 1][j];
                    }
                }
            }
        }

        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                left[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        left[i][j] = 1;
                    }

                    if (j - 1 >= 0) {
                        left[i][j] += left[i][j - 1];
                    }
                }
            }
        }


        for (int i = 0; i < rLen; i++) {
            for (int j = cLen - 1; j >= 0; j--) {
                right[i][j] = 0;
                if (grid[i][j] != 'W') {
                    if (grid[i][j] == 'E') {
                        right[i][j] = 1;
                    }

                    if (j + 1 <= cLen - 1) {
                        right[i][j] += right[i][j + 1];
                    }
                }
            }
        }


        int max = 0;
        for (int i = 0; i < rLen; i++) {
            for (int j = 0; j < cLen; j++) {
                if (grid[i][j] == '0') {
                    int b = up[i][j] + down[i][j] + left[i][j] + right[i][j];
                    if (b > max) {
                        max = b;
                    }
                }
            }
        }


        return max;
    }


}
