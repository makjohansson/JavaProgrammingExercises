package mj223vn_assign4.binaryHeapTask;

public interface Task extends Comparable<Task>{
	
	int priority = 0;
	String task = "";
	public String toString();
	public int compareTo(Task other);

}
