package mj223vn_assign1.exercise1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	
	
	public void push(int n) {
		if(size == values.length)
			resize();
		else
			values[size++] = n;
	}

	
	public int pop() throws IndexOutOfBoundsException {
		int onTop = values[size -1];
		values[size -1] = 0;
		size--;
		return onTop;
	}

	
	public int peek() throws IndexOutOfBoundsException {
		
		return values[size -1];
	}
	
	

}
