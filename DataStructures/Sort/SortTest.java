package mj223vn_assign3.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
/**
 * Test program for the SortingAlgorithms program
 * @author marcus
 *
 */
public class SortTest {
	
private static int testCounter = 0; 
	
	@BeforeEach
	public void setUp() {
		testCounter++;
		System.out.println("Test " + testCounter);
	}
	
	@AfterEach
	public void tearDown() {}
	
	static SortingAlgorithms sa = new SortingAlgorithms();
	
	@Test
	public void testinsertionSortInt() {
		int[] unSortArr = {100, 5, 7, 95, 485, 50, 1008, 60, 350};
		int[] sortArr = {5, 7, 50, 60, 95, 100, 350, 485, 1008}; 
		sa.insertionSort(unSortArr);
		assertArrayEquals(unSortArr, sortArr);
	}
	
	@Test
	public  void testinsertionSortString() {
		String[] unSortArr = {"David Gilmour", "Roger Waters", "Syd Barret", "Richard Wright", "Nick Mason", "Bob Klose"};
		String[] sortArr = {"Bob Klose", "David Gilmour", "Nick Mason", "Richard Wright", "Roger Waters", "Syd Barret"};
		Comparator<String> c = (s1,s2) -> s1.compareTo(s2);
		sa.insertionSort(unSortArr, c);
		assertArrayEquals(unSortArr, sortArr);
 	}
	
	@Test
	public void testmergeSort() {
		int[] unSortArr = {100, 5, 7, 95, 485, 50, 1008, 60, 350};
		int[] sortArr = {5, 7, 50, 60, 95, 100, 350, 485, 1008}; 
		int[] sort = new int[unSortArr.length];
		sort = SortingAlgorithms.mergeSort(unSortArr);
		assertArrayEquals(sort, sortArr);
	}
	
	@Test
	public  void testMergeSortString() {
		String[] unSortArr = {"David Gilmour", "Roger Waters", "Syd Barret", "Richard Wright", "Nick Mason", "Bob Klose"};
		String[] sortArr = {"Bob Klose", "David Gilmour", "Nick Mason", "Richard Wright", "Roger Waters", "Syd Barret"};
		String[] sort = new String[unSortArr.length];
		sort = SortingAlgorithms.mergeSort(unSortArr);
		assertArrayEquals(sort, sortArr);
 	}
}
