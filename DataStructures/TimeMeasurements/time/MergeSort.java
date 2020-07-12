package mj223vn_assign4.time;

public class MergeSort {
	
	public MergeSort() {
		
	}
	/**
	 * mergeSort for a integer array
	 * @param a is an integer array
	 * @return sorted (smallest to biggest) integer array
	 */
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
