// Logan Murray
// CSC300
// January 8th, 2018


/*
Please enter an integer value: 
8
4
2
1
Iterations: 3
The value of logBASE2(value) = 3.0

Please enter an integer value: 
219
109
54
27
13
6
3
1
Iterations: 7
The value of logBASE2(value) = 7.774787059601174

*/
import stdlib.*;
public class csc300hw1b {

	public static void main(String[] args) {
		// Problem 1b
        StdOut.println("Please enter an integer value: ");
        
        int N = StdIn.readInt();
        
        double logOf2 = Math.log(N)/Math.log(2);
        
        int count = 0;
        
        while( N != 1) {
        	N = N / 2 ;
        	StdOut.println(N);
        	count++;
        }
        StdOut.println("Iterations: " + count);	
        StdOut.println("The value of logBASE2(value) = " + logOf2);
    }

}
