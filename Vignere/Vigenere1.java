public class Vigenere1 {
   // declare instance variables for text and keyword
   private String plainText;
   private String key;
   final private static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   // default constructor
   public Vigenere1() {

   }

   // initialization constructor
   public Vigenere1(String theMsg, String theKey) {
      plainText = theMsg;
      key = theKey;
   }

   // modifier method for plainText
   public void setPlainText(String text){
      plainText = text;
   }

   // modifier method for key
   public void setKey(String text) {
      key = text;
   }

   // accessor method for plainText
   public String getPlainText(){
      return plainText;
   }

   // accessor method for key
   public String getKey() {
      return key;
   }

   // encrypt method
   //   return a String
   //   no parameters
   public String encrypt() {
      String newMsg = "";
      for (int i = 0; i < plainText.length(); i++){
         newMsg += ALPHABET.charAt((ALPHABET.indexOf(plainText.charAt(i)) + ALPHABET.indexOf(key.charAt(i%key.length())))%26);
      }
      return newMsg;
   }

   // decrypt method
   //   return a String
   //   String parameter 
   public String decrypt(String cipherText){
      String newMsg = "";
      for (int i = 0; i < cipherText.length(); i++) {
         newMsg += ALPHABET.charAt((ALPHABET.indexOf(cipherText.charAt(i)) - ALPHABET.indexOf(key.charAt(i % key.length())) + ALPHABET.length()) % 26);
      }
      return newMsg;
   }

   // equals method
   //   return a boolean
   //   Vigenere reference parameter
   public boolean equals(Object obj){
      Vigenere1 s = (Vigenere1) obj;
      return(plainText.equals(s.getPlainText()) && key.equals(s.getKey()));
   }

   // toString() method
   public String toString() {
      return ("plain Text     = " + plainText + "\nkey            = " + key + "\nencrypted Text = " + encrypt()); // Do NOT modify 
   }

}