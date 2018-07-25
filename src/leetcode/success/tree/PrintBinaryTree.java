package leetcode.success.tree;

import common.TreeNode;

import java.util.*;

/**
 * https://leetcode.com/problems/print-binary-tree/description/
 * Print a binary tree in an m*n 2D string array following these rules:
 * <p>
 * The row number m should be equal to the height of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 * 1
 * /
 * 2
 * Output:
 * [["", "1", ""],
 * ["2", "", ""]]
 * Example 2:
 * Input:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * Output:
 * <p>
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The height of binary tree is in the range of [1, 10].
 */
public class PrintBinaryTree {
    class QueueNode {
        TreeNode n;
        int pos;

        QueueNode(int pos, TreeNode n) {
            this.pos = pos;
            this.n = n;
        }
    }

    class ListNode {
        int val;
        int pos;

        ListNode(int pos, int val) {
            this.val = val;
            this.pos = pos;
        }
    }

    private List<ListNode> unconstructTreeNodeList(TreeNode root) {

        Queue<QueueNode> q = new LinkedList<>();
        List<ListNode> rtn = new ArrayList<>();

        q.add(new QueueNode(0, root));

        while (!q.isEmpty()) {
            QueueNode qn = q.poll();
            if (qn.n != null) {
                int val = qn.n.val;
                int pos = qn.pos;

                rtn.add(new ListNode(pos, val));
                int childPos = pos * 2;
                q.add(new QueueNode(childPos + 1, qn.n.left));
                q.add(new QueueNode(childPos + 2, qn.n.right));
            }
        }


        return rtn;
    }

    private int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> rtn = new ArrayList<>();
        if (root == null) {
            return rtn;
        }
        List<ListNode> list = unconstructTreeNodeList(root);
        /**
         *  (val,pos):(1,0),(2,1),(3,2),(4,4)
         *  listSize=4;
         *  maxPos=4;
         *  height = 3;
         *  rowSize = 7;
         *  level,  boundarySpace,  btwSpace,   currentLevelBoundary,   lastLevelBoundary
         *  1,      3,              8,          1,                      0
         *  2,      1,              4,          3,                      1
         *  3,      0,              2,          7,                      3
         *         int level = 1;
         *         int boundarySpace = rowSize / 2;
         *         int btwSpace = boundarySpace;
         *         int currentLevelBoundary = (int) (Math.pow(2, level)) - 1;
         *         int lastLevelBoundary = currentLevelBoundary / 2;
         *  {"", "", "", "1", "", "", ""},
         *  {"", "2", "", "", "", "3", ""},
         *  {"", "", "4", "", "", "", ""};
         *
         *
         */

        int listSize = list.size();
        int maxPos = list.get(listSize - 1).pos;
        int height = (int) (Math.floor(log2(maxPos + 1))) + 1;
        int rowSize = (int) (Math.pow(2, height)) - 1;
        int level = 1;
        int boundarySpace = rowSize / 2;
        int btwSpace = rowSize+1;
        int currentLevelBoundary = (int) (Math.pow(2, level)) - 1;
        int lastLevelBoundary = currentLevelBoundary / 2;
        String[] row = new String[rowSize];
        Arrays.fill(row, "");
        int pos = 0;
        for (int i = 0; i < listSize; i++) {
            ListNode n = list.get(i);
            int listPos = n.pos;
            int val = n.val;

            if (listPos >= currentLevelBoundary) {
                List<String> rowList = Arrays.asList(row);
                rtn.add(rowList);
                row = new String[rowSize];
                Arrays.fill(row, "");
                btwSpace = boundarySpace + 1;
                boundarySpace /= 2;
                lastLevelBoundary = currentLevelBoundary;
                currentLevelBoundary = currentLevelBoundary * 2 + 1;
                pos = boundarySpace + (listPos - lastLevelBoundary) * btwSpace;
            } else {
                pos = boundarySpace + (listPos - lastLevelBoundary) * btwSpace;
            }

            row[pos] = Integer.toString(val);
        }
        List<String> rowList = Arrays.asList(row);
        rtn.add(rowList);

        return rtn;
    }


}
