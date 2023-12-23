package pl.code.library;

import pl.code.library.visual.VisualizationUtils;

import java.util.*;

public class Scoreboard {
    private final List<Game> gameList = new LinkedList<>();
    private final VisualizationUtils visualizationUtils = new VisualizationUtils();
    private final Comparator<Game> sortStrategy = Comparator.comparingInt(Game::getTotalScore).thenComparingLong(Game::getStartTime).reversed();

    public List<Game> getSortedScoreboardList() {
        gameList.sort(sortStrategy);
        return Collections.unmodifiableList(gameList);
    }

    public String getVizualizedString() {
        return visualizationUtils.createScoreboardString(getSortedScoreboardList());
    }

    public boolean startGame(String homeTeam, String awayTeam) {
        try {
            return gameList.add(new Game(homeTeam, awayTeam));
        } catch (NonValidNamesException e) {
            return false;
        }
    }

    public boolean updateGame(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
        return findGame(homeTeam, awayTeam).map(game -> game.update(homeTeamScore, awayTeamScore)).orElse(false);
    }

    public boolean finishGame(String homeTeam, String awayTeam) {
        return gameList.remove(findGame(homeTeam, awayTeam).orElse(null));
    }

    private Optional<Game> findGame(String homeTeam, String awayTeam) {
        return gameList.stream().filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)).findFirst();
    }
}
