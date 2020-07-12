package mj223vn_assign4.binheap;

public class BinaryIntHeap {
	private int size;
	private int[] pq;

	public BinaryIntHeap(int maxSize) { // Constructs an empty heap
		this.size = 0;
		pq = new int[maxSize + 1];
		pq[0] = Integer.MAX_VALUE;

	}

	public void insert(int n) { // Add n to heap
		if(n < 0)
			return;
		pq[++size] = n;
		int current = size;
		while (pq[current] > pq[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		
	}

	public int pullHighest() { // Return and remove element with highest priority
		int highest = pq[1];
		pq[1] = pq[size--];
		percolate(1);
		return highest;
	}

	public int size() { // Current heap size
		return size;
	}

	public boolean isEmpty() { // True if heap is empty
		return size == 0;
	}
	
	public void print() {
		for(int i = 1; i <= size / 2; i++) {
			System.out.print("Parent: " + pq[i] + ", Left child: " + pq[2 * i] + ", Right child: " + pq[2 * i + 1] + "\n");
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
		int temp;
		temp = pq[lastPos];
		pq[lastPos] = pq[parentPos];
		pq[parentPos] = temp;
	}

	private void percolate(int pos) {
		if (pos >= (size / 2) && pos <= size)
			return;
		if (pq[pos] < pq[leftChild(pos)] || pq[pos] < pq[rightChild(pos)]) {
			if (pq[leftChild(pos)] > pq[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				percolate(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				percolate(rightChild(pos));
			}
		}
	}
}
