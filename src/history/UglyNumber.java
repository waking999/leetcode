package history;
import org.junit.Assert;

public class UglyNumber {
	public boolean isUgly(int num) {
		if(num<=0) return false;
		
		if ((num <= 6)&&(num>=1))
			return true;

		while(num!=1){
			int m=num%2;
			if(m==0){
				num=num/2; 
			}else{
				m=num%3;
				if(m==0){
					num=num/3; 
				}else{
					m=num%5;
					if(m==0){
						num=num/5; 
					}else{
						return false;
					}
				}
			}
			
		}
		
		return true;
	}

	 
	
	public static void main(String[] args) {
		UglyNumber x = new UglyNumber();

		int a;

		a = 6;
		Assert.assertTrue(x.isUgly(a));

		a = 1;
		Assert.assertTrue(x.isUgly(a));

		a = 8;
		Assert.assertTrue(x.isUgly(a));

		a = 14;
		Assert.assertTrue(!x.isUgly(a));

		
		a=-2147483648;
		Assert.assertTrue(!x.isUgly(a));
		System.out.println("done");

	}

}
