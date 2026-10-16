// AI-Generated
package module57_switch_var_and_text_blocks_ai.step03_switch_on_strings_and_enums_ai;

import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A drinks machine is run by commands, one per line, until the line {@code quit}. It keeps a credit of coins, at first 0. Write the switch on the command, so that:
     * <ul>
     * <li>{@code coin} adds one coin to the credit and prints the credit, like {@code Credit: 2}
     * <li>{@code tea} costs 2 coins: if the credit is at least 2, it takes them and prints {@code Here is your tea}; otherwise it prints {@code Tea costs 2 coins}
     * <li>{@code refund} prints the coins given back, like {@code Returned 3 coins}, and sets the credit to 0
     * <li>any other command prints {@code Unknown command: } and the command
     * </ul>
     * <p>The loop and the check for {@code quit} are written. With this input:
     * <p>Input
     * <pre>{@code
     * coin
     * tea
     * coin
     * coin
     * coin
     * tea
     * refund
     * dance
     * quit
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Credit: 1
     * Tea costs 2 coins
     * Credit: 2
     * Credit: 3
     * Credit: 4
     * Here is your tea
     * Returned 2 coins
     * Unknown command: dance
     * Bye
     * }</pre>
     * Hints
     * 1. Write <code>switch (command) {</code> with a case for each word: {@code case "coin" -> { ... }}. A case with two statements needs braces.
     * 2. The {@code tea} case holds an {@code if}: enough credit or not. {@code default -> ...} catches every other word.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int credit = 0;
        while (true) {
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                break;
            }
            // react to the command here, with a switch

        }
        System.out.println("Bye");
    }
}
