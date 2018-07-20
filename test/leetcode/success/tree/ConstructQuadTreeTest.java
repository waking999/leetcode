package leetcode.success.tree;

import common.QuadTree.Node;
import leetcode.success.tree.ConstructQuadTree;
import org.junit.jupiter.api.Test;

public class ConstructQuadTreeTest {
    @Test
    public void test1() {
        ConstructQuadTree s = new ConstructQuadTree();

        int[][] grid;
        Node outputNode;

        grid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
        };

        outputNode=s.construct(grid);
        System.out.println();

    }


}
