package mj223vn_assign1;

public class PrintRecursive {
	
	private static void print(String str, int n) {
		if(n != str.length()) {
			System.out.print(str.charAt(n));
			print(str, n+1);
		}
	}
	
	private static void printReverse(String str, int n) {
		if(n != str.length()) {
			System.out.print(str.charAt(str.length() - n - 1));
			printReverse(str, n+1);
		}
	}
	
	private static boolean isPalindrome(char[] str, int first, int last) {
		if( last <= first)
			return true;
		else if(str[first] != str[last])
			return false;
		else
			return isPalindrome(str, first + 1 , last - 1);
	}
	
	public static void main(String[] args) {
		
		String str = "Hello Everyone!";
		char[] word = "madan".toCharArray();
		
		print(str,0);
		System.out.println("\n");
		printReverse(str,0);
		System.out.println("\n");
		System.out.println(isPalindrome(word,0,4));
	}

}
