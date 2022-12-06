import java.util.Scanner;

public class GallonsWasted {
    final static int DRIPS_PER_GALLON = 15140;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter faucet drips per minute: ");
        double dripsPerMin = scan.nextDouble();
        System.out.print("Enter number of days: ");
        int days = scan.nextInt();
        System.out.println("A faucet with " + dripsPerMin + " drips per minute over " + days + " days will waste " + waste(DRIPS_PER_GALLON, dripsPerMin, days) + " gallons of water");
    }
    
    public static double waste(int dripsPerGal, double dripsPerMin, int days){
        double waste = (dripsPerMin*60*24)*days/dripsPerGal;
        return waste;
    }
}
