import java.util.Scanner;
import java.io.*;
import java.util.Arrays;

public class WordSearchRunner {
	public static void main(String[] args) throws FileNotFoundException {
		// instantiate Scanner object to read in from file
		Scanner in = new Scanner(new File("grid.txt")); // read in grid.txt

		// read in rows
		int rows = in.nextInt();
		// read in columns
		int columns = in.nextInt();

		// instantiate WordSearch object passing in number of rows & columns for 2D array
		WordSearch wordsearch = new WordSearch(rows, columns);

		// loop through the rows in the file
		for (int i = 0; i < rows; i++) {
			// loop through the columns in the file
			for (int j = 0; j < columns; j++) {
				// read in value from file using local variable
				char s = in.next().charAt(0);
				// pass row, column, and value into the 2D array
				wordsearch.setSpot(s, i, j);
			}
		}
		// System.out.println(wordsearch);
		// read number of words to search for from file
		int numWords = in.nextInt();

		// loops through the words
		for (int i = 0; i < numWords; i++) {
			// read in word from file
			String word = in.next();
			// method call to search for the word in the 2D array
			// print out word to search for and true/false
			System.out.println(word + " -> " + wordsearch.inGrid(word));
		
		}

		

	}
}