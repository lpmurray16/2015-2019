package GCD;

// Logan Murray
// CSC300-601

import stdlib.StdIn;
import stdlib.StdOut;

public class gcd {
	
	public static int gcdCalc(int n, int k) {
		if (n==0||k==0){
			return n+k;
		}
		else{
			return gcdCalc(k, n%k);
		}
	}

	public static void main(String[] args) {
		StdOut.println("Enter a number: ");
		int num1 = StdIn.readInt();
		
		StdOut.println("Enter another number: ");
		int num2 = StdIn.readInt();
		
		int answer = gcdCalc(num1, num2);
		
		StdOut.println("The Greatest Common Divisor is: " + answer);
		
		

	}

}
