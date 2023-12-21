package pl.code.visual;

import pl.code.library.Game;
import pl.code.library.Scoreboard;

public class VisualizationUtils {
    public static String createGameString(Game game) {
        return String.format("%s %d - %s %d", game.getHomeTeam(), game.getHomeTeamScore(), game.getAwayTeam(), game.getAwayTeamScore());
    }

    public static String createScoreboardString(Scoreboard scoreboard) {
        StringBuilder output = new StringBuilder();
        for (Game game : scoreboard.getSortedScoreboardList()) {
            output.append(createGameString(game));
            output.append("\n");
        }
        return output.toString();
    }
}
