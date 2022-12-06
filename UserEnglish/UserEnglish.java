import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserEnglish {
    public static void main(String[] args) throws FileNotFoundException, NoSuchAlgorithmException{
        File usersToHack = new File("usersToHack.dat");
        Scanner userScan = new Scanner(usersToHack);
        File commonWords = new File("words.dat");

        while(userScan.hasNextLine()){
            String username = userScan.next();
            String sha = userScan.next();
            String salt = userScan.next();
            Scanner wordScan = new Scanner(commonWords);
            while(wordScan.hasNextLine()){
                String word = wordScan.nextLine();
                if(toHexString(getSHA(word+salt)).equals(sha)){
                    System.out.println("user = " + username + " password = '" + word + "'");
                }
            }
            userScan.nextLine();
        }
    }

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