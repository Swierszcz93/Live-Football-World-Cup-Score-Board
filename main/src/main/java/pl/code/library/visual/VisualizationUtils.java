package pl.code.library.visual;

import pl.code.library.Game;

import java.util.List;

public class VisualizationUtils {
    private String createGameString(Game game) {
        return String.format("%s %d - %s %d", game.getHomeTeam(), game.getHomeTeamScore(), game.getAwayTeam(), game.getAwayTeamScore());
    }

    public String createScoreboardString(List<Game> gameList) {
        StringBuilder output = new StringBuilder();
        for (Game game : gameList) {
            output.append(createGameString(game));
            output.append("\n");
        }
        return output.toString();
    }
}
