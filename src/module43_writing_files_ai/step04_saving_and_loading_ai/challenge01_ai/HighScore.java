// AI-Generated
package module43_writing_files_ai.step04_saving_and_loading_ai.challenge01_ai;

public class HighScore {
    private String player;
    private int points;

    public HighScore(String player, int points) {
        this.player = player;
        this.points = points;
    }

    public String getPlayer() {
        return this.player;
    }

    public int getPoints() {
        return this.points;
    }

    public String toCsv() {
        return this.player + "," + this.points;
    }

    @Override
    public String toString() {
        return this.player + ": " + this.points;
    }
}
