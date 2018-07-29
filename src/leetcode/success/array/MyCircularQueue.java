package leetcode.success.array;

/**
 * https://leetcode.com/problems/design-circular-queue/description/
 * Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".
 * <p>
 * One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.
 * <p>
 * Your implementation should support following operations:
 * <p>
 * MyCircularQueue(k): Constructor, set the size of the queue to be k.
 * Front: Get the front item from the queue. If the queue is empty, return -1.
 * Rear: Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
 * deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
 * isEmpty(): Checks whether the circular queue is empty or not.
 * isFull(): Checks whether the circular queue is full or not.
 * <p>
 * Example:
 * <p>
 * MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be 3
 * circularQueue.enQueue(1);  // return true
 * circularQueue.enQueue(2);  // return true
 * circularQueue.enQueue(3);  // return true
 * circularQueue.enQueue(4);  // return false, the queue is full
 * circularQueue.Rear();  // return 3
 * circularQueue.isFull();  // return true
 * circularQueue.deQueue();  // return true
 * circularQueue.enQueue(4);  // return true
 * circularQueue.Rear();  // return 4
 * <p>
 * Note:
 * <p>
 * All values will be in the range of [0, 1000].
 * The number of operations will be in the range of [1, 1000].
 * Please do not use the built-in Queue library.
 */
public class MyCircularQueue {
    private int[] array;
    private int totalLen;
    private int head;
    private int tail;
    private int currentLen;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        array = new int[k];
        totalLen = k;
        head = 0;
        tail = 0;
        currentLen=0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (!isFull()) {
            currentLen++;
            if (tail < totalLen) {
                array[tail++] = value;
                return true;
            } else {
                array[0] = value;
                tail=1;
                return true;
            }
        }
        return false;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (!isEmpty()) {
            currentLen--;
            if (head < totalLen - 1) {
                head++;
                return true;
            } else {
                head = 0;
                return true;
            }
        }
        return false;

    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (!isEmpty()) {
            return array[head];
        }
        return -1;
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (!isEmpty()) {
            return array[tail-1];
        }
        return -1;
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return currentLen == 0;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return currentLen==totalLen;

    }
}
