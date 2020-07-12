package mj223vn_assign4.binaryHeapTask;

public interface PriorityQueue {
	
	public void insert(Task t);
	public Task pullHighest();
	public int size();
	public boolean isEmpty();
	public boolean contains(Task t);
	public Task peekHighest();

}
