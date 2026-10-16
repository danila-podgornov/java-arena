// AI-Generated
package module50_gui_multiple_views_ai.step07_a_practice_app_part_2_the_views_ai.challenge03_ai;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class NewCardView {
    private CardBox box;
    private VBox view;

    public NewCardView(CardBox box) {
        this.box = box;
        TextField country = new TextField();
        country.setPromptText("Country");
        TextField capital = new TextField();
        capital.setPromptText("Capital");
        Button add = new Button("Add card");
        Label message = new Label("");
        add.setOnAction(event -> {
            if (this.box.add(country.getText(), capital.getText())) {
                message.setText("Added. Cards in the box: " + this.box.size());
                country.clear();
                capital.clear();
            } else {
                message.setText("Fill in both fields, and add each country once.");
            }
        });
        this.view = new VBox(8, country, capital, add, message);
        this.view.setPadding(new Insets(10));
    }

    public Parent getView() {
        return this.view;
    }
}
