import java.util.Scanner;

public class HowManyPages{
    
    public static void main(String[] args) {
        System.out.print("Enter your age: ");
        int age = new Scanner(System.in).nextInt();
        int toRead = Pages(age);  
        System.out.println(age + " year olds should read at least " + toRead + " pages.");
    }
    
    public static int Pages(int x){
        return (100-x);
    }
}