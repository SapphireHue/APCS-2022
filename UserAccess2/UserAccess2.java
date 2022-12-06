import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAccess2 {

  // keyboard scanner shared by all methods
  public static final Scanner scanInput = new Scanner(System.in);

  public static void main(String[] args) throws FileNotFoundException, IOException, NoSuchAlgorithmException {

    File userFile = new File("users2.dat");
    System.out.print("(l)ogin or (r)egister? ");
    String logOrReg = scanInput.next();
    while (!logOrReg.equals("l") && !logOrReg.equals("r")){
      System.out.println("Please enter either 'l' or 'r'");
      System.out.print("(l)ogin or (r)egister? ");
      logOrReg = scanInput.next();
    }
    if ("r".equals(logOrReg)) {
      register(userFile);
    } else if ("l".equals(logOrReg)) {
      while (!login(userFile)) {
        System.out.println("Username and/or password do not match. Try again.");
      }
      System.out.println("Welcome!!!");
    }
  }

  public static boolean login(File userFile) throws FileNotFoundException, NoSuchAlgorithmException {
    System.out.print("Username? ");
    String user = scanInput.next();
    System.out.print("Password? ");
    String pass = scanInput.next();
    Scanner in = new Scanner(userFile);

    while (in.hasNextLine()) {
      if (user.equals(in.next())) {
        String sha = in.next();
        String salt = in.next();
        return (toHexString(getSHA(pass+salt)).equals(sha));
      } else {
        in.nextLine();
      }
    }
    return false;
  }

  public static void register(File userFile) throws FileNotFoundException, IOException, NoSuchAlgorithmException {
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
    String salt = makeSalt();
    pw.println(user + " " + toHexString(getSHA(pass+salt)) + " " + salt);
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

  public static String makeSalt() {
    char[] ALPHANUMERIC = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    String str = "";
    for (int i = 0; i < 25; i++){
      str += ALPHANUMERIC[(int) (Math.random()*ALPHANUMERIC.length)];
    }
    return str;
  }

  // getSHA() and toHexString() from https://www.geeksforgeeks.org/sha-256-hash-in-java/
  public static byte[] getSHA(String input) throws NoSuchAlgorithmException {
    // Static getInstance method is called with hashing SHA
    MessageDigest md = MessageDigest.getInstance("SHA-256");

    // digest() method called
    // to calculate message digest of an input
    // and return array of byte
    return md.digest(input.getBytes(StandardCharsets.UTF_8));
  }

  public static String toHexString(byte[] hash) {
    // Convert byte array into signum representation
    BigInteger number = new BigInteger(1, hash);

    // Convert message digest into hex value
    StringBuilder hexString = new StringBuilder(number.toString(16));

    // Pad with leading zeros
    while (hexString.length() < 64) {
      hexString.insert(0, '0');
    }

    return hexString.toString();
  }

}