package algs11;
import java.util.Arrays;
import stdlib.*;

/**
CSC300Program4  version 1.2
 * 
 *   Logan Murray
 *   CSC300 - 501
 *   
 *   Does your program have compile errors?     Yes / No
 *   
 * This is a skeleton file for your homework. Edit the sections marked TODO. You
 * may add new functions. You may also edit the function "main" to test your
 * code.
 *
 * You must not add static variables. You MAY add static functions, just not
 * static variables.
 *
 * It is okay to add functions, such as
 *
 * <pre>
 *     public static double sumEvensHelper (double[] list, int i) {
 * </pre>
 *
 * but it is NOT okay to add static variables, such as
 *
 * <pre>
 * public static int x;
 * </pre>
 *
 * As in homework 1,2,3 you must not change the declaration of any method.
 * 
 * You can edit the main function all you want. I will not run your main
 * function when grading. For example, you can "comment out" sections of main
 *  when testing your functions
 */
public class CSC300Program4 {

	/**
	 * As a model, here is a minValue function, both iteratively and recursively
	 *
	 * precondition:   list is not empty
	/** iterative version */
	public static double minValueIterative (int[] list) {
		int result = list[0];
		int i = 1;
		while (i < list.length) {
			if (list[i] < result) result = list[i];
			i = i + 1;
		}
		return result;
	}

	/** recursive version 
	 * Find minimum of a list of size N starting at location 0
	 * Smaller problem is :  Find minimum of list of size N-1, starting at 0
	 * 
	 * precondition:   list is not empty
	 */
	public static int minValueRecursive (int[] list) {
		return minValueHelper (list, list.length);  
	}
	private static int minValueHelper (int[] list, int n) {
		if (n == 1)           // the list of size 1 is the single element list[0]
			return list[0];   //  the minimum of this list is just that element.

		//  else:  find minimum of smaller list

		int minOfSmallerList = minValueHelper( list, n-1);  // recursive call, 'smaller' list

		//  now compare min of smaller list to 'last' element of this list
		//  the list is of size n, the 'last' element is at position n-1
		//    because indexes start at 0.
		int theMin;

		if ( list[n-1] < minOfSmallerList)
			theMin = list[n-1];
		else
			theMin = minOfSmallerList;

		return theMin;
	}

	/**
	 * PROBLEM 1: Translate the following summing function from iterative to
	 * recursive.
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * 
	 * Precondition:  a list of ints, - maybe empty!
	 * Postcondition: the sum of the even values is returned
	 */
	public static int sumEvens (int[] a) {
		int result = 0;
		int i = 0;
		while (i < a.length) {
			if ( a[i] %2 == 0)
				result = result + a[i];
			i = i + 1;
		}
		return result;
	}

	public static int sumEvensRecursive (int[] a) {
		int sum = sumOfEvensHelper(a, 0, 0);
	    return sum;
	}
	private static int sumOfEvensHelper(int[] list, int i, int sum){
	    if(i < list.length){
	        if(list[i] % 2 == 0){
	            sum += list[i];
	        }
	        sum = sumOfEvensHelper(list, i+1, sum);
	    }
	    return sum;
	}

	/**
	 * PROBLEM 2: Do the same translation for this in-place reverse function
	 * 
	 * in-place means:  you may not create an extra array
	 *
	 * You should write a helper method. You may not use any "fields" to solve
	 * this problem (a field is a variable that is declared "outside" of the
	 * function declaration --- either before or after).
	 * You may not use any other methods
	 * 
	 * Your helper function must be parameterized to allow a smaller problem to
	 * be specified.  How do you reverse an array of size N?
	 * (the answer is NOT: reverse an array of size N-1 ! )
	 */
	public static void reverseIterative (int[] a) {
		int hi = a.length - 1;
		int lo = 0;
		while (lo < hi) {
			int loVal = a[lo];
			int hiVal = a[hi];
			a[hi] = loVal;
			a[lo] = hiVal;
			lo = lo + 1;
			hi = hi - 1;
		}
	}

	public static void reverseRecursive (int[] a) {
		reverseHelper(a, 0, a.length -1);
    }

	private static void reverseHelper(int[] list, int i, int j){
		if( i < j ) {     
			int tmp = list[i];
			list[i] = list[j];
			list[j] = tmp;
			reverseHelper(list, ++i, --j);  
		}   
			
	}



	/**
	 * PROBLEM 3: combine together two arrays of ints into a new array using an 
	 * every-other-element strategy, beginning with the first array
	 * For example  combine: [ 3 1 5 7 ] with [ 4 2 8 6] would yield [3 4 1 2 5 8 7 6] 
	 * There is no guarantee about the size of either array. When/if you run out of elements in 
	 * either array, copy all the remaining elements from the nonempty array to the the new array 
	 * precondition: either array may be empty
	 * postcondition: an array with all elements from both arrays, with elements as described above
	 * 
	 * You may not use any additional methods, sorting routines etc
	 * You will need to create a new array inside the function
	 * 
	 * You do not have to write this recursively.
	 */

