package week1examples;

import stdlib.*;

public class CountWordsTwoTales {

	public static void main(String[] args) {
    	String textSource = "data/twotales.txt";
    	StdIn.fromFile(textSource);
        final String bookText = StdIn.readAll();
        String[] bookWords = bookText.split("\\s+");
        StdOut.println ("There are " + bookWords.length + " words in " + textSource + ".");
    }

}
