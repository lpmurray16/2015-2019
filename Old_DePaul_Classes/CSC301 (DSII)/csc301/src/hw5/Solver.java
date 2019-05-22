package hw5;

import java.util.ArrayList;

public class Solver {
	public static String solve(char[][] grid) {
		// TODO
		/*
		 * 1. Construct a graph using grid
		 * 2. Use BFS to find shortest path from start to finish
		 * 3. Return the sequence of moves to get from start to finish
		 */
		
		Graph g = new Graph(grid.length*grid.length); // creates graph with grid size amount of vertices
		
		// below adds appropriate edges to the new graph
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
		
		int start = 0; // initialize start to zero
		int finish = grid.length*grid.length; // initialize finish to the size of grid
		
		for(int row = 0; row < grid.length; row++) {
			for(int col = 0; col < grid.length; col++) {
				if(grid[row][col]=='s') {
					start = row*grid.length+col; // set location of 's'
				}
				if(grid[row][col]=='f') {
					finish = row*grid.length+col; // set location of 'f'
				}
			}
		}
		
		BreadthFirstPaths gPath = new BreadthFirstPaths(g, start); // creates a BFS object at 's'
		Iterable<Integer> pathToF = gPath.pathTo(finish); // creates the Iterable from 's' to 'f'
		ArrayList<Integer> pathList = new ArrayList<>(); // creates empty ArrayList
		pathToF.iterator().forEachRemaining(pathList::add); // adds elements from Iterable to ArrayList
		char[] finalArr = new char[pathList.size()-1]; // creates empty char array to add directions
		
		for(int i = 0; i < pathList.size()-1; i++) {
			for(int j = 1; j < pathList.size(); j++) {
				int outcome = pathList.get(i)-pathList.get(j);
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
		String finalAnswer = new String(finalArr);
		
		
		
		return finalAnswer;
		
	}
}
