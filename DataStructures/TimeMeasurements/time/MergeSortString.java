package mj223vn_assign4.time;
import java.util.Random;
/**
 * Timing sorting words containing 10 chars using MergeSort.
 * @author marcus
 *
 */

public class MergeSortString {
	
	public static void main(String[] args) {
		
		int numberOfWords = 1050000;
		int numberOfTests = 10;
		int numberOfRuns = 10;
		long elapsedTime = 0;
		long averageTime = 0;
		long warmUp = 0;
		long runTime = 0;
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		for (int i = 0; i < 500; i++) {
			warmUp += timeSortingString(1000);
		}
		for (int j = 0; j < numberOfTests; j++) {
			for (int i = 0; i < numberOfRuns; i++) {
				elapsedTime += timeSortingString(numberOfWords);
			}
			averageTime = elapsedTime / numberOfRuns;
			long usedMemory = runtime.totalMemory() - runtime.freeMemory();
			long mbytes = usedMemory / 1000000;
			System.out.println("Number of words = " + numberOfWords + ", Time = " + averageTime + ", Memory = " + mbytes + "MB");
			numberOfWords = numberOfWords + 50000;
			runTime += elapsedTime;
			elapsedTime = 0;
		}
		System.out.println("Warm up time = " + warmUp + "\n" + runTime);
		
	}
	
	private static long timeSortingString(int numberOfWords) {
		String[] arr = genarateRandomStrings(numberOfWords);
		Timer timer = new Timer();
		timer.Start();
		MergeSort.mergeSort(arr);
		timer.Stop();
		long returnTime = timer.getElapsedTime();
		return returnTime;
	}

	private static String[] genarateRandomStrings(int numberOfWords) {
		String[] randomStrings = new String[numberOfWords];
		Random rand = new Random();
		for (int i = 0; i < numberOfWords; i++) {
			char[] word = new char[10];
			for (int j = 0; j < word.length; j++) {
				word[j] = (char) ('a' + rand.nextInt(26));
			}
			randomStrings[i] = new String(word);
		}
		return randomStrings;
	}

}
