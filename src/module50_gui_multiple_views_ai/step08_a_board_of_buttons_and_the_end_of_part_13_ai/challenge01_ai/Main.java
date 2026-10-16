// AI-Generated
package module50_gui_multiple_views_ai.step08_a_board_of_buttons_and_the_end_of_part_13_ai.challenge01_ai;

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
     * Finish the game's logic. {@code NumberGrab.java} is the class from above, with two placeholder methods at its end, and {@code Main.java} is the window, which now shows {@code status()} in the label under the board. In NumberGrab:
     * <ul>
     * <li>write {@code isOver()}: it returns {@code true} when a player has more than half of the total of all the board's numbers, or when every number is taken, and {@code false} otherwise
     * <li>write {@code status()}: while the game goes on, it returns {@code Red's turn} or {@code Blue's turn}; when it's over, {@code Red wins 32 to 6} or {@code Blue wins 32 to 6} (the winner's points first), or for equal points {@code A draw: 29 each}
     * <li>change {@code take}: once the game is over, it takes nothing and returns {@code false}
     * </ul>
     * <p>The total and the number of taken cells can be kept in instance variables, worked out in the constructor and in {@code take}. The check runs:
     * <pre>{@code
     * NumberGrab game = new NumberGrab(new int[][] {{9, 1}, {8, 2}});
     * System.out.println(game.status());
     * game.take(0, 0);
     * game.take(1, 0);
     * System.out.println(game.isOver() + " " + game.status());
     * game.take(0, 1);
     * game.take(1, 1);
     * System.out.println(game.isOver() + " " + game.status());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Red's turn
     * false Red's turn
     * true A draw: 10 each
     * }</pre>
     * Hints
     * 1. Add {@code private int total;} and {@code private int taken;}. The constructor adds up every number with two loops (for-each loops over the rows and their numbers work), and {@code take} adds one to {@code taken} for each move it makes. Then {@code isOver()} is {@code 2 * this.red > this.total || 2 * this.blue > this.total || this.taken == cells}, with {@code cells} the number of rows times the number of columns.
     * 2. {@code status()} returns the turn's text first {@code if (!this.isOver())}; then compares {@code this.red} and {@code this.blue} for the three endings. At the start of {@code take}, {@code if (this.isOver() || ...)} returns {@code false}.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
