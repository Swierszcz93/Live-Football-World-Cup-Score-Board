package pl.code.library;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private final long startTime;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    public Game(String homeTeam, String awayTeam) throws NonValidNamesException {
        if (isNameValid(homeTeam) && isNameValid(awayTeam)) {
            this.homeTeam = homeTeam;
            this.awayTeam = awayTeam;
            startTime = System.nanoTime(); //used instead of System.currentTimeMillis(); <- caused problems in unit tests, don't wanted to add sleep times
        } else throw new NonValidNamesException(homeTeam, awayTeam);
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

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
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
}
