package history;
import org.junit.Assert;
import org.junit.Test;

public class NimGame {
	public boolean canWinNim(int n) {
		return !(n % 4 == 0) ;
	}

	@Test
	public void test1() {
		int n = 4;
		boolean actual = canWinNim(n);
		boolean expected = false;
		Assert.assertEquals(expected, actual);

	}

	@Test
	public void test2() {
		int n = 1;
		boolean actual = canWinNim(n);
		boolean expected = true;
		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void test3() {
		int n = 16;
		boolean actual = canWinNim(n);
		boolean expected = false;
		Assert.assertEquals(expected, actual);

	}
	
	@Test
	public void test4() {
		int n = 17;
		boolean actual = canWinNim(n);
		boolean expected = true;
		Assert.assertEquals(expected, actual);

	}
}
