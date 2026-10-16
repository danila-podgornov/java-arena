// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge02_ai;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class OrderView {
    private VBox view;

    public OrderView(Button toSeeds) {
        TextField what = new TextField();
        what.setPromptText("What would you like?");
        Button send = new Button("Send order");
        Label message = new Label("");
        send.setOnAction(event -> message.setText("Ordered: " + what.getText()));
        this.view = new VBox(8, what, send, message, toSeeds);
    }

    public Parent getView() {
        return this.view;
    }
}
