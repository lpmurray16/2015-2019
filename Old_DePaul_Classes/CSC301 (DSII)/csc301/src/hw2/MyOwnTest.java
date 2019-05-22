package hw2;

public class MyOwnTest {

	public static void main(String[] args) {
		MyIntSET st = new MyIntSET();
		MyIntSET copyOfst = new MyIntSET();
		MyIntSET testTree = new MyIntSET();
		
		//st.put(30); //first
		//st.put(50); //last
		//st.put(20); //before first
		//st.put(40); //middle
		//st.put(100); //odd number
		//st.put(98);
		//st.put(101);
		
		testTree.put(31); //first
		testTree.put(27); //last
		testTree.put(62); //before first
		testTree.put(6); //middle
		testTree.put(56); //odd number
		testTree.put(88);
		testTree.put(10);
		testTree.put(64);
		testTree.put(99);
//		copyOfst.put(30); //first
//		copyOfst.put(50); //last
//		copyOfst.put(20); //before first
//		copyOfst.put(40); //middle
//		copyOfst.put(21); //odd number
//		copyOfst.put(51);
//		
//		System.out.println("Height of the tree: " + st.height());
//		st.printInOrder();
//		System.out.println("Size: " + st.size());
//		System.out.println("Size of odds: " + st.sizeOdd());
//		System.out.println("Level order: " + st.levelOrder());
//		System.out.println("Level order: " + copyOfst.levelOrder());
//
//		System.out.println("treeEquals test: " + st.treeEquals(copyOfst));
//		System.out.println("Test for balance: " + st.isPerfectlyBalancedS());
//		st.removeOddSubtrees();
//		System.out.println("Size: " + st.size());
//		st.printInOrder();
		
		testTree.deleteKey(62);
		System.out.println("Level order: " + testTree.levelOrder() + "****");
//		System.out.println("Size of testTree: " + testTree.size());
//		System.out.println("Number of nodes at depth 0: " + testTree.sizeAtDepth(0));
//		System.out.println("Number of nodes at depth 1: " + testTree.sizeAtDepth(1));
//		System.out.println("Number of nodes at depth 2: " + testTree.sizeAtDepth(2));
//		System.out.println("Number of nodes at depth 3: " + testTree.sizeAtDepth(3));
//		System.out.println("Number of nodes at depth 4: " + testTree.sizeAtDepth(4));
//		
//		System.out.println("Number of nodes above depth 0: " + testTree.sizeAboveDepth(0));
//		System.out.println("Number of nodes above depth 1: " + testTree.sizeAboveDepth(1));
//		System.out.println("Number of nodes above depth 2: " + testTree.sizeAboveDepth(2));
//		System.out.println("Number of nodes above depth 3: " + testTree.sizeAboveDepth(3));
//	    System.out.println("Number of nodes above depth 4: " + testTree.sizeAboveDepth(4));
		
		



//		testTree.removeOddSubtrees();
//		System.out.println("Size of testTree after removal: " + testTree.size());
//		testTree.printInOrder();
		
		


		
		
		
		
		
	}
		
		
		

}
