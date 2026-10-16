// AI-Generated
package module05_making_decisions_ai.step02_blocks_and_indentation_ai;

import java.util.Scanner;

public class Challenge03Ai {
    /**
     * The indentation in this program makes it look as if both extra lines belong to the inner {@code if}, but only the first one does: an {@code if} without braces controls just one statement. Add braces, so both lines are printed only when the points are over 20. For the input {@code 25} the program prints:
     * <pre>{@code
     * Level up!
     * Bonus!
     * Double bonus!
     * }</pre>
     * <p>For {@code 15} it prints only {@code Level up!}.
     * Hints
     * 1. Without braces, {@code if (points > 20)} only controls the next statement, {@code Bonus!}. {@code Double bonus!} runs whenever the points are over 10.
     * 2. Put <code>{</code> after {@code if (points > 20)} and a matching <code>}</code> after the {@code Double bonus!} line.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = Integer.valueOf(scanner.nextLine());
        if (points > 10) {
            System.out.println("Level up!");
            if (points > 20)
                System.out.println("Bonus!");
                System.out.println("Double bonus!");
        }
    }
}
