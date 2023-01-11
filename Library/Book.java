public class Book {

   private String title;
   private String author;
   private int rating;

   public Book(String t, String a, int r) {
      title = t;
      author = a;
      setRating(r);
   }

   public String getTitle() {
      return title;
   }

   public void setTitle(String t) {
      title = t;
   }

   public String getAuthor() {
      return author;
   }

   public void setAuthor(String a) {
      author = a;
   }

   public int getRating() {
      return rating;
   }

   /**
    * Set a book's rating. We only accept rating values between 0 and 10.
    * @param newRating is the new rating value
    * if the newRating is larger than 10, set the rating to 10.
    * if the newRating is less than 0, set the rating to 0.
    */
   public void setRating(int newRating) {
      if (newRating < 0) {
         rating = 0;
      } 
      else if (newRating > 10) {
         rating = 10;
      } 
      else {
         rating = newRating;
      }
   }

   // Two books are equal if they have the same title and the same author
   // If the book being compared to this book has a null reference return false
   public boolean equals(Object obj) {
      if(obj==null){
         return false;
      }
      Book book2 = (Book) obj;
      return (book2.getTitle().equals(title) && book2.getAuthor().equals(author));
   }

   // determine if the title contains the string in the parameter target
   // independent of the case of the letters in target - e.g. "HITCHHIKER" containts "hitch" 
   public boolean titleContains(String target) {
      return (title.toLowerCase().indexOf(target.toLowerCase()) >= 0);
   }

   // determine if the author contains the string in the parameter target
   // independent of the case of the letters in target - e.g. "King" contains "king"
   public boolean authorContains(String target) {
      return (author.toLowerCase().indexOf(target.toLowerCase()) >= 0);
   }

   public String toString() {
      return "\"" + title + "\" by " + author + " (" + rating + ")";
   }
}