import java.util.Scanner;
public class UserInput{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = scan.nextLine();
        System.out.println("Hello " + name + "!");
        System.out.print("What is your age in days? ");
        int age = scan.nextInt();
        int months = age%365; //actually the total number of days that don't go fully into years
        age = (age-months)/365; //number of years
        int days = months%30;
        months = (months-days)/30;
        System.out.println("You are "+age+" years "+months+" months and " + days +" days old.");
        scan.nextLine(); //dummy
        System.out.print("What is your favorite band? ");
        String band1 = scan.nextLine();
        System.out.print("What is your 2nd favorite band? ");
        String band2 = scan.nextLine();
        System.out.println("I like "+band1+" and "+band2+" too!!!");
        System.out.print("How long does it take? ");
        int hours = scan.nextInt();
        scan.next(); scan.next(); //to consume the "hours and"
        int minutes = scan.nextInt(); scan.next(); //to consume the "minutes"
        String place = scan.nextLine();
        System.out.println("It takes " + (minutes + hours*60) + " minutes" + place+".");
    }
}