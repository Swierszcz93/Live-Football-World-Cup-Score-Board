package pl.code.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreboardTest {
    private Scoreboard scoreboard;

    @BeforeEach
    public void beforeEach() {
        scoreboard = new Scoreboard();
    }

    @Test
    public void shouldCreateFirstGame() {
        assertTrue(scoreboard.startGame("Mexico", "Canada"));
        assertEquals("Mexico 0 - Canada 0\n", scoreboard.getSortedScoreBoard());
    }

    @Test
    public void shouldNotCreateNonValidGame() {
        assertFalse(scoreboard.startGame(null, "Canada"));
        assertFalse(scoreboard.startGame("", "Canada"));
        assertFalse(scoreboard.startGame("    ", "Canada"));
        assertEquals("", scoreboard.getSortedScoreBoard());
    }

    @Test
    public void shouldUpdateGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertTrue(scoreboard.updateGame("Mexico", "Canada", 2, 3));
        assertEquals("Mexico 2 - Canada 3\n", scoreboard.getSortedScoreBoard());
    }

    @Test
    public void shouldNotUpdateGameWhenIncorrectNumber() {
        scoreboard.startGame("Mexico", "Canada");

        assertFalse(scoreboard.updateGame("Mexico", "Canada", -2, 3));
        assertEquals("Mexico 0 - Canada 0\n", scoreboard.getSortedScoreBoard());
    }

    @Test
    public void shouldRemoveExistingGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertTrue(scoreboard.removeGame("Mexico", "Canada"));
        assertEquals("", scoreboard.getSortedScoreBoard());
    }


    @Test
    public void shouldNotRemoveNonExistingGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertFalse(scoreboard.removeGame("France", "Canada"));
        assertEquals("Mexico 0 - Canada 0\n", scoreboard.getSortedScoreBoard());
    }

    @Test
    public void shouldShowGamesInCorrectOrder() {
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
                """, scoreboard.getSortedScoreBoard());
    }

}