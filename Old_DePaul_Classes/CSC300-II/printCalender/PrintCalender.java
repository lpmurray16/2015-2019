package printCalender;

// Logan Murray
// CSC 300-601

import algs12.Date;
import stdlib.*;

public class PrintCalender {

	public static void main(String[] args) {
		StdOut.print("Enter a starting date: ");
		String startDate = StdIn.readString();
		
		StdOut.print("Enter an ending date: ");
		String endDate = StdIn.readString();
		
		Date startingDate =  new Date(startDate);
		Date endingDate = new Date(endDate);
		
		while(!startingDate.equals(endingDate)){
			if(startingDate.isBefore(endingDate)){
				StdOut.print(startingDate+"\t");
				for(int i=0; i < 6; i++){
					
					startingDate = startingDate.next();
				    StdOut.print(startingDate+"\t");
					
				}
				StdOut.print("\n");
				
			}
			
			
		}
		
		
	}

}
