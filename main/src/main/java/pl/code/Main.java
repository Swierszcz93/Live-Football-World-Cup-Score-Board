package pl.code;

import pl.code.library.Scoreboard;

import java.util.List;
import java.util.Random;

public class Main {
    private static final List<List<String>> TEAM_PAIRS = List.of(
            List.of("Germany", "France"),
            List.of("Italy", "Andora"),
            List.of("Poland", "Spain"),
            List.of("Brazil", "Argentina")
    );
    private static final int MAX_SCORE = 10;

    public static void main(String[] args) {
        System.out.println("Showcase started");

        Scoreboard scoreboard = new Scoreboard();
        System.out.println("Initial scoreboard state");
        System.out.println(scoreboard.getVizualizedString());
        for (List<String> pair : TEAM_PAIRS) {
            System.out.printf("Starting game: %s - %s%n", pair.get(0), pair.get(1));
            scoreboard.startGame(pair.get(0), pair.get(1));
        }
        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());
        Random rnd = new Random();
        for (List<String> pair : TEAM_PAIRS) {
            System.out.printf("Setting up game score: %s - %s%n", pair.get(0), pair.get(1));
            scoreboard.updateGame(pair.get(0), pair.get(1), rnd.nextInt(MAX_SCORE), rnd.nextInt(MAX_SCORE));
        }
        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());

        System.out.println("Removing random game");
        int gameNumber = rnd.nextInt(TEAM_PAIRS.size());

        System.out.printf("Removing : %s - %s%n", TEAM_PAIRS.get(gameNumber).get(0), TEAM_PAIRS.get(gameNumber).get(1));
        scoreboard.finishGame(TEAM_PAIRS.get(gameNumber).get(0), TEAM_PAIRS.get(gameNumber).get(1));

        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());

        System.out.println("Showcase ended");
    }
}