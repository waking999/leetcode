package leetcode.success.array;

import java.util.Arrays;

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
        for (int curr : houses) {
            int low = 0;
            int high = heatersLen;
            while (low < high) {
                int mid = (low + high) / 2;
                if (heaters[mid] >= curr) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            int dist1 = (high == heatersLen ? Integer.MAX_VALUE : heaters[high] - curr);
            int dist2 = (high == 0 ? Integer.MAX_VALUE : curr - heaters[high - 1]);
            maxDis = Math.max(maxDis, Math.min(dist1, dist2));

        }
		return maxDis;
		
	 
	}





}
