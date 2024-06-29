import java.io.*;
import java.util.*;

public class MergeSort {
    public static void main(String[] args){
        String[] temp = {"C", "D", "F", "Z", "j", "fsdui", "Jose", "32gj", "c"};
        System.out.println(Arrays.toString(sort(temp)));
    }
    /**
     * Sorts the given array in ascending order.
     * DO NOT MODIFY THIS METHOD SIGNATURE.
     *
     * @param array The array to be sorted.
     * @return The sorted array.
     */
    public static String[] sort(String[] array) {
        if (array.length == 1) {
            return array;
        }
        String[] array1 = Arrays.copyOfRange(array, 0, array.length / 2);
        String[] array2 = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(sort(array1), sort(array2));
    }

    public static String[] merge(String[] array1, String[] array2) {
        int pointer1 = 0;
        int pointer2 = 0;
        String[] newArr = new String[array1.length + array2.length];
        for (int i = 0; i < newArr.length; i++) {
            if (pointer1 >= array1.length) {
                newArr[i] = array2[pointer2];
                pointer2++;
            } else if (pointer2 >= array2.length) {
                newArr[i] = array1[pointer1];
                pointer1++;
            } else {
                if (array1[pointer1].compareTo(array2[pointer2]) <= 0) {
                    newArr[i] = array1[pointer1];
                    pointer1++;
                } else {
                    newArr[i] = array2[pointer2];
                    pointer2++;
                }
            }
        }
        return newArr;
    }

}