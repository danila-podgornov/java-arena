// AI-Generated
package module52_drawing_images_and_sound_ai.step07_sound_and_the_end_of_section_14_2_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        Image picture = new Image("file:pic.png");
        BarChart<String, Number> chart = new BarChart<>(new CategoryAxis(), new NumberAxis());

        stage.setScene(new Scene(chart));
        stage.setTitle("Brightness");
        stage.show();
    }

    /**
     * How light is a picture? Count the pixels of {@code pic.png} in three groups by their brightness, the average of their red, green and blue as whole numbers from 0 to 255 (rounded with {@code Math.round}, and divided by 3 with whole-number division): {@code dark} below 85, {@code middle} from 85 to 169, and {@code light} from 170 up.
     * <p>Show the counts in a bar chart (module 51), which is the scene's root: the x axis a {@code CategoryAxis} and the y axis a {@code NumberAxis}, both without labels and auto-ranging; the chart's title {@code Brightness of pic.png} and no legend; and one series named {@code Pixels} with the three data points {@code ("dark", count)}, {@code ("middle", count)} and {@code ("light", count)}, in that order. The window's title is {@code Brightness}. The first test gives the program the sunset {@code photo.png} as {@code pic.png}, and the window should look like the drawing below.
     * Hints
     * 1. Three int counters, then the two loops over the pixels: for each, the brightness {@code (red + green + blue) / 3} from the whole-number amounts, and {@code if}, {@code else if} and {@code else} to pick the counter.
     * 2. Then a {@code XYChart.Series<String, Number>} named {@code Pixels} with {@code new XYChart.Data<>("dark", dark)} and the other two, added to {@code chart.getData()}. The chart also needs {@code setTitle(...)} and {@code setLegendVisible(false)}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
