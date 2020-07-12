package mj223vn_assign4.exercise1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class QueueTest {
	private static int testCounter = 0;

	@BeforeEach
	void setUp() throws Exception {
		testCounter++;
		System.out.println("Test " + testCounter);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void addToQueueIntegerAndcheckSize() {
		Queue<Integer> lq = buildInt(14);
		assertEquals(14, lq.size());
		lq.dequeue();
		lq.dequeue();
		assertEquals(12, lq.size());
	}

	@Test
	void addToQueueStringAndCheckSize() {
		Queue<String> lq = buildString();
		assertEquals(7, lq.size());
		lq.dequeue();
		lq.dequeue();
		assertEquals(5, lq.size());
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		lq.dequeue();
		assertEquals(0, lq.size());
	}

	@Test
	void checkFirstElementInQueueIntegerAndRemove() {
		Queue<Integer> lq = buildInt(6);
		assertEquals(0, (int) lq.dequeue());
		assertEquals(1, (int) lq.dequeue());
	}

	@Test
	void checkFirstElementInQueueStringAndRemove() {
		Queue<String> lq = buildString();
		assertEquals("Hello", lq.dequeue().toString());
		assertTrue("Hola".equals(lq.dequeue().toString()));
		assertEquals("Ciao", lq.dequeue().toString());
	}
	
	@Test
	void shouldReturnTrueIfIntegerQueueIsEmptyAndFalseIfNotEmpty() {
		Queue<Integer> lq = new LinkedQueue<Integer>();
		assertTrue(lq.isEmpty());
		lq.enqueue(5);
		assertFalse(lq.isEmpty());
	}
	
	@Test
	void shouldReturnTrueIfStringQueueIsEmptyAndFalseIfNotEmpty() {
		Queue<String> lq = new LinkedQueue<String>();
		assertTrue(lq.isEmpty());
		lq.enqueue("Hello");
		assertFalse(lq.isEmpty());
	}
	
	@Test
	void returnTheFirstElementInIntegerQueueWithoutRemoving() {
		Queue<Integer> lq = buildInt(7);
		assertEquals(0, (int) lq.first());
		assertEquals(0, (int) lq.first());
		lq.dequeue();
		assertEquals(1, (int) lq.first());
	}
	
	@Test
	void returnTheLastElementInIntegerQueueWithoutRemoving() {
		Queue<Integer> lq = buildInt(7);
		assertEquals(6, (int) lq.last());
		assertEquals(6, (int) lq.last());
		lq.dequeue();
		assertEquals(6, (int) lq.last());
	}
	
	@Test
	void returnTheFirstElementInStringQueueWithoutRemoving() {
		Queue<String> lq = buildString();
		assertEquals("Hello", lq.first());
		assertEquals("Hello", lq.first());
		lq.dequeue();
		assertEquals("Hola", lq.first());
	}
	
	@Test
	void returnTheLastElementInStringQueueWithoutRemoving() {
		Queue<String> lq = buildString();
		assertEquals("Namaste", lq.last());
		assertEquals("Namaste", lq.last());
		lq.dequeue();
		assertEquals("Namaste", lq.last());
	}
	
	@Test
	void testToStringIntegerQueue() {
		Queue<Integer> lq = buildInt(12);
		System.out.println("\t" + lq.toString());
	}
	
	@Test
	void testToStringStringQueue() {
		Queue<String> lq = buildString();
		System.out.println("\t" + lq.toString());
	}

	private Queue<Integer> buildInt(int size) {
		Queue<Integer> lq = new LinkedQueue<Integer>();
		for (int i = 0; i < size; i++)
			lq.enqueue(i);
		return lq;
	}

	private Queue<String> buildString() {
		Queue<String> lq = new LinkedQueue<String>();
		lq.enqueue("Hello");
		lq.enqueue("Hola");
		lq.enqueue("Ciao");
		lq.enqueue("Hej");
		lq.enqueue("Yasso");
		lq.enqueue("Aloha");
		lq.enqueue("Namaste");
		return lq;
	}

}
