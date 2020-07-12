package mj223vn_assign4.exercise1;

import java.util.Iterator;

public class LinkedQueue<T> implements Queue<T> {
	int size = 0;
	private Node head = null;
	private Node tail = null;

	public int size() {

		return size;
	}

	public boolean isEmpty() {

		return head == null;
	}

	public void enqueue(T element) {
		if (isEmpty()) {
			head = new Node(element);
			tail = head;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
		}
		size++;

	}

	public T dequeue() {
		if (head.value.equals(null) || tail.value.equals(null))
			throw new NullPointerException("Empty queue!!");

		Node first = head;
		head = head.next;
		size--;
		return first.value;
	}

	public T first() {
		if (head == null)
			throw new NullPointerException("Empty queue!!");
		return head.value;
	}

	public T last() {
		if (tail == null)
			throw new NullPointerException("Empty queue!!");
		return tail.value;
	}

	public String toString() {
		String result = "";
		Node current = head;
		String first = head.value.toString();
		while (current.next != null) {
			current = current.next;
			result +=  " " + current.value;
		}
		return first + result;
	}

	public Iterator<T> iterator() {

		return new QueueIterator<T>();
	}

	private class Node {
		T value;
		Node next;

		Node(T value) {
			this.value = value;
		}
	}

	private class QueueIterator<X> implements Iterator<T> {
		private Node node = head;

		public boolean hasNext() {
			return node != null;
		}

		public T next() {
			T value = (T) node.value;
			node = node.next;
			return value;
		}
	}

}
