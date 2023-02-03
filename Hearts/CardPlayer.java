import java.util.ArrayList;
import java.util.Collections;

public class CardPlayer extends Player {
    private ArrayList<Card> hand, takenCards;

    public CardPlayer(String name, int score, ArrayList<Card> hand) {
        super(name, score);
        this.hand = new ArrayList<Card>();
        for (Card card : hand) {
            this.hand.add(card);
        }
        takenCards = new ArrayList<Card>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand.clear();
        for (Card card : hand) {
            this.hand.add(card);
        }
    }

    public ArrayList<Card> getTakenCards() {
        return takenCards;
    }

    public void setTakenCards(ArrayList<Card> takenCards) {
        for (Card card : takenCards) {
            this.takenCards.add(card);
        }
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return (hand.remove(index));
    }

    public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRound) {
        Card twoClub = new Card("2", "clubs", 2);
        if (hand.contains(twoClub)) {
            return playCard(hand.indexOf(twoClub));
        }

        if (round.size() == 0) {
            return playCard((int) (Math.random() * hand.size()));
        }

        // look for hearts and matching suits
        String targetSuit = round.get(0).getSuit();
        ArrayList<Card> temp = new ArrayList<Card>();
        ArrayList<Card> tempHearts = new ArrayList<Card>();
        for (Card card : hand) {
            if (targetSuit.equals(card.getSuit())) {
                temp.add(card);
            }
            if ("hearts".equals(card.getSuit())) {
                tempHearts.add(card);
            }
        }

        // check for cards of matching suit
        if (temp.size() > 0) {
            Card toPlay = temp.get((int) (Math.random() * temp.size()));
            return playCard(hand.indexOf(toPlay));
        }

        // check for hearts
        if (tempHearts.size() > 0) {
            Card toPlay = tempHearts.get((int) (Math.random() * tempHearts.size()));
            return playCard(hand.indexOf(toPlay));
        }

        // if there are neither hearts nor a card of the same suit
        return playCard((int) (Math.random() * hand.size()));
    }

    public String toString() {
        Collections.sort(this.hand);
        return super.getName() + " (" + super.getScore() + ") " + hand.toString();
    }
}