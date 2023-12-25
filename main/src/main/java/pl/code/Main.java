package pl.code;

import pl.code.library.Scoreboard;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class Main {
    private static final List<List<String>> TEAM_PAIRS = List.of(
            List.of("Germany", "France"),
            List.of("Italy", "Andora"),
            List.of("Poland", "Spain"),
            List.of("Brazil", "Argentina"),
            List.of("   ", "Empty")
    );
    private static final int HOME = 0;
    private static final int AWAY = 1;
    private static final int MAX_SCORE = 10;
    public static void main(String[] args) {
        System.out.println("Showcase started");

        Scoreboard scoreboard = new Scoreboard();
        System.out.println("Initial scoreboard state");
        System.out.println(scoreboard.getVizualizedString());
        for (List<String> pair : TEAM_PAIRS) {
            System.out.printf("Starting game: %s - %s%n", pair.get(HOME), pair.get(AWAY));
            showResult(() -> scoreboard.startGame(pair.get(HOME), pair.get(AWAY)));
        }
        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());


        Random rnd = new Random();
        for (List<String> pair : TEAM_PAIRS) {
            int homeScore = rnd.nextInt(MAX_SCORE);
            int awayScore = rnd.nextInt(MAX_SCORE);
            System.out.printf("Setting up game score: %s %d - %s %d%n", pair.get(HOME), homeScore, pair.get(AWAY), awayScore);
            showResult(() -> scoreboard.updateGame(pair.get(HOME), pair.get(AWAY), homeScore, awayScore));
        }
        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());


        System.out.println("Removing random game");
        int gameNumber = rnd.nextInt(TEAM_PAIRS.size());
        System.out.printf("Removing : %s - %s%n", TEAM_PAIRS.get(gameNumber).get(HOME), TEAM_PAIRS.get(gameNumber).get(AWAY));
        showResult(() -> scoreboard.finishGame(TEAM_PAIRS.get(gameNumber).get(HOME), TEAM_PAIRS.get(gameNumber).get(AWAY)));
        System.out.println("Current scoreboard state");
        System.out.println(scoreboard.getVizualizedString());

        System.out.println("Showcase ended");
    }

    private static void showResult(Supplier<Boolean> function) {
        if (function.get()) {
            System.out.println("Success!");
        } else {
            System.out.println("Failure!");
        }
    }
}