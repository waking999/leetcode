package leetcode.success.string;

import leetcode.success.comm.Util;

public class CountandSay {
	public String countAndSay(int n) {
		if (n < 1) {
			return null;
		}
		String res="1";
		int i=1;
		while(i<n) {
			StringBuilder sb=new StringBuilder();
			int count=1;
			int resLen=res.length();
			char[] resChars=res.toCharArray();
			for(int j=1;j<resLen;j++) {
				if(resChars[j]==resChars[j-1]) {
					count++;
				}else {
					sb.append(count);
					sb.append(resChars[j-1]);
					count=1;
				}
			}
			sb.append(count);
			sb.append(resChars[resLen-1]);
			res=sb.toString();
			i++;
		}
		return res;
	}

	public static void main(String[] args) {
		CountandSay s = new CountandSay();

		int n;
		String expect;
		String output;
		int seq=0;

		n = 1;
		expect = "1";
		output = s.countAndSay(n);
		Util.verify(expect, output, seq++);

		n = 2;
		expect = "11";
		output = s.countAndSay(n);
		Util.verify(expect, output, seq++);

		n = 3;
		expect = "21";
		output = s.countAndSay(n);
		Util.verify(expect, output, seq++);

		n = 4;
		expect = "1211";
		output = s.countAndSay(n);
		Util.verify(expect, output, seq++);

		n = 5;
		expect = "111221";
		output = s.countAndSay(n);
		Util.verify(expect, output, seq++);

	}

}
