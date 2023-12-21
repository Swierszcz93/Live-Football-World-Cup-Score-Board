package pl.code.library;

public class Game {
    private final String homeTeam;
    private final String awayTeam;
    private int homeTeamScore = 0;
    private int awayTeamScore = 0;

    public Game(String homeTeam, String awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s %d", homeTeam, homeTeamScore, awayTeam, awayTeamScore);
    }

    public void update(int homeTeamScore, int awayTeamScore) {
        if (homeTeamScore >= 0 && awayTeamScore >= 0){
            this.homeTeamScore = homeTeamScore;
            this.awayTeamScore = awayTeamScore;
        }
        //TODO what if not, warning? exception?
    }
}
