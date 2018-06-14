package lintcode.google.level2;

import common.VerifyUtil;
import org.junit.Test;

import static common.VerifyUtil.*;

public class BombEnemyTest {
    @Test
    public void testmaxKilledEnemies() {
        BombEnemy s = new BombEnemy();

        char[][] grid;
        int expect;
        int output;
        int seq = 1;

        grid = new char[][]{{'0', 'E', '0', '0'}, {'E', '0', 'W', 'E'}, {'0', 'E', '0', '0'}};
        expect = 3;
        output = s.maxKilledEnemies(grid);
        verify(expect, output, seq++);
    }
}
