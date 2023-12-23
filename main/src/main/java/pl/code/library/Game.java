package pl.code.library;

public class Game {
    private final String homeTeamName;
    private final String awayTeamName;
    private final long startTime;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    public Game(String homeTeamName, String awayTeamName) throws NonValidNamesException {
        if (isNameValid(homeTeamName) && isNameValid(awayTeamName)) {
            this.homeTeamName = homeTeamName;
            this.awayTeamName = awayTeamName;
            startTime = System.nanoTime(); //used instead of System.currentTimeMillis(); <- caused problems in unit tests, don't wanted to add sleep times
        } else throw new NonValidNamesException(homeTeamName, awayTeamName);
    }

    private boolean isNameValid(String teamName) {
        return null != teamName && !teamName.isBlank();
    }

    public boolean update(int homeTeamScore, int awayTeamScore) {
        if (isScoreValid(homeTeamScore) && isScoreValid(awayTeamScore)) {
            this.homeTeamScore = homeTeamScore;
            this.awayTeamScore = awayTeamScore;
            return true;
        }
        return false;
    }

    private boolean isScoreValid(int teamScore) {
        return teamScore >= 0;
    }

    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public int getTotalScore() {
        return homeTeamScore + awayTeamScore;
    }
}