	public static int[] combineArrays( int[] a, int[] b) {
        int[] result = new int[a.length+b.length];
        if(a.length == 0) result = b;
        if(b.length == 0) result = a;
        
        if(a.length > 0 && b.length > 0) {
        	int index = 0;
        	int smallerArray = 0;
        	
        	if(a.length < b.length) smallerArray = a.length;
        	else if (a.length > b.length) smallerArray = b.length;
        	
        	for (int i = 0; i < smallerArray; i ++) {
        		result[index++] = a[i];
        		result[index++] = b[i];
        	}
        	
        	if(a.length > smallerArray)
        	      System.arraycopy(a, smallerArray, result, index, a.length - smallerArray);
        	else if(b.length > smallerArray)
        	      System.arraycopy(b, smallerArray, result, index, b.length - smallerArray);
        	
        }
		return result;
        
        
        
        
        
          
	}

	/**
	 * PROBLEM 4: write a recursive function to compute the harmonic sum:
	 *    H(N) = 1 + 1/2 + 1/3 + 1/4 + 1/5 + ...+ 1/N 
	 *
	 * precondition: N >=1
	 * postcondition: returns the value of H(N)
	 *
	 */
	public static double harmonicSum( int N) {
		if(N == 1) {
	        return 1.0;
	    } else {
	        return (1.0 / N) + harmonicSum(N - 1);
	    }
	}

	/*
	 * testing functions and main.
	 * There are no Todo's for you in the code below.
	 */
	public static void combineArrayTests() {

		int a[] = new int[] {1,3,5,7,9,11};
		int b[] = new int[] {2,4,6};
		int[] combinedArray = combineArrays( a,b);
		StdOut.println("combining: "+ Arrays.toString(a) + " " + Arrays.toString(b));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int c[] = new int[] {1,3,5,7,9,11};
		int d[] = new int[] {2,4};
		combinedArray = combineArrays( c,d);
		StdOut.println("combining: "+ Arrays.toString(c) + " " + Arrays.toString(d));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int e[] = new int[] {1,3,5,7,9,11};
		int f[] = new int[] {};
		combinedArray = combineArrays( e,f);
		StdOut.println("combining: "+ Arrays.toString(e) + " " + Arrays.toString(f));
		StdOut.println("  --> " + Arrays.toString(combinedArray));

		int g[] = new int[] {3,11};
		int h[] = new int[] {2,4,6,8,10};
		combinedArray = combineArrays( g,h);
		StdOut.println("combining: "+ Arrays.toString(g) + " " + Arrays.toString(h));
		StdOut.println("  --> " + Arrays.toString(combinedArray));
	}

	/*
	 * The harmonic sum H(N) is  ~ ln N
	 * this function tests your recursive function to see how close
	 * this approximation is to your computed value
	 */
	public static void harmonicApproxTests() {
		double result, hsApprox, relativeError;
		for (int N=10; N <= 10000; N *=10) {
			result = harmonicSum(N);
			hsApprox = Math.log(N)-1;
			relativeError = Math.abs(result-hsApprox)/result;
			StdOut.format("\n harmonic sum of %d is %8.4f. \n        Relative error: %8.4f ", 
					N,result, relativeError );
		}
	}

	public static void main (String[] args) {
		int[] list0 = new int[] {};
		int[] list1 = new int[] { 5 };
		int[] list2 = new int[] { -3, 4 };
		int[] list3 = new int[] { 2, -3, 4 };
		int[] list4 = new int[] { -1, 2, 4, 5 };
		int[] list5 = new int[] { 6, -1, 2, -3, 8 };

		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list0), sumEvensRecursive (list0));
		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list1), sumEvensRecursive (list1));
		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list2), sumEvensRecursive (list2));
		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list3), sumEvensRecursive (list3));
		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list4), sumEvensRecursive (list4));
		StdOut.format(" list: %s  sum of evens: %d\n",Arrays.toString(list5), sumEvensRecursive (list5));

		StdOut.println ("Reverse: Before: " + Arrays.toString(list1 )  );
		reverseRecursive (list1);
		StdOut.println ("         After:  " + Arrays.toString (list1) + "\n" );

		StdOut.println ("Reverse: Before: " + Arrays.toString(list2 )  );
		reverseRecursive (list2);
		StdOut.println ("         After:  " + Arrays.toString (list2) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list3 )  );
		reverseRecursive (list3);
		StdOut.println ("         After:  " + Arrays.toString (list3) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list4 ) );
		reverseRecursive (list4);
		StdOut.println ("         After:  " + Arrays.toString (list4) + "\n");

		StdOut.println ("Reverse: Before: " + Arrays.toString(list5 ) );
		reverseRecursive (list5);
		StdOut.println ("         After:  " + Arrays.toString (list5) + "\n");

		combineArrayTests();
		harmonicApproxTests();


	}

}
