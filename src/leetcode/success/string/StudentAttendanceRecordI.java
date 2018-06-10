package leetcode.success.string;

import leetcode.success.comm.Util;

public class StudentAttendanceRecordI {
	public boolean checkRecord(String s) {
		if(s==null) {
			return true;
		}
		int sLen=s.length();
		if(sLen==0) {
			return true;
		}
		char[] sArr=s.toUpperCase().toCharArray();
		int cntA=0;
		int cntL=0;
		for(char c:sArr) {
			if(c=='A') {
				cntA++;
				if(cntA>1) {
					return false;
				}
				cntL=0;
			}else if(c=='L') {
				cntL++;
				if(cntL>2) {
					return false;
				}
			}else {
				cntL=0;
			}
		}
		
		
		
		return true;
	}

	public static void main(String[] args) {
		StudentAttendanceRecordI s = new StudentAttendanceRecordI();

		String str;
		boolean expect;
		boolean output;

		str = "PPALLP";
		expect = true;
		output = s.checkRecord(str);
		Util.verify(expect, output, 1);

		str = "PPALLL";
		expect = false;
		output = s.checkRecord(str);
		Util.verify(expect, output, 2);

	}

}
