package history;
import org.junit.Assert;
import org.junit.Test;

public class AddDigit {
	public int addDigits(int num) {
		return num - ((num - 1) / 9) * 9;
	}

	@Test
	public void test1() {
		int n = 38;
		int actual = addDigits(n);
		int expected = 2;
		Assert.assertEquals(expected, actual);

	}

}
