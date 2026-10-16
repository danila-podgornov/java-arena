// AI-Generated
package module57_switch_var_and_text_blocks_ai.step04_var_for_local_variables_ai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Challenge01Ai {
    /**
     * A dice tournament reads rolls, one per line as a player's name and the roll, such as {@code Noor 5}, until the line {@code end}, and prints each player's total, in the order the players first rolled. The program works, but its types make it wordy. Declare every local variable with {@code var} instead of its type: the ones inside the loops and the loops' own variables too. What it prints stays the same. With this input:
     * <p>Input
     * <pre>{@code
     * Noor 5
     * Elif 6
     * Noor 3
     * Elif 6
     * end
     * }</pre>
     * <p>the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Noor: 8
     * Elif: 12
     * }</pre>
     * Hints
     * 1. Each declaration loses its type and gets {@code var}: {@code var line = scanner.nextLine();}. In the loops too: {@code for (var player : players)}.
     * 2. When the right-hand side is {@code new ArrayList<String>()}, keep the type argument there: {@code var players = new ArrayList<String>();}. With {@code <>}, javac couldn't tell what the list holds.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> players = new ArrayList<String>();
        HashMap<String, ArrayList<Integer>> rolls = new HashMap<String, ArrayList<Integer>>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }
            String[] parts = line.split(" ");
            String player = parts[0];
            if (!rolls.containsKey(player)) {
                players.add(player);
                rolls.put(player, new ArrayList<Integer>());
            }
            rolls.get(player).add(Integer.valueOf(parts[1]));
        }
        for (String player : players) {
            int total = 0;
            for (int roll : rolls.get(player)) {
                total += roll;
            }
            System.out.println(player + ": " + total);
        }
    }
}
