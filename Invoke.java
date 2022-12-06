public class Invoke{

    public static int piggyBank(int pennies, int nickels, int dimes, int quarters, int halfDollars){
        return (pennies + 5*nickels + 10*dimes + 25*quarters + 50*halfDollars);
    }

    public static int mp3Sizer(int songs, int videos, int photos){
        return (int) Math.ceil((3.04*songs + 89.3*videos + 1.72*photos)/1000);
    }
    
}