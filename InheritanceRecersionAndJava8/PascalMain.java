package mj223vn_assign1;
import java.util.Scanner;

/**
 *           1
 *         1   1
 *       1   2   1  // first
 *     1   3   3   1  // second
 *   1   4   6   4   1
 * 1   5  10  10  5   1 
 * @author marcus
 *
 */

public class PascalMain {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("What row do you want to know? ");
		int row = in.nextInt();
		System.out.println();
		int[] theRow = pascalRow(row);
		print(theRow);
		in.close();
	}
	
	
	public static void print(int[] arr) {
		int rowNum = arr.length - 1;
		System.out.print("Row nr " + rowNum + ": ");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
	}
	
	public static int[] pascalRow(int n) {
		if(n == 0) {
			int[] result = {1};
			return result;
		}
		if(n == 1) {
			int[] result = {1,1};
			return result;
		}
		int[] first = {1,1};
		for(int i = 2; i <= n; i++) {
			int[] second = new int[i +1];
			second[0] = 1;
			for(int j = 1; j < i; j++) {
				second[j] = first[j - 1] + first[j];
			}
			second[i] = 1;
			first = second;
		}
		return first;
	}
	

}
