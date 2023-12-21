package pl.code.library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatchTest {

    @Test
    public void shouldShowZeroScore(){
        Match match = new Match("Mexico", "Canada");
        assertEquals("Mexico 0 - Canada 0",match.toString());
    }

    @Test
    public void shouldShowUpdatedScore(){
        Match match = new Match("Mexico", "Canada");
        match.update(1,2);
        assertEquals("Mexico 1 - Canada 2",match.toString());
    }

    @Test
    public void shouldShowNotUpdatedScoreWhenProvidedNumbersAreIncorrect(){
        Match match = new Match("Mexico", "Canada");
        match.update(-1,2);
        assertEquals("Mexico 0 - Canada 0",match.toString());
    }


}