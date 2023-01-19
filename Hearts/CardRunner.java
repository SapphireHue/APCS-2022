import java.util.Arrays;

public class CardRunner {
    public static void main(String[] args) {
        Card card1 = new Card("3", "spades", 3);
        Card card2 = new Card("5", "diamonds", 5);
        System.out.println(card1.compareTo(card2));
        // // System.out.println(card2.compareTo(card1));
        // Card myCard = new Card();
        // System.out.println(myCard.getName());
        // System.out.println(myCard.getSuit());
        // System.out.println(myCard);
        // System.out.println(card1);

        // Card[] deck = { new Card("5", "clubs", 5), new Card("3", "clubs", 3), new Card("5", "diamonds", 5),
        //         new Card("1", "clubs", 1), new Card("6", "hearts", 6), new Card("K", "clubs", 13),
        //         new Card("5", "diamonds", 5) };
        // // Arrays.sort(deck);
        // System.out.println(Arrays.toString(deck));
    }
}
