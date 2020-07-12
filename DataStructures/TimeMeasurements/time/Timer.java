package mj223vn_assign4.time;
/**
 * Class to use when timing runtime.
 * @author marcus
 *
 */
public class Timer {
	private long startTime;
	private long elapsedTime;
	private long stopTime;
	
	public Timer() {
		reset();
	}
	
	public void Start() {
		startTime = System.nanoTime();
	}
	
	public void Stop() {
		stopTime = System.nanoTime();
		elapsedTime = stopTime - startTime;
	}
	
	public long getElapsedTime() {
		return elapsedTime;
	}
	
	public void reset() {
		elapsedTime = 0;
		startTime = 0;
		stopTime = 0;
	}

}
