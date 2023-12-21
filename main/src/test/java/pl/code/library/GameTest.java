package pl.code.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldHaveZeroScoreAfterInitialization() throws NonValidNamesException {
        Game game = new Game("Mexico", "Canada");

        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }

    @Test
    public void shouldThrowExceptionAndNotCreateNewGame() {
        Game game = null;
        int catchCount = 0;
        try {
            game = new Game(null, "Canada");
        } catch (NonValidNamesException e) {
            assertEquals("Invalid name: 'null' or 'Canada'", e.getMessage());
            catchCount++;
        }
        try {
            game = new Game("", "Canada");
        } catch (NonValidNamesException e) {
            assertEquals("Invalid name: '' or 'Canada'", e.getMessage());
            catchCount++;
        }
        try {
            game = new Game("     ", "Canada");
        } catch (NonValidNamesException e) {
            assertEquals("Invalid name: '     ' or 'Canada'", e.getMessage());
            catchCount++;
        }
        assertNull(game);
        assertEquals(3, catchCount);
    }

    @Test
    public void shouldUpdateScore() throws NonValidNamesException {
        Game game = new Game("Mexico", "Canada");
        assertTrue(game.update(1, 2));

        assertEquals(1, game.getHomeTeamScore());
        assertEquals(2, game.getAwayTeamScore());
    }

    @Test
    public void shouldNotUpdatedScoreWhenProvidedNumbersAreIncorrect() throws NonValidNamesException {
        Game game = new Game("Mexico", "Canada");
        assertFalse(game.update(-1, 2));

        assertEquals(0, game.getHomeTeamScore());
        assertEquals(0, game.getAwayTeamScore());
    }


}