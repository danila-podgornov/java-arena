// AI-Generated
package module29_larger_programs_ai.step05_the_end_of_java_programming_i_ai.challenge01_ai;

import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    /**
     * The league's logic. {@code Player.java} is the class above, and {@code Main.java} is ready: it reads {@code league.csv} and gives each line to {@code add}, and then it tries the other methods out. In {@code League.java}, replace the placeholders:
     * <ul>
     * <li>{@code find(String name)} returns the player with that name, or {@code null}.
     * <li>{@code add(String playerName, int points)} adds a game's points to the player. When there's no player by that name yet, it first creates one and adds it to the list.
     * <li>{@code leader()} returns the player with the most points in all, or {@code null} when there are no players. If two players have the same total, the one added first.
     * <li>{@code playerNames()} returns a new list of the players' names in alphabetical order. Sort it with {@code Collections.sort}.
     * </ul>
     * <p>League doesn't print anything. For the file shown below, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Players: [Jonas, Mia, Priya]
     * Leader: Mia, total 23, games [8, 7, 8]
     * Priya, total 22, games [6, 9, 7]
     * null
     * }</pre>
     * Hints
     * 1. {@code find} is the loop of step 3's {@code FoodBank.find}. {@code add} calls {@code this.find(playerName)} first. When that's {@code null}, it makes {@code new Player(playerName)}, adds it to {@code this.players} and keeps it in the variable, and then calls {@code addGame(points)} on the player either way.
     * 2. {@code leader} is a best match that starts from {@code null} and compares {@code player.total()}, with {@code >} so that the first of two equal players stays. {@code playerNames} adds each player's {@code getName()} to a new {@code ArrayList<String>}, and calls {@code Collections.sort(names)} before returning it.
     */
    public static void main(String[] args) {
        League league = readLeague("league.csv");
        System.out.println("Players: " + league.playerNames());
        System.out.println("Leader: " + league.leader());
        System.out.println(league.find("Priya"));
        System.out.println(league.find("Pia"));
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
