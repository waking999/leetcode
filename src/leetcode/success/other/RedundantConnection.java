package leetcode.success.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedundantConnection {
	 
	public int[] findRedundantConnection(int[][] edges) {
		if(edges==null) {
			return null;
		}
	
		Map<Integer, Integer> valTree= new HashMap<>();
		Map<Integer, List<Integer>> treeNode= new HashMap<>();
		
		int count=0;
		for(int[] edge:edges) {
			int u=edge[0];
			int v=edge[1];
			int min=Math.min(u, v);
			int max=Math.max(u, v);
			u=min;
			v=max;
		
			if(valTree.containsKey(u)&&valTree.containsKey(v)) {
				int t1=valTree.get(u);
				int t2=valTree.get(v);
				if(t1==t2) {
					return new int[] {u,v};
				}else {
					List<Integer> l2=treeNode.get(t2);
					for(int val:l2) {
						valTree.put(val, t1);
					}
					List<Integer> l1=treeNode.get(t1);
					l1.addAll(l2);
					treeNode.remove(t2);
				}
			}else if(!valTree.containsKey(u)&&valTree.containsKey(v)) {
				int t1=valTree.get(v);
				valTree.put(u, t1);
				List<Integer> l1=treeNode.get(t1);
				l1.add(u);
			}else if(valTree.containsKey(u)&&!valTree.containsKey(v)) {
				int t1=valTree.get(u);
				valTree.put(v, t1);
				List<Integer> l1=treeNode.get(t1);
				l1.add(v);
			}else {
				count++;
				List<Integer> l= new ArrayList<>();
				l.add(u);
				l.add(v);
				treeNode.put(count, l);
				
				valTree.put(u, count);
				valTree.put(v, count);
			}
			
		}
		
		
		return null;
	}
	

}
