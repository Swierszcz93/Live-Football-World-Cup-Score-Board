package pl.code.library;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    private final long startTime;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        startTime = System.nanoTime(); //used instead of System.currentTimeMillis(); <- caused problems in tests
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s %d", homeTeam, homeTeamScore, awayTeam, awayTeamScore);
    }

    public boolean update(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore >= 0 && awayTeamScore >= 0){
            this.homeTeamScore = homeTeamScore;
            this.awayTeamScore = awayTeamScore;
            return true;
        }
        return false;
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
