public class Player {
    private String playerName;
    private String symbol;
    private int score;

    public Player(String playerName, String symbol) {
        this.playerName = playerName;
        this.symbol = symbol;
        this.score = 0;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void increaseScore() {
        score++;
    }

    public int getScore() {
        return score;
    }
}
