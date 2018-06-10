package other;

public class MultiplesOf3And5 {
	public int getMultiples(int n){
		int sum=0;
		for(int i=3;i<n;i++){
			if(i%3==0){
				sum+=i;
			}else if(i%5==0){
				sum+=i;
			}
			
		}
		return sum;
	}
	public static void main(String[] args) {
		MultiplesOf3And5 s=new MultiplesOf3And5();
		
		int n;
		int expect;
		int output;
		
		n=10;
		expect=23;
		output=s.getMultiples(n);
		assert(expect==output):"1:wrong";
		
		
		n=16;
		expect=60;
		output=s.getMultiples(n);
		assert(expect==output):"1:wrong";
		
		output=s.getMultiples(1000);
		
		System.out.println("Finish "+output);
		
	}

}
