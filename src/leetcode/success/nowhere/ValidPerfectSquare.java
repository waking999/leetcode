package leetcode.success.nowhere;
 
public class ValidPerfectSquare {
	public boolean isPerfectSquare(int num) {
		 
		for(int i=1;i<=num/i;i++){
			if(i*i==num){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ValidPerfectSquare s = new ValidPerfectSquare();

		int num;
		boolean expect;
		boolean output;

		num = 16;
		expect = true;
		output = s.isPerfectSquare(num);
		assert (expect == output) : "1:wrong";

		num = 14;
		expect = false;
		output = s.isPerfectSquare(num);
		assert (expect == output) : "2:wrong";

		num = 49;
		expect = true;
		output = s.isPerfectSquare(num);
		assert (expect == output) : "3:wrong";
		
		System.out.println("Finish");

	}
}
