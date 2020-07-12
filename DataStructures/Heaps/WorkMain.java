package mj223vn_assign4.binaryHeapTask;

public class WorkMain {
	
	public static void main(String[] args) {
		
		BinaryHeapQueue bhq = new BinaryHeapQueue(10);
		WorkTask one = new WorkTask(1, "count money");
		WorkTask two = new WorkTask(5, "call Saul");
		WorkTask three = new WorkTask(4, "milk the cow");
		WorkTask four = new WorkTask(3, "feed the cow");
		WorkTask oneAlso = new WorkTask(2,"eat");
		bhq.insert(one);
		bhq.insert(two);
		bhq.insert(three);
		bhq.insert(four);
		bhq.insert(oneAlso);
		
		System.out.println("Is feed the cow in the heap? " + bhq.contains(four));
		System.out.println("Just a peek on the highest priority task: " + bhq.peekHighest() + "\n");
		System.out.println(bhq.pullHighest());
		System.out.println(bhq.pullHighest());
		System.out.println(bhq.pullHighest());
		System.out.println(bhq.pullHighest());
		System.out.println(bhq.pullHighest());
		
			
	}

}
