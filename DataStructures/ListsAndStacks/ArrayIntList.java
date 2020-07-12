package mj223vn_assign1.exercise1;
import java.util.Arrays;
public class ArrayIntList extends AbstractIntCollection implements IntList {

	
	public void add(int n) {
		if(size == values.length)
			resize();
		else
			values[size++] = n;	
	}

	
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if(size == values.length) 
			resize();
		
		values = Arrays.copyOf(values, values.length + 1);
		System.arraycopy(values, index, values, index + 1, values.length - index - 1);
		values[index] = n;
		
		size++;
	}

	
	public void remove(int index) throws IndexOutOfBoundsException {
		int counter = 0;
		int[] temp = new int[values.length - 1];
		for(int i = 0; i < values.length;i++) {
			if(i == index) {
				continue;
			}
			temp[counter++] = values[i];
		}
		size--;
		values = temp;
	}

	
	public int get(int index) throws IndexOutOfBoundsException {
	
		return values[index];
	}

	
	public int indexOf(int n) {
		for(int i = 0; i < values.length; i++) {
			if(values[i] == n) 
				return i;		
		}
		return -1;	
	}
	

}
