package hw4;

public class MyOwnTestHw4 {

	public static void main(String[] args) {
		LinearProbingHashST<Integer, String> st = new LinearProbingHashST<Integer, String>(4);
		st.put(7, "seven");
		st.put(2, "two");
		st.put(6, "six");
		
		System.out.println("Before deletion: " + st.get(2));
		//st.delete(2);
		System.out.println("After deletion: " + st.get(2));
		
		st.delete(7);
		st.delete(6);
		st.put(2, "two");
		st.put(7, "seven");
		
		
		System.out.println("    Key : Value : IsLazyDeleted");
		for(int i = 0; i < st.tableSize(); i++) {
			System.out.printf("%d = %d : %s : %b\n", i, st.getKeyAt(i), st.getValueAt(i), st.isLazyDeleted(i));
		}
		System.out.println("There are " + st.size() + " keys in table.");
		System.out.println("The size of the table = " + st.tableSize());
		System.out.println("The only valid keys are: " + st.keys());
		

	}

}
