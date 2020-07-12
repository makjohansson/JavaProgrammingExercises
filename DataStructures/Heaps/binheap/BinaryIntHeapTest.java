package mj223vn_assign4.binheap;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BinaryIntHeapTest {
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
	void testPullHighestSizeDecreasesWithOne() {
		BinaryIntHeap bh = build(12);
		assertEquals(11, bh.size());
		int highest = bh.pullHighest();
		assertEquals(10, bh.size());
		assertEquals(14, highest);
	}
	
	@Test
	void testIfHeapIsEmpty() {
		BinaryIntHeap bh = new BinaryIntHeap(0);
		assertTrue(bh.isEmpty());
		bh = build(12);
		assertFalse(bh.isEmpty());
	}

	private BinaryIntHeap build(int size) {
		
		BinaryIntHeap bh = new BinaryIntHeap(size);

		bh.insert(8);
		bh.insert(6);
		bh.insert(7);
		bh.insert(4);
		bh.insert(3);
		bh.insert(5);
		bh.insert(2);
		bh.insert(1);
		bh.insert(14);
		bh.insert(13);
		bh.insert(12);
		
		return bh;
	}

}
