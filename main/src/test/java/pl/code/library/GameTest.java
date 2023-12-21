package pl.code.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldHaveZeroScoreAfterInitialization() {
        Game game = new Game("Mexico", "Canada");

        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }

    @Test
    public void shouldUpdateScore() {
        Game game = new Game("Mexico", "Canada");
        assertTrue(game.update(1, 2));

        assertEquals(1, game.getHomeTeamScore());
        assertEquals(2, game.getAwayTeamScore());
    }

    @Test
    public void shouldNotUpdatedScoreWhenProvidedNumbersAreIncorrect() {
        Game game = new Game("Mexico", "Canada");
        assertFalse(game.update(-1, 2));

        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }


}