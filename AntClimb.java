
import java.util.Scanner;

public class AntClimb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Upward progress: ");
        int upward = scan.nextInt();
        System.out.print("Downward slide: ");
        int downward = scan.nextInt();
        System.out.print("Depth of hole: ");
        int depthOfHole = scan.nextInt();
        System.out.println("Distance: " + climb(upward, downward, depthOfHole));
    }

    public static int climb(int x, int y, int m){
        if(m<=x){
            return m;
        }
        return x+y+climb(x, y, m-x+y);
    }
}
