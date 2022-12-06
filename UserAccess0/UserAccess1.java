import java.io.*;
import java.util.*;

public class UserAccess1 {

   // keyboard scanner shared by all methods
   public static final Scanner scanInput = new Scanner(System.in);

   public static void main(String[] args) throws FileNotFoundException, IOException {
      File userFile = new File("users1.dat");
      System.out.print("(l)ogin or (r)egister? ");
      String logOrReg = scanInput.next();
      if ("r".equals(logOrReg)) {
         register(userFile);
      } else if ("l".equals(logOrReg)) {
         while(!login(userFile)){
            System.out.println("Username and/or password do not match. Try again.");
         }
         System.out.println("Welcome!!!");
      }

   }

   public static boolean login(File userFile) throws FileNotFoundException {
      System.out.print("Username? ");
      String user = scanInput.next();
      System.out.print("Password? ");
      String pass = scanInput.next();
      Scanner in = new Scanner(userFile);

      while (in.hasNextLine()) {
         if (user.equals(in.next())) {
            return (pass.equals(in.next()));
         } else {
            in.nextLine();
         }
      }
      return false;
   }

   public static void register(File userFile) throws FileNotFoundException, IOException {
      System.out.print("Username? ");
      String user = scanInput.next();
      while (userExists(user, userFile)/*username taken*/) {
         System.out.println("Username already taken. Please choose a different one.");
         System.out.print("Username? ");
         user = scanInput.next();
      }

      System.out.print("Password? ");
      String pass = scanInput.next();
      System.out.print("Verify Password? ");
      String newPass = scanInput.next();
      while (!pass.equals(newPass)) {
         System.out.println("Passwords do not match.");
         System.out.print("Password? ");
         pass = scanInput.next();
         System.out.print("Verify Password? ");
         newPass = scanInput.next();
      }

      System.out.println("Welcome!!!");

      //given code
      FileWriter fw = new FileWriter(userFile, true); // open file in append mode by passing true
      PrintWriter pw = new PrintWriter(fw); // use PrintWriter to write a line using println
      pw.println(user + " " + pass);
      pw.flush(); // flush output to file
   }

   public static boolean userExists(String user, File userFile) throws FileNotFoundException, IOException {
      Scanner in = new Scanner(userFile);
      while (in.hasNextLine()) {
         if (user.equals(in.next())) {
            return true;
         } else {
            in.nextLine();
         }
      }
      return false;
   }
}