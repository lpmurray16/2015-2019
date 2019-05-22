package hw1;

import static org.junit.Assert.*;

import org.junit.Test;

public class HW1Test {

	/**
	 * A toy test function. Tests that symbol table behaves as expected when a
	 * single key/value pair is inserted.
	 */
	@Test
	public void testSinglePutGet() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		assertEquals(0, st.size());
		assertNull(st.get("apple"));
		st.put("apple", 42);
		assertEquals(1, st.size());
		assertEquals(new Integer(42), st.get("apple"));
		assertNull(st.get("a"));
		assertNull(st.get("b"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testGetNull() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("a", 1);

		// Null is not a valid key. This should throw an IllegalArgumentException
		st.get(null);
	}

	// TODO
	// Write some more test functions below. Make sure to test:
	// 1. Putting at the beginning, end, and middle of the list.
	@Test
	public void beginMidEnd() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		assertEquals(0, st.size());
		st.put("a", 1);	// puts first entry in
		
		assertEquals(1, st.size());
		st.put("c", 3); // puts second entry in, but should be last
		
		assertEquals(2, st.size());
		st.put("b", 2);	// puts third entry in, but should be in the middle
		
		assertEquals(3, st.size());
	}
	// 2. Putting something that is already in the list
	@Test
	public void alreadyThere() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("a", 1);
		assertEquals(1, st.size());
		st.put("c", 3);
		assertEquals(2, st.size());
		st.put("b", 2);
		assertEquals(3, st.size());
		
		st.put("a", 1); // should be there

	}
	// 3. Size works correctly --------DONE
	// 4. Get works correctly for keys in beginning, middle and end.
	@Test
	public void getTesting() {
		SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
		st.put("b", 2);
		st.put("c", 3);
		st.put("e", 5);
		
		st.get("a"); // not at beginning :null
		st.get("d"); // not in middle :null
		st.get("f"); // not at end :null
		
		st.get("b");
		st.get("c"); 
		st.get("e");
	}
	// 5. Get works correctly for keys that are not in the list but
	// would be located at beginning, middle, end of list. ----DONE ABOVE
	// 6. Delete works correctly for keys in beginning, middle, and end.
	
	// 7. Delete works correctly for keys that are not in the symbol table.
	// 8. You can put a few items, delete them all, and then put more items
	// and all the functions (put, get, delete, iterate) continue to work.
	// 9. The iterator returned by keys() provides the keys in increasing order.
	//10.  Null is not a valid key.  Your code should behave as before your
	//      changes and throw an IllegalArgumentException when null is given as a
	//      key to any method. 

}
