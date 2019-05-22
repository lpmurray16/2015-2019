package orderedList;
//Logan Murray
//CSC 300-601
import week8examples.LLStack.Node;

public class OrderedLinkedList<Item extends Comparable<? super Item>> {

	private class Node {
		private Item data;
		private Node next;

		public Node(Item data) {
			this.data = data;
			this.next = null;
		}

		public Item getData() {
			return this.data;
		}

		public Node getNext() {
			return this.next;
		}

		public void setData(Item data) {
			this.data = data;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}

	private Node head;

	public OrderedLinkedList() {
		head = null;
	}

	public void insert(Item newData) {
		// Create a new Node containing newData.
		Node newNode = new Node(newData);
		// Declare two Node reference variables, previous (intialized to null)
		// and current (initialized to head)
		Node previous = null;
		Node current = head;
		
		
		while (true) {
		     if (current == null || newData.compareTo(current.getData()) < 0){
		         // If current is null, that means this new node is being inserted
		         // at the end.  If not null, it's being inserted elsewhere.
		         newNode.setNext(current);
		         if(previous == null){
		             // Special case: Inserting new node as first node in the linked list.
		             head = newNode;
		         } else {
		             previous.setNext(newNode);
		         }
		         return;
		     }
		     previous = current;
		     current = current.getNext();
		 }
		
	}

	public void remove(Item oldData) {
		// Declare two Node reference variables, previous (intialized to null)
		// and current (initialized to head).
		Node previous = null;
		Node current = head;
		 while (current != null) {
		     if(oldData.compareTo(current.getData())==0) {
		         if(previous == null){
		             // Special case: Removing the first node in the linked list.
		             head = head.getNext();
		         } else {
		             previous.setNext(current.getNext());
		         }
		         return;
		     }
		     previous = current;
		     current = current.getNext();
		 }
	}

	public String toString() {
		String s = "[";
		boolean firstItem = true;
		for (Node current = head; current != null; current = current.getNext()) {
			if (firstItem) {
				firstItem = false;
				s += current.getData();
			} else {
				s += ", " + current.getData();
			}
		}
		s += "]";
		return s;
	}

}
