package pl.code.library;

public class NonValidNamesException extends Exception {
    public NonValidNamesException(String homeTeamName, String awayTeamName) {
        super(String.format("Invalid name: '%s' or '%s'", homeTeamName, awayTeamName));
    }
}
