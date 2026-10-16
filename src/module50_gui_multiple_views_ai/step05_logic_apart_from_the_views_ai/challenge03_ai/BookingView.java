// AI-Generated
package module50_gui_multiple_views_ai.step05_logic_apart_from_the_views_ai.challenge03_ai;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class BookingView {
    private Excursion excursion;
    private VBox view;

    public BookingView(Excursion excursion) {
        this.excursion = excursion;
        Label info = new Label(excursion.toString());
        TextField seats = new TextField();
        seats.setPromptText("Seats");
        Button book = new Button("Book");
        Label message = new Label("");
        book.setOnAction(event -> {
            try {
                int count = Integer.valueOf(seats.getText());
                if (this.excursion.book(count)) {
                    message.setText("Seats booked: " + count + ".");
                    info.setText(this.excursion.toString());
                } else {
                    message.setText("Can't book that. Free seats: " + this.excursion.free() + ".");
                }
            } catch (NumberFormatException e) {
                message.setText("Type the number of seats in digits.");
            }
        });
        this.view = new VBox(8, info, seats, book, message);
    }

    public Parent getView() {
        return this.view;
    }
}
