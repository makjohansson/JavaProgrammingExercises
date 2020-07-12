package mj223vn_assign3.sort;

import java.util.Random;
import java.util.Comparator;

/**
 * Program to sort int and string arrays using insertion sort algorithm
 * 
 * @author marcus
 *
 */
public class SortingAlgorithms {

	public SortingAlgorithms() {
	}

	/**
	 * 
	 * @param length of an integer array.
	 * @param n      bound of random integer 0 -> n(exclusive).
	 * @return a random integer array.
	 */
	public static int[] randomIntArray(int length, int n) {
		Random rand = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}

	/**
	 * Insertion sort algorithm, as example in Horstmann, Big Java.
	 * 
	 * @param in integer array.
	 * @return sorted integer array.
	 */
	public int[] insertionSort(int[] in) {
		int key;
		for (int i = 1; i < in.length; i++) {
			key = in[i];
			int j = i;
			while (j > 0 && in[j - 1] > key) {
				in[j] = in[j - 1];
				j--;
			}
			in[j] = key;
		}
		return in;
	}
	
	public static int[] mergeSort(int[] a) {
		int[] arr = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		sort(arr);
		return arr;
	}

	private static void sort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		int[] first = new int[a.length / 2];
		int[] second = new int[a.length - first.length];
		for(int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}

		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		sort(first);
		sort(second);
		merge(first, second, a);
	}

	private  static void merge(int[] first, int[] second, int[] a) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;

		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] < second[iSecond]) {
				a[j] = first[iFirst];
				iFirst++;
			} else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}

		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++;
			j++;

		}
		
		while(iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++;
			j++;
		}

	}

	public String[] insertionSort(String[] in, Comparator<String> c) {
		String key;
		for (int i = 1; i < in.length; i++) {
			key = in[i];
			int j = i - 1;
			while (j >= 0) {
				if (key.compareTo(in[j]) > 0) {
					break;
				}
				in[j + 1] = in[j];
				j--;
			}
			in[j + 1] = key;
		}
		return in;
	}
	
	/**
	 * MergeSort for strings
	 * @param a is a String array
	 * @return lexicographical sorted String array
	 */
	public static String[] mergeSort(String[] a) {
		String[] arr = new String[a.length];
		for(int i = 0; i < a.length; i++) {
			arr[i] = a[i];
		}
		sortString(arr);
		return arr;
	}

	private static void sortString(String[] a) {
		if (a.length <= 1) {
			return;
		}
		String[] first = new String[a.length / 2];
		String[] second = new String[a.length - first.length];
		for(int i = 0; i < first.length; i++) {
			first[i] = a[i];
		}

		for (int i = 0; i < second.length; i++) {
			second[i] = a[first.length + i];
		}
		sortString(first);
		sortString(second);
		mergeString(first, second, a);
	}

	private  static void mergeString(String[] first, String[] second, String[] a) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;
		
		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst].compareTo(second[iSecond]) < 0) {
				a[j] = first[iFirst];
				iFirst++;
			} else {
				a[j] = second[iSecond];
				iSecond++;
			}
			j++;
		}

		while (iFirst < first.length) {
			a[j] = first[iFirst];
			iFirst++;
			j++;

		}
		
		while(iSecond < second.length) {
			a[j] = second[iSecond];
			iSecond++;
			j++;
		}

	}


}


