package mj223vn_assign4.time;
/**
 * Timing long strings using StringBuilder
 * @author marcus
 *
 */

public class LongStringStringBuilder {

	public static void main(String[] args) {
		int numOfApp = 17000000;
		int tests = 10;
		for (int i = 0; i < tests; i++) {
			System.out.print("Numbers of appends = " + numOfApp + ", ");
			timeNumOfConcatenations(numOfApp, 10, 2);
			numOfApp = numOfApp + 50000;
		}

	}

	private static void timeNumOfConcatenations(int size, int testRuns, int warmUps) {
		int keepTrack = 0;
		long averageTime = 0;
		Timer timer = new Timer();
		StringBuilder sb = new StringBuilder();
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		while (keepTrack < warmUps) {
			sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append("abcdefghigklmnopqurstvwxyzåäöabcdefghigklmnopqurstvwxyzåäöabcdefghigklmnopqurstv");
			}
			keepTrack++;
		}
		keepTrack = 0;
		timer.Start();
		while (keepTrack < testRuns) {
			sb = new StringBuilder();
			for (int i = 0; i < size; i++) {
				sb.append("abcdefghigklmnopqurstvwxyzåäöabcdefghigklmnopqurstvwxyzåäöabcdefghigklmnopqurstv");
			}
			keepTrack++;
		}
		timer.Stop();
		averageTime = timer.getElapsedTime() / testRuns;
		long usedMemory = runtime.totalMemory() - runtime.freeMemory();
		long mbytes = usedMemory / 1000000;
		String str = sb.toString();
		System.out.println("Elapsed time: " + averageTime + " nanoseconds" + ", String length = " + str.length()
				+ ", Memory = " + mbytes + "MB");

	}

}
