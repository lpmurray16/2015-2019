package algs11;

import java.util.Arrays;
import stdlib.*;

/**
 * CSC300Program1  version 1.0
 * 
 *   Logan Murray
 *   CSC 300 - 501
 *   
 *   Does your program have compile errors?     Yes / No
 *   Indicate which TODOs have been completed correctly   
 *   TODO 1    Correct / Incorrect
 *   TODO 2    Correct / Incorrect
 *   TODO 3    Correct / Incorrect
 *   TODO 4    Correct / Incorrect
 *   TODO 5    Correct / Incorrect
 * 
 * This is a skeleton file for your programming assignment. Edit the sections marked TODO. 
 *
 * Unless specified otherwise, you must not change the declaration of any method. 
 * This will be true of every skeleton file I give you.
 *
 * For example, you will get zero points if you change the line
 * <pre>
 *     public static double valRange (double[] list)
 * </pre>
 * to something like
 * <pre>
 *     public static void valRange (double[] list)
 * </pre>
 * or
 * <pre>
 *     public static double valRange (double[] list, int i) {
 * </pre>
 * 
 * Each of the functions below is meant to be SELF CONTAINED. This means that
 * you should use no other functions or classes.  You should not use any HashSets
 * or ArrayLists, or anything else! Exception: You may use Math.abs  (look it up)
 * In addition, each of your functions should go through the argument array at most once. 
 */
public class CSC300Program2 {

