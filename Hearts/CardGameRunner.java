public class CardGameRunner {
    public static void main(String[] args) {
        String[] playerNames = { "Rio", "Jose", "Saachi", "Ashley" };
        CardGame game = new CardGame("Hi", 4, playerNames, 0);
        int badPoints = 0;
        for (int gameNum = 0; gameNum < 1000; gameNum++) {
            badPoints+=26;
            game.getDeckOfCards().initializeDeck();
            // for (int i = 0; i < 10; i++) {
                game.getDeckOfCards().shuffle();
            // }
            // System.out.println(game.getDeckOfCards());
            for (int x = 0; x < 13; x++) {
                for (int i = 0; i < 4; i++) {
                    game.deal(1, i);
                }
            }
            game.playGame();
            // for (int k = 0; k < 4; k++) {
            //     System.out.printf("%s %2d   ", game.getPlayers().get(k).getName(), game.getPlayers().get(k).getScore());
            // }
            //System.out.println(game);
        }
        System.out.println("Total bad points: " + badPoints);
        for(CardPlayer player : game.getPlayers()){
            System.out.printf("%s %.2f%%    ", player.getName(), (player.getScore()/(double)badPoints)*100);
        }
    }
}