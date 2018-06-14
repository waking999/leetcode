package leetcode.success.nowhere;

import java.util.Stack;

public class MyQueue {
	Stack<Integer> s1;
	Stack<Integer> s2;

	/** Initialize your data structure here. */
	public MyQueue() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	/** Push element x to the back of queue. */
	public void push(int x) {
		if (empty()) {
			s1.push(x);
		} else {

			int size = s1.size();
			while (size > 0) {
				s2.push(s1.pop());
				size--;
			}

			s1.push(x);
			size = s2.size();
			while (size > 0) {
				s1.push(s2.pop());
				size--;
			}
		}
	}

 

	/** Removes the element from in front of queue and returns that element. */
	public int pop() {

		return s1.pop();

	}

	/** Get the front element. */
	public int peek() {

		return s1.peek();

	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return s1.isEmpty();
	}
}
