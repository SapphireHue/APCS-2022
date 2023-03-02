import java.util.ArrayList;
import java.util.Collections;

public class CardGame {
    private Deck deckOfCards;
    private String nameOfGame;
    private ArrayList<CardPlayer> players;
    private int numberOfPlayers, currentPlayer;

    public CardGame(String name, int numPlayers, String[] players, int currentPlayer) {
        deckOfCards = new Deck();
        nameOfGame = name;
        this.players = new ArrayList<CardPlayer>();
        this.players.add(new CardPlayerLevel3(players[0], 0, new ArrayList<Card>()));
        for (int i = 1; i < 4; i++) {
            this.players.add(new CardPlayerLevel1(players[i], 0, new ArrayList<Card>()));
        }
        // this.players.add(new CardPlayerLevel1(players[0], 0, new ArrayList<Card>()));
        // for (int i = 1; i < 4; i++) {
        //     this.players.add(new CardPlayer(players[i], 0, new ArrayList<Card>()));
        // }
        numberOfPlayers = 4;
        this.currentPlayer = currentPlayer;
    }

    public void deal(int numCards, int player) {
        for (int i = 0; i < numCards; i++) {
            players.get(player).addCard(deckOfCards.dealTopCard());
        }
    }

    public void playGame() {
        setUpGame();
        ArrayList<Card> cardsPlayed = new ArrayList<Card>();
        for (int i = 0; i < 13; i++) { // 13 rounds
            ArrayList<Card> trick = playRound(cardsPlayed);
            currentPlayer = takesTrick(trick, currentPlayer);
            cardsPlayed.addAll(trick);

            // add to taken cards
            ArrayList<Card> takenCards = new ArrayList<Card>();
            takenCards.addAll(players.get(currentPlayer).getTakenCards());
            takenCards.addAll(trick);
            players.get(currentPlayer).setTakenCards(takenCards);
        }

        for (CardPlayer player : players) {
            player.updateScore(calculateScore(player.getTakenCards()));
        }
    }

    public void setUpGame() {
        for (CardPlayer player : players) {
            player.setTakenCards(new ArrayList<Card>());
        }
        currentPlayer = playerWith(new Card("2", "clubs", 2));
    }

    public int playerWith(Card card) {
        for (int i = 0; i < 4; i++) {
            if (players.get(i).getHand().contains(card)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Card> playRound(ArrayList<Card> previousRounds) {
        ArrayList<Card> thisRound = new ArrayList<Card>();
        int player = currentPlayer; // 
        for (int i = 0; i < 4; i++) {
            thisRound.add(players.get(player % numberOfPlayers).chooseCard(thisRound, previousRounds));
            player += 1;
        }
        checkRound(thisRound, currentPlayer);
        return thisRound;
    }

    public int takesTrick(ArrayList<Card> trick, int startingPlayer) {
        ArrayList<Card> temp = new ArrayList<Card>();
        String targetSuit = trick.get(0).getSuit();
        for (Card card : trick) {
            if (targetSuit.equals(card.getSuit())) {
                temp.add(card);
            }
        }
        Collections.sort(temp);
        Card highestCard = temp.get(temp.size() - 1);
        return (startingPlayer + trick.indexOf(highestCard)) % 4;
    }

    public int calculateScore(ArrayList<Card> cards) {
        int score = 0;
        Card Qs = new Card("Q", "spades", 12);
        for (Card card : cards) {
            if (card.getSuit().equals("hearts")) {
                score += 1;
            } else if (card.equals(Qs)) {
                score += 13;
            }
        }
        return score;
    }

    // GETTERS AND SETTERS

    public Deck getDeckOfCards() {
        return deckOfCards;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setDeckOfCards(Deck deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    public void setPlayers(ArrayList<CardPlayer> players) {
        this.players = players;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public String toString() {
        String string = "***" + nameOfGame + "***\n";
        for (Player player : players) {
            string += player.toString() + "\n";
        }
        string += "deck -> " + deckOfCards.toString();
        return string;
    }

    static int errorsInCheckRound;

    public void checkRound(ArrayList<Card> round, int startingPlayer) {
        if (errorsInCheckRound < 5) {
            // System.out.print(startingPlayer + " ");
            String roundSuit = round.get(0).getSuit(); // Suit that was led
            for (int i = 1; i < round.size(); i++) { // for all other cards played in the round
                if (!round.get(i).getSuit().equals(roundSuit)) {
                    CardPlayer player = players.get((i + startingPlayer) % round.size());
                    for (Card c : player.getHand()) { // check each card in that players hand
                        if (c.getSuit().equals(roundSuit)) {
                            System.out.println("*** DID NOT FOLLOW SUIT ***\n  round=" + round + "\n  played="
                                    + round.get(i) + "\n  hand=" + player.getHand());
                            errorsInCheckRound++;
                            break;
                        }
                    }
                }
            }
        }
    }

}