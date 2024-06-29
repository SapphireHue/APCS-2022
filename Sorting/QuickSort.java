import java.util.ArrayList;
import java.util.Arrays;

public class QuickSort {
  // public static void main(String[] args) {
  //   String[] temp = { "C", "D", "F", "Z", "j", "fsdui", "Jose", "32gj", "c" };
  //   System.out.println(Arrays.toString(sort(temp)));
  // }

  public static String[] sort(String[] array) {
    if (array.length <= 1) {
      return array;
    }

    // break into sublists
    ArrayList<String> arrayList1 = new ArrayList<String>();
    ArrayList<String> arrayList2 = new ArrayList<String>();
    int pivotIndex = array.length/2;
    for (int i = 0; i < array.length; i++) {
      if(i == pivotIndex){
        continue;
      }
      if (array[i].compareTo(array[pivotIndex]) <= 0) {
        arrayList1.add(array[i]);
      } else {
        arrayList2.add(array[i]);
      }
    }

    // sort the new lists
    String[] array1 = sort(arrayList1.toArray(new String[0]));
    String[] array2 = sort(arrayList2.toArray(new String[0]));
    
    // add the new lists together
    String[] newArr = new String[array.length];
    int x = 0;
    for(int i = 0; i < array1.length; i++){
      newArr[x] = array1[i];
      x++;
    }
    newArr[x] = array[pivotIndex];
    x++;
    for (int i = 0; i < array2.length; i++) {
      newArr[x] = array2[i];
      x++;
    }

    return newArr;
  }
}