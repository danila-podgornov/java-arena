// AI-Generated
package module49_gui_event_handling_ai.step03_reacting_to_typing_ai;

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
        TextField email = new TextField();
        email.setPromptText("Email address");
        Label status = new Label("Not an email address yet");
        Button send = new Button("Send invite");
        send.setDisable(true);

        stage.setScene(new Scene(new VBox(email, status, send)));
        stage.setTitle("Invite a friend");
        stage.show();
    }

    /**
     * A website's invite page asks for a friend's email address. The window is built already: a text field with the prompt text {@code Email address}, the label {@code Not an email address yet}, and the disabled button {@code Send invite}. Make it work:
     * <ul>
     * <li>After every change of the text, if it contains {@code @}, the label says {@code Ready to send} and the button is enabled; if not, the label says {@code Not an email address yet} and the button is disabled.
     * <li><b>Send invite</b> sets the label to {@code Invite sent to } and the address, like {@code Invite sent to sam@example.com}.
     * </ul>
     * <p>The task card shows the window after typing {@code sam@example.com} and clicking Send invite.
     * Hints
     * 1. Add a listener to {@code email.textProperty()}. In it, {@code newValue.contains("@")} tells which of the two cases it is; each case sets the label's text and calls {@code send.setDisable(...)}.
     * 2. The button's handler is one line: {@code send.setOnAction(event -> status.setText("Invite sent to " + email.getText()));}.
     */
    public static void main(String[] args) {
        launch(Challenge03Ai.class);
    }
}
