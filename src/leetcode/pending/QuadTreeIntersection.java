package leetcode.pending;

import common.QuadTree.Node;

/**
 * https://leetcode.com/problems/quad-tree-intersection/description/
 * <p>
 * A quadtree is a tree data in which each internal node has exactly four children: topLeft, topRight, bottomLeft and bottomRight. Quad trees are often used to partition a two-dimensional space by recursively subdividing it into four quadrants or regions.
 * <p>
 * We want to store True/False information in our quad tree. The quad tree is used to represent a N * N boolean grid. For each node, it will be subdivided into four children nodes until the values in the region it represents are all the same. Each node has another two boolean attributes : isLeaf and val. isLeaf is true if and only if the node is a leaf node. The val attribute for a leaf node contains the value of the region it represents.
 * <p>
 * For example, below are two quad trees A and B:
 * <p>
 * A:
 * +-------+-------+   T: true
 * |       |       |   F: false
 * |   T   |   T   |
 * |       |       |
 * +-------+-------+
 * |       |       |
 * |   F   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight: T
 * bottomLeft: F
 * bottomRight: F
 * <p>
 * B:
 * +-------+---+---+
 * |       | F | F |
 * |   T   +---+---+
 * |       | T | T |
 * +-------+---+---+
 * |       |       |
 * |   T   |   F   |
 * |       |       |
 * +-------+-------+
 * topLeft: T
 * topRight:
 * topLeft: F
 * topRight: F
 * bottomLeft: T
 * bottomRight: T
 * bottomLeft: T
 * bottomRight: F
 * <p>
 * <p>
 * Your task is to implement a function that will take two quadtrees and return a quadtree that represents the logical OR (or union) of the two trees.
 * <p>
 * A:                 B:                 C (A or B):
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       | F | F |  |       |       |
 * |   T   |   T   |  |   T   +---+---+  |   T   |   T   |
 * |       |       |  |       | T | T |  |       |       |
 * +-------+-------+  +-------+---+---+  +-------+-------+
 * |       |       |  |       |       |  |       |       |
 * |   F   |   F   |  |   T   |   F   |  |   T   |   F   |
 * |       |       |  |       |       |  |       |       |
 * +-------+-------+  +-------+-------+  +-------+-------+
 * Note:
 * <p>
 * Both A and B represent grids of size N * N.
 * N is guaranteed to be a power of 2.
 * If you want to know more about the quad tree, you can refer to its wiki.
 * The logic OR operation is defined as this: "A or B" is true if A is true, or if B is true, or if both A and B are true.
 */
public class QuadTreeIntersection {
    public Node intersect(Node quadTree1, Node quadTree2) {
        return help(quadTree1, quadTree2);
    }

    private Node help(Node aTree, Node bTree) {
        if (aTree.isLeaf && bTree.isLeaf) {
            //both a and b are leaves
            return new Node(aTree.val | bTree.val, true, null, null, null, null);
        } else if (aTree.isLeaf) {
            return getNodeIfAIsLeaf(aTree, bTree);
        } else if (bTree.isLeaf) {
            return getNodeIfAIsLeaf(bTree, aTree);
        } else {
            Node[] aChildren = getChildren(aTree);
            Node[] bChildren = getChildren(bTree);

            boolean merge=false;
            boolean abChildren0=aChildren[0].val|bChildren[0].val;
            boolean abChildren1=aChildren[1].val|bChildren[1].val;
            boolean abChildren2=aChildren[2].val|bChildren[2].val;
            boolean abChildren3=aChildren[3].val|bChildren[3].val;
            if((abChildren0==abChildren1)&&(abChildren0==abChildren2)&&(abChildren0==abChildren3)){
                merge=true;
            }
            if(merge){
                return new Node(abChildren0,true,null,null,null,null);
            }



            return new Node(false, false,
                    help(aChildren[0], bChildren[0]),
                    help(aChildren[1], bChildren[1]),
                    help(aChildren[2], bChildren[2]),
                    help(aChildren[3], bChildren[3]));
        }
    }

    private Node getNodeIfAIsLeaf(Node aTree, Node bTree) {
        //if a is leaf, b is not
        if (aTree.val) {
            //if a.val is true
            return new Node(true, true, null, null, null, null);
        } else {
            Node[] children = getChildren(bTree);
            return new Node(false, false, children[0], children[1], children[2], children[3]);
        }
    }

    private Node[] getChildren(Node node) {
        Node[] rtn = new Node[4];
        rtn[0] = node.topLeft;
        rtn[1] = node.topRight;
        rtn[2] = node.bottomLeft;
        rtn[3] = node.bottomRight;
        return rtn;
    }
}
