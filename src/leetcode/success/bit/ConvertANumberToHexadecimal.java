package leetcode.success.bit;

import leetcode.success.comm.Util;

public class ConvertANumberToHexadecimal {
	public String toHex(int num) {
		StringBuffer sb=new StringBuffer();
		
		for(int i=0;num!=0&&i<8;i++){
			int t=num&0xf;
			if(t>=10){
				sb.insert(0, (char)('a'+t-10));
			}else{
				sb.insert(0, (char)('0'+t));
			}
			num>>=4;
		}
		if(sb.length()==0){
			sb.append("0");
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ConvertANumberToHexadecimal s = new ConvertANumberToHexadecimal();

		int num;
		String expect;
		String output;

		num = 26;
		expect = "1a";
		output = s.toHex(num);
		Util.verify(expect, output, 1);

		num = -1;
		expect = "ffffffff";
		output = s.toHex(num);
		Util.verify(expect, output, 1);
		
		num = 0;
		expect = "0";
		output = s.toHex(num);
		Util.verify(expect, output, 1);
		
		System.out.println("Finish");

	}

}
