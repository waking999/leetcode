package common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    public static final int IMPOSSIBLE_VALUE = Integer.MIN_VALUE;
    private static Node targetNode;
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

    public static Node constructTreeNode(int[] values, int[] parentIdxs) {
        int nodesLen = values.length;
        if (nodesLen == 0) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        Node root = new Node( values[0],null);
        map.put(0, root);

        for (int i = 1; i < nodesLen; i++) {
            Node childNode = new Node(values[i],null);

            int parentIdx = parentIdxs[i];
            Node parentNode = map.get(parentIdx);
            List<Node> children = parentNode.children;
            if (children == null) {
                children = new ArrayList<>();
            }
            children.add(childNode);
            parentNode.children = children;

            map.put(i, childNode);
        }

        return root;

    }

}