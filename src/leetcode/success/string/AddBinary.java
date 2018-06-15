package leetcode.success.string;

import java.util.Arrays;

public class AddBinary {
	public String addBinary(String a, String b) {
		int aLen = a.length();
		int bLen = b.length();
		if (aLen == 0) {
			return b;
		}
		if (bLen == 0) {
			return a;
		}
		int len = Math.min(aLen, bLen);

		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();

		int carry = 0;
		int cLen = Math.max(aLen, bLen) + 1;
		char[] cArr = new char[cLen];

		for (int i = 1; i <= len; i++) {
			int aC = aArr[aLen - i] - '0';
			int bC = bArr[bLen - i] - '0';
			int re = aC + bC + carry;
			if (re == 3) {
				cArr[cLen - i] = '1';
				carry = 1;
			} else if (re == 2) {
				cArr[cLen - i] = '0';
				carry = 1;

			} else if (re == 1) {
				cArr[cLen - i] = '1';
				carry = 0;
			} else {
				cArr[cLen - i] = '0';
				carry = 0;
			} 
		}
		
		for(int i=1;i<=aLen-len;i++) {
			int aC=aArr[aLen-len-i]-'0';
			int re=aC+carry;
			if(re==2) {
				cArr[cLen-len-i]='0';
				carry=1;
			}else if(re==1) {
				cArr[cLen-len-i]='1';
				carry=0;
			}else {
				cArr[cLen-len-i]='0';
				carry=0;
			}
		}
		
		for(int i=1;i<=bLen-len;i++) {
			int bC=bArr[bLen-len-i]-'0';
			int re=bC+carry;
			if(re==2) {
				cArr[cLen-len-i]='0';
				carry=1;
			}else if(re==1) {
				cArr[cLen-len-i]='1';
				carry=0;
			}else {
				cArr[cLen-len-i]='0';
				carry=0;
			}
		}
		
		if(carry==1) {
			cArr[0]='1';
			return String.valueOf(cArr);
		}else {
			char[] dArr=Arrays.copyOfRange(cArr, 1, cLen);
			return String.valueOf(dArr);
		}

		 
	}



}
