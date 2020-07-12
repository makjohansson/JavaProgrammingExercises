package mj223vn_assign4.time;
import java.util.Comparator;
import java.util.Random;
/**
 * Timing sorting words containing 10 chars using InsertionSort.
 * @author marcus
 *
 */
public class InsertionSortString {

	public static void main(String[] args) {
		int numberOfWords = 21000;
		int numberOfTests = 1;
		int numberOfRuns = 10;
		long elapsedTime = 0;
		long averageTime = 0;
		long warmUp = 0;
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
			numberOfWords = numberOfWords + 1000;
			elapsedTime = 0;
		}
		System.out.println("Warm up time = " + warmUp);
	}

	private static long timeSortingString(int numberOfWords) {
		InsertionSort sort = new InsertionSort();
		Comparator<String> c = (s1, s2) -> s1.compareTo(s2);
		String[] arr = genarateRandomStrings(numberOfWords);
		Timer timer = new Timer();
		timer.Start();
		sort.insertionSort(arr, c);
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
