import java.util.Scanner;

public class BeanCount{
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter jelly bean length (cm): ");
        double length = scan.nextDouble();
        System.out.print("Enter jelly bean height (cm): ");
        double height = scan.nextDouble();
        System.out.print("Enter jar size (mL): ");
        int size = scan.nextInt();
        int estimate = estimate(length, height, size);
        System.out.println("Estimate for number of jelly beans with average\nlength: " + length + " cm\nheight: " + height + " cm\nin a jar of size " + size + " mL is " + estimate);

    }

    public static int estimate(double length, double height, double size){
        double beanVolume = (5*Math.PI*length*(Math.pow(height, 2)/24));
        return (int) (size*0.698/beanVolume);
    }
}