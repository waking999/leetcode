package leetcode.success.nowhere;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leetcode.success.comm.Util;

public class RedundantConnection {
	 
	public int[] findRedundantConnection(int[][] edges) {
		if(edges==null) {
			return null;
		}
	
		Map<Integer, Integer> valTree=new HashMap<Integer,Integer>();
		Map<Integer, List<Integer>> treeNode=new HashMap<Integer,List<Integer>>();
		
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
				List<Integer> l=new ArrayList<Integer>();
				l.add(u);
				l.add(v);
				treeNode.put(count, l);
				
				valTree.put(u, count);
				valTree.put(v, count);
			}
			
		}
		
		
		return null;
	}
	
	 

	public static void main(String[] args) {

		RedundantConnection s=new RedundantConnection();
		
		int[][] edges;
		int[] expect;
		int[] output;
		
		
		
		
		edges=new int[][] {{1,2}, {1,3}, {2,3}};
		expect=new int[] {2,3};
		output=s.findRedundantConnection(edges);
		Util.verifyUnsort(expect, output, 1);
		
		
		edges=new int[][] {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
		expect=new int[] {1,4};
		output=s.findRedundantConnection(edges);
		Util.verifyUnsort(expect, output, 2);
				
		edges=new int[][] {{37,40},{18,28},{5,37},{14,19},{5,46},{15,48},{27,42},{1,44},{12,33},{29,50},{1,7},{26,37},{1,15},{24,32},{32,46},{4,17},{9,37},{6,31},{13,38},{39,43},{22,45},{30,43},{36,50},{7,47},{29,35},{19,23},{34,37},{2,16},{10,21},{1,21},{4,49},{12,21},{38,42},{8,48},{10,48},{17,22},{7,50},{17,25},{19,50},{6,13},{3,37},{2,13},{11,16},{13,40},{20,32},{30,46},{4,18},{33,38},{24,41},{19,45}};
		expect=new int[] {10, 48};
		output=s.findRedundantConnection(edges);
		Util.verifyUnsort(expect, output, 3);
	}

}
