package leetcode.success.tree;

import common.NaryTree.Node;

import java.util.*;

/**
 * https://leetcode.com/problems/n-ary-tree-postorder-traversal/description/
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * Return its postorder traversal as: [5,6,3,2,4,1].
 * <p>
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePostorderTraversal {
    public List<Integer> postorder(Node root) {
        List<Integer> rtn = new ArrayList<>();
        if (root == null) {
            return rtn;
        }

        Queue<Integer> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            ((LinkedList<Integer>) queue).addFirst(node.val);
            List<Node> children = node.children;
            if (children != null) {
                for (Node child : children) {
                    stack.push(child);
                }
            }
        }

        while (!queue.isEmpty()) {
            rtn.add(((LinkedList<Integer>) queue).pollFirst());
        }

        return rtn;
    }

//    public List<Integer> postorder(Node root) {
//        List<Integer> rtn = new ArrayList<>();
//        if (root == null) {
//            return rtn;
//        }
//
//        helper(root,rtn);
//
//        return rtn;
//    }
//
//    private void helper(Node node, List<Integer> rtn){
//        if(node==null){
//            return;
//        }
//        List<Node> children=node.children;
//        if(children!=null){
//            for(Node child:children){
//                helper(child,rtn);
//            }
//        }
//        rtn.add(node.val);
//    }


}

