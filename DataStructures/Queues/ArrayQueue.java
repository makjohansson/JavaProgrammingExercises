package mj223vn_assign2.Exercise2;

import java.util.Arrays;

public class ArrayQueue {
	private Object[] circularQueue;
	private int head;
	private int tail;
	private int currentSize;

	ArrayQueue(int size) {
		circularQueue = new Object[size];
		head = -1;
		tail = -1;
		currentSize = 0;
	}

	public void enqueue(int a) {
		if (isQueueFull()) {
			resize();
		}
		tail = (tail + 1) % circularQueue.length;
		circularQueue[tail] = a;
		currentSize++;
		if (head == -1) {
			head++;
		}

	}

	public Object dequeue() throws Exception {
		if (isEmpty())
			throw new Exception("Queue is Empty");
		Object temp = circularQueue[head];
		circularQueue[head] = null;
		head = (head + 1) % circularQueue.length;
		currentSize--;
		return temp;
	}

	public boolean isQueueFull() {
		if (currentSize == circularQueue.length)
			return true;
		return false;
	}

	public boolean isEmpty() {
		if (currentSize == 0)
			return true;
		return false;
	}

	public String toString() {
		Object[] temp = new Object[currentSize];
		for (int i = 0; i < currentSize; i++) {
			temp[i] = circularQueue[i];
		}
		return "ArrayQueue = " + Arrays.toString(circularQueue) + ", Head position = " + head + ", Tail position = "
				+ tail + ", currentSize = " + currentSize;
	}

	private void resize() {
		Object[] temp = new Object[2 * circularQueue.length];
		for (int i = 0; i < currentSize; i++) {
			temp[i] = circularQueue[i];
		}
		circularQueue = temp;
	}

}