	/**
	 * valRange returns the difference between the maximum and minimum values
	 * in the array; Max-Min.  
	 * Precondition: the array is nonempty. 
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *    0  == valRange (new double[] { -7 })
	 *    10 == valRange (new double[] { 1, 7, 8, 11 })
	 *    10 == valRange (new double[] { 11, 7, 8, 1 })
	 *    18 == valRange (new double[] { 1, -4, -7, 7, 8, 11 })
	 *    24 == valRange (new double[] { -13, -4, -7, 7, 8, 11 })
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static double valRange (double[] list) { 
		double result = 0;
		double min = list[0];
		double max = list[0];
		
		if(list.length >= 1) {
			for(int i = 1; i < list.length; i++) {
				if (list[i] > max ) {
					max = list[i];
				}
				else if (list[i] < min) {
					min = list[i];
				}
			}
		}
		
		result = max - min;
		
		return result;

	}

	/**
	 * minPosition returns the position where the minimum value is located
	 *
	 * Precondition:  the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  
	 * 
	 * Here are some examples (using "==" informally):
	 *
	 * <pre>
	 *   0 == minPosition(new double[] { -7 })                      // -7 is the minimum
	 *   2 == minPosition(new double[] { 1, -4, -7, 7, 8, 11 }),    // -7 is is location 2
	 *   0 == minPosition(new double[] { -13, -4, -7, 7, 8, 11 })   // -13 is in location 0
	 *   6 == minPosition(new double[] { 1, -4, -7, 7, 8, 11, -9 }) // -9 is in location 6
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int minPosition (double[] list) {
		int indexNum = 0;
		double min = list[0];
		
		if(list.length >= 1) {
			for(int i = 1; i < list.length; i++) {
				if(list[i] < min) {
					min = list[i];
				    indexNum = i;
				}
			}
		}
		
		return indexNum;

	}
	/**
	 * posOfLargestElementLTOET returns the position of the largest element in the array that is
	 * less than or equal to the theVal parameter
	 * if all values are greater than theVal, return -1;
	 * 
	 * Precondition:  the array is nonempty and all elements are unique.
	 * Your solution must go through the array exactly once.  
	 *
	 * <pre>
	 *   0 == posOfLargestElementLTOET(3, new double[] { -7 })                      // value:-7 is in pos 0
	 *   5 == posOfLargestElementLTOET(3, new double[] { 11, -4, -7, 7, 8, 1 }),    // value:1 is in pos 5
	 *  -1 == posOfLargestElementLTOET(-7, new double[] { 1, -4, -5, 7, 8, 11 }),   // all elements are > -7
	 * 
	 * The code below is a stub version, you should replace the line of code
	 * labeled TODO  with code that achieves the above specification
	 * </pre>
	 */
	public static int posOfLargestElementLTOET( double theVal, double[] list) {
		/*int indexNum = 0;
		double diff = 0;
		int count = 0;
		
		for(int i = 0; i < list.length; i++) {
			if(list[i] <= theVal) {
				count++;
				// I am struggling with the process of this code. Will need to ask in class.
			}
			else {
				break;
			}
		}
		if(count == 0) return -1;*/
		return 0;
	}
	/**
	 * A test program, using private helper functions.  See below.
	 */
	public static void main (String[] args) {
		// for ValRange: array must be nonempty
		testValRange (0, new double[] {11} );
		testValRange (0, new double[] { 11,11,11,11,11} );
		testValRange (10, new double[] {11, 1} );
		testValRange (10, new double[] {1,11} );
		testValRange (32, new double[] {11, 21, 9, 31, 41});
		testValRange (32, new double[] {41, 21, 9, 31, 11});
		testValRange (32, new double[] {11, 41, 9, 31, 21});
		testValRange (32, new double[] {-41, -21, -11, -31, -9});
		testValRange (32, new double[] {-9, -21, -11, -31, -41});
		testValRange (32, new double[] {-41, -11, -9, -31, -21});
		testValRange (32, new double[] {-11, -21, -41, -31, -9});		
		testValRange (0.7, new double[] { 0.2, -0.5, -0.1});
		StdOut.println();

		// for distanceBetweenMinAndMax: array must be nonempty with unique elements
		testMinPosition (0, new double[] {11});
		testMinPosition (0, new double[] {-11});
		testMinPosition (0, new double[] {9, 11, 21, 31, 41});
		testMinPosition (1, new double[] {11, 9, 21, 31, 41});
		testMinPosition (2, new double[] {11, 21, 9, 31, 41});
		testMinPosition (3, new double[] {11, 21, 31, 9, 41});
		testMinPosition (4, new double[] {11, 21, 31, 41, 9});
		testMinPosition (4, new double[] {9, -11, -21, -31, -41});
		testMinPosition (4, new double[] {-11, -21, -31, 9, -41});
		testMinPosition (3, new double[] {-11, -21, -31, -41, 9});
		testMinPosition (2, new double[] {1, -4, -7, 7, 8, 11, 9, -5});
		testMinPosition (1, new double[] {0.2, -0.5, -0.1});
		StdOut.println();
		
		// for posOfElementClosestTo: array must be nonempty with unique elements
		testPosOfLargestElementLTOET( 0, 3 , new double[] {-7});      
		testPosOfLargestElementLTOET( 5, 3 , new double[] {11, -4, -7, 7, 8, 1}); 

		
// TODO 4   Add calls for three more test cases for posOfElementClosestTo
//		   these must be substantively different than two provided.
//         Try to imagine what 'could go wrong' in the function being tested and create a test case that 
//         checks this case.
		testPosOfLargestElementLTOET(-1, -7, new double[] {2, 3, -4, -5, 6});
		testPosOfLargestElementLTOET(1, 3, new double[] {2, 3, -4, -5, 6});
		testPosOfLargestElementLTOET(0, 4, new double[] {4});
		StdOut.println ("Finished tests");
	}
	
	/* Test functions --- lot's of similar code! */
	private static void testValRange (double expected, double[] list) {
		double actual = valRange (list);
		if (expected != actual) {
			StdOut.format ("Failed valRange(%s): Expecting (%.1f) Actual (%.1f)\n", Arrays.toString(list), expected, actual);
		}
	}
	private static void testMinPosition (int expected, double[] list) {
		
		int actual = minPosition (list);
		
		if (expected != actual) {
			StdOut.format ("Failed testMinPosition(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}	
	
	private static void testPosOfLargestElementLTOET (int expected, double theVal, double[] list) {
	
	//TO DO 5  fix this!
		int actual = posOfLargestElementLTOET(theVal, list);
		
		if(expected != actual) {
			StdOut.format ("Failed. posOfLargestElementLTOET(%s): Expecting (%d) Actual (%d)\n", Arrays.toString(list), expected, actual);
		}
	}
	
}