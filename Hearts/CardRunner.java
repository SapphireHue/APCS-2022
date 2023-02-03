import java.util.ArrayList;

// import java.util.Collections;
public class CardRunner {
    public static void main(String[] args) {

        // Card[] deck = { new Card("5", "clubs", 5), new Card("3", "clubs", 3), new Card("5", "diamonds", 5),
        //         new Card("1", "clubs", 1), new Card("6", "hearts", 6), new Card("K", "clubs", 13),
        //         new Card("5", "diamonds", 5) };

        Card[] deck = { new Card("3", "clubs", 3), new Card("2", "clubs", 2), new Card("7", "spades", 7),
                new Card("A", "hearts", 14), new Card("6", "spades", 6), new Card("3", "diamonds", 3), 
                new Card("3", "hearts", 3) };

        ArrayList<Card> deck2 = new ArrayList<Card>();
        for (Card card : deck) {
            deck2.add(card);
        }

        CardPlayer person = new CardPlayer("Kara Jones", 0, deck2);
        System.out.println("New CardPlayer -> " + person);
        System.out.println("Played " + person.playCard(6) + " at index 5");
        ArrayList<Card> round = new ArrayList<Card>();
        ArrayList<Card> previousRound = new ArrayList<Card>();
        System.out.println("Starting a game: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        round.add(new Card("10", "spades", 10));
        System.out.println("Playing card to follow 10 of spades: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);

        round.clear();
        round.add(new Card("9", "clubs", 9));
        System.out.println("Playing card to follow 9 of clubs (should be a heart): " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);

        round.clear();
        System.out.println("Playing a random card: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        System.out.println("Playing a random card: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        System.out.println("Playing a random card: " + person.chooseCard(round, previousRound));
        System.out.println("Player -> " + person);
        // for (Card card : deck) {
        //     deck2.add(card);
        // }
        // person.setHand(deck2);
        // System.out.println("Set Hand ->" + person);
        // for (Card card : deck) {
        //     person.addCard(card);
        // }
        // System.out.println("Added 6 cards ->" + person);
        // deck2.clear();
        // System.out.println("Player ->" + person);
        // System.out.println("Played " + person.playCard(5) + " at index 5");
        // person.setScore(25);
        // person.updateScore(2);
        // System.out.println("Updated score to 27 points.");
        // System.out.println("Player ->" + person);


        // Deck myDeck = new Deck();
        // // for (int i = 0; i < 10; i++) {
        // //     myDeck.initializeDeck();
        // //     myDeck.shuffle();
        // //     System.out.println(myDeck);
        // //     System.out.println();
        // // }
        // myDeck.shuffle();
        // System.out.println(myDeck);
        // Deck myDeck2 = new Deck();
        // myDeck.setDeck(myDeck2.getDeck());
        // myDeck2.dealTopCard();
        // System.out.println(myDeck);

    }
}
