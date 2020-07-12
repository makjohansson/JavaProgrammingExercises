package mj223vn_assign4.binaryHeapTask;

public class WorkTask implements Task{
	final int priority;
	final String task;

	public WorkTask(int priority, String task) {
		this.priority = priority;
		this.task = task;
	}
	public String toString() {
		return priority + ", " + task;
	}
	
	@SuppressWarnings("static-access")
	public int compareTo(Task other) {
		
		return priority < other.priority ? -1 :priority > other.priority ? 1 : 0;
	}

}
