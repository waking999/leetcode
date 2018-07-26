package leetcode.success.array;

/**
 * https://leetcode.com/problems/design-circular-deque/description/
 * Design your implementation of the circular double-ended queue (deque).
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularDeque(k): Constructor, set the size of the deque to be k.
 * insertFront(): Adds an item at the front of Deque. Return true if the operation is successful.
 * insertLast(): Adds an item at the rear of Deque. Return true if the operation is successful.
 * deleteFront(): Deletes an item from the front of Deque. Return true if the operation is successful.
 * deleteLast(): Deletes an item from the rear of Deque. Return true if the operation is successful.
 * getFront(): Gets the front item from the Deque. If the deque is empty, return -1.
 * getRear(): Gets the last item from Deque. If the deque is empty, return -1.
 * isEmpty(): Checks whether Deque is empty or not.
 * isFull(): Checks whether Deque is full or not.
 * <p>
 * <p>
 * Example:
 * <p>
 * MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
 * circularDeque.insertLast(1);			// return true
 * circularDeque.insertLast(2);			// return true
 * circularDeque.insertFront(3);			// return true
 * circularDeque.insertFront(4);			// return false, the queue is full
 * circularDeque.getRear();  			// return 32
 * circularDeque.isFull();				// return true
 * circularDeque.deleteLast();			// return true
 * circularDeque.insertFront(4);			// return true
 * circularDeque.getFront();			// return 4
 * <p>
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Deque library.
 */
public class MyCircularDeque {
    private int[] array;
    private int currentLength;
    private int totalLength;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        totalLength = k;
        array = new int[totalLength];
        currentLength = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (!isFull()) {
            for (int i = currentLength - 1; i >= 0; i--) {
                array[i + 1] = array[i];
            }
            array[0] = value;
            currentLength++;
            return true;

        }
        return false;

    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (!isFull()) {
            array[currentLength++] = value;
            return true;
        }
        return false;

    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (!isEmpty()) {
            for (int i = 0; i < currentLength - 1; i++) {
                array[i] = array[i + 1];
            }
            currentLength--;
            return true;
        }
        return false;

    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (!isEmpty()) {
            currentLength--;
            return true;
        }
        return false;


    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (!isEmpty()) {
            return array[0];
        }
        return -1;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (!isEmpty()) {
            return array[currentLength - 1];
        }
        return -1;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return currentLength == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return currentLength == totalLength;
    }
}
