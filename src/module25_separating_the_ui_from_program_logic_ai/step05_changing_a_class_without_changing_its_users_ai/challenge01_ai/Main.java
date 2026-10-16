// AI-Generated
package module25_separating_the_ui_from_program_logic_ai.step05_changing_a_class_without_changing_its_users_ai.challenge01_ai;

import java.util.Scanner;

public class Main {
    /**
     * A café's tip jar program works, but {@code TipJar} keeps every tip in a list, only to answer three questions. Rewrite {@code TipJar} without the list: keep the number of tips, their total and the biggest tip in three {@code int} variables, and update them in {@code add}. Keep the public methods as they are, so that {@code UserInterface.java} and {@code Main.java} work without a change. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Thank you!
     * > Thank you!
     * > Thank you!
     * > 3 tips
     * > Total: 450 cents
     * > Biggest: 200 cents
     * > Closed
     * }</pre>
     * Hints
     * 1. Replace the list with {@code private int count;}, {@code private int total;} and {@code private int biggest;}, all 0 in the constructor. A variable may have the same name as a method: {@code this.count} is the variable, {@code this.count()} the method.
     * 2. {@code add} does all the work: {@code this.count++;}, adds {@code cents} to {@code this.total}, and makes {@code cents} the new {@code this.biggest} when it's bigger. The three other methods only return a variable.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TipJar jar = new TipJar();
        UserInterface ui = new UserInterface(scanner, jar);
        ui.start();
    }
}
