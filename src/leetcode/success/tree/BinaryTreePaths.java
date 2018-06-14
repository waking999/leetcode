package leetcode.success.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import common.NormalBinaryTreeNode;
import common.TreeNode;

public class BinaryTreePaths {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> result=new ArrayList<>();
		Stack<Integer> path=new Stack<>();
		dfs(root,path,result);
		return result;
	}
	
	private void dfs(TreeNode node, Stack<Integer> path, List<String> result){
		if(node==null){
			return;
		}
		path.push(node.val);
		if(node.left==null&&node.right==null){
			result.add(generatePath(path));
		}else{
			if(node.left!=null){
				dfs(node.left,path,result);
				path.pop();
			}
			if(node.right!=null){
				dfs(node.right,path,result);
				path.pop();
			}
		}
	}
	
	private String generatePath(List<Integer> list){
		return list.stream().map(Object::toString).collect(Collectors.joining("->"));
	}

	public static void main(String[] args) {
		BinaryTreePaths s=new BinaryTreePaths();
		
		int[] nodes;
		int[] parents;
		int[] children;
		TreeNode root;
		
		nodes=new int[]{1,2,3,5};
		parents=new int[]{-1,0,0,1};
		children=new int[]{-1,0,1,1};
		root=NormalBinaryTreeNode.constructTreeNode(nodes, parents, children);
		List<String> expect=new ArrayList<>();
		expect.add("1->2->5");
		expect.add("1->3");
		List<String> output=s.binaryTreePaths(root);
		assert(expect.size()==output.size()):"1 wrong";
		for(int i=0;i<expect.size();i++){
			assert(expect.get(i).equals(output.get(i))):"1 wrong";
		}
		
		System.out.println("Finish");
		
		
	}

}
