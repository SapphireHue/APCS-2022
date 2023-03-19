// Stopped trying to find a way to optimize and resorted to brute force!
// Praying it doesn't crash anything!
// Sean (Clarke) was talking about a trick they learned in AMR for getting every possible subset of a set and something pinged in the back of my brain

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Candela {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("candela.dat");
        Scanner fileScan = new Scanner(inputFile);
        int numQuestions = fileScan.nextInt();
        int[][] orderedQuestions = new int[numQuestions][2]; // [points, difficulty]
        for (int i = 0; i < numQuestions; i++) {
            orderedQuestions[i][0] = fileScan.nextInt();
            orderedQuestions[i][1] = fileScan.nextInt();
        }

        // find all combinations
        int numCombinations = (int) Math.pow(2, numQuestions);
        Object[][] combinations = new Object[numCombinations - 1][3]; // [combinationString, points, difficulty]
        for (int i = 1; i < numCombinations; i++) { // for each possible combination
            String combinationString = Integer.toBinaryString(i);
            combinationString = String.format("%" + numQuestions + "s", combinationString).replace(" ", "0");
            int points = 0;
            int difficulty = 0;
            for (int questionNum = 0; questionNum < combinationString.length(); questionNum++) { // for each question
                if (combinationString.charAt(questionNum) == '1') {
                    points += orderedQuestions[questionNum][0];
                    difficulty += orderedQuestions[questionNum][1];
                }
            }
            combinations[i - 1][0] = combinationString;
            combinations[i - 1][1] = points;
            combinations[i - 1][2] = difficulty;
        }

        // sort every possible combination by ascending difficulty
        Arrays.sort(combinations, new Comparator<Object[]>() {
            public int compare(Object[] a, Object[] b) {
                return Double.compare((int) a[2], (int) b[2]);
            }
        });

        while (fileScan.hasNextInt()) {
            int targetDiff = fileScan.nextInt();
            int combinationNum = 0; // position in list combinations
            // int maxPoints = 0;
            int bestCombinationNum = 0;
            while (combinationNum < combinations.length && (int) combinations[combinationNum][2] <= targetDiff) {
                if ((int) combinations[combinationNum][1] > (int) combinations[bestCombinationNum][1]) {
                    bestCombinationNum = combinationNum;
                }
                combinationNum++;
            }
            printOutput(targetDiff, (int) combinations[bestCombinationNum][2],
                    (int) combinations[bestCombinationNum][1],
                    combinations[bestCombinationNum][0].toString(), orderedQuestions);
            System.out.println("=====");
        }
    }

    public static void printOutput(int target, int difficulty, int points, String combinationString,
            int[][] questions) {
        System.out.println("Target diff     = " + target);
        System.out.println("Calculated diff = " + difficulty);
        System.out.println("Expected points = " + points);
        for (int num = 0; num < combinationString.length(); num++) { // for each question
            if (combinationString.charAt(num) == '1') {
                System.out.printf("Q#%2d, %2d pts, diff%2d%n", num+1, questions[num][0], questions[num][1]);
            }
        }

    }

    public static void print2d(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}