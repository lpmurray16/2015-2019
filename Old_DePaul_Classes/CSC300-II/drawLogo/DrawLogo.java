package drawLogo;

// Logan Murray
// CSC300-601

import stdlib.*;

public class DrawLogo {

	public static void main(String[] args) {
		//Cyan Circle
		StdDraw.setPenColor(StdDraw.CYAN);
		StdDraw.filledCircle(0.75,0.75,0.25);
		
		//Magenta Circle
		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.filledCircle(0.25,0.25,0.25);
		
		//Red Square
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.filledSquare(0.25, 0.75, 0.25);
		
		//Blue Square
		StdDraw.setPenColor(StdDraw.BLUE);
		StdDraw.filledSquare(0.75, 0.25, 0.25);

	}

}
