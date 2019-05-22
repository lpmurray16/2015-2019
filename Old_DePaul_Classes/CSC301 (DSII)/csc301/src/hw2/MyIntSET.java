package hw2;

import java.util.LinkedList;

/* ***********************************************************************
 * A simple BST with int keys and no values
 *
 * Complete each function below.
 * Write each function as a separate recursive definition (do not use more than one helper per function).
 * Depth of root==0.
 * Height of leaf==0.
 * Size of empty tree==0.
 * Height of empty tree=-1.
 *
 * TODO: complete the functions in this file.
 * DO NOT change the Node class.
 * DO NOT change the name or type of any function (the first line of the function)
 *
 * Restrictions:
 *  - no loops (you cannot use "while" "for" etc...)
 *  - only one helper function per definition
 *  - no fields (static or non static).  Only local variables
 *************************************************************************/
public class MyIntSET {
	private Node root;
	private static class Node {
		public int key;
		public Node left, right;
		public Node(int key) { this.key = key; }
	}

	public void printInOrder() {
		printInOrder(root);
	}
	
	private void printInOrder(Node n) {
		if (n == null)
			return;
		printInOrder(n.left);
		System.out.println(n.key);
		printInOrder(n.right);
	}

	// the number of nodes in the tree
	public int size() {
		// TODO
		return size(root);
	}
	
	private int size(Node n) {
		if (n==null) {
			return 0;
		}
		int leftSize = size(n.left);
		int rightSize = size(n.right);
		return leftSize + rightSize + 1;
	}

	// Recall the definitions of height and depth.
	// in the BST with level order traversal "41 21 61 11 31",
	//   node 41 has depth 0, height 2
	//   node 21 has depth 1, height 1
	//   node 61 has depth 1, height 0
	//   node 11 has depth 2, height 0
	//   node 31 has depth 2, height 0
	// height of the whole tree is the height of the root

	
	// 20 points
	/* Returns the height of the tree.
	 * For example, the BST with level order traversal 50 25 100 12 37 150 127
	 * should return 3.
	 * 
	 * Note that the height of the empty tree is defined to be -1.
	 */
	public int height() {
		// TODO
		return height(root);
	}
	
	private int height(Node n) {
		if(n==null) {
			return -1;
		}
		
		int leftHeight = height(n.left);
		int rightHeight = height(n.right);
		
		if (leftHeight > rightHeight) {
			return leftHeight +1;
		} else {
			return rightHeight +1;
		}
	}


	// 20 points
	/* Returns the number of nodes with odd keys.
	 * For example, the BST with level order traversal 50 25 100 12 37 150 127
	 * should return 3  (25, 37, and 127).
	 */
	public int sizeOdd() {
		// TODO
		return sizeOdd(root);
	}
	
	private int sizeOdd(Node n) {
		if(n==null) {
			return 0;
		}
		int count = sizeOdd(n.left) + sizeOdd(n.right);
		
		if(n.key%2 != 0) {
			return count + 1;
		} else {
			return count;
		}
	}

	
	// 20 points
	/* Returns true if this tree and that tree "look the same." (i.e. They have
	 * the same keys in the same locations in the tree.)
	 * Note that just having the same keys is NOT enough.  They must also be in
	 * the same positions in the tree.
	 */
	public boolean treeEquals(MyIntSET that) {
		
		if(this.size() != that.size()) return false; // if they aren't the same size they aren't equal
		
		return treeEqualsHelper(root, that.root); // helper function that takes the root of each Object
			
	}
	
	private boolean treeEqualsHelper(Node n, Node k) {
		
		if(n==null && k==null) { // base case, they are both empty *still means they are equal
			return true;
		}
		
		if(n != null && k!=null) { // case 1: they both aren't empty so compare them and their subtrees
			return (n.key == k.key && treeEqualsHelper(n.left, k.left) && treeEqualsHelper(n.right, k.right));
		}
		
		return false; // one is empty, the other isn't so overall : false
		
		
	}
	
	
	
	
	
	

	// 10 points
	/* Returns the number of nodes in the tree, at exactly depth k.
	 * For example, given BST with level order traversal 50 25 100 12 37 150 127
	 * the following values should be returned
	 * t.sizeAtDepth(0) == 1		[50]
	 * t.sizeAtDepth(1) == 2		[25, 100]
	 * t.sizeAtDepth(2) == 3		[12, 37, 150]
	 * t.sizeAtDepth(3) == 1		[127]
	 * t.sizeAtDepth(k) == 0 for k >= 4
	 */
	public int sizeAtDepth(int k) {
		if(k<0 || k>this.height())
			return 0;
		int current = 0;
		return sizeAtDepthHelper(root, current, k);
	}
	
	private int sizeAtDepthHelper(Node start, int curr, int desired) {
		if(start==null)
			return 0;
		
		if(curr==desired) return 1;
		
		return sizeAtDepthHelper(start.left, curr+1, desired) + sizeAtDepthHelper(start.right, curr+1, desired);
    }


