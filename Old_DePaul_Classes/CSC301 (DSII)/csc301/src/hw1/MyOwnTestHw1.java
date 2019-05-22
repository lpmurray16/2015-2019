package hw1;


public class MyOwnTestHw1 {

	public static void main(String[] args) {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		// placing items in, hopefully sequential
		st.put("b", 2); 
		st.put("a", 1);
		st.put("d", 4);
		st.put("c", 3);
		
		
		
		//st.put("a", 10); // try to replace the val of "a" with 10
		
		//st.delete("a"); // uncomment to test deletion
		//st.delete("b"); // uncomment to test deletion
		
		
		
		// printing out the test results
		System.out.println("***Iterative Tests***\nsize =  " + st.size());
		System.out.println("contains: " + st.contains("a") + "  and a = " + st.get("a"));
		System.out.println("contains: " + st.contains("b") + "  and b = " + st.get("b"));
		System.out.println("contains: " + st.contains("c") + "  and c = " + st.get("c"));
		System.out.println("contains: " + st.contains("d") + "  and d = " + st.get("d"));
		System.out.println(st.keys());
        
		
		//++++++++++++++++BEGINNING OF RECURSIVE TEST++++++++++++++++++++
		RSequentialSearchST<String, Integer> rst = new RSequentialSearchST<String, Integer>();
		// testing the insertions method
		rst.put("b", 2); // place in empty
		rst.put("a", 1); // test placing before "b"
		rst.put("d", 4); // test placing at end of nonempty
		rst.put("c", 3); // test placing in the middle
		
		rst.put("b", 10); // try to replace the val of "a" with 10
		
		rst.delete("d"); // try and delete an existing key
		
		
		
		
		// printing out test result
		System.out.println("***Recursive Test***\nsize =  " + rst.size());
		System.out.println("contains: " + rst.contains("a") + "  and a = " + rst.get("a"));
		System.out.println("contains: " + rst.contains("b") + "  and b = " + rst.get("b"));
		System.out.println("contains: " + rst.contains("c") + "  and c = " + rst.get("c"));
		System.out.println("contains: " + rst.contains("d") + "  and d = " + rst.get("d"));
		System.out.println(rst.keys());


		
	}

}
