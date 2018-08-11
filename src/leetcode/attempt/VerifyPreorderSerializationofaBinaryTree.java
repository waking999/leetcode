package leetcode.attempt;

/**
 * https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/description/
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 *
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 *
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 *
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * Example 1:
 *
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 *
 * Input: "1,#"
 * Output: false
 * Example 3:
 *
 * Input: "9,#,#,1"
 * Output: false
 */
public class VerifyPreorderSerializationofaBinaryTree {
    public boolean isValidSerialization(String preorder) {
        if(preorder==null){
            return true;
        }
        int preorderLen=preorder.trim().length();
        if(preorderLen==0){
            return true;
        }
        String[] nodes=preorder.split(",");
        int nodesLen=nodes.length;
        if(nodesLen%2==0){
            return false;
        }
        if(nodesLen==1&&"#".equals(nodes[0])){
            return true;
        }
        if(nodesLen==3&&"#".equals(nodes[0])&&"#".equals(nodes[1])&&"#".equals(nodes[2])){
            return false;
        }

        if(!"#".equals(nodes[nodesLen-1])&&!"#".equals(nodes[nodesLen-2])){
            return false;
        }
        for(int i=0;i<nodesLen;i++){
            if(!"#".equals(nodes[i])){
                int count=getSharpCount(nodes,i,nodesLen);
                if(count<=3){
                    continue;
                }else  {
                    return false;
                }
            }else{
                continue;
            }
        }

        return true;
    }
    private int getSharpCount(String[] nodes,int pos,int nodesLen){
        int count=0;
        for(int i=1;i<=4&&pos+i<nodesLen;i++){
            if("#".equals(nodes[pos+i])){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