	// 10 points
	/*
	 * Returns the number of nodes in the tree "above" depth k. 
	 * Do not include nodes at depth k.
	 * For example, given BST with level order traversal 50 25 100 12 37 150 127
	 * the following values should be returned 
	 * t.sizeAboveDepth(0) == 0
	 * t.sizeAboveDepth(1) == 1					[50]
	 * t.sizeAboveDepth(2) == 3					[50, 25, 100]		
	 * t.sizeAboveDepth(3) == 6					[50, 25, 100, 12, 37, 150] 
	 * t.sizeAboveDepth(k) == 7 for k >= 4		[50, 25, 100, 12, 37, 150, 127] 
	 */
	public int sizeAboveDepth(int k) {
		int current = 0;
		return sizeAboveDepth(root, current, k);
	}
	
	private int sizeAboveDepth(Node n, int curr, int depth) {
		if(n != null && curr < depth) {
			return sizeAboveDepth(n.left, curr+1, depth) + sizeAboveDepth(n.right, curr+1, depth) + 1;
		} else {
			return 0;
		}
	}

	// A tree is perfect if for every node, size of left == size of right
	// hint: in the helper, return -1 if the tree is not perfect, otherwise return the size
	// 10 points
	/* Returns true if for every node in the tree has the same number of nodes
	 * to its left as to its right.
	 */
	public boolean isPerfectlyBalancedS() {
		// TODO
		return isPerfBal(root);
	}
	private boolean isPerfBal(Node n) {
		if(n==null) {
			return true;
		}
		if(n.left != null && n.right != null)
			return isPerfBal(n.left) && isPerfBal(n.right);
		
		return false;
	}


	
	/*
	 * Mutator functions
	 * HINT: This is easier to write if the helper function returns Node, rather than void
	 * similar to recursive mutator methods on lists.
	 */

	// 10 points
	/* Removes all subtrees with odd roots (if node is odd, remove it and its descendants)
	 * A node is odd if it has an odd key.
	 * If the root is odd, then you should end up with the empty tree.
	 * For example, when called on a BST
	 * with level order traversal 50 25 100 12 37 150 127
	 * the tree will be changed to have level order traversal 50 100 150
	 */
	public void removeOddSubtrees () {
		// TODO
		root = removeOddSubtrees(root);
	
	}
	
	private Node removeOddSubtrees(Node n) {
		if(n==null) {
			return null;
		}
		
		if(n.key%2!=0) {
			n = null;
		} else {
			n.left = removeOddSubtrees(n.left);
		    n.right = removeOddSubtrees(n.right);
		}
		
		return n;
	}
	
	public void deleteKey(int key){
        root = deleteRec(root, key);
    }
 
    
    private Node deleteRec(Node root, int key){
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the in order successor (smallest
            // in the right subtree)
            root.key = minValue(root.right);
 
            // Delete the in order successor
            root.right = deleteRec(root.right, root.key);
        }
 
        return root;
    }
    public int minValue(Node root)
    {
        int minv = root.key;
        while (root.left != null)
        {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }
 



	/* ***************************************************************************
	 * Some methods to create and display trees
	 *****************************************************************************/

	// Do not modify "put"
	public void put(int key) { root = put(root, key); }
	private Node put(Node n, int key) {
		if (n == null) return new Node(key);
		if      (key < n.key) n.left  = put(n.left,  key);
		else if (key > n.key) n.right = put(n.right, key);
		return n;
	}
	// This is what contains looks like
	public boolean contains(int key) { return contains(root, key); }
	private boolean contains(Node n, int key) {
		if (n == null) return false;
		if      (key < n.key) return contains(n.left,  key);
		else if (key > n.key) return contains(n.right, key);
		return true;
	}
	// Do not modify "copy"
	public MyIntSET copy () {
		MyIntSET that = new MyIntSET ();
		for (int key : levelOrder())
			that.put (key);
		return that;
	}
	// Do not modify "levelOrder"
	public Iterable<Integer> levelOrder() {
		LinkedList<Integer> keys = new LinkedList<Integer>();
		LinkedList<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n == null) continue;
			keys.add(n.key);
			queue.add(n.left);
			queue.add(n.right);
		}
		return keys;
	}
	// Do not modify "toString"
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int key: levelOrder())
			sb.append (key + " ");
		return sb.toString ();
	}
	
	public void prettyPrint() {
		if (root == null)
			System.out.println("<EMPTY>");
		else
			prettyPrintHelper(root, "");
	}
	
	private void prettyPrintHelper(Node n, String indent) {
		if (n != null) {
			System.out.println(indent + n.key);
			indent += "    ";
			prettyPrintHelper(n.left, indent);
			prettyPrintHelper(n.right, indent);
		}
	}
	
	public static void main(String[] args) {
		MyIntSET s = new MyIntSET();
		s.put(15);
		s.put(11);
		s.put(21);
		s.put(8);
		s.put(13);
		s.put(16);
		s.put(18);
		s.printInOrder();
	}	
}
