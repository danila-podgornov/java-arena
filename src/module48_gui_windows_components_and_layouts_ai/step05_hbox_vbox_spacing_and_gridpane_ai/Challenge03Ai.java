// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step05_hbox_vbox_spacing_and_gridpane_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        GridPane keypad = new GridPane();
        Button seven = new Button("7");
        keypad.add(seven, 0, 2);
        keypad.add(new Button("8"), 1, 2);
        System.out.println(GridPane.getColumnIndex(seven) + " " + GridPane.getRowIndex(seven));

        Insets padding = new Insets(4, 8, 12, 16);
        keypad.setPadding(padding);
        System.out.println(padding.getRight() + padding.getLeft());

        VBox box = new VBox(keypad);
        System.out.println(box.getAlignment() + " " + box.getSpacing());

        stage.setScene(new Scene(box));
        stage.show();
    }

    /**
     * A few questions about a grid, padding and a box's settings. {@code getAlignment()} returns a Pos, which prints as its name. What does the program print?
     * Hints
     * 1. {@code add(seven, 0, 2)} takes the column first: column 0, row 2.
     * 2. Insets are top, right, bottom, left: the right is 8.0 and the left 16.0, and they are doubles. A VBox that was given nothing else has the alignment TOP_LEFT and the spacing 0.0.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
