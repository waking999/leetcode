package lintcode.google.level2.required;

import common.TreeNode;

import java.util.Arrays;

/**
 * Serialize and Deserialize Binary Tree
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree to a file is called 'serialization' and reading back from the file to reconstruct the exact same binary tree is 'deserialization'.
 * <p>
 * Example
 * An example of testdata: Binary tree {3,9,20,#,#,15,7}, denote the following structure:
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * Our data serialization use bfs traversal. This is just for when you got wrong answer and want to debug the input.
 * <p>
 * You can use other method to do serializaiton and deserialization.
 */

public class SerializeandDeserializeBinaryTree {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);

        return sb.toString();
    }

    private void dfs(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        dfs(node.left, sb);
        dfs(node.right, sb);
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        //3,9,#,#,20,15,#,#,7,#,#,
        String[] strs = data.split(",");
        int strsLen = strs.length;
        if ("#".equals(strs[0])) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        TreeNode[] parents = new TreeNode[strsLen];
        boolean[] parentHaveRightChildren=new boolean[strsLen];
        Arrays.fill(parentHaveRightChildren,false);
        int level = 0;
        parents[level] = root;

        for (int i = 1; i < strsLen; i++) {

            TreeNode parent = parents[level];

            if ("#".equals(strs[i])) {
                if (!"#".equals(strs[i - 1])) {
                    parent.left = null;
                    parentHaveRightChildren[level]=false;
                } else {
                    parent.right = null;
                    parentHaveRightChildren[level]=true;
                    while(parentHaveRightChildren[level]){
                        level--;
                        if(level<0){
                            return root;
                        }
                    }
                }
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(strs[i]));
                if (!"#".equals(strs[i - 1])) {
                    parent.left = node;
                    level++;
                    parents[level] = node;
                    parentHaveRightChildren[level-1]=false;
                } else {
                    parent.right = node;
                    level++;
                    parents[level] = node;
                    parentHaveRightChildren[level-1]=true;
                }

            }
        }


        return root;
    }


}
