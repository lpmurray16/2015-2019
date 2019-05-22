package hw5;

import java.awt.List;
import java.util.ArrayList;

public class MyOwnTestHw5 {

	public static void main(String[] args) {
		
		
		String[] data = 
			{
					" * *  ",
					"   *  ",
					"s  *  ",
					"**  * ",
					"  * * ",
					"  *  f"
			};
		
		
		char[][] grid; 
		grid = GridUtilities.fromStringArray(data); // makes a grid out of the string above
		
		String mysolution = Solver.solve(grid);
		int start = 0;
		int finish = 0;
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid.length; col++) {
				if(grid[row][col]=='s') {
					start = row*grid.length+col;
				}
				if(grid[row][col]=='f') {
					finish = row*grid.length+col; // set location of 'f'
				}
			}
		}
        
		Graph g = new Graph(grid.length*grid.length); // creates a new graph (empty)
		
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid.length; col++) {
				
				if(grid[row][col]!='*') {
					if(row-1 >= 0 && row+1 < grid.length) {
						if(grid[row-1][col]!='*') { // up check
							g.addEdge(row*grid.length+col, (row-1)*grid.length+col);
						}
						if(grid[row+1][col]!='*') { // down check
							g.addEdge(row*grid.length+col, (row+1)*grid.length+col);
						}
					}
					if(col-1 >= 0 && col+1 < grid.length) {
						if(grid[row][col-1]!='*') { // left check
							g.addEdge(row*grid.length+col, row*grid.length+(col-1));
						}
						if(grid[row][col+1]!='*') { //right check
							g.addEdge(row*grid.length+col, row*grid.length+(col+1));
						}
					}
					
				}
			}
		}
		
		BreadthFirstPaths test1 = new BreadthFirstPaths(g, start);
		Iterable<Integer> testArr = test1.pathTo(finish);
		ArrayList<Integer> list1 = new ArrayList<>();
		testArr.iterator().forEachRemaining(list1::add);
		char[] finalArr = new char[list1.size()-1];
		
		for(int i = 0; i < list1.size()-1; i++) {
			for(int j = 1; j < list1.size(); j++) {
				int outcome = list1.get(i)-list1.get(j);
				if(outcome==-1) {
					finalArr[i]='R';
				}else if(outcome==1) {
					finalArr[i]='L';
				}else if(outcome==grid.length) {
					finalArr[i]='U';
				}else if(outcome==(0-grid.length)) {
					finalArr[i]='D';
				}
			}
		}
		String b = new String(finalArr);
		
		System.out.println(mysolution+" " + b.length());

	}
}

/*if(grid[row][col]=='s') vArray[row*grid.length+col]='s';
else if(grid[row][col]==' ') vArray[row*grid.length+col]=' ';
else if(grid[row][col]=='f') vArray[row*grid.length+col]='f';
else if(grid[row][col]=='*') vArray[row*grid.length+col]='*';
*/