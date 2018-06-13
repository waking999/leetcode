package leetcode.success.array;

import leetcode.success.comm.Util;
import org.junit.Test;

public class CanPlaceFlowers {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		if (flowerbed == null) {
			return false;
		}
		int flowerbedLen = flowerbed.length;
		if (flowerbedLen < 2 * n - 1) {
			return false;
		}
		if(flowerbedLen==1&&n==1&&flowerbed[0]==0) {
			return true;
		}
		for (int i = 0; i < flowerbedLen - 1 && n > 0; i++) {
			if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
				if (i == 0) {
					n--;
					flowerbed[i] = 1;
					 
				} else if (i == flowerbedLen - 2) {
					n--;
					flowerbed[i + 1] = 1;
					 
				} else {
					if (flowerbed[i + 2] == 0) {
						n--;
						flowerbed[i + 1] = 1;
						i = i + 1;
					} else {
						i = i + 1;
					}
				}
			}

		}
        return n == 0;
	}

    @Test
    public void test1() {
		CanPlaceFlowers s = new CanPlaceFlowers();

		int[] flowerbed;
		int n;
		boolean expect;
		boolean output;

		flowerbed = new int[] { 1, 0, 0, 0, 1 };
		n = 1;
		expect = true;
		output = s.canPlaceFlowers(flowerbed, n);
		Util.verify(expect, output, 1);

		flowerbed = new int[] { 1, 0, 0, 0, 1 };
		n = 2;
		expect = false;
		output = s.canPlaceFlowers(flowerbed, n);
		Util.verify(expect, output, 2);

		flowerbed = new int[] { 1, 0, 0, 0, 0, 0, 1 };
		n = 2;
		expect = true;
		output = s.canPlaceFlowers(flowerbed, n);
		Util.verify(expect, output, 3);
		
		flowerbed = new int[] {0};
		n = 1;
		expect = true;
		output = s.canPlaceFlowers(flowerbed, n);
		Util.verify(expect, output, 4);
		
		

		flowerbed = new int[] { 0,0,0,0,1 };
		n = 2;
		expect = true;
		output = s.canPlaceFlowers(flowerbed, n);
		Util.verify(expect, output, 5);
	}

}
