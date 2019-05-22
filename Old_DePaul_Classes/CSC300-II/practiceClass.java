import java.util.ArrayList;

import stdlib.*;
public class practiceClass{
	
	
	
	
	public static int[] deDupAndReverse (int[] list) {
		
			ArrayList<Integer> uniqueVals = new ArrayList<>(); //creates array list to help.
			 
			 
		
			for(int i = list.length - 1; i >= 0; i--){
				if(!uniqueVals.contains(list[i])){  // checks if value is in created list.
					uniqueVals.add(list[i]);        // if value is NOT in created list, it adds it.
				}
			}
		    
			int[] revArray = new int[uniqueVals.size()];
		    
			for(int i = 0; i < revArray.length; i++) {
				if (uniqueVals.get(i) != null) {
					revArray[i] = uniqueVals.get(i);
				}
			}
		
			return revArray;
	}



	public static void main(String[] args) {
		//int[] array = {11,11,11,11,22,22,33,44,55,55,66,66,77,77,88,88};
		//StdOut.println(array.length);
		//int[] newArray = deDupAndReverse(array);
		//for(int i = 0; i < newArray.length; i++) StdOut.println(newArray[i]);
	    //int answer = f(2);
	    //StdOut.println(answer);
	    
		int i, num;

	    num = StdIn.readInt();   // get a value from the user

	    for (i = 1; i < num; i++) {

	      StdOut.println( "i is " + i);

	    }

	    StdOut.println( " the final value of i  is " + i);
	}
	
	public static int f(int n) {

		   if ( n < 0 ) 

		       return 2;

		  else

		        return f(n-1) + f(n-3);

		}
	
	
		














}
