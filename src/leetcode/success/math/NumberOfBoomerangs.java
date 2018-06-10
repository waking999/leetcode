package leetcode.success.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import leetcode.success.comm.Util;

public class NumberOfBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		int pointsLen=points.length;
		
		Map<Integer,Integer> map=new HashMap<>();
		int answer=0;
		for(int i=0;i<pointsLen;i++){
			map.clear();
			int[] pointi=points[i];
			for(int j=0;j<pointsLen;j++){
				if(i!=j){
					int[] pointj=points[j];
					int a=pointi[0]-pointj[0];
					int b=pointi[1]-pointj[1];
					int l=a*a+b*b;
					if(map.containsKey(l)){
						map.put(l, map.get(l)+1);
					}else{
						map.put(l, 1);
					}
				}
			}
			Set<Integer> keySet=map.keySet();
			for(int key:keySet){
				int e=map.get(key);
				answer+=e*(e-1);
			}
			
		}
		return answer;
	}

	public static void main(String[] args) {
		NumberOfBoomerangs s=new NumberOfBoomerangs();
		
		int[][] points;
		int expect;
		int output;
		
		points=new int[][]{{0,0},{1,0},{2,0}};
		expect=2;
		output=s.numberOfBoomerangs(points);
		Util.verify(expect, output, 1);
		
		System.out.println("Finish");

	}

}
