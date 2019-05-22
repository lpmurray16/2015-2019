// Logan Murray
// CSC 300
//January 12, 2018

/*
 Please enter GPA values: 
4.0
3.7
2.9
3.5
-1
# of GPAs entered: 5
The sum of GPAs: 13.1
The average GPA: 2.62
[4.0, 3.7, 2.9, 3.5, -1.0]
*/

import stdlib.*;
import java.util.*;
public class csc300hw1c {

	public static void main(String[] args) {
		
		List<Double> gpas = new ArrayList<Double>();
		
		StdOut.println("Please enter GPA values: ");
		
		
		int count = 0;
		
		double x = 0;
		double sum = 0;
		
		
		while(x >= 0) {
			x = StdIn.readDouble();
			gpas.add(x);
			count++;
			
		}
		
		for(int i = 0; i < gpas.size(); i++) {
			sum += gpas.get(i);
		}
		
		double average = sum/gpas.size();
		
		
		StdOut.println("# of GPAs entered: " + count);
		StdOut.println("The sum of GPAs: " + sum);
		StdOut.println("The average GPA: " + average);		
			
		
		
		StdOut.println(gpas);
	}

}
