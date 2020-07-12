package mj223vn_assign3;

/**
 * This program demonstrates the use of Euclidean algorithm.
 * @author marcus
 *
 */

public class EuclideanMain {
	
	public static void main(String[] args) {
	
		GCD(18,6);
		GCD(42,56);
		GCD(9,28);
	}
	
	static public void GCD(int M, int N) {
		
		System.out.print("GCD(" + M + "," + N + ") = ");
		while(N > 0) {
			int reminder = M % N;
			M = N;
			N = reminder;
		}
		System.out.print(M);
		System.out.println();
	}

}
