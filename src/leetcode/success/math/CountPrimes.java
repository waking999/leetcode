package leetcode.success.math;

import java.util.Arrays;

import leetcode.success.comm.Util;

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

	public static void main(String[] args) {
		CountPrimes s = new CountPrimes();

		int n;
		int expect;
		int output;
		
		n=4;
		expect=2;
		output=s.countPrimes(n);
		Util.verifyUnsort(expect, output, 1);
		
		n=2;
		expect=0;
		output=s.countPrimes(n);
		Util.verifyUnsort(expect, output, 1);
		
		n=3;
		expect=1;
		output=s.countPrimes(n);
		Util.verifyUnsort(expect, output, 1);

	}

}
