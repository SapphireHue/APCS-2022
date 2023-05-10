import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HeartsTournament {
    static int numGames = 20000;
    static int badPoints = numGames * 26;
    static boolean printMatches = true;

    public static ArrayList<Competitor> getPlayers(String filePath) {
        ArrayList<Competitor> players = new ArrayList<Competitor>();
        File path = new File(filePath);
        File[] classFiles = path.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.matches("CardPlayer.+\\.class");
            }
        });
        // Class playerClass = Class.forName("CardPlayer");
        for (File classFile : classFiles) {
            String name = classFile.getName().replace(".class", "");
            try {
                Class<?> playerClass = Class.forName(name);
                name = name.replace("CardPlayer", "");
                Constructor<CardPlayer> playerConstructor = (Constructor<CardPlayer>) (playerClass
                        .getConstructor(String.class, int.class, ArrayList.class));
                players.add(new Competitor(playerConstructor));
            } catch (ClassNotFoundException e) {
                System.err.println("Class not found: " + name);
            } catch (Exception e) {
                System.err.println("Something else went wrong for " + name + " :" + e);
            }
        }
        return players;
    }

    public static void runGames(HeartsGame game) {
        for (int gameNum = 0; gameNum < numGames; gameNum++) {
            game.getDeckOfCards().initializeDeck();
            game.getDeckOfCards().shuffle();

            for (int x = 0; x < 13; x++) {
                for (int i = 0; i < 4; i++) {
                    game.deal(1, i);
                }
            }

            game.playGame();
        }
        // System.out.println("Total bad points: " + badPoints);
        if (printMatches) {
            System.out.println("***" + game.getNameOfGame() + "***");
            for (CardPlayer player : game.getPlayers()) {
                // System.out.printf("%s %.2f%%    ", player.getName(), (player.getScore() / (double) badPoints) * 100);
                System.out.printf("%s %d    ", player.getName(), player.getScore());
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        ArrayList<Competitor> players = getPlayers(
                ClassLoader.getSystemClassLoader().getResource("").getPath());
        for (int player1 = 0; player1 < players.size() - 1; player1++) {
            for (int player2 = player1 + 1; player2 < players.size(); player2++) {
                HeartsGame game = new HeartsGame(players.get(player1), players.get(player2));
                runGames(game);

                ArrayList<CardPlayer> roundPlayers = game.getPlayers();
                players.get(player1).updatePoints(roundPlayers.get(0).getScore() + roundPlayers.get(2).getScore());
                players.get(player2).updatePoints(roundPlayers.get(1).getScore() + roundPlayers.get(3).getScore());
            }
        }
        int i = 1;
        System.out.println("***LEADERBOARD***");
        Collections.sort(players, new Comparator<Competitor>() {
            public int compare(Competitor a, Competitor b){
                return Integer.compare(a.getPoints(), b.getPoints());
            }
        });
        for(Competitor player : players){
            System.out.printf("%-3s %-20s %10d%n", i++ + ".", player.getName(), player.getPoints());
        }
    }
}

class Competitor {
    private Constructor<CardPlayer> constructor;
    private String name;
    private int wins;
    private int points;

    public Competitor(Constructor<CardPlayer> constructor) {
        this.constructor = constructor;
        name = constructor.getName().replace("CardPlayer", "");
        points = 0;
        wins = 0;
    }

    public void incrementWins() {
        wins++;
    }

    public void updatePoints(int points) {
        this.points += points;
    }

    public Constructor<CardPlayer> getConstructor() {
        return constructor;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getPoints() {
        return points;
    }
}