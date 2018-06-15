package leetcode.success.other;

public class NthDigit {
	public int findNthDigit(int n) {
		int len=1;
		long cnt=9;
		int start=1;
		
		while(n>len*cnt){
			n-=len*cnt;
			len++;
			cnt*=10;
			start*=10;
		}
		start+=(n-1)/len;
		String s=Integer.toString(start);
		char c=s.charAt((n-1)%len);
		
        return c-'0';
    }
	public static void main(String[] args) {
		NthDigit s=new NthDigit();
	
		int n;
		int expect;
		int output;
		
		n=11;
		expect=0;
		output=s.findNthDigit(n);
		assert(expect==output):"1:wrong";
		
		n=2147483647;
		expect=2;
		output=s.findNthDigit(n);
		assert(expect==output):"2:wrong";
		
		System.out.println("Finish");
	}

}
