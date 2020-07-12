package mj223vn_assign4.binheap;

public class BinaryHeapDemo {
	
	public static void main(String[] args) {
		
		BinaryIntHeap bh = new BinaryIntHeap(12);
		
		bh.insert(8);
		bh.insert(6);
		bh.insert(7);
		bh.insert(4);
		bh.insert(3);
		bh.insert(5);
		bh.insert(2);
		bh.insert(1);
		bh.insert(14);
		bh.insert(13);
		bh.insert(12);
		
		
		System.out.println(bh.size() + " " + bh.isEmpty() + " " + bh.pullHighest());
		bh.print();
	}

}
