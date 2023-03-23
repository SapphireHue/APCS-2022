import java.util.ArrayList;
import java.util.Arrays;

public class DIYSorting {
    public static void main(String args[]) {
        System.out.println("TESTING bubbleSort() with 4 different sets of random number from 1-20");
        {
            int[] intArray = createArray(10);
            System.out.println(
                    "bubble sort (array) " + Arrays.toString(intArray) + " " + bubbleSort(intArray, true) + " bubbles");
            System.out.println("sorted (asc=true) " + Arrays.toString(intArray));
            intArray = createArray(10);
            System.out.println(
                    "bubble sort (array) " + Arrays.toString(intArray) + " " + bubbleSort(intArray, false)
                            + " bubbles");
            System.out.println("sorted (asc=false) " + Arrays.toString(intArray));

            ArrayList<Integer> intArrayList = createArrayList(10);
            System.out
                    .println("bubble sort (ArrayList) " + intArrayList + " " + bubbleSort(intArrayList, true)
                            + " bubbles");
            System.out.println("sorted (asc=true) " + intArrayList);
            intArrayList = createArrayList(10);
            System.out
                    .println(
                            "bubble sort (ArrayList) " + intArrayList + " " + bubbleSort(intArrayList, false)
                                    + " bubbles");
            System.out.println("sorted (asc=false) " + intArrayList);
            System.out.println();
        }

        {
            System.out.println("TESTING selectionSort() with 4 different sets of random number from 1-20");
            int[] intArray = createArray(10);
            System.out
                    .println("selection sort (array) " + Arrays.toString(intArray) + " " + selectionSort(intArray, true)
                            + " moves");
            System.out.println("sorted (asc=true) " + Arrays.toString(intArray));
            intArray = createArray(10);
            System.out
                    .println(
                            "selection sort (array) " + Arrays.toString(intArray) + " " + selectionSort(intArray, false)
                                    + " moves");
            System.out.println("sorted (asc=false) " + Arrays.toString(intArray));

            ArrayList<Integer> intArrayList = createArrayList(10);
            System.out
                    .println("selection sort (ArrayList) " + intArrayList + " " + selectionSort(intArrayList, true)
                            + " moves");
            System.out.println("sorted (asc=true) " + intArrayList);
            intArrayList = createArrayList(10);
            System.out
                    .println(
                            "selection sort (ArrayList) " + intArrayList + " " + selectionSort(intArrayList, false)
                                    + " moves");
            System.out.println("sorted (asc=false) " + intArrayList);
            System.out.println();
        }

        {
            System.out.println("TESTING bubbleSelectionSort()");
            int[] intArray = { 7, 13, 1, 17, 20, 8, 12, 19, 2, 10 };
            System.out
                    .println("Testing bubbleSelectionSort on this specific array [7, 13, 1, 17, 20, 8, 12, 19, 2, 10]");
            int[] temp = bubbleSelectionSort(intArray, true);
            System.out.println("bubbleSelection sort [7, 13, 1, 17, 20, 8, 12, 19, 2, 10] " + temp[0] + " bubbles & "
                    + temp[1] + " moves");
            System.out.println("sorted " + Arrays.toString(intArray));
            System.out.println();
        }

        for (int i = 1; i <= 3; i++) {
            System.out.println("Test " + i + " with 10 random numbers from 1 - 20");
            int[] intArray = createArray(10);
            int[] tempArr = Arrays.copyOf(intArray, intArray.length);
            System.out.println(
                    "bubble sort " + Arrays.toString(tempArr) + " " + bubbleSort(tempArr, true) + " bubbles");
            tempArr = Arrays.copyOf(intArray, intArray.length);
            System.out.println(
                    "selection sort " + Arrays.toString(tempArr) + " " + selectionSort(tempArr, true) + " moves");
            tempArr = Arrays.copyOf(intArray, intArray.length);
            int[] temp = bubbleSelectionSort(tempArr, true);
            System.out.println("bubbleSelection sort " + Arrays.toString(intArray) + " " + temp[0] + " bubbles & "
                    + temp[1] + " moves");   
            System.out.println("sorted " + Arrays.toString(tempArr));
            System.out.println();
        }
    }

