package algs11;

import csc300w18.CSC300Sorts;  // you must have the csc300.jar file installed
							  // and added to the build path.
import stdlib.StdOut;
import stdlib.StdRandom;
import stdlib.Stopwatch;
/*
 * This is the starter file for Homework 8
 * Logan Murray
 * <Explain how you used this program to collect your data here>
 * 
 * Well this is all very messy. But I created a static method that is very similar to what is
 * found in XSortCompare. This method is called "findAverageTime" and takes two parameters.
 * The first parameter being the size of the array, the second being the amount of times you want the
 * test to run. This creates an empty array of the size you want and fills it with random values (each time one test is run).
 * Within each one test it creates a stopwatch variable to time how fast that array is sorted using one of the
 * Sort1, Sort2, Sort4 methods. It averages the times collected into one variable "average" and returns it.
 * 
 * In the main() function I created variables to contain each average for each size of array tested.
 * Now the messy part is if I wanted to test Sort1 with every size array I would have to make sure Sort1 is
 * what is typed in inside the findAverageTime function. Now I'd have to change it to Sort2 in order to test the 
 * same array sizes for that particular Sort#. To collect my data I did exactly that. Starting with Sort1, I tested and collected 
 * average computation times for each size and recorded them. After, I would go in to findAverageTime and change "Sort1" to "Sort2".
 * Rinse and repeated for Sort4.
 *
 */
public class CSC300HW8 {

	//	ToDo 1
	//	write a function:  isSorted,  which will check to see if an array of doubles 
	//	passed as a parameter, is sorted.
	//  
	 public static boolean isSorted (double[] a) {
		 boolean result = true;
		 
		 for(int i = 0; i < a.length-1; i++) {
			 if(a[i] > a[i+1]) {
				 result = false;
				 break;
			 }
		 }
		 
		 
		 
		 
		 return result;
	 }
	
	
	// this sample main program creates an array of size 9, passes it to Sort1
	// and prints the elapsed time.
	// you might try changing Sort2, Sort3, Sort4  just to make sure 
	// they are 'callable'
	//
	//  ToDo:  Change main, add additional methods if you want to facilitate
	//         collecting the data you need.
	//         You can automate this as much or as little as you like
	//
	//         You might want to review  XSortCompare in algs21 for some code hints
	//
	//	       Somewhere you should show how you used the   isSorted  function   
	//
	//		   You may not use any other Java classes or methods
	
	
	 public static double findAverageTime(int Size, int Times)  {
		 // running total of times	
		 double total = 0.0;
		    // creates an empty array of size Size
			double[] a = new double[Size];
			// run the test the amount of "Times" given. M value
			for (int t = 0; t < Times; t++) {
				// fill array with random numbers
				for (int i = 0; i < Size; i++)
					a[i] = StdRandom.uniform();
				// create a stopwatch variable
				Stopwatch sw = new Stopwatch();
				// sort the random array, Sort# is changed based on what test is conducted
				CSC300Sorts.Sort2(a);
				// create variable for elapsed time
				double elapsed = sw.elapsedTime();
				// record average time
				total+=elapsed;
				
			}
			double averageTime = total/Times;
			return averageTime;
		}
	 
	 
	 
	 
	 
	 public static void main( String[] args) {
		

		
		
		// runs and returns an average amount of time taken
		double av1024 = findAverageTime(1024, 100000);
		double av2048 = findAverageTime(2048, 100000);
		double av4096 = findAverageTime(4096, 100000);
	    double av8192 = findAverageTime(8192, 10000);
	    double av16384 = findAverageTime(16384, 1000);
	    double av32768 = findAverageTime(32768, 1000);
	    double av65536 = findAverageTime(65536, 1000);
	    double av131072 = findAverageTime(131072, 100);
	    double av262144 = findAverageTime(262144, 50);
		
	    StdOut.println(" elapsed time 1024: " + av1024);
	    StdOut.println(" elapsed time 2048: " + av2048);
	    StdOut.println(" elapsed time 4096: " + av4096);
	    StdOut.println(" elapsed time 8192: " + av8192);
	    StdOut.println(" elapsed time 16384: " + av16384);
	    StdOut.println(" elapsed time 32768: " + av32768);
	    StdOut.println(" elapsed time 65536: " + av65536);
	    StdOut.println(" elapsed time 131072: " + av131072);
	    StdOut.println(" elapsed time 262144: " + av262144);
		
	    /*Stopwatch sw = new Stopwatch();
		CSC300Sorts.Sort1(a);
		boolean isSort = isSorted(a);
		double elapsed =  sw.elapsedTime();
	    StdOut.format(" elapsed time %10.6f\n", elapsed);	
	    StdOut.println("is it sorted? "+ isSort + a[1] +" "+ a[398]); // displays true if sorted, false if not.*/
	}

}
