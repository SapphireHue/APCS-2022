// Sorry, I changed the names and didn't save the file
import java.util.Arrays;

public class WordSearch80 {
	/** one 2D array private instance variable named wordArray - You CANNOT add any additional instance variables */
	private char[][] wordArray; // this is the array that is the word search NOT an array of words to be found

	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col */
	public WordSearch80(int row, int col) {
		wordArray = new char[row][col];
	}

	/** method to set an element in the 2D array
		* @param s which is the value to store in the 2D array
		* @param row the row to use
		* @param col the column to use*/
	public void setSpot(char s, int row, int col) {
		wordArray[row][col] = s;
	}

	/** methods to check for the word in the 2D array
		* @param the word to search for
		* @return return true or false*/
	public boolean inGrid(String word) {
		// search rows
		for(char[] row : wordArray){
			// build string from row
			String rowString = "";
			for(char s : row){
				rowString+=s;
			}

			// check for word in row
			if(rowString.indexOf(word) >= 0){
				return true;
			}
			
			// build reverse row string
			String rowStringReverse = "";
			for(int i = rowString.length()-1; i >=0 ; i--){
				rowStringReverse+=rowString.charAt(i);
			}
			
			// check for word backwards in row
			if (rowStringReverse.indexOf(word) >= 0) {
				return true;
			}
		}

		// search columns
		for(int i = 0; i < wordArray[0].length; i++){
			String columnString = "";
			for(char[] row : wordArray){
				columnString+=row[i];
			}
			// check for word in column
			if (columnString.indexOf(word) >= 0) {
				return true;
			}

			// build reverse column string
			String columnStringReverse = "";
			for (int j = columnString.length() - 1; j >= 0; j--) {
				columnStringReverse += columnString.charAt(j);
			}

			// check for word backwards in column
			if (columnStringReverse.indexOf(word) >= 0) {
				return true;
			}
		}

		
		

		return false;
	}

	/** toString method
		* @return String containing all elements in the 2D array*/
	public String toString() {
		String str = "[";
		for(char[] row : wordArray){
			str+="[";
			for(char s : row){
				str+= " " + s;
			}
			str+=" ]\n ";
		}
		str = str.substring(0, str.length()-2) + "]";
		return str;
	}
}