// Logan Murray
// CSC 300
// January 12, 2018

import stdlib.*;
public class csc300hw1d {

	
	public static int sumInts(int n) {
		int result = 0; // error on this line, don't know why
		for (int i = 1; i <= n; i++) {
			result += sumInts(i);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		
		StdOut.println("Please enter an integer: ");
		
		int N = StdIn.readInt();
		
		for(int i = 1; i <= N; i++) {
			StdOut.println(sumInts(i));
		}
		
		StdOut.println("The value of M: " + sumInts(N));
		StdOut.println("The result of sumInts(N): " + sumInts(N));
		StdOut.println("The value of (M+1)*M / 2: ");
		
	}
// I tried to get this to work but I think I need more practice
// with creating and implementing functions.

	
}