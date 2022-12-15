import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Carla {
    public static void main(String[] args) throws FileNotFoundException {
        File carla = new File("carla.dat");
        Scanner scan = new Scanner(carla);
        String[] rwx = {"---", "--x", "-w-", "-wx", "r--", "r-x", "rw-", "rwx"};
        while (scan.hasNextLine()){
            String line = scan.nextLine();
            String output = "";
            String type;
            if (line.charAt(0)=='F'){
                output+="-";
            }
            else{
                output+=line.toLowerCase().charAt(0);
            }

            for(int i = 1; i < 4; i++){
                output+=(rwx[Integer.parseInt(line.substring(i, i+1))]);
            }

            System.out.println(output);
        }
    }
}
