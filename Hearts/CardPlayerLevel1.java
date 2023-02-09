import java.util.ArrayList;
import java.util.Collections;

public class CardPlayerLevel1 extends CardPlayer {
    public CardPlayerLevel1(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRound) {
        if (round.size() != 0) {
            String targetSuit = round.get(0).getSuit();

            // look for cards of the right suit, the queen of spades, and hearts
            ArrayList<Card> temp = new ArrayList<Card>();
            ArrayList<Card> tempHearts = new ArrayList<Card>();
            Card Qs = new Card("Q", "spades", 12);
            boolean hasQueen = false;
            for (Card card : super.getHand()) {
                if (targetSuit.equals(card.getSuit())) {
                    temp.add(card);
                }
                if (card.equals(Qs)) {
                    hasQueen = true;
                }
                if ("hearts".equals(card.getSuit())) {
                    tempHearts.add(card);
                }
            }

            // check for cards of matching suit; same as in super
            if (temp.size() > 0) {
                Card toPlay = temp.get((int) (Math.random() * temp.size()));
                return playCard(super.getHand().indexOf(toPlay));
            }

            if(hasQueen){
                return playCard(super.getHand().indexOf(Qs));
            }

            // check for hearts
            if (tempHearts.size() > 0) {
                Collections.sort(tempHearts);
                Card toPlay = tempHearts.get(tempHearts.size() - 1);
                return playCard(super.getHand().indexOf(toPlay));
            }

            // if there are neither hearts nor a card of the same suit
            return playCard((int) (Math.random() * super.getHand().size()));

        }
        return super.chooseCard(round, previousRound);
    }
}
