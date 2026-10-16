// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step05_hbox_vbox_spacing_and_gridpane_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        GridPane keypad = new GridPane();

        stage.setScene(new Scene(keypad));
        stage.setTitle("Gate");
        stage.show();
    }

    /**
     * A keypad for a gate, with the digits in the order of a calculator: {@code 7}, {@code 8} and {@code 9} in the top row, {@code 1}, {@code 2} and {@code 3} in the bottom row of digits. Build it: the title is {@code Gate}, and the root is a GridPane with the gaps 5 between both columns and rows, and the padding 10 on every side. It holds:
     * <ul>
     * <li>rows 0 to 2: the digit buttons, {@code 7 8 9}, then {@code 4 5 6}, then {@code 1 2 3}, each row from column 0 to column 2
     * <li>row 3: the buttons {@code Clear} in column 0, {@code 0} in column 1 and {@code Open} in column 2
     * </ul>
     * <p>Make the nine digit buttons with two nested {@code for} loops, one for the rows and one for the columns (the check counts the {@code new Button} in your code: one in the loops and three for row 3). The window it should show is drawn below.
     * Hints
     * 1. Which digit starts row 0, which starts row 1, and which starts row 2? How much does the first digit change from one row to the next?
     * 2. Row 2 starts with 1, row 1 with 4 and row 0 with 7: the first digit of a row is {@code (2 - row) * 3 + 1}. Add the column to it for the digit in each cell.
     * 3. {@code keypad.add(new Button("" + digit), column, row);} takes the column first. The gaps are {@code setHgap(5)} and {@code setVgap(5)}, and the padding {@code new Insets(10)}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
