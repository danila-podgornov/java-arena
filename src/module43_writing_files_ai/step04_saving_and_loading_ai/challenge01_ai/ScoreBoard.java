// AI-Generated
package module43_writing_files_ai.step04_saving_and_loading_ai.challenge01_ai;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ScoreBoard {
    private ArrayList<HighScore> scores;

    public ScoreBoard() {
        this.scores = new ArrayList<>();
    }

    public void add(HighScore score) {
        this.scores.add(score);
    }

    public HighScore best() {
        HighScore best = null;
        for (HighScore score : this.scores) {
            if (best == null || score.getPoints() > best.getPoints()) {
                best = score;
            }
        }
        return best;
    }

    // Write the methods save and load here.
}
