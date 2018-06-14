package leetcode.success.bit;

 

class HammingDistance {
	public int hammingDistance(int x, int y) {
		int xor= x^y;
		int dist=0;

		do{
			int m=xor%2;
			if(m==1){
				dist++;
			}
			xor/=2;
		}while(xor>0);
		
		return dist;
	}

	public static void main(String[] args) {
		int x = 1;
		int y = 4;
		int expect = 2;

		int result = new HammingDistance().hammingDistance(x, y);

		assert (expect == result);

	}
}