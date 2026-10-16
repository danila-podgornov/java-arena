// AI-Generated
package module49_gui_event_handling_ai.step04_logic_in_a_class_of_its_own_ai.challenge02_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        UsernameChecker checker = new UsernameChecker();
        checker.addTaken("admin");
        checker.addTaken("ada");
        checker.addTaken("linus");

        TextField username = new TextField();
        username.setPromptText("Username");
        Label status = new Label("At least 3 characters");
        Button signUp = new Button("Sign up");
        signUp.setDisable(true);

        stage.setScene(new Scene(new VBox(username, status, signUp)));
        stage.setTitle("Sign up");
        stage.show();
    }

    /**
     * Now the sign-up window, with {@code UsernameChecker} from the last challenge ready in its own file. The window is built already: a text field with the prompt text {@code Username}, the label {@code At least 3 characters}, and the disabled button {@code Sign up}. The names {@code admin}, {@code ada} and {@code linus} are taken. Make it work, with the checker doing the checking:
     * <ul>
     * <li>After every change of the text, the label shows the checker's message for the text, and the button is enabled only when the checker says the name is free.
     * <li><b>Sign up</b> marks the name in the field as taken, sets the label to {@code Signed up: } and the name ({@code Signed up: grace}), and disables the button.
     * </ul>
     * <p>The task card shows the window after typing {@code grace} and clicking Sign up.
     * Hints
     * 1. The listener asks the checker twice: once with {@code message} for the label's text, and once with {@code isFree}, negated, for whether the button is disabled.
     * 2. The listener is two lines: {@code status.setText(checker.message(newValue));} and {@code signUp.setDisable(!checker.isFree(newValue));}. In Sign up's handler, read the name with {@code username.getText()}, then call {@code checker.addTaken(name)}, set the label and disable the button.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
