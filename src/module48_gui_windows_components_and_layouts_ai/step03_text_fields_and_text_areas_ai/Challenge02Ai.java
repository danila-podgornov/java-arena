// AI-Generated
package module48_gui_windows_components_and_layouts_ai.step03_text_fields_and_text_areas_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Challenge02Ai extends Application {

    @Override
    public void start(Stage stage) {
        TextField title = new TextField("Dune");
        title.setPromptText("Title");
        title.appendText(" Messiah");
        System.out.println(title.getText() + " " + title.getLength());
        title.clear();
        System.out.println("[" + title.getText() + "] " + title.getPromptText());

        TextArea note = new TextArea("Due on Friday");
        note.appendText("\nRenewed once");
        note.setText(note.getText().toUpperCase());
        System.out.println(note.getText().split("\n")[1]);

        stage.setScene(new Scene(new FlowPane(title, note)));
        stage.show();
    }

    /**
     * The returns desk tries out the methods of text fields and text areas. What does the program print?
     * Hints
     * 1. {@code appendText} adds to the end, so the field holds {@code Dune Messiah}: 12 characters, the space too. {@code clear()} empties the text, but the prompt text stays.
     * 2. The area's text has two lines. {@code setText} replaces it with the same text in capital letters, and {@code split("\n")[1]} is its second line.
     */
    public static void main(String[] args) {
        launch(Challenge02Ai.class);
    }
}
