// AI-Generated
package module50_gui_multiple_views_ai.step04_views_as_classes_ai.challenge02_ai;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        Button toOrder = new Button("Order");
        Button toSeeds = new Button("Seeds");
        SeedView seeds = new SeedView(toOrder);
        OrderView order = new OrderView(toSeeds);

        toOrder.setOnAction(event -> stage.setScene(new Scene(order.getView())));
        toSeeds.setOnAction(event -> stage.setScene(new Scene(seeds.getView())));

        stage.setScene(new Scene(seeds.getView()));
        stage.setTitle("Seed shop");
        stage.show();
    }

    /**
     * A seed shop's app has two views as classes, each a VBox that's made once, in the constructor. Each view holds the button that leads to the other one: {@code Main} makes the buttons and gives them to the views. The app starts on the seeds, and the first click on Order works, but a click on Seeds after it prints an exception that starts with {@code Exception in thread "JavaFX Application Thread" java.lang.IllegalArgumentException}, and the window stays on the order view.
     * <p>Fix {@code Main}, so that the two buttons switch between the views as often as the user likes. The views, and what they show, stay as they are: make a scene for each view once, and switch between those two scenes. The task card shows the window after the clicks Order and Seeds.
     * Hints
     * 1. {@code getView()} returns the same VBox every time, and the first {@code new Scene(seeds.getView())} already made it the root of a scene. A second {@code new Scene} with the same root is what throws.
     * 2. Make the two scenes once, before the handlers: {@code Scene seedScene = new Scene(seeds.getView());} and {@code Scene orderScene = new Scene(order.getView());}. The handlers and the start of the window then use these variables.
     */
    public static void main(String[] args) {
        launch(Main.class);
    }
}
