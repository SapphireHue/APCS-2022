import java.util.Arrays;
import java.util.Scanner;

public class CollatzRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Starting number: ");
        int start = scan.nextInt();
        Collatz myCollatz = new Collatz(start);
        System.out.println("Starting number " + start + " takes " + myCollatz.steps() + " steps");
        System.out.println(Arrays.toString(myCollatz.sequence()));
        
        System.out.println("Odd values" + Arrays.toString(myCollatz.oddValues()));
        System.out.println("Maximum value: " + myCollatz.maxValue());
        System.out.println("Minimum odd value: " + myCollatz.minOddValue());
        System.out.println("Sum: " + myCollatz.sumValues());
        
        
        myCollatz.printColumns();

    }
}
