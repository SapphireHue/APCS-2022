public class CardGameRunner {
    public static void main(String[] args) {
        String[] playerNames = { "Rio", "Jose", "Saachi", "Ashley" };
        CardGame game = new CardGame("Hi", 4, playerNames, 0);
        int numGames = 20000;
        int badPoints = numGames*26;
        // int[] starts = new int[4];
        // int[] starts2 = new int[4];
        
        for (int gameNum = 0; gameNum < numGames ; gameNum++) {
            game.getDeckOfCards().initializeDeck();
            game.getDeckOfCards().shuffle();

            for (int x = 0; x < 13; x++) {
                for (int i = 0; i < 4; i++) {
                    game.deal(1, i);
                }
            }

            // for(int i = 0; i < 4; i++){
            //     if(game.getPlayers().get(i).getHand().contains(new Card("2", "clubs", 2))){
            //         starts[i]+=1;
            //         break;
            //     }
            // }

            // int temp = game.playGame();
            // starts2[temp]+=1;
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
        
        // System.out.println();
        // for (int i : starts2) {
        //     System.out.print(i + "\t\t");
        // }
        // System.out.println();
        // for(int i : starts){
        //     System.out.print(i + "\t\t");
        // }
    }
}