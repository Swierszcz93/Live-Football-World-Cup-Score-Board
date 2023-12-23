package pl.code.library;

import pl.code.library.visual.VisualizationUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Scoreboard {
    private final List<Game> gameList = new LinkedList<>();
    private final VisualizationUtils visualizationUtils = new VisualizationUtils();

    public List<Game> getSortedScoreboardList() {
        sortList();
        return Collections.unmodifiableList(gameList);
    }

    public String getVizualizedString(){
        return visualizationUtils.createScoreboardString(getSortedScoreboardList());
    }

    private void sortList() {
        gameList.sort((game1, game2) -> {
            int scoreComparator = Integer.compare(game2.getHomeTeamScore() + game2.getAwayTeamScore(), game1.getHomeTeamScore() + game1.getAwayTeamScore());
            return scoreComparator != 0 ? scoreComparator : Long.compare(game2.getStartTime(), game1.getStartTime());
        });
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
