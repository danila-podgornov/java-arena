// AI-Generated
package module49_gui_event_handling_ai.step04_logic_in_a_class_of_its_own_ai.challenge03_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Label now = new Label("Now: Work 1");
        Button next = new Button("Next");
        Button startOver = new Button("Start over");

        stage.setScene(new Scene(new VBox(now, new HBox(next, startOver))));
        stage.setTitle("Pomodoro plan");
        stage.show();
    }

    /**
     * A pomodoro timer goes through a fixed plan of steps: {@code Work 1}, {@code Short break}, {@code Work 2}, {@code Short break}, {@code Work 3}, {@code Short break}, {@code Work 4}, {@code Long break}, and then from {@code Work 1} again. Write both parts:
     * <ul>
     * <li>In {@code PomodoroCycle.java}, the class {@code PomodoroCycle}, without anything from JavaFX: a constructor that starts at {@code Work 1}, {@code current()}, which returns the name of the current step, {@code next()}, which moves to the next step, and {@code restart()}, which goes back to {@code Work 1}.
     * <li>In {@code Main.java}, the window is built already: the label {@code Now: Work 1}, and under it the buttons {@code Next} and {@code Start over}. Make a PomodoroCycle in {@code start}. <b>Next</b> moves the cycle to its next step and <b>Start over</b> restarts it; after either one, the label shows {@code Now: } and the current step, like {@code Now: Short break}.
     * </ul>
     * <p>The task card shows the window after seven clicks on Next.
     * Hints
     * 1. PomodoroCycle can keep the number of the step, 0 to 7: the even steps 0, 2, 4 and 6 are {@code Work 1} to {@code Work 4} ({@code "Work " + (step / 2 + 1)}), step 7 is the long break, and the other odd steps are short breaks. {@code next()} adds one, and goes from 7 back to 0.
     * 2. In {@code start}, make the cycle with {@code PomodoroCycle cycle = new PomodoroCycle();}. Each handler calls the cycle's method, then sets the label: {@code now.setText("Now: " + cycle.current());}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