    public static int[] createArray(int length) {
        int[] intArray = new int[length];
        for (int i = 0; i < length; i++) {
            intArray[i] = (int) (Math.random() * 20) + 1;
        }
        return intArray;
    }

    public static ArrayList<Integer> createArrayList(int length) {
        ArrayList<Integer> intArrayList = new ArrayList<Integer>();
        for (int i = 0; i < length; i++) {
            intArrayList.add((int) (Math.random() * 20) + 1);
        }
        return intArrayList;
    }

    public static void swap(int[] array, int i1, int i2) {
        int temp = array[i1];
        array[i1] = array[i2];
        array[i2] = temp;
    }

    public static void swap(ArrayList<Integer> list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    public static int bubbleSort(int[] array, boolean ascending) {
        int numSwaps = 0;
        for (int x = 0; x < array.length; x++) { // each pass
            boolean swapped = false;
            for (int i = 0; i < array.length - 1 - x; i++) { // each pair
                // if(!(ascending ^ array[i] < array[i+1]))
                if (ascending ? array[i] > array[i + 1] : array[i + 1] > array[i]) {
                    swapped = true;
                    swap(array, i, i + 1);
                    numSwaps++;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return numSwaps;
    }

    public static int bubbleSort(ArrayList<Integer> list, boolean ascending) {
        int numSwaps = 0;
        for (int x = 0; x < list.size(); x++) { // each pass
            boolean swapped = false;
            for (int i = 0; i < list.size() - 1 - x; i++) { // each pair
                // if(!(ascending ^ array[i] < array[i+1]))
                if (ascending ? list.get(i) > list.get(i + 1) : list.get(i + 1) > list.get(i)) {
                    swapped = true;
                    swap(list, i, i + 1);
                    numSwaps++;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return numSwaps;
    }

    public static int selectionSort(int[] array, boolean ascending) {
        int numSwaps = 0;
        for (int x = 0; x < array.length; x++) { // each pass; x represents start of unsorted section
            int extremeIndex = x;
            int extremeValue = array[x];
            for (int i = x; i < array.length; i++) { // each value in unsorted section
                if (ascending ? array[i] < extremeValue : array[i] > extremeValue) {
                    extremeIndex = i;
                    extremeValue = array[i];
                }
            }
            if (x != extremeIndex) {
                swap(array, x, extremeIndex);
                numSwaps++;
            }
        }
        return numSwaps;
    }

    public static int selectionSort(ArrayList<Integer> list, boolean ascending) {
        int numSwaps = 0;
        for (int x = 0; x < list.size(); x++) { // each pass; x represents start of unsorted section
            int extremeIndex = x;
            int extremeValue = list.get(x);
            for (int i = x; i < list.size(); i++) { // each value in unsorted section
                if (ascending ? list.get(i) < extremeValue : list.get(i) > extremeValue) {
                    extremeIndex = i;
                    extremeValue = list.get(i);
                }
            }
            if (x != extremeIndex) {
                swap(list, x, extremeIndex);
                numSwaps++;
            }
        }
        return numSwaps;
    }

    public static int[] bubbleSelectionSort(int[] array, boolean ascending) {
        int numSwaps = 0;
        int numMoves = 0;
        for (int x = 0; x < array.length; x++) { // each pass
            int extremeIndex = x;
            boolean swapped = false;
            for (int i = x; i < array.length - 1 - x; i++) { // each pair
                // after swapping the ith element will be the smaller of the two -> when checking it for it will be fine
                if (ascending ? array[i] > array[i + 1] : array[i + 1] > array[i]) {
                    swapped = true;
                    swap(array, i, i + 1);
                    numSwaps++;
                }
                if (ascending ? array[i] < array[extremeIndex] : array[i] > array[extremeIndex]) {
                    extremeIndex = i;
                }
            }
            if (!swapped) {
                break;
            }
            if (x != extremeIndex) {
                swap(array, x, extremeIndex);
                numMoves++;
            }
        }
        int[] temp = { numSwaps, numMoves };
        return temp;
    }
}