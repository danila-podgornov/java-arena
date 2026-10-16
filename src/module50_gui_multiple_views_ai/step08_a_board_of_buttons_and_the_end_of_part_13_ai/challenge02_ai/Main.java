// AI-Generated
package module50_gui_multiple_views_ai.step08_a_board_of_buttons_and_the_end_of_part_13_ai.challenge02_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        int[][] numbers = {{5, 2, 8, 3}, {1, 9, 4, 7}, {6, 3, 2, 8}};
        NumberGrab game = new NumberGrab(numbers);
        Label status = new Label(game.status());
        Label score = new Label("Red 0, Blue 0");

        GridPane board = new GridPane();
        board.setHgap(4);
        board.setVgap(4);
        board.setPadding(new Insets(10));
        for (int row = 0; row < numbers.length; row++) {
            for (int column = 0; column < numbers[row].length; column++) {
                int r = row;
                int c = column;
                Button cell = new Button("" + numbers[r][c]);
                cell.setOnAction(event -> {
                    if (game.take(r, c)) {
                        cell.setText(game.ownerAt(r, c) + " " + game.numberAt(r, c));
                        status.setText(game.status());
                        score.setText("Red " + game.score("Red") + ", Blue " + game.score("Blue"));
                    }
                });
                board.add(cell, c, r);
            }
        }

        BorderPane frame = new BorderPane();
        frame.setCenter(board);
        frame.setBottom(new VBox(4, status, score));

        stage.setScene(new Scene(frame));
        stage.setTitle("Number grab");
        stage.show();
    }

    /**
     * Make the board show which numbers are gone. {@code NumberGrab} is complete now, with {@code isOver()} and {@code status()}. Change the window in {@code Main}:
     * <ul>
     * <li>the button of a number that has just been taken is disabled
     * <li>when the game is over, every button of the board is disabled: call {@code setDisable(true)} on each button itself, not on the GridPane or the frame
     * </ul>
     * <p>A disabled button can't be clicked, so the window no longer even tries to take a number twice. Everything else stays as it is. A list of the buttons, filled in the loops, lets a handler reach all of them. The task card shows the window after clicks on 9, 8, the taken 9 and 7.
     * Hints
     * 1. In the handler, after a successful {@code take}, {@code cell.setDisable(true);} disables the button that was clicked.
     * 2. Before the loops, make {@code ArrayList<Button> cells = new ArrayList<>();} (and import {@code java.util.ArrayList}), and add each button to it in the loop. In the handler, {@code if (game.isOver())}, go through {@code cells} and disable every one.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
