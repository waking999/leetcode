package leetcode.success.array;

import java.util.Arrays;

import leetcode.success.comm.Util;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters) {
		if (houses == null) {
			return 0;
		}
		int housesLen = houses.length;
		if (housesLen == 0) {
			return 0;
		}
		if (heaters == null) {
			return 0;
		}
		int heatersLen = heaters.length;
		if (heatersLen == 0) {
			return 0;
		}
		Arrays.sort(houses);
		Arrays.sort(heaters);
		if(houses[housesLen-1]<heaters[0]) {
			return heaters[0]-houses[0];
		}
		
		if(houses[0]>heaters[heatersLen-1]) {
			return houses[housesLen-1]-heaters[heatersLen-1];
		}
		
		int maxDis=0;
		for(int i=0;i<housesLen;i++) {
			int curr=houses[i];
			int low=0;
			int high=heatersLen;
			while(low<high) {
				int mid=(low+high)/2;
				if(heaters[mid]>=curr) {
					high=mid;
				}else {
					low=mid+1;
				}
			}
			int dist1=(high==heatersLen?Integer.MAX_VALUE:heaters[high]-curr);
			int dist2=(high==0?Integer.MAX_VALUE:curr-heaters[high-1]);
			maxDis=Math.max(maxDis,Math.min(dist1, dist2));
			
		}
		return maxDis;
		
	 
	}
 
	
	 

	public static void main(String[] args) {
		Heaters s = new Heaters();

		int[] houses;
		int[] heaters;
		int expect;
		int output;

		houses = new int[] { 1, 2, 3 };
		heaters = new int[] { 2 };
		expect = 1;
		output = s.findRadius(houses, heaters);
		Util.verify(expect, output, 1);

		houses = new int[] { 1, 2, 3, 4 };
		heaters = new int[] { 1, 4 };
		expect = 1;
		output = s.findRadius(houses, heaters);
		Util.verify(expect, output, 2);
		
		houses = new int[] { 1, 5 };
		heaters = new int[] { 2 };
		expect = 3;
		output = s.findRadius(houses, heaters);
		Util.verify(expect, output, 3);
		
		houses = new int[] { 1, 5 };
		heaters = new int[] { 10};
		expect = 9;
		output = s.findRadius(houses, heaters);
		Util.verify(expect, output, 4);


	}

}
