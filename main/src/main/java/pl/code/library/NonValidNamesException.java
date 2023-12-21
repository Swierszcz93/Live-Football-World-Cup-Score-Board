package pl.code.library;

public class NonValidNamesException extends Exception {
    public NonValidNamesException(String homeTeam, String awayTeam) {
        super(String.format("Invalid name: %s or %s", homeTeam, awayTeam));
    }
}
