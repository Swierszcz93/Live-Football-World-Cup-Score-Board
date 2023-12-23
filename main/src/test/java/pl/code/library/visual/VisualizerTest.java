package pl.code.library.visual;

import org.junit.jupiter.api.Test;
import pl.code.library.Scoreboard;

import static org.junit.jupiter.api.Assertions.*;

class VisualizerTest {

    private final Visualizer visualizer = new Visualizer();

    @Test
    public void shouldReturnScoreboardString() {
        Scoreboard scoreboard = new Scoreboard();
        scoreboard.startGame("Mexico", "Canada");
        scoreboard.updateGame("Mexico", "Canada", 0, 5);
        scoreboard.startGame("Spain", "Brazil");
        scoreboard.updateGame("Spain", "Brazil", 10, 2);
        scoreboard.startGame("Germany", "France");
        scoreboard.updateGame("Germany", "France", 2, 2);
        scoreboard.startGame("Uruguay", "Italy");
        scoreboard.updateGame("Uruguay", "Italy", 6, 6);
        scoreboard.startGame("Argentina", "Australia");
        scoreboard.updateGame("Argentina", "Australia", 3, 1);

        assertEquals("""
                Uruguay 6 - Italy 6
                Spain 10 - Brazil 2
                Mexico 0 - Canada 5
                Argentina 3 - Australia 1
                Germany 2 - France 2
                """, visualizer.createScoreboardString(scoreboard.getSortedScoreboardList()));
    }
}