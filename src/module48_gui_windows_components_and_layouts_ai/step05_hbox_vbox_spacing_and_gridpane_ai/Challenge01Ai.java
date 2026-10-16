// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step05_hbox_vbox_spacing_and_gridpane_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        VBox board = new VBox();

        stage.setScene(new Scene(board));
        stage.setTitle("Scoreboard");
        stage.show();
    }

    /**
     * A scoreboard at the end of a match. Build it: the title is {@code Scoreboard}, and the root is a VBox with the spacing 6, the padding 10 at the top and the bottom and 20 on the left and the right, and the alignment {@code CENTER}. It holds the labels {@code Harbor Rovers 2}, {@code Mill Town 1} and {@code Full time}, in that order. No size for the scene. The window it should show is drawn below.
     * Hints
     * 1. The gap between a VBox's children is its spacing, the place of its children is its alignment (a Pos constant), and the empty edge around them is its padding (an Insets). Insets and Pos need {@code import javafx.geometry.Insets;} and {@code import javafx.geometry.Pos;}.
     * 2. {@code board.setSpacing(6);} and {@code board.setAlignment(Pos.CENTER);}. Insets takes the top, the right, the bottom and the left, in that order: {@code new Insets(10, 20, 10, 20)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
