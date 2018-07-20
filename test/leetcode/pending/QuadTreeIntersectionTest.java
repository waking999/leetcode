package leetcode.pending;

import common.QuadTree.Node;
import leetcode.success.tree.ConstructQuadTree;
import org.junit.jupiter.api.Test;

public class QuadTreeIntersectionTest {
    @Test
    public void test1() {
        ConstructQuadTree c = new ConstructQuadTree();
        QuadTreeIntersection s = new QuadTreeIntersection();

        int[][] aGrid;
        Node aTree;
        int[][] bGrid;
        Node bTree;
        Node cTree;

        aGrid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
        };
        aTree = c.construct(aGrid);


        bGrid = new int[][]{
                {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
                , {1, 1, 1, 1, 0, 0, 0, 0}
        };
        bTree = c.construct(bGrid);

        cTree = s.intersect(aTree, bTree);

        System.out.println();

    }

    @Test
    public void test2() {
        ConstructQuadTree c = new ConstructQuadTree();
        QuadTreeIntersection s = new QuadTreeIntersection();

        int[][] aGrid;
        Node aTree;
        int[][] bGrid;
        Node bTree;
        Node cTree;

        aGrid = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {0, 0, 0, 0, 0, 0, 0, 0}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}

        };
        aTree = c.construct(aGrid);


        bGrid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {1, 1, 1, 1, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
                , {0, 0, 0, 0, 1, 1, 1, 1}
        };
        bTree = c.construct(bGrid);

        cTree = s.intersect(aTree, bTree);

        System.out.println();

    }
}
