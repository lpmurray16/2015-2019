package algs11;

/**
*  Version 1.1
*  
*  CSC300 Program 3b:  the file name must be  PairOfDice
*  
*   Logan Murray
*   CSC300 - 501
*   
*   Does your program have compile errors?     Yes / No
*   
* This is a skeleton file for your homework. Edit the sections marked TODO. You
* may also edit the function "main" to test your code.
*
* You must not change the declaration of any method. 
*/
import stdlib.StdOut;
import stdlib.StdRandom;

public class PairOfDice {
	private static final boolean True = true;
	private static final boolean False = false;
	private int die1, die2;

	public PairOfDice() {
		roll();
	}

	public void roll() {
		die1 = StdRandom.uniform(1, 7);
		die2 = StdRandom.uniform(1, 7);
	}
	public boolean isDoubles() {
		return die1 == die2;
	}
	public int sum() {
		return die1 + die2;
	}
	
	// ToDo 1
	// add an instance method that determines if both dice are even.
	// hint boolean
	public boolean isEven() {
		if (die1 % 2 == 0 && die2 % 2 == 0) {
			return True;
		} 
		else {
			return False;
		}
	}

	// ToDo 2
	// add an instance method that determines if both dice are odd.
	// hint boolean
	public boolean isOdd() {
		if (die1 % 2 != 0 && die2 % 2 != 0) {
			return True;
		} 
		else {
			return False;
		}
	}
	
//------------------------------------- testing program ---------------------
	
	 /* experiment 1
	 * precondition:   rollValue is an integer from 1 - 12
	 * 
	 * Q. how many rolls does it take (on the average) to roll a given number?
	 * write a loop to count the number of rolls needed to get the specified rollValue. 
	 * add code to repeat that test 1,000,000 times.  
	 * return: the average (number of rolls needed) of all the tests
	 */
	
	public static double experimentOne( PairOfDice x, int rollValue) {
		
		double sumOfCounts = 0; //need to have a value that adds up all 1,000,000 test number of rolls
		int test = 0;
		while(x.sum() != rollValue && test <=1000000) {
			sumOfCounts++;
			test++;
		}
		
		
		StdOut.println(sumOfCounts);  // a check to see what is wrong.... which provides me with nothing but more questions
		
		return sumOfCounts/1000000;   // takes sum of all counts and divides them by the # of tests to find average
		
		
		
		
	}
	
	
	/*
	 * experiment 2
	 * precondition: rollType will be   "Even", "Odd", "OneOfEach"
	 * the function should roll the dice 1,000,000 times and 
	 * determine and return the percentage of rolls that are : rollType
	 * you must use the instance methods you created above
	 * hint:  don't use == for string comparison
	 */
	public static double experimentTwo( PairOfDice x, String rollType) {
		
		int rolls = 0;
		int evenRolls = 0;
		int oddRolls = 0;
		int OneAndOne = 0;
		
		while(rolls != 1000000) {     // runs test 1,000,000 times
			x.roll();        // rolls the two dice
			        
			
			if(x.isEven()) {    //checks if both die are even
				evenRolls++;    // if they are than the # of even rolls gets +1
			}
			
			if(x.isOdd()) {    // checks if both die are odd
				oddRolls++;   // if they are odd, odd rolls gets +1
			}
			if (x.isEven() && x.isOdd()){  // if both the other test come back false, then die must be one odd and one even
				OneAndOne++;                // seen as both are different, this criteria gets +1
			}
			
			rolls++;        // increments rolls
		}
		  
		double finalValue = 0.0; // initializes a final value to be 0.0. Below statements change value for return.
		
		if(rollType.equals("Even") || rollType.equals("even")) {
			finalValue = evenRolls/1000000;   //      integer/double = double... but for some reason it doens't work.                        
		} else if (rollType.equals("Odd") || rollType.equals("odd")) {
			finalValue = oddRolls/1000000;  // same as before. Division isn't working properly
		}else if(rollType.equals("OneOfEach")) {
			finalValue = OneAndOne/1000000; // same again.
		}
		
		return finalValue;
	}
	
	// nothing to do here
	public static void main(String[] args) {
		
		 PairOfDice x = new PairOfDice();
		
         double sevens = experimentOne(x, 7);
         double twelves = experimentOne(x,12);
         
         double evens = experimentTwo(x, "Even");
         double odds  = experimentTwo(x, "Odd");
         double oneOfEach = experimentTwo(x, "OneOfEach");
         
         StdOut.format(" The average number of rolls to get a 7: %5.3f\n", sevens);
         StdOut.format(" The average number of rolls to get a 12: %5.3f\n", twelves);
         StdOut.format(" The percentage of rolls with both dice even is %5.3f\n", evens);
         StdOut.format(" The percentage of rolls with both dice odd is %5.3f\n", odds);
         StdOut.format(" The percentage of rolls with one even and one odd is %5.3f\n", oneOfEach);
	}

	
	
}
