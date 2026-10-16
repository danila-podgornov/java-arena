// AI-Generated
package module50_gui_multiple_views_ai.step02_a_form_and_its_result_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField guests = new TextField();
        Button book = new Button("Book");
        Label message = new Label("");
        Scene form = new Scene(new VBox(8, new Label("Guests"), guests, book, message));

        Label booked = new Label("");
        Button change = new Button("Change");
        Scene bookedScene = new Scene(new VBox(8, booked, change));

        stage.setScene(form);
        stage.setTitle("Table booking");
        stage.show();
    }

    /**
     * A restaurant books tables online. The form is a VBox with the spacing 8 holding the label {@code Guests}, a text field, the button {@code Book} and an empty label for messages. The booked scene is a VBox with the spacing 8 holding an empty label and the button {@code Change}. Both are built already: write the handlers.
     * <p><b>Book</b> reads the number of guests from the field and checks it, in this order:
     * <ul>
     * <li>not a whole number ({@code Integer.valueOf} throws a NumberFormatException, module 42): the message is {@code Type the number of guests in digits.}
     * <li>below 1: {@code At least 1 guest, please.}
     * <li>above 8: {@code For more than 8 guests, please call us.}
     * <li>otherwise the booked scene's label says {@code A table for 4 is booked.} (with the number), the message label is emptied, and the window shows the booked scene.
     * </ul>
     * <p>In the first three cases the window stays on the form. <b>Change</b> shows the form again, with the number still in the field. The task card shows the window after typing {@code 4} and clicking Book.
     * Hints
     * 1. Put the reading and the checks in a {@code try} block: {@code int count = Integer.valueOf(guests.getText());} jumps to {@code catch (NumberFormatException e)} when the text isn't a whole number, and that's where the first message is set.
     * 2. Inside the {@code try}, an {@code if}, {@code else if}, {@code else} chain handles below 1, above 8, and the booking. Only the last branch empties the message and calls {@code stage.setScene(bookedScene)}.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
