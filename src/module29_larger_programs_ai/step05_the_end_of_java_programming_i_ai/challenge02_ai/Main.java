// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge02_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    /**
     * The league's user interface. {@code League.java} (with the methods of the previous challenge), {@code Player.java} and {@code Main.java} are ready: {@code main} reads {@code league.csv} into a League and starts the user interface. In {@code UserInterface.java}, the loop, {@code quit}, {@code leader}, the answer to unknown commands and the lesson's {@code toNumber} are ready too. Write the two empty branches:
     * <ul>
     * <li>{@code add}, then a player's name and a line with the points: the points must be a whole number from 0 to 10, and otherwise print {@code Points must be a whole number from 0 to 10}. With valid points, add the game's points (a name that's new makes a new player) and print the player.
     * <li>{@code compare}, then two lines, each with a player's name. Read both lines first. If the first player isn't in the league, print {@code No player called } and that name, and otherwise the same for the second. When both are there, print who has more points in all, the one with more points first, like {@code Priya is ahead of Mia: 24 to 15}. When their totals are the same, print the two names in the order they were typed, like {@code Mia and Jonas are tied at 15}.
     * </ul>
     * <p>For the input shown and the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * > Points must be a whole number from 0 to 10
     * > Priya, total 24, games [6, 9, 9]
     * > Priya is ahead of Mia: 24 to 15
     * > No player called Pia
     * > Jonas, total 15, games [9, 5, 1]
     * > Mia and Jonas are tied at 15
     * > Leader: Priya, total 24, games [6, 9, 9]
     * > Unknown command: score
     * > Good night
     * }</pre>
     * Hints
     * 1. Each branch reads all its lines before any check, like {@code log} in the lesson. {@code add} needs {@code toNumber}, then the league's {@code add} and {@code find}; {@code compare} needs {@code find} twice and each player's {@code total()}.
     * 2. In {@code add}, {@code this.toNumber(...)} gives -1 for text that isn't a number, so {@code points < 0 || points > 10} catches it; after adding, the player is in the league even if new, so {@code find} gives it back to print. {@code compare} checks the first player for {@code null}, then the second, and only then compares their totals: the first ahead, the second ahead, or tied.
     */
    public static void main(String[] args) {
        League league = readLeague("league.csv");
        Scanner scanner = new Scanner(System.in);
        UserInterface ui = new UserInterface(scanner, league);
        ui.start();
    }

    public static League readLeague(String fileName) {
        League league = new League();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length < 2) {
                    continue;
                }
                league.add(parts[0], Integer.valueOf(parts[1]));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return league;
    }
}
