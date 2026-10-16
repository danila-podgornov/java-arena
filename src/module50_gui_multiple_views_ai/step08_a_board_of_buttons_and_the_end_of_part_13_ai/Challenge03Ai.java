// AI-Generated
package module50_gui_multiple_views_ai.step08_a_board_of_buttons_and_the_end_of_part_13_ai;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label last = new Label("none");
        GridPane grid = new GridPane();
        ArrayList<Button> buttons = new ArrayList<>();
        for (int row = 0; row < 2; row++) {
            for (int column = 0; column < 3; column++) {
                int r = row;
                int c = column;
                Button button = new Button("?");
                button.setOnAction(event -> last.setText("row " + r + ", column " + c));
                grid.add(button, c, r);
                buttons.add(button);
            }
        }
        System.out.println(last.getText() + " " + buttons.size());
        buttons.get(4).fire();
        System.out.println(last.getText());
        buttons.get(2).fire();
        System.out.println(last.getText());
        System.out.println(GridPane.getRowIndex(buttons.get(3)) + " " + GridPane.getColumnIndex(buttons.get(3)));

        stage.setScene(new Scene(new VBox(grid, last)));
        stage.setTitle("Grid");
        stage.show();
    }

    /**
     * A grid of buttons made in loops, with each button's cell copied for its lambda. The buttons also go into a list, in the order the loops make them. {@code GridPane.getRowIndex(node)} and {@code GridPane.getColumnIndex(node)} tell which cell of the grid a node is in. What does the program print?
     * Hints
     * 1. The loops make the buttons row by row: row 0 gets columns 0, 1 and 2, then row 1 does. So the list's indexes 0 to 2 are row 0, and 3 to 5 are row 1.
     * 2. No handler runs until {@code fire()}, so the label says {@code none} at first. Each handler sets the label from its own copies {@code r} and {@code c}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
