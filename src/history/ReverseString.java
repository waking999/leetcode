package history;
import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
	public String reverseString(String s) {
		byte[] bytes=s.getBytes();
		int sLen=s.length();
		int half=0;
		if(sLen%2==0){
			half=sLen/2;
		}else{
			half=(sLen-1)/2;
		}
		
		for(int i=0;i<half;i++){
			byte tmp=bytes[i];
			int j=sLen-1-i;
			bytes[i]=bytes[j];
			bytes[j]=tmp;
		}
		
		String s2=new String(bytes);
		return s2;
	}

	public static void main(String[] args) {

	}
	
	@Test
	public void test1(){
		ReverseString a=new ReverseString();
		
		String s="hello";
		String expected="olleh";
		String actual=a.reverseString(s);
		Assert.assertEquals(expected, actual);
	}
	@Test
	public void test2(){
		ReverseString a=new ReverseString();
		
		String s="helo";
		String expected="oleh";
		String actual=a.reverseString(s);
		Assert.assertEquals(expected, actual);
	}
}