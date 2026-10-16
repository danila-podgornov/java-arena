// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step06_layouts_inside_layouts_ai;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Challenge01Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label header = new Label("Apply for a library card");
        header.setFont(Font.font("Serif", 18));

        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(form());
        root.setBottom(buttons());

        stage.setScene(new Scene(root));
        stage.setTitle("New library card");
        stage.show();
    }

    private GridPane form() {
        GridPane form = new GridPane();
        return form;
    }

    private HBox buttons() {
        HBox buttons = new HBox();
        return buttons;
    }

    /**
     * The library's form for a new card. Build it with two helper methods, {@code form()} and {@code buttons()}, which {@code start} already uses. The window's title is {@code New library card}, and its root is a BorderPane with:
     * <ul>
     * <li>top: the label {@code Apply for a library card}, in the font {@code Font.font("Serif", 18)}
     * <li>center: the GridPane that {@code form()} returns, with the gaps 8 between both columns and rows and the padding 10 on every side. It holds the labels {@code Name}, {@code Email} and {@code Branch} in column 0, rows 0 to 2, and next to each label, in column 1, an empty TextField.
     * <li>bottom: the HBox that {@code buttons()} returns, with the spacing 8, the padding 10 on every side and the alignment {@code CENTER_RIGHT}. It holds the buttons {@code Cancel} and {@code Apply}.
     * </ul>
     * <p>The window it should show is drawn below.
     * Hints
     * 1. {@code add(node, column, row)} takes the column first: each label goes into column 0 and its field into column 1 of the same row, one row per name. A loop over the three names saves writing each row.
     * 2. In {@code form()}: {@code form.add(new Label("Name"), 0, 0);} and {@code form.add(new TextField(), 1, 0);}, and the same for rows 1 and 2 (or a loop over the three names). Then {@code setHgap(8)}, {@code setVgap(8)} and {@code setPadding(new Insets(10))}.
     * 3. In {@code buttons()}: {@code new HBox(8, new Button("Cancel"), new Button("Apply"))} gives the spacing and the buttons at once. Add {@code setPadding(new Insets(10))} and {@code setAlignment(Pos.CENTER_RIGHT)}.
     */
    public static void main(String[] args) {
        launch(Challenge01Ai.class);
    }
}
