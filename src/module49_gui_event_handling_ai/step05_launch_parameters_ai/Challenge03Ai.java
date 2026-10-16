// AI-Generated
package module49_gui_event_handling_ai.step05_launch_parameters_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Challenge03Ai extends Application {

    @Override
    public void start(Stage stage) {
        Label rate = new Label("Tip percent: 15");
        TextField bill = new TextField();
        bill.setPromptText("Bill in euros");
        Button tip = new Button("Tip");
        Label result = new Label("");

        stage.setScene(new Scene(new VBox(rate, bill, tip, result)));
        stage.setTitle("Tip calculator");
        stage.show();
    }

    /**
     * A tip calculator's percent is a launch parameter, {@code --percent=20}, and 15 when it isn't given. The window is built already: the label {@code Tip percent: 15}, a text field with the prompt text {@code Bill in euros}, the button {@code Tip}, and an empty label. Make it work:
     * <ul>
     * <li>Read the percent in {@code start}, and show it in the first label, like {@code Tip percent: 20}.
     * <li><b>Tip</b> reads the bill, a whole number of euros, and sets the last label to the tip, {@code bill * percent / 100.0}, like {@code Tip: 9.0 euros} for a bill of 45 at 20 percent.
     * <li>{@code main} hands its arguments on to the application.
     * </ul>
     * <p>The task card shows the window for the arguments {@code --percent=20}, after typing 45 and clicking Tip.
     * Hints
     * 1. Read the percent from the named parameters at the top of {@code start}, with {@code getOrDefault} and "15" when it's missing, and make the first label's text from it.
     * 2. The percent is {@code Integer.valueOf(getParameters().getNamed().getOrDefault("percent", "15"))}. The handler can use {@code percent}: it's a local variable, but it never changes (step 2). Read the bill with {@code Integer.valueOf(bill.getText())}, and remember {@code launch(Main.class, args)} in {@code main}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
