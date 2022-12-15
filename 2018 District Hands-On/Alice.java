import java.util.Scanner;

public class Alice {
    public static void main(String[] args) {
        String sail = "&\n&&\n&&&\n&&-&\n&&--&\n&&---&\n&&----&\n&&--.--&\n&&--..--&\n&&--...--&\n&&--....--&\n&&--.....--&\n&&--......--&\n&&--.......--&\n&&--........--&\n&&--.........--&\n&&--..........--&\n&&--...........--&\n&&--............--&\n&&--.............--&";
        Scanner sailScanner = new Scanner(sail);
        while (sailScanner.hasNextLine()){
            System.out.println(spaces(11) + sailScanner.nextLine());
        }
        System.out.println(spaces(12) + "||" + spaces(19) + "\\o/");
        System.out.println(spaces(12) + "||" + spaces(20) + "|");
        System.out.println(" " + "======================================");
        System.out.println(spaces(3) + "==================================");
        System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
    }

    public static String spaces(int times){
        String output = "";
        for(int i = 0; i < times; i++){
            output+=" ";
        }
        return output;
    }
}
