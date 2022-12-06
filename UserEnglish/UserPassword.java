import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserPassword {
    public static void main(String[] args) throws NoSuchAlgorithmException{
        final String HASH = "00e4b94812a0e72c20369d7feb44e02e0d258a291aca3c588c125478d8390803";
        final String SALT  = "z\"*)+r@:S@Ha]Ty0\\/{t@f*m2";
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] num = "0123456789".toCharArray();
        for(char i1 : alpha){
            System.out.println(i1);
            for(char i2:alpha){
                for(char i3:alpha){
                    for(char x1:num){
                        for(char x2:num){
                            for(char x3 :num){
                                String pass = "" + i1 + i2 + i3 + x1 + x2 + x3;
                                if(toHexString(getSHA(pass+SALT)).equals(HASH)){
                                    System.out.println("Password found " + pass);
                                }
                            }
                        }
                    }
                }
            }
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

/*
(26^3)(10^3) permutations = 1 minute -> 17576000 attempts/min

Password of 6 characters, each is either an upper or lowercase letter (52), a digit (10), or a symbol (14):
(52+10+14)^6 permutations -> (52+10+14)^6 / 17576000 = 10963.8 min = 182.7 hrs = 7.6 days

Password of 8 characters:
(52+10+14)^8 permutations -> ((52+10+14)^8 / 17576000)/(60*24*365) = 120.5 years
*/