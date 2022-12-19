import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

public class Candela {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("candela.dat");
        Scanner fileScan = new Scanner(inputFile);
        int numQuestions = fileScan.nextInt();
        int[][] questions = new int[numQuestions][3]; // [question #, points, difficulty]
        int[][] orderedQuestions = new int[numQuestions][2];
        for (int i = 0; i < numQuestions; i++) {
            questions[i][0] = i + 1;
            orderedQuestions[i][0] = questions[i][1] = fileScan.nextInt();
            orderedQuestions[i][1] = questions[i][2] = fileScan.nextInt();
        }

        // sort the array; prioritize ratio of points/difficulty, ties broken with greater point value
        Arrays.sort(questions, new Comparator<int[]>() { // points
            public int compare(int[] a, int[] b) {
                return Double.compare(b[1], a[1]); // b and then a bc greatest points should come first in list
            }
        });
        Arrays.sort(questions, new Comparator<int[]>() { // ratio
            public int compare(int[] a, int[] b) {
                return Double.compare(b[1] / (double) b[2], a[1] / (double) a[2]); // b and then a bc greatest ratio should come first in list
            }
        });

        while (fileScan.hasNextInt()) {
            int targetDiff = fileScan.nextInt();
            String[] testInfo = calculateDifficulty(targetDiff, questions);

            String[] temp = testInfo[0].split(" ");
            int[] questionNumbers = new int[temp.length];
            for (int i = 0; i < temp.length; i++) {
                questionNumbers[i] = Integer.parseInt(temp[i]);
            }

            printOutput(questionNumbers, Integer.parseInt(testInfo[1]), Integer.parseInt(testInfo[2]), targetDiff,
                    orderedQuestions);
            System.out.println("=====");
        }
    }

    // should these be methods? probably not, since I keep having to pass in questions 
    public static String[] calculateDifficulty(int target, int[][] questions) {
        String questionsToDo = "";
        int difficulty = 0;
        int points = 0;
        for (int[] question : questions) {
            if (difficulty + question[2] <= target) {
                questionsToDo += question[0] + " ";
                points += question[1];
                difficulty += question[2];
            }
        }
        String[] output = { questionsToDo, Integer.toString(difficulty), Integer.toString(points) };
        return output;
    }

    public static void printOutput(int[] questionNumbers, int difficulty, int points, int target, int questions[][]) {
        System.out.println("Target diff     = " + target);
        System.out.println("Calculated diff = " + difficulty);
        System.out.println("Expected points = " + points);
        Arrays.sort(questionNumbers);
        for (int num : questionNumbers) {
            System.out.printf("Q#%2d, %2d pts, diff%2d%n", num, questions[num-1][0], questions[num - 1][1]);
        }
    }
}