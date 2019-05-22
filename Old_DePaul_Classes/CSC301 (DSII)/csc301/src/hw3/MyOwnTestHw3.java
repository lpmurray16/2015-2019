package hw3;

public class MyOwnTestHw3 {

	public static void main(String[] args) {
		// create first testing 2-3 tree
		TwoThreeIntSet s1 = new TwoThreeIntSet();
		s1.put(10);
		s1.put(5);
		s1.put(3); //becomes 4 node, must split
		s1.put(7); 
		s1.put(4);
		s1.put(2); //becomes 4 node, must split
		s1.put(8); //becomes 4 node, must split, new root
		s1.put(9);
		System.out.println(s1.levelOrder());
		System.out.println("Check to see if 4 is in tree: " + s1.contains(4));
		
		
	}

}
