package mj223vn_assign4.binaryHeapTask;

public class BinaryHeapQueue implements PriorityQueue {
	private int size;
	private Task[] pq;

	public BinaryHeapQueue(int maxSize) {
		this.size = 0;
		pq = new Task[maxSize + 1];
		pq[0] = null;
	}

	public void insert(Task t) {
		pq[++size] = t;
		int current = size;
		while(pq[current].compareTo(pq[parent(current)]) == -1) {
			swap(current, parent(current));
			current = parent(current);
		}

	}

	public Task pullHighest() throws NullPointerException{
		Task highest = pq[1];
		pq[1] = pq[size--];
		percolate(1);
		return highest;

	}

	public int size() {

		return this.size;
	}

	public boolean isEmpty() {

		return size == 0;
	}

	
	public boolean contains(Task t) throws NullPointerException {
		int i = 1;
		boolean temp = false;
		while (temp == false) {
			if (pq[i].equals(t)) {
				temp = true;
			}
			i++;
		}
		return temp;
	}

	public Task peekHighest() throws NullPointerException{

		return pq[1];
	}
	
	public void print() {
		for(int i = 1; i <= size / 2; i++) {
			System.out.print(pq[i] + ", " + pq[2 * i] + ", " + pq[2 * i + 1] + "\n");
		}
	}

	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return pos * 2;
	}

	private int rightChild(int pos) {
		return (pos * 2) + 1;
	}

	private void swap(int lastPos, int parentPos) {
		Task temp;
		temp = pq[lastPos];
		pq[lastPos] = pq[parentPos];
		pq[parentPos] = temp;
	}

	private void percolate(int pos) {
		if (pos >= (size / 2) && pos <= size)
			return;
		if (pq[pos].compareTo(pq[leftChild(pos)]) == -1 || pq[pos].compareTo(pq[rightChild(pos)]) == -1) {
			if (pq[leftChild(pos)].compareTo(pq[rightChild(pos)]) == 1) {
				swap(pos, leftChild(pos));
				percolate(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				percolate(rightChild(pos));
			}
		}
	}

}
