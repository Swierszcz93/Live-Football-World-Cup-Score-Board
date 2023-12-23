package pl.code.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

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

        assertEquals(1, scoreboard.getSortedScoreboardList().size());
    }

    @Test
    public void shouldNotCreateNonValidGame() {
        assertFalse(scoreboard.startGame(null, "Canada"));
        assertFalse(scoreboard.startGame("", "Canada"));
        assertFalse(scoreboard.startGame("    ", "Canada"));

        assertEquals(0, scoreboard.getSortedScoreboardList().size());
    }

    @Test
    public void shouldUpdateGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertTrue(scoreboard.updateGame("Mexico", "Canada", 2, 3));

        Game game = scoreboard.getSortedScoreboardList().get(0);
        assertEquals(2, game.getHomeTeamScore());
        assertEquals(3, game.getAwayTeamScore());
    }

    @Test
    public void shouldReturnFalseAndNotUpdateGameWhenIncorrectNumber() {
        scoreboard.startGame("Mexico", "Canada");

        assertFalse(scoreboard.updateGame("Mexico", "Canada", -2, 3));

        Game game = scoreboard.getSortedScoreboardList().get(0);
        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }

    @Test
    public void shouldReturnFalseAndNotUpdateNonExistingGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertFalse(scoreboard.updateGame("Argentina", "Canada", 2, 3));

        Game game = scoreboard.getSortedScoreboardList().get(0);
        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }

    @Test
    public void shouldReturnTrueWhenRemovingExistingGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertTrue(scoreboard.finishGame("Mexico", "Canada"));

        assertEquals(0, scoreboard.getSortedScoreboardList().size());
    }


    @Test
    public void shouldReturnFalseAndNotRemoveNonExistingGame() {
        scoreboard.startGame("Mexico", "Canada");

        assertFalse(scoreboard.finishGame("France", "Canada"));

        assertEquals(1, scoreboard.getSortedScoreboardList().size());
    }

    @Test
    public void shouldReturnGamesInCorrectOrder() {
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

        List<Game> list = scoreboard.getSortedScoreboardList();
        assertEquals("Uruguay", list.get(0).getHomeTeam());
        assertEquals("Italy", list.get(0).getAwayTeam());
        assertEquals("Spain", list.get(1).getHomeTeam());
        assertEquals("Brazil", list.get(1).getAwayTeam());
        assertEquals("Mexico", list.get(2).getHomeTeam());
        assertEquals("Canada", list.get(2).getAwayTeam());
        assertEquals("Argentina", list.get(3).getHomeTeam());
        assertEquals("Australia", list.get(3).getAwayTeam());
        assertEquals("Germany", list.get(4).getHomeTeam());
        assertEquals("France", list.get(4).getAwayTeam());
    }

    @Test
    public void shouldShowSortedScoreboard() {
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
                """, scoreboard.getVizualizedString());
    }
}