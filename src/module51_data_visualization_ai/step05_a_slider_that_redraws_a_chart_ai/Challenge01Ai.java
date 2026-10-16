// AI-Generated
package module51_data_visualization_ai.step05_a_slider_that_redraws_a_chart_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Slider people = new Slider(1, 8, 4);
        people.setShowTickLabels(true);
        people.setMajorTickUnit(1);
        people.setMinorTickCount(0);
        people.setSnapToTicks(___);
        Label title = new Label("Pancakes for 4");
        Label flour = new Label("Flour: 240 g");
        Label milk = new Label("Milk: 600 ml");
        people.___().addListener((observable, oldValue, newValue) -> {
            int count = newValue.___();
            title.setText("Pancakes for " + count);
            flour.setText("Flour: " + count * 60 + " g");
            milk.setText("Milk: " + count * 150 + " ml");
        });

        stage.setScene(new Scene(new VBox(10, people, title, flour, milk)));
        stage.setTitle("Pancakes");
        stage.show();
    }

    /**
     * A pancake recipe needs, per person, 60 g of flour and 150 ml of milk. Fill in the blanks of the recipe scaler: its slider goes from 1 to 8 people, starts at 4 and snaps to whole numbers (a major tick every 1, no minor ticks), and its labels follow the slider. The task card shows the window after the slider is moved to 6, where the labels say {@code Pancakes for 6}, {@code Flour: 360 g} and {@code Milk: 900 ml}.
     * Hints
     * 1. Which value turns snapping on? Which method of the slider gives its value as a property that a listener can go on, and which method of a Number gives an int?
     * 2. A slider snaps to its ticks when {@code setSnapToTicks} is given {@code true}. The listener goes on the slider's value as a property, {@code valueProperty()}, and the new value is a Number: {@code intValue()} gives it as an int.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
