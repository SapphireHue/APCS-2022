import java.util.Arrays;

public class WordSearch {
	/** one 2D array private instance variable named wordArray - You CANNOT add any additional instance variables */
	private char[][] wordArray; // this is the array that is the word search NOT an array of words to be found

	/** constructor used to set the number of rows and columns in the 2D array
		* @param row
		* @param col */
	public WordSearch(int row, int col) {
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
		for (char[] row : wordArray) {
			// build string from row
			String rowString = "";
			for (char s : row) {
				rowString += s;
			}

			// check for word in row
			if (rowString.indexOf(word) >= 0 || reverseString(rowString).indexOf(word) >= 0) {
				return true;
			}
		}

		// search columns
		for (int i = 0; i < wordArray[0].length; i++) {
			String columnString = "";
			for (char[] row : wordArray) {
				columnString += row[i];
			}
			// check for word in column
			if (columnString.indexOf(word) >= 0 || reverseString(columnString).indexOf(word) >= 0) {
				return true;
			}
		}

		// search diagonals
		int width = wordArray[0].length;
		int height = wordArray.length;

		// if taller than wide or square:
		if (height >= width) {
			for (int startY = 0; startY < height; startY++) {
				// starting left and going down
				int x = 0;
				String diagonal = "";
				for (int y = startY; y < height && x < width; y++) {
					diagonal += wordArray[y][x];
					x++;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting left and going up
				x = 0;
				diagonal = "";
				for (int y = startY; y >= 0 && x < width; y--) {
					diagonal += wordArray[y][x];
					x++;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting right and going down
				x = width-1;
				diagonal = "";
				for (int y = startY; y < height && x >= 0; y++) {
					diagonal += wordArray[y][x];
					x--;
				}
				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting right and going up
				x = width-1;
				diagonal = "";
				for (int y = startY; y >= 0 && x >= 0; y--) {
					diagonal += wordArray[y][x];
					x--;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}
			}
		} 
		// if wider than tall
		else {
			for (int startX = 0; startX < width; startX++) {
				// starting up and going right
				int y = 0;
				String diagonal = "";
				for (int x = startX; x < width && y < height; x++) {
					diagonal += wordArray[y][x];
					y++;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting up and going left
				y = 0;
				diagonal = "";
				for (int x = startX; x >= 0 && y < height; x--) {
					diagonal += wordArray[y][x];
					y++;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting down and going right
				y = height-1;
				diagonal = "";
				for (int x = startX; x < width && y >= 0; x++) {
					diagonal += wordArray[y][x];
					y--;
				}
				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}

				// starting down and going left
				y = height-1;
				diagonal = "";
				for (int x = startX; x >= 0 && y >= 0; x--) {
					diagonal += wordArray[y][x];
					y--;
				}

				if (diagonal.indexOf(word) >= 0 || reverseString(diagonal).indexOf(word) >= 0) {
					return true;
				}
			}
		}

		return false;
	}

	/** toString method
		* @return String containing all elements in the 2D array*/
	public String toString() {
		String str = "[";
		for (char[] row : wordArray) {
			str += "[";
			for (char s : row) {
				str += " " + s;
			}
			str += " ]\n ";
		}
		str = str.substring(0, str.length() - 2) + "]";
		return str;
	}

	private String reverseString(String str) {
		String str2 = "";
		for (int i = str.length() - 1; i >= 0; i--) {
			str2 += str.charAt(i);
		}
		return str2;
	}
}