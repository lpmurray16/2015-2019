package finalexam;

// Logan Murray
// CSC 300 - 601




import java.util.ArrayList;
import algs13.Queue;
import java.util.Stack;
import finalexam.Chord;
import algs24.MinPQ;
import stdlib.*;
public class Final {

	
    //*************Question 1 (Your Name)***********		
	public static String yourName(){
		String firstname = "Logan";
		String lastname = "Murray";
		String formatted = firstname +", "+lastname;
		return formatted;
	}
	
	//********Question 2 (Priority Queue)*************
	public static <Item extends Comparable<? super Item>> void minpqSort(Item[] a){
		MinPQ<Item> minpqArray = new MinPQ<Item>();
		
		for(int i = 0; i < a.length; i++){
			minpqArray.insert(a[i]);
		}
		
		for(int i = 0; i < a.length; i++){
			Item min = minpqArray.delMin();
			
			a[i] = min;
		}
		
	}
	
	//********Question 3 (FIFO Queue)*********
	public static <Item> Queue<Item> reverseQueue(Queue<Item> queue){
		
		Stack<Item> stack = new Stack<Item>();
		
		while(!queue.isEmpty()){
			stack.push(queue.dequeue());
		}
		
		while(!stack.isEmpty()){
			queue.enqueue(stack.pop());
		}
		
		return queue;
		
	}
	
	//*********Question 4 (Reference)**********
	// reference class made in package 
	
	
	
	//*********Question 5 (Swam Song)**********
	public static ArrayList<Chord> createRisingChordList(double duration, double[] frequencies, int count){
		ArrayList<Chord> array = new ArrayList<Chord>();
		
		for(int i = 0; i < count; i++){
			Chord newChord = new Chord(duration, frequencies);
			array.add(newChord);
			for(int j = 0; j < frequencies.length; j++){
				frequencies[j] = frequencies[j]*1.224;
			}
		}
		for(Chord chord: array){
			chord.play();
		}
		return array;
		
	}
	
	

	

}
