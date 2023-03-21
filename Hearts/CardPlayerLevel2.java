import java.util.ArrayList;
import java.util.Collections;

public class CardPlayerLevel2 extends CardPlayer {
    private static final Card Qs = new Card("Q", "spades", 12);
    private static final Card C2 = new Card("2", "clubs", 2);

    public CardPlayerLevel2(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
        if (super.getHand().contains(C2)) {
            return playCard(super.getHand().indexOf(C2));
        }
        if (round.size() != 0) {
            String targetSuit = round.get(0).getSuit();

            // look for cards of the right suit, the queen of spades, and hearts
            ArrayList<Card> temp = new ArrayList<Card>(); // temp = all cards of matching suit
            ArrayList<Card> tempHearts = new ArrayList<Card>();
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

            // if there are cards matching the leading suit
            if (temp.size() > 0) {
                Collections.sort(temp);
                Card highestSafe = highestSafeCard(temp, highestCard(round));
                if (round.size() == 3) {
                    
                    if (!hasHazards(round)) { // if there are no hazards, just take it with the highest card you have
                        Card toPlay = temp.get(temp.size() - 1);
                        return playCard(super.getHand().indexOf(toPlay));
                    }
                    if (highestSafe == null) { // if there are no safe cards to play, just take it with the highest card you have
                        Card toPlay = temp.get(temp.size() - 1);
                        return playCard(super.getHand().indexOf(toPlay));
                    }
                    else{
                        return playCard(super.getHand().indexOf(highestSafe));
                    }
                }
                // if there are no safe cards to play, play the lowest card of the right suit you have
                if(highestSafe==null){
                    Card toPlay = temp.get(0);
                    return playCard(super.getHand().indexOf(toPlay));
                }
                else{
                    return playCard(super.getHand().indexOf(highestSafe));
                }
                
            }

            // no cards matching the leading suit + have queen in hand
            if (hasQueen) {
                return playCard(super.getHand().indexOf(Qs));
            }

            // no cards matching the leading suit + have hearts
            if (tempHearts.size() > 0) {
                Collections.sort(tempHearts);
                Card toPlay = tempHearts.get(tempHearts.size() - 1);
                return playCard(super.getHand().indexOf(toPlay));
            }

            // if there are neither hearts nor a card of the same suit, play the highest card
            // TODO: don't do this if the queen of spades hasn't been played yet and the highest card is higher
            // return playCard((int) (Math.random() * super.getHand().size()));
            return playCard(super.getHand().indexOf(highestCardByValue(super.getHand())));

        }

        // TODO: return the lowest card (may change somewhat depending on spades)
        return playCard(super.getHand().indexOf(lowestCardByValue(super.getHand())));
    }

    private boolean hasHazards(ArrayList<Card> round) {
        for (Card card : round) {
            if (card.equals(Qs) || "hearts".equals(card.getSuit())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param setOfOneSuit - sorted list of cards containing only one suit
     * @param targetCard - card to be lower than
     * @return highest safe card if one exists, else return null
     */
    private Card highestSafeCard(ArrayList<Card> setOfOneSuit, Card targetCard) {
        Card myCard = null;
        for (Card card : setOfOneSuit) {
            if (card.compareTo(targetCard) < 0) {
                if (myCard == null) {
                    myCard = card;
                } else if (card.compareTo(myCard) < 0) {
                    myCard = card;
                }
            }
        }
        return null;
    }

    /**
     * @param toSearch 
     * @return the highest card in the ArrayList that matches the suit of the first card
     */
    private Card highestCard(ArrayList<Card> toSearch) {
        Card highestCard = toSearch.get(0);
        String targetSuit = highestCard.getSuit();
        for (Card card : toSearch) {
            if (targetSuit.equals(card.getSuit()) && card.compareTo(highestCard) < 0) {
                highestCard = card;
            }
        }
        return highestCard;
    }
    private Card highestCardByValue(ArrayList<Card> toSearch){
        Card highestCard = toSearch.get(0);
        for(Card card:toSearch){
            if(card.getRank() > highestCard.getRank()){
                highestCard = card;
            }
        }
        return highestCard;
    }

    private Card lowestCardByValue(ArrayList<Card> toSearch) {
        Card lowestCard = toSearch.get(0);
        for (Card card : toSearch) {
            if (card.getRank() < lowestCard.getRank()) {
                lowestCard = card;
            }
        }
        return lowestCard;
    }
}