public class CardRunner {
    public static void main(String[] args) {

        // Card[] deck = { new Card("5", "clubs", 5), new Card("3", "clubs", 3), new Card("5", "diamonds", 5),
        //         new Card("1", "clubs", 1), new Card("6", "hearts", 6), new Card("K", "clubs", 13),
        //         new Card("5", "diamonds", 5) };
        Deck myDeck = new Deck();
        // for (int i = 0; i < 10; i++) {
        //     myDeck.initializeDeck();
        //     myDeck.shuffle();
        //     System.out.println(myDeck);
        //     System.out.println();
        // }
        myDeck.shuffle();
        System.out.println(myDeck);
        Deck myDeck2 = new Deck();
        myDeck.setDeck(myDeck2.getDeck());
        myDeck2.dealTopCard();
        System.out.println(myDeck);

    }
}
