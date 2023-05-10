import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

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
                System.out.printf("%s %.2f%%    ", player.getName(), (player.getScore() / (double) badPoints) * 100);
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void main(String[] args)
            throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Competitor[] players = getPlayers(
                ClassLoader.getSystemClassLoader().getResource("").getPath())
                .toArray(new Competitor[0]);
        for (int firstPlayer = 0; firstPlayer < players.length - 1; firstPlayer++) {
            Competitor player1 = players[firstPlayer];
            Constructor<CardPlayer> constructor1 = player1.getConstructor();
            String name1 = player1.getName();
            for (int secondPlayer = firstPlayer + 1; secondPlayer < players.length; secondPlayer++) {
                Competitor player2 = players[secondPlayer];
                Constructor<CardPlayer> constructor2 = player2.getConstructor();
                String name2 = player2.getName();
                ArrayList<CardPlayer> roundPlayers = new ArrayList<CardPlayer>(4);

                roundPlayers.add(constructor1.newInstance(name1 + 1, 0, new ArrayList<Card>()));
                roundPlayers.add(constructor2.newInstance(name2 + 1, 0, new ArrayList<Card>()));
                roundPlayers.add(constructor1.newInstance(name1 + 2, 0, new ArrayList<Card>()));
                roundPlayers.add(constructor2.newInstance(name2 + 2, 0, new ArrayList<Card>()));

                HeartsGame game = new HeartsGame(String.format("Hearts Tournament: %s vs %s", name1, name2),
                        roundPlayers);
                
                runGames(game);
                
            }
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