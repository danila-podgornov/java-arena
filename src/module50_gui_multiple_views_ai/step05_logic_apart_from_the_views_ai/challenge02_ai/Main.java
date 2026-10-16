// AI-Generated
package module50_gui_multiple_views_ai.step05_logic_apart_from_the_views_ai.challenge02_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Excursion excursion = new Excursion("Island tour", 40);
        BookingView booking = new BookingView(excursion);

        stage.setScene(new Scene(booking.getView()));
        stage.setTitle("Excursions");
        stage.show();
    }

    /**
     * The agency's booking view. {@code Excursion} (the class from the first task) and {@code Main} are ready. Write the class {@code BookingView} in {@code BookingView.java}:
     * <ul>
     * <li>a constructor {@code BookingView(Excursion excursion)}
     * <li>{@code getView()}, which returns a Parent: a VBox with the spacing 8 and no padding, holding a label with the excursion's {@code toString()}, a text field with the prompt text {@code Seats}, the button {@code Book} and an empty label for messages. Make them once, in the constructor.
     * </ul>
     * <p><b>Book</b> reads the number of seats from the field, and:
     * <ul>
     * <li>when the text isn't a whole number, the message is {@code Type the number of seats in digits.}
     * <li>when {@code book} returns {@code true}, the message is {@code Seats booked: 3.} (with the number), and the first label shows the excursion's new {@code toString()}
     * <li>when {@code book} returns {@code false}, the message is {@code Can't book that. Free seats: 37.} (with the number of free seats)
     * </ul>
     * <p>Book never clears the field: it keeps the text that was typed, whatever the outcome.
     * <p>The rules about which numbers can be booked are in Excursion: the view only forwards the number. The task card shows the window after typing {@code 3} and clicking Book.
     * Hints
     * 1. Keep the excursion in an instance variable and make the four nodes in the constructor. The first label starts with {@code excursion.toString()}.
     * 2. In Book's handler, {@code int count = Integer.valueOf(seats.getText());} goes in a {@code try}, with {@code catch (NumberFormatException e)} for the first message. Then {@code if (this.excursion.book(count))} decides between the other two messages.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
