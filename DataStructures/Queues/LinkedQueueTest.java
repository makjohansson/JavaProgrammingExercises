package mj223vn_assign2.Exercise1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
/**
 * 
 * @author marcus
 *
 */
class LinkedQueueTest {
	
	private static int testCounter = 0; 
	
	@BeforeEach
	public void setUp() {
		testCounter++;
		System.out.println("Test " + testCounter);
	}
	
	@AfterEach
	public void tearDown() {}
	
	// Test cases using help method build.

	@Test
	public void testLinkedQueueSize() {
		Queue lq = new LinkedQueue();
		assertEquals(0,lq.size()); 
	}
	@Test
	public void testAddtoQueue() {
		Queue lq = build(5); // [0,1,2,3,4]
		assertEquals(5,lq.size());
	}
	
	@Test
	public void testDequeue() {
		Queue lq = build(8); //[0,1,2,3,4,5,6,7]
		System.out.println("\tDequeue method return and remove first in queue: " + lq.dequeue());
		System.out.println("\tDequeue method return and remove first in queue: " + lq.dequeue());
		assertEquals(6,lq.size());
	}
	
	
	@Test
	public void testFirst() {
		Queue lq = build(4); // [0,1,2,3]
		System.out.println("\tFirst method, return first element without removing: " + lq.first());
		assertEquals(4,lq.size());
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		assertThrows(IndexOutOfBoundsException.class, () -> lq.first());
		assertEquals(0,lq.size());
	}
	
	@Test
	public void testLast() {
		Queue lq = build(4);
		System.out.println("\tLast method, return last element without removing: " + lq.last());
		assertEquals(4,lq.size());
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		assertThrows(NullPointerException.class, () -> lq.dequeue());
		assertEquals(0,lq.size());
	}
	
	@Test
	public void testToString() {
		Queue lq = build(18);
		System.out.println("\t" + lq.toString());
	}
	
	private Queue build(int size) {
		Queue lq = new LinkedQueue();
		for(int i = 0; i < size; i++) {
			lq.enqueue(i);
		}
		return lq;
	}

}
