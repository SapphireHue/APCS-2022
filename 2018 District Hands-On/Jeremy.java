import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Jeremy {
    public static void main(String[] args) throws FileNotFoundException {
        File jeremy = new File("jeremy.dat");
        Scanner scan = new Scanner(jeremy);
        int numMatrixes = scan.nextInt();
        for (int matrixNumber = 0; matrixNumber < numMatrixes; matrixNumber++) {
            int[][] matrix = new int[scan.nextInt()][scan.nextInt()];
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[row][col] = scan.nextInt();
                }
            }

            fillSquare(matrix, scan.nextInt(), scan.nextInt(), scan.nextInt());
            printMatrix(matrix);
            System.out.println("=====");
        }

    }

    public static void fillSquare(int[][] matrix, int row, int column, int color) {
        int originalColor = matrix[row][column];
        matrix[row][column] = color;
        //printMatrix(matrix);
        if (row > 0 && matrix[row - 1][column] == originalColor) {
            fillSquare(matrix, row - 1, column, color);
        }
        if (row + 1 < matrix.length && matrix[row + 1][column] == originalColor) {
            fillSquare(matrix, row + 1, column, color);
        }

        if (column > 0 && matrix[row][column - 1] == originalColor) {
            fillSquare(matrix, row, column - 1, color);
        }
        if (column + 1 < matrix[0].length && matrix[row][column + 1] == originalColor) {
            fillSquare(matrix, row, column + 1, color);
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int item : row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
