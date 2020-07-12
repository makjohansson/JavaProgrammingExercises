package mj223vn_assign4.time;

import java.util.Comparator;

public class InsertionSort {

	public InsertionSort() {

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

}
