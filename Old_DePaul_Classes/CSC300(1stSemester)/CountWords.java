package week1examples;

import stdlib.*;

public class CountWords {

	public static void main(String[] args) {
		StdOut.print("Please enter the pathname or URL of the book file: ");
		String textSource = StdIn.readLine();
    	StdIn.fromFile(textSource);
        final String bookText = StdIn.readAll();
        String[] bookWords = bookText.split("\\s+");
        StdOut.println ("There are " + bookWords.length + " words in " + textSource + ".");
    }

}
