package common;

public class BinarySearchTreeNode extends TreeNode {
	
	BinarySearchTreeNode(int x) {
		super(x);
	}

	 
	private static void add(BinarySearchTreeNode node, int value) {
        if (value < node.val) {
            if (node.left != null) {
                add((BinarySearchTreeNode)node.left, value);
            } else {
                 
                node.left = new BinarySearchTreeNode(value);
            }
        } else if (value > node.val) {
            if (node.right != null) {
                add((BinarySearchTreeNode)node.right, value);
            } else {
                 
                node.right = new BinarySearchTreeNode(value);
            }
        }
    }

	public static BinarySearchTreeNode constructTreeNode(int[] nodes) {
		if (nodes == null) {
			return null;
		}
		int nodesLen = nodes.length;
		if (nodesLen == 0) {
			return null;
		}

		BinarySearchTreeNode root = new BinarySearchTreeNode(nodes[0]);

		for (int i = 1; i < nodesLen; i++) {
			add(root, nodes[i]);
		}

		return root;
	}

	

	
}