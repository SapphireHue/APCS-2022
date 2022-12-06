import java.util.Scanner;

public class Tasteable {
    public static void main(String[] args){
        System.out.print("Enter the shelf life: ");
        int shelfLife = new Scanner(System.in).nextInt();
        int bestTaste = tastesBestBefore(shelfLife);
        System.out.println(shelfLife + " week shelf life tastes best when it is no more than " + bestTaste + " weeks old.");
    }

    public static int tastesBestBefore(int x){
        return (x/2 + 7);
    }
}