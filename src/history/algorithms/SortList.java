package history.algorithms;

import org.junit.Test;

import history.common.ISolution;

public class SortList implements ISolution<Return1, Input1> {
	public ListNode sortList(ListNode head) {
		return null;
	}

	@Test
	public void test1() {
		ISolution<Return1, Input1> s = new SortList();
		ListNode ln = null;
		Input1 i = new Input1(ln);
		ListNode ln1 = null;
		Return1 e = new Return1(ln1);
		s.test(i, e);
	}

	@Override
	public Return1 solution(Input1 i) {
		ListNode ln = i.ln;

		ListNode ln1 = sortList(ln);
		Return1 r = new Return1(ln1);
		return r;
	}

}

class Input1 {
	ListNode ln;

	public Input1(ListNode ln) {
		this.ln = ln;
	}

}

class Return1 {
	ListNode ln;

	public Return1(ListNode ln) {
		this.ln = ln;
	}

	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Return1))
			return false;

		Return1 r = (Return1) o;
		ListNode rLn = r.ln;
		if (rLn == null) {
			return false;
		}
		int rLnVal = rLn.val;
		ListNode rNext = rLn.next;

		ListNode tLn = this.ln;
		if (tLn == null) {
			return false;
		}

		int tLnVal = ln.val;
		ListNode tNext = ln.next;
		if (rLnVal != tLnVal) {
			return false;
		}

		return rNext.equals(tNext);
	}

	public int hashCode() {
		int result = 2;
		result = 2 * result + this.ln.val;
		result = 2 * result + this.ln.next.val;

		return result;
	}

	public String toString() {
		if (ln != null) {
			return ln.val + "->" + ln.next.val;
		}
		return "";
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}