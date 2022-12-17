import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Diya {
    public static void main(String[] args) throws FileNotFoundException {
        File diya = new File("diya.dat");
        Scanner scan = new Scanner(diya);
        while (scan.hasNextInt()) {
            int size = scan.nextInt();
            int[][] matrix = new int[size][size];
            // make matrix
            int offset = 0;
            // int xStep = 1;
            // int yStep = 1;
            int x = 1;
            int row = 0;
            int col = 0;
            while (x <= Math.pow(size, 2)) {
                while (col < size - offset) {
                    matrix[row][col] = x;
                    x++;
                    col++;
                }
                col--; // the above breaks when col goes "out of bounds", so we're remedying that; it's scuffed and there's probably a better way but
                row++;
                while (row < size - offset) {
                    matrix[row][col] = x;
                    x++;
                    row++;
                }
                row--;
                col--;
                while (col >= offset) {
                    matrix[row][col] = x;
                    x++;
                    col--;
                }
                col++;
                row--;
                offset++;
                while (row >= offset) {
                    matrix[row][col] = x;
                    x++;
                    row--;
                }
                row++;
                col++;

            }

            // print
            printMatrix(matrix, size);
        }
    }

    public static void printMatrix(int[][] matrix, int size) {
        int padWidth = ("" + (int) Math.pow(size, 2)).length() + 1;
        for (int[] line : matrix) {
            for (int item : line) {
                System.out.printf("%-" + padWidth + "d", item);
            }
            System.out.println();
        }
        System.out.println("=====");
    }
}
