// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge01_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        HoursView hours = new HoursView();
        SketchView sketches = new SketchView();

        Button toHours = new Button("Opening hours");
        Button toSketches = new Button("My sketches");
        HBox menu = new HBox(10, toHours, toSketches);
        menu.setPadding(new Insets(10));

        BorderPane frame = new BorderPane();
        frame.setTop(menu);
        frame.setCenter(hours.getView());
        toHours.setOnAction(event -> frame.setCenter(hours.getView()));
        toSketches.setOnAction(event -> frame.setCenter(sketches.getView()));

        stage.setScene(new Scene(frame));
        stage.setTitle("Art studio");
        stage.show();
    }

    /**
     * An art studio's app has the pages {@code Opening hours} and {@code My sketches}. {@code Main} and {@code HoursView} are ready. Write the class {@code SketchView} in {@code SketchView.java}:
     * <ul>
     * <li>a constructor without parameters
     * <li>{@code getView()}, which returns a Parent: a VBox with the spacing 8 and the padding 10 on every side, holding the label {@code Sketches today: 0} and the button {@code Finished a sketch}
     * <li>each click on the button adds one to the number in the label, like {@code Sketches today: 3}
     * <li>the count must stay when the user goes to the opening hours and back, so {@code getView()} returns the same VBox at every call: make it in the constructor
     * </ul>
     * <p>The task card shows the window after a click on My sketches and three clicks on Finished a sketch.
     * Hints
     * 1. Give the class two instance variables, {@code private int sketches;} and {@code private VBox view;}. The constructor makes the label and the button, gives the button its handler, and stores {@code new VBox(8, count, done)} in {@code this.view}, then sets its padding.
     * 2. The handler adds one to {@code this.sketches} and sets the label's text. {@code getView()} only returns {@code this.view}. The file needs imports for Insets, Parent, Button, Label and VBox.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
