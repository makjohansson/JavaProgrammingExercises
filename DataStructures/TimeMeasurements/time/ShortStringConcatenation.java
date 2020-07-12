package mj223vn_assign4.time;
/**
 * Timing short strings using concatenation
 * @author marcus
 *
 */



public class ShortStringConcatenation {

	public static void main(String[] args) {
		int numOfApp = 80000;
		int tests = 10;
		for (int i = 0; i < tests; i++) {
			System.out.print("Numbers of concatenations = " + numOfApp + ", ");
			timeNumOfConcatenations(numOfApp, 10, 2);
			numOfApp = numOfApp + 5000;
		}
	}
	
	private static void timeNumOfConcatenations(int size, int testRuns, int warmUps) {
		int keepTrack = 0;
		long averageTime = 0;
		Timer timer = new Timer();
		String str = "";
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		while (keepTrack < warmUps) {
			str = "";
			for (int i = 0; i < size; i++) {
				str += "A";
			}
			keepTrack++;
		}
		keepTrack = 0;
		timer.Start();
		while (keepTrack < testRuns) {
			str = "";
			for (int i = 0; i < size; i++) {
				str += "A";
			}
			keepTrack++;
		}
		timer.Stop();
		averageTime = timer.getElapsedTime() / testRuns;
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long mbytes = usedMemory / 1000000;
		System.out.println("Elapsed time: " + averageTime + " nanoseconds" + ", String length = " + str.length()
				+ ", Memory = " + mbytes + "MB");

	}

}
