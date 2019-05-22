package orderedList;
//Logan Murray
//CSC 300-601

import stdlib.*;
public class TestOLL {

	public static void main(String[] args) {
		OrderedLinkedList<String> newLinkList = new OrderedLinkedList<String>();
		newLinkList.insert("goodbye"); 
		newLinkList.insert("adios");
		newLinkList.insert("buenos dias"); 
		newLinkList.insert("bon jour"); 
		newLinkList.insert("adieu"); 
		newLinkList.insert("guten Tag"); 
		newLinkList.insert("hello"); 
		newLinkList.insert("auf Wiedersehen");
		
		StdOut.print(newLinkList);

	}

}
