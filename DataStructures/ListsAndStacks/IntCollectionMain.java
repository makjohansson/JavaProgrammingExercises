package mj223vn_assign1.exercise1;
/**
 * A program to demonstrate the use of the Abstract class AbstractIntCollection and the classes ArrayIntList, ArrayIntStack.
 * The classes implements the interfaces IntList and IntStack.
 * @author Marcus 
 */
import java.util.Iterator;

public class IntCollectionMain {
	
	public static void main(String[] args) {
		System.out.println("ArrayIntStack demonstration:");
		ArrayIntStack stackDemo = new ArrayIntStack();
		stackDemo.push(3);
		stackDemo.push(7);
		stackDemo.push(13);
		stackDemo.push(17);
		stackDemo.push(11);
		stackDemo.push(5);
		
		
		
		Iterator<Integer> it = stackDemo.iterator();
		System.out.print("Stack iterator: ");
		while(it.hasNext()) {
			int stackInt = it.next();
			System.out.print(stackInt + " ");
		}
		
		System.out.println("\nPeek: " + stackDemo.peek());
		System.out.println("Current size: " + stackDemo.size());
		System.out.println("Pop: " + stackDemo.pop());
		System.out.println("Current size: " + stackDemo.size());
		System.out.println("Peek: " + stackDemo.peek());
		System.out.println("Is the stack empty: " + stackDemo.isEmpty());
		
		System.out.println("\nArrayIntList demonstration:");
		ArrayIntList intDemo = new ArrayIntList();
		
		for(int i = 1; i < intDemo.values.length; i++) {
			intDemo.add(i*i);
		}
		
		
		System.out.println("The ArrayInList length: " + intDemo.values.length);
		System.out.println("Integers currently stored: " + intDemo.size);
		System.out.println("Is the stack empty: " + intDemo.isEmpty());
		System.out.println("Integer at index 5: " + intDemo.get(5));
		System.out.println("ArrayIntList to string: " + intDemo.toString());
		intDemo.addAt(12, 3);
		System.out.println("AddAt: " + intDemo.toString());
		intDemo.remove(3);
		System.out.println("Integer at index 3 removed: " + intDemo.toString());
		
		
		
		
		

	}

}
