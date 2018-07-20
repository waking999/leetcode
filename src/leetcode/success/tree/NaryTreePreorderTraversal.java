package leetcode.success.tree;

import common.NaryTree.Node;

import java.util.*;

/**
 * https://leetcode.com/problems/n-ary-tree-preorder-traversal/description/
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 * <p>
 * <p>
 * For example, given a 3-ary tree:
 * <p>
 * Return its preorder traversal as: [1,3,5,6,2,4].
 * <p>
 * <p>
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class NaryTreePreorderTraversal {
    public List<Integer> preorder(Node root) {
        List<Integer> rtn = new ArrayList<>();
        if (root == null) {
            return rtn;
        }

        Queue<Node> queue=new LinkedList<>();
        ((LinkedList<Node>) queue).addFirst(root);
        while(!queue.isEmpty()){
            Node node=((LinkedList<Node>) queue).pollFirst();
            rtn.add(node.val);
            List<Node> children=node.children;
            if(children!=null){
                int childrenSize=children.size();
                for(int i=childrenSize-1;i>=0;i--){
                    Node child=children.get(i);
                    ((LinkedList<Node>) queue).addFirst(child);
                }
            }
        }

        return rtn;
    }

//    public List<Integer> preorder(Node root) {
//        List<Integer> rtn = new ArrayList<>();
//        if (root == null) {
//            return rtn;
//        }
//
//
//        helper(root,rtn);
//
//
//        return rtn;
//    }
//
//    private void helper(Node node,List<Integer> rtn){
//        if(node==null){
//            return;
//        }
//        rtn.add(node.val);
//        List<Node> children = node.children;
//        if (children != null) {
//            for (Node child : children) {
//                helper(child,rtn);
//            }
//        }
//    }

 }
