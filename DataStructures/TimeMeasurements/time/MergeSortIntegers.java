package mj223vn_assign4.time;
import java.util.Random;
/**
 * Timing sorting array of integers using MergeSort.
 * @author marcus
 *
 */

public class MergeSortIntegers {

	public static void main(String[] args) {
		int size = 4000000;
		int runs = 10;
		int rand = Integer.MAX_VALUE;
		long warmUp = 0;
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		for (int i = 0; i < 500; i++) {
			warmUp += timeSortIntegerArray(1000, rand);
		}
		for (int j = 0; j < 10; j++) {
			long elapsedTime = 0;
			for (int i = 0; i < runs; i++) {
				elapsedTime += timeSortIntegerArray(size, rand);
			}
			long printTimer = elapsedTime / runs;
			long usedMemory = runtime.totalMemory() - runtime.freeMemory();
			long mbytes = usedMemory / 1000000;
			System.out.println("Size = " + size + ", Time = " + printTimer + ", Memory = " + mbytes + "MB");
			size = size + 500000;
		}
		System.out.println("Warm up time: " + warmUp);
	}

	private static long timeSortIntegerArray(int size, int randomSize) {

		Timer timer = new Timer();
		int[] arr = randomIntArray(size, randomSize);
		timer.Start();
		int[] sortArr = arr;
		MergeSort.mergeSort(sortArr);
		timer.Stop();
		long returnTime = timer.getElapsedTime();
		return returnTime;
	}

	private static int[] randomIntArray(int length, int n) {
		Random rand = new Random();
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(n);
		}
		return arr;
	}

}
