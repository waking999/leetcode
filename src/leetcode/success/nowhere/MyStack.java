package leetcode.success.nowhere;

import java.util.LinkedList;
import java.util.Queue;

import leetcode.success.comm.Util;

public class MyStack {
	Queue<Integer> q1;
	Queue<Integer> q2;

	/** Initialize your data structure here. */
	public MyStack() {
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		if (empty()) {
			q1.offer(x);
		} else {
			if (q1.size() > 0) {
				q2.offer(x);
				int size = q1.size();
				while (size > 0) {
					q2.offer(q1.poll());
					size--;
				}
			} else {
				q1.offer(x);
				int size = q2.size();
				while (size > 0) {
					q1.offer(q2.poll());
					size--;
				}
			}
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {

		if (q1.size() > 0) {
			return q1.poll();
		} else if (q2.size() > 0) {
			return q2.poll();
		}
		return 0;
	}

	/** Get the top element. */
	public int top() {
		if (q1.size() > 0) {
			return q1.peek();
		} else if (q2.size() > 0) {
			return q2.peek();
		}
		return 0;
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return q1.isEmpty() && q2.isEmpty();
	}

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		int x = 4;
		obj.push(x);

		int param3 = obj.top();
		Util.verifyUnsort(x, param3, 1);

		boolean param4 = obj.empty();
		Util.verifyUnsort(false, param4, 2);

		int param5 = obj.pop();
		Util.verifyUnsort(x, param5, 3);

		param4 = obj.empty();
		Util.verifyUnsort(true, param4, 4);
	}
}
