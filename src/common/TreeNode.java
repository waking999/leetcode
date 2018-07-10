package common;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    public static final int IMPOSSIBLE_VALUE = Integer.MIN_VALUE;
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    static List<Integer> getTreeNodeValueList(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> valList = new ArrayList<>();

        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node != null) {
                valList.add(node.val);
                TreeNode left = node.left;
                TreeNode right = node.right;

                if (left != null || right != null) {
                    q.add(left);
                    q.add(right);
                }

            }

        }
        return valList;
    }

    public static int[] unconstructTreeNode(TreeNode root) {
        List<Integer> valList = TreeNode.getTreeNodeValueList(root);
        int valListLen = valList.size();
        int[] valArray = new int[valListLen];
        for (int i = 0; i < valListLen; i++) {
            valArray[i] = valList.get(i);
        }
        return valArray;
    }

    public static List<Integer> unconstructTreeNodeList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> rtn = new ArrayList<>();

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();
            if (n == null) {
                rtn.add(null);
            } else {
                rtn.add(n.val);
                q.add(n.left);
                q.add(n.right);
            }
        }

        int rtnLen=rtn.size();
        int i=rtnLen-1;
        int count=0;
        while(rtn.get(i)==null){
            count++;
            i--;
        }
        rtn=rtn.subList(0,rtnLen-count);
        return rtn;
    }

    public String toString() {
        return Integer.toString(this.val);
    }

}
