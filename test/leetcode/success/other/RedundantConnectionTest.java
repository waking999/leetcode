package leetcode.success.other;

import org.junit.jupiter.api.Test;

import static common.Util.verifyUnsort;

public class RedundantConnectionTest {

    @Test
    public void test1() {

        RedundantConnection s = new RedundantConnection();

        int[][] edges;
        int[] expect;
        int[] output;


        edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        expect = new int[]{2, 3};
        output = s.findRedundantConnection(edges);
        verifyUnsort(expect, output, 1);


        edges = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        expect = new int[]{1, 4};
        output = s.findRedundantConnection(edges);
        verifyUnsort(expect, output, 2);

        edges = new int[][]{{37, 40}, {18, 28}, {5, 37}, {14, 19}, {5, 46}, {15, 48}, {27, 42}, {1, 44}, {12, 33}, {29, 50}, {1, 7}, {26, 37}, {1, 15}, {24, 32}, {32, 46}, {4, 17}, {9, 37}, {6, 31}, {13, 38}, {39, 43}, {22, 45}, {30, 43}, {36, 50}, {7, 47}, {29, 35}, {19, 23}, {34, 37}, {2, 16}, {10, 21}, {1, 21}, {4, 49}, {12, 21}, {38, 42}, {8, 48}, {10, 48}, {17, 22}, {7, 50}, {17, 25}, {19, 50}, {6, 13}, {3, 37}, {2, 13}, {11, 16}, {13, 40}, {20, 32}, {30, 46}, {4, 18}, {33, 38}, {24, 41}, {19, 45}};
        expect = new int[]{10, 48};
        output = s.findRedundantConnection(edges);
        verifyUnsort(expect, output, 3);
    }


}
