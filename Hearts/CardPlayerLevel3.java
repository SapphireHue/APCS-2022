// Finished! todos are for level Saffron
import java.util.ArrayList;
import java.util.Collections;

public class CardPlayerLevel3 extends CardPlayer {
    private static final Card Qs = new Card("Q", "spades", 12);
    private static final Card C2 = new Card("2", "clubs", 2);

    public CardPlayerLevel3(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    public Card chooseCard(ArrayList<Card> round, ArrayList<Card> previousRounds) {
        if (super.getHand().contains(C2)) {
            return playCard(super.getHand().indexOf(C2));
        }

        if (round.size() != 0) {
            String targetSuit = round.get(0).getSuit();

            // look for cards of the right suit, the queen of spades, and hearts
            ArrayList<Card> temp = cardsOfSuit(targetSuit, super.getHand()); // temp = all cards of matching suit
            ArrayList<Card> tempHearts = cardsOfSuit("hearts", super.getHand());
            boolean hasQueen = super.getHand().contains(Qs);

            // if there are cards matching the leading suit
            if (temp.size() > 0) {
                Collections.sort(temp);
                Card highestSafe = highestSafeCard(temp, highestCard(round));
                if (round.size() == 3) {

                    if (!hasHazards(round)) { // if there are no hazards, just take it with the highest card you have
                        // unless you're in the last 5 rounds; then try to give it to someone else
                        if (round.size() >= 32 && highestSafe != null) {
                            return playCard(super.getHand().indexOf(highestSafe));
                        }
                        Card toPlay = temp.get(temp.size() - 1);
                        return playCard(super.getHand().indexOf(toPlay));
                    }
                    if (highestSafe == null) { // if there are no safe cards to play, just take it with the highest card you have
                        Card toPlay = temp.get(temp.size() - 1);
                        return playCard(super.getHand().indexOf(toPlay));
                    } else {
                        return playCard(super.getHand().indexOf(highestSafe));
                    }
                }
                // if there are no safe cards to play, play the lowest card of the right suit you have
                //TODO: count cards to see what isn't safe yet but will be later, or to see when it's better to just eat the loss and take it, or when no more hazards will be appearing
                if (highestSafe == null) {
                    Card toPlay = temp.get(0);
                    return playCard(super.getHand().indexOf(toPlay));
                } else {
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
            return playCard(super.getHand().indexOf(highestCardByValue(super.getHand())));

        }
        // TODO: play the highest starting card that won't result in hazards being taken
        return playCard(super.getHand().indexOf(chooseStartingCard(previousRounds)));
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

    private Card highestCardByValue(ArrayList<Card> toSearch) {
        Card highestCard = toSearch.get(0);
        for (Card card : toSearch) {
            if (card.getRank() > highestCard.getRank()) {
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

    private Card chooseStartingCard(ArrayList<Card> previousRounds) {
        ArrayList<Card> spades = cardsOfSuit("spades", super.getHand());
        Collections.sort(spades);
        if (!previousRounds.contains(Qs) && !spades.contains(Qs) && spades.size() > 0) { // if the queen hasn't been played yet, you don't have it, and you have other spades
            // try to flush it out
            if (spades.get(0).getRank() < 13){
                return spades.get(0);
            }
        }

        return lowestCardByValue(super.getHand());


    }

    private ArrayList<Card> cardsOfSuit(String targetSuit, ArrayList<Card> toSearch) {
        ArrayList<Card> temp = new ArrayList<Card>();
        for (Card card : toSearch) {
            if (card.getSuit().equals(targetSuit)) {
                temp.add(card);
            }
        }
        return temp;
    }
}