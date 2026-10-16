// AI-Generated
package module51_data_visualization_ai.step07_honest_charts_ai.challenge03_ai;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        List<String> lines = Files.readAllLines(Paths.get("votes.csv"));

        stage.setTitle("Club trip");
        stage.show();
    }

    /**
     * A youth club votes on where its trip goes, and the votes are in {@code votes.csv}. {@code Bounds} (with {@code upperBound} and {@code niceTick}) is ready. Write {@code start}: the window, titled {@code Club trip}, shows a bar chart (the scene's root) with the title {@code Where should the trip go?}, a category axis labeled {@code Place}, no legend, and one series, {@code Votes}, with a bar (place, votes) for each row, in the order of the file. Its y axis is labeled {@code Votes}, starts at 0 and has bounds computed from the data: the tick unit is {@code niceTick} of the largest number of votes, and the upper bound is {@code upperBound} of the votes with that tick unit. The task card shows the window for this file, where the axis goes from 0 to 50 with a tick every 5: see the expected output below.
     * Expected output
     * <pre>{@code
     * place,votes
     * Lake camp,34
     * Science museum,21
     * Zoo,47
     * Climbing hall,12
     * }</pre>
     * Hints
     * 1. Read the rows into two lists first, the places and the votes, so that the bounds can be computed before the axis is made.
     * 2. Find the largest vote, {@code int tick = Bounds.niceTick(max);}, then {@code new NumberAxis("Votes", 0, Bounds.upperBound(votes, tick), tick)}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
