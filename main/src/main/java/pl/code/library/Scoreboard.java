package pl.code.library;

import pl.code.library.visual.Visualizer;

import java.util.*;

public class Scoreboard {
    private final List<Game> gameList = new LinkedList<>();
    private final Visualizer visualizer = new Visualizer();
    private final Comparator<Game> sortStrategy = Comparator.comparingInt(Game::getTotalScore).thenComparingLong(Game::getStartTime).reversed();

    public List<Game> getSortedScoreboardList() {
        gameList.sort(sortStrategy);
        return Collections.unmodifiableList(gameList);
    }

    public String getVizualizedString() {
        return visualizer.createScoreboardString(getSortedScoreboardList());
    }

    public boolean startGame(String homeTeamName, String awayTeamName) {
        try {
            return gameList.add(new Game(homeTeamName, awayTeamName));
        } catch (NonValidNamesException e) {
            return false;
        }
    }

    public boolean updateGame(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        return findGame(homeTeamName, awayTeamName).map(game -> game.update(homeTeamScore, awayTeamScore)).orElse(false);
    }

    public boolean finishGame(String homeTeamName, String awayTeamName) {
        return gameList.remove(findGame(homeTeamName, awayTeamName).orElse(null));
    }

    private Optional<Game> findGame(String homeTeamName, String awayTeamName) {
        return gameList.stream().filter(game -> game.getHomeTeamName().equals(homeTeamName) && game.getAwayTeamName().equals(awayTeamName)).findFirst();
    }
}
