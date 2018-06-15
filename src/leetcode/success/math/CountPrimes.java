package leetcode.success.math;

import java.util.Arrays;

public class CountPrimes {
	public int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		for (int i = 2; i*i < n; i++) {
			if (isPrime[i]) {
				for (int j = i; j * i < n; j++)
					isPrime[j * i] = false;
			}

		}
		 
		int cnt = 0;
		for (int i = 2; i < n; i++)
			if (isPrime[i])
				cnt++;
		return cnt;

	}



}
