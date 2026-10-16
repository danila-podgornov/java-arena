// AI-Generated
package module29_larger_programs_ai.step03_commands_and_input_that_doesnt_fit_ai.challenge02_ai;

import java.util.Scanner;

public class Main {
    /**
     * A café's cake counter sells cakes by the slice. {@code Cake.java}, {@code CakeCounter.java} and {@code Main.java} are ready: the counter has a carrot cake of 8 slices and a lemon tart of 4, {@code find} returns the cake with the given name or {@code null}, and a cake has {@code getName()}, {@code getSlices()} and {@code sell(int slices)}. In {@code UserInterface.java}, write the {@code sell} command. It reads two lines: the cake's name, and how many slices. Read both lines first, and then check, in this order:
     * <ol>
     * <li>No cake by that name: print {@code No cake called } and the name.
     * <li>The slices aren't a whole number of at least 1 (such as {@code two}, {@code 0} or {@code -3}): print {@code Slices must be a whole number, 1 or more}.
     * <li>The cake has fewer slices left: print {@code Not enough }, the name, {@code : } and the slices left, like {@code Not enough lemon tart: 4 left}.
     * <li>Otherwise, sell them and print {@code Sold }, the slices, {@code of}, the name, {@code , } and the slices left, like {@code Sold 2 of carrot cake, 6 left}.
     * </ol>
     * <p>Turn the text into a number with {@code try} and {@code catch}, as in the lesson, so that text that isn't a whole number counts as not valid. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Sold 2 of carrot cake, 6 left
     * > No cake called banana bread
     * > Slices must be a whole number, 1 or more
     * > Slices must be a whole number, 1 or more
     * > Not enough lemon tart: 4 left
     * > Sold 4 of lemon tart, 0 left
     * > carrot cake: 6 slices
     * lemon tart: 0 slices
     * > Closed
     * }</pre>
     * Hints
     * 1. Read the name and the number's line right at the start of the branch, before any {@code if}. Then {@code find} the cake, and check {@code cake == null} first.
     * 2. Copy the lesson's {@code toNumber} method into the class, and call {@code this.toNumber(this.scanner.nextLine())}. It returns {@code -1} for text that isn't a number, so {@code slices < 1} catches that too. Compare {@code cake.getSlices() < slices} before selling.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CakeCounter counter = new CakeCounter();
        counter.add(new Cake("carrot cake", 8));
        counter.add(new Cake("lemon tart", 4));
        UserInterface ui = new UserInterface(scanner, counter);
        ui.start();
    }
}
