import java.io.InputStream;
import java.util.*;

public class InOrderRunner
{
    // main(): program starting point
    public static void main( String[] args ) 
    {
        Scanner scan = new Scanner(System.in);
        
        
        // prompt the user for input
        System.out.print( "Enter x, y, and z: " );
        
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        
        // create an InOrder object by calling the initialization constructor
        InOrder thing = new InOrder(x, y, z);
        
        // print the 3 numbers that were entered and then the boolean returned by the areTheyInOrder() method
        System.out.println("" + thing.getNumOne() + " <= " + thing.getNumTwo() + " <= " + thing.getNumThree() +" is " + thing.areTheyInOrder());
        
        // print out "The original order is" and then the inOrder object
        System.out.println("The original order is " + thing);

        // call the method that puts the data (i.e. numbers) of your object in order.
        thing.sortThem();

        // print out "The sorted order is" and then the inOrder object
        System.out.println("The sorted order is " + thing);

        // print out "The middle number is" and then the middle number  
        System.out.print("The middle number is " + thing.getNumTwo());
    }       
    
  }