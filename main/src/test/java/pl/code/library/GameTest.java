package pl.code.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    public void shouldShowZeroScore(){
        Game game = new Game("Mexico", "Canada");
        assertEquals("Mexico 0 - Canada 0",game.toString());
    }

    @Test
    public void shouldShowUpdatedScore(){
        Game game = new Game("Mexico", "Canada");
        game.update(1,2);
        assertEquals("Mexico 1 - Canada 2",game.toString());
    }

    @Test
    public void shouldShowNotUpdatedScoreWhenProvidedNumbersAreIncorrect(){
        Game game = new Game("Mexico", "Canada");
        game.update(-1,2);
        assertEquals("Mexico 0 - Canada 0",game.toString());
    }


}