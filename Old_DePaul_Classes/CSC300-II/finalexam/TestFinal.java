package finalexam;

/*
 * This class is a program class that tests the
 * various methods and classes written for the CSC
 * 300 final exam for Spring, 2017.  It was written
 * by John Rogers.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import stdlib.StdIn;
import stdlib.StdOut;
import algs13.Queue;

public class TestFinal {

	public static <Item extends Comparable<? super Item>> boolean isSorted(Item[] a) {
		for (int i = 0; i < a.length-1; i++) {
			if (a[i].compareTo(a[i+1]) > 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {

		StdOut.println("*** " + Final.yourName() + " ***");
		StdOut.println();

		Integer[] array = new Integer[12];
		Random r = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = r.nextInt(1000);
		}
		StdOut.println("Array before sorting: " + Arrays.toString(array));
		Final.minpqSort(array);
		StdOut.println("Array after sorting:  " + Arrays.toString(array));
		StdOut.println("Array is sorted: " + isSorted(array));
		StdOut.println();

		Queue<String> queue = new Queue<String>();
		queue.enqueue("first");
		queue.enqueue("second");
		queue.enqueue("third");
		queue.enqueue("fourth");
		StdOut.println("Queue before reversing: " + queue);
		Final.reverseQueue(queue);
		StdOut.println("Queue after reversing: " + queue);
		StdOut.println();

		double[] frequencies = {110.0, 110.0*1.224, 110.0*1.224*1.224};
		ArrayList<Chord> risingChords = Final.createRisingChordList(0.2, frequencies, 10);
		for (Chord risingChord: risingChords) {
			StdOut.println("Playing: " + risingChord);
			risingChord.play();
		}
		StdOut.println();

		ArrayList<CTATrain> ctaTrains = new ArrayList<CTATrain>();
		StdIn.fromFile("data/CTAdata.txt");
		while (!StdIn.isEmpty()) {
			int runNumber = StdIn.readInt();
			String lineColor = StdIn.readString();
			String nextStation = StdIn.readString();
			String arrivalTime = StdIn.readString();
			ctaTrains.add(new CTATrain(runNumber, lineColor, nextStation, arrivalTime));
		}
		StdOut.println("--- Trains before sorting ---");
		for (CTATrain ctaTrain: ctaTrains) {
			StdOut.println(ctaTrain);
		}
		StdOut.println();

		ctaTrains.sort(null);
		StdOut.println("--- Trains after sorting by run number ---");
		for (CTATrain ctaTrain: ctaTrains) {
			StdOut.println(ctaTrain);
		}
		StdOut.println();

		ctaTrains.sort((CTATrain t1, CTATrain t2) -> (t1.getArrivalTime().compareTo(t2.getArrivalTime())));
		StdOut.println("--- Trains after sorting by arrival time ---");
		for (CTATrain ctaTrain: ctaTrains) {
			StdOut.println(ctaTrain);
		}
		StdOut.println();

		StdOut.println("=== " + Final.yourName() + " ===");
	}

}
