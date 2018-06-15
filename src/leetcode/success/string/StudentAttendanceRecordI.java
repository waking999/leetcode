package leetcode.success.string;

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



}
