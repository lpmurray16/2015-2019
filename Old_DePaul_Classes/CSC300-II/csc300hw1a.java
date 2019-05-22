// Logan Murray
// CSC 300
// January 8th, 2018

/*
Please enter two floating point values: 
3.5
4.2
The sum is: 7.699999809265137
The difference is: -0.6999998092651367
The quotient is: 0.8333333711775539
And num1^num2 is: 192.79052344938842
*/
import java.text.DecimalFormat;

import stdlib.*;

public class csc300hw1a {

	public static void main(String[] args) {
		// Problem 1a
		DecimalFormat df = new DecimalFormat("#.00");
		StdOut.println("Please enter two floating point values: ");
		double num1 = StdIn.readFloat();
		double num2 = StdIn.readFloat();
		double sum = num1 + num2;
		double diff = num1 - num2;
		double quotient = num1/num2;
		double exponent = Math.pow(num1, num2);
		StdOut.println("The sum is: " + sum);
		StdOut.println("The difference is: " + diff);
		StdOut.println("The quotient is: " + quotient);
		StdOut.println("And num1^num2 is: " + exponent);
     // Directions don't specify rounding answers.
	}

}
