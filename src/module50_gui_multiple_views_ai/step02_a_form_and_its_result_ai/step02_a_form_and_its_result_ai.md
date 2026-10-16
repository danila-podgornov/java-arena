> [!info] AI-Generated

# A form and its result

A common pair of views: a **form**, where the user types something, and a **result**, which shows what the program made of it. The handler of the form's button reads the fields, fills in the result and switches to it.

## A postcard

A holiday app writes postcards. The form has a field for whom the card is for and a text area for the message; the card shows them:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField to = new TextField();
        to.setPromptText("To");
        TextArea message = new TextArea();
        Button preview = new Button("Preview");
        Scene form = new Scene(new VBox(8, to, message, preview));

        Label greeting = new Label("");
        Label text = new Label("");
        Button edit = new Button("Edit");
        Scene card = new Scene(new VBox(8, greeting, text, edit));

        preview.setOnAction(event -> {
            greeting.setText("Dear " + to.getText() + ",");
            text.setText(message.getText());
            stage.setScene(card);
        });
        edit.setOnAction(event -> stage.setScene(form));

        stage.setScene(form);
        stage.setTitle("Postcard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextField 1 "Ada"
type TextArea 1 "The lake is warm. See you soon!"
click Button "Preview"
```

- Both scenes are built in `start`. The card's labels start empty: there's nothing to show before the user has written anything.
- The handler of Preview reads the field and the text area when it runs, so it gets what the user has typed by then (module 49). It sets the card's labels from them, and then shows the card.
- Edit shows the form again, and the form still holds what was typed, since it's the same scene with the same field and text area. The user can change the message and preview it again.

## Refusing empty input

With the field empty, the card says `Dear ,`. A form should refuse that and say what's missing, without leaving the form. The form gets an empty label for messages, and the handler checks the field first:

```java
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        TextField to = new TextField();
        to.setPromptText("To");
        TextArea message = new TextArea();
        Button preview = new Button("Preview");
        Label error = new Label("");
        Scene form = new Scene(new VBox(8, to, message, preview, error));

        Label greeting = new Label("");
        Label text = new Label("");
        Button edit = new Button("Edit");
        Scene card = new Scene(new VBox(8, greeting, text, edit));

        preview.setOnAction(event -> {
            if (to.getText().trim().isEmpty()) {
                error.setText("Write who the card is for.");
            } else {
                greeting.setText("Dear " + to.getText().trim() + ",");
                text.setText(message.getText());
                error.setText("");
                stage.setScene(card);
            }
        });
        edit.setOnAction(event -> stage.setScene(form));

        stage.setScene(form);
        stage.setTitle("Postcard");
        stage.show();
    }

    public static void main(String[] args) {
        launch(Main.class);
    }
}
```

```text
type TextArea 1 "Greetings from the lake!"
click Button "Preview"
```

- `trim()` removes the spaces at the ends (module 16), so a field with only spaces counts as empty too.
- When the field is empty, the handler sets the message and does nothing else: the window stays on the form, and the user can fix it.
- When the field has a name, the handler empties the message before it switches. Otherwise the old message would still be there when Edit brings the form back.

## Building the result in the handler

The card above is built once, and the handler only changes the texts of its labels. A handler can also build the result scene itself, each time it runs:

```java
preview.setOnAction(event -> {
    Label greeting = new Label("Dear " + to.getText().trim() + ",");
    VBox card = new VBox(8, greeting, new Label(message.getText()));
    stage.setScene(new Scene(card));
});
```

Each click makes a new card, with new labels and a new scene. That's handy when the result's shape depends on the input, such as a label for each line the user wrote, and the third challenge below needs it. A view that is built once keeps its state between visits; a view that is built in the handler starts fresh every time.

---

Source: [A form and its result](https://javaarena.com/learn/gui-views/form-and-result/) in the module [GUI: multiple views](https://javaarena.com/learn/gui-views/) on Java Arena.

This module follows sections [13.5 Multiple views](https://java-programming.mooc.fi/part-13/5-multiple-views), [13.6 Summary](https://java-programming.mooc.fi/part-13/6-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
