import java.util.ArrayList;
import java.util.Collections;
public class Deck {
    private ArrayList<Card> deck;
    public static final String[] NAMES = { "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A" };
    public static final String[] SUITS = { "clubs", "spades", "hearts", "diamonds" };
    public static final int[] RANKS = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

    public Deck() {
        initializeDeck();
    }

    public void initializeDeck() {
        deck = new ArrayList<Card>();
        for (String suit : SUITS) {
            for (int rank : RANKS) {
                deck.add(new Card(NAMES[rank - 2], suit, rank));
            }
        }
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> d) {
        deck.clear();
        deck.addAll(d);
    }

    public Card getCard(int index) {
        return deck.get(index);
    }

    public Card dealTopCard() {
        return (deck.remove(0));
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public void shuffle2() {
        int numCards = (int) (Math.random() * 9) + 2;
        int insertAt = (int) (Math.random() * (52 - numCards) + numCards);
        for (int i = 0; i < numCards; i++) {
            deck.add(insertAt, deck.remove(0));
        }
    }

    public String toString() {
        String output = "";
        for (Card card : deck) {
            output += card.toString();
        }
        if (output.length() == 0) {
            output = "No cards in the deck!";
        }
        return output;
    }
}