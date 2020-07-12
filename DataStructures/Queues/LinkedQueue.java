package mj223vn_assign2.Exercise1;
/**
* A class representing a simple linked list.  This class implements all the required
* functionality from the interface <code>Queue</code>. 
* <p/>
*
* @author	Marcus Johansson
* @since 2019-02-06
*/
import java.util.Iterator;



public class LinkedQueue implements Queue {
	private int size = 0;
	private Node head = null;
	private Node tail = null;
	
	@Override 
	public int size() {
		return size;
	}
	
	@Override 
	public boolean isEmpty() {
		return head == null;
	}
	
	@Override 
	public void enqueue(Object element) {
		if (isEmpty()) {
			head = new Node(element);
			tail = head;
		} else {
			tail.next = new Node(element);
			tail = tail.next;
		}
		size++;

	}
	
	@Override 
	public Object dequeue() {
		Node node = head;
		head = head.next;
		size--;
		return node.value;
	}
	
	@Override 
	public Object first() {
		if (head == null)
			throw new IndexOutOfBoundsException("Empty queue!!");
		else
			return head.value;
	}
	
	@Override 
	public Object last() {
		if (tail == null)
			throw new IndexOutOfBoundsException("Empty queue!!");
		else
			return tail.value;
	}
	
	@Override 
	public Iterator<Object> iterator() {

		return new QueueIterator();
	}
	
	@Override 
	public String toString() {
		String print = "";
		Node current = head;
		String first = head.value.toString();
		while (current.next != null) {
			current = current.next;
			print += current.value;
		}
		return first + print;
	}

	private class Node {
		Object value;
		Node next = null;

		Node(Object value) {
			this.value = value;
		}
	}

	private class QueueIterator implements Iterator<Object> {
		private Node node = head;

		@Override
		public boolean hasNext() {

			return node != null;
		}

		@Override
		public Object next() {
			Object value = node.value;
			node = node.next;
			return value;
		}

	}

}
