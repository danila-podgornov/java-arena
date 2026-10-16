// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step04_a_class_for_the_user_interface_ai.challenge03_ai;

public class Main {
    /**
     * A lemonade stand starts the day with 10 cups of lemonade. {@code LemonadeStand.java} is ready, and so is the {@code start()} method of {@code UserInterface.java}. But the user interface has no instance variables or constructor yet, so it doesn't compile. Add them: the constructor takes a {@code Scanner} and a {@code LemonadeStand}, and {@code start()} uses them as {@code this.scanner} and {@code this.stand}.
     * <p>Then write {@code main}: create the Scanner, a stand with 10 cups and the user interface, and start it. When {@code start()} returns, print {@code Sold today: }, the number of cups sold and {@code  cups}. The stand knows it: ask it with {@code cupsSold()}. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Sold 3 cups
     * > Sold 4 cups
     * > Cups left: 3
     * > Only 3 cups left
     * > Closing the stand
     * Sold today: 7 cups
     * }</pre>
     * Hints
     * 1. The names come from {@code start()}: it uses {@code this.scanner} and {@code this.stand}, so those are the instance variables, a {@code Scanner} and a {@code LemonadeStand}. The constructor sets both.
     * 2. {@code main} needs {@code import java.util.Scanner;} at the top. Keep the stand in a variable, give it to the user interface, and after {@code ui.start();} ask that same stand for {@code cupsSold()}.
     */
    public static void main(String[] args) {
        // Create the objects, start the user interface, and print the cups sold.
    }
}
