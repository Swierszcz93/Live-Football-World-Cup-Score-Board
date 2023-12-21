package pl.code.library;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Scoreboard {
    private final LinkedList<Game> gameList = new LinkedList<>();

    public List<Game> getSortedScoreboardList() {
        sortList();
        return gameList;
    }

    private void sortList() {
        gameList.sort((game1, game2) -> {
            int scoreComparator = Integer.compare(game2.getHomeTeamScore() + game2.getAwayTeamScore(), game1.getHomeTeamScore() + game1.getAwayTeamScore());
            return scoreComparator != 0 ? scoreComparator : Long.compare(game2.getStartTime(), game1.getStartTime());
        });
    }

    public boolean startGame(String homeTeam, String awayTeam) {
        if (isNameValid(homeTeam) && isNameValid(awayTeam)) {
            gameList.add(new Game(homeTeam, awayTeam));
            return true;
        }
        return false;
    }

    private boolean isNameValid(String teamName) {
        return null != teamName && !teamName.isBlank();
    }

    public boolean updateGame(String homeTeam, String awayTeam, int homeTeamScore, int awayTeamScore) {
        return findGame(homeTeam, awayTeam).map(game -> game.update(homeTeamScore, awayTeamScore)).orElse(false);
    }

    public boolean removeGame(String homeTeam, String awayTeam) {
        return gameList.remove(findGame(homeTeam, awayTeam).orElse(null));
    }

    private Optional<Game> findGame(String homeTeam, String awayTeam) {
        return gameList.stream().filter(game -> game.getHomeTeam().equals(homeTeam) && game.getAwayTeam().equals(awayTeam)).findFirst();
    }
}
