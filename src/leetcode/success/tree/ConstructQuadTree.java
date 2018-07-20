package leetcode.success.tree;

import common.QuadTree.Node;

/**
 * https://leetcode.com/problems/construct-quad-tree/description/
 * <p>
 * We want to use quad trees to store an N x N boolean grid. Each cell in the grid can only be true or false. The root node represents the whole grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same.
 * <p>
 * Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * Your task is to use a quad tree to represent a given grid. The following example may help you understand the problem better:
 * <p>
 * Given the 8 x 8 grid below, we want to construct the corresponding quad tree:
 * <p>
 * It can be divided according to the definition above:
 * <p>
 * <p>
 * The corresponding quad tree should be as following, where each node is represented as a (isLeaf, val) pair.
 * <p>
 * For the non-leaf nodes, val can be arbitrary, so it is represented as *.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * N is less than 1000 and guaranteened to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 */
public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        if (grid == null) {
            return null;
        }
        int rLen = grid.length;
        if (rLen == 0) {
            return null;
        }
        int cLen = grid[0].length;
        if (cLen == 0) {
            return null;
        }

        Node node = help(0, rLen-1, 0, cLen - 1, grid);
        return node;
    }

    private Node help(int r1, int r2, int c1, int c2, int[][] grid) {
        if (r1 > r2 || c1 > c2) {
            return null;
        }
        boolean isLeaf = true;
        int val = grid[r1][c1];
        outter:
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break outter;
                }
            }
        }
        if (isLeaf) {
            return new Node(val == 1, isLeaf, null, null, null, null);
        }

        int rMid = r1 + (r2 - r1) / 2;
        int cMid = c1 + (c2 - c1) / 2;
        return new Node(false, false,
                help(r1, rMid, c1, cMid, grid),
                help(r1, rMid, cMid + 1, c2, grid),
                help(rMid + 1, r2, c1, cMid, grid),
                help(rMid + 1, r2, cMid + 1, c2, grid));

    }
}
