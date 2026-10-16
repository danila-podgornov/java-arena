// AI-Generated
package module24_lists_inside_objects_ai.step09_rules_the_owner_enforces_ai.challenge03_ai;

public class Main {
    /**
     * A five-a-side team keeps a roster of its players, and each player has a shirt number. {@code Player.java} is ready, with {@code getName()} and {@code getNumber()}, and a toString like {@code #7 Ada}. {@code Roster.java} has the team's name, the most players it may have, and the list. Write three methods in it:
     * <ul>
     * <li>{@code add(Player player)} adds the player and returns {@code true}, except when the roster is already full, or when a player on it already has the same shirt number. Then it adds nothing and returns {@code false}.
     * <li>{@code remove(int number)} removes the player with that shirt number and returns {@code true}, or returns {@code false} when there's no such player.
     * <li>{@code toString()} gives the team's name and how many players it has of the most it may have, like {@code Otters: 2/3 players}, and then each player on a line of its own.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Roster roster = new Roster("Otters", 3);
     * System.out.println(roster.add(new Player("Ada", 7)));
     * System.out.println(roster.add(new Player("Ben", 7)));
     * System.out.println(roster.add(new Player("Ben", 9)));
     * System.out.println(roster.add(new Player("Cleo", 4)));
     * System.out.println(roster.add(new Player("Dan", 11)));
     * System.out.println(roster.remove(9));
     * System.out.println(roster.remove(5));
     * System.out.println(roster);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * false
     * true
     * true
     * false
     * true
     * false
     * Otters: 2/3 players
     * #7 Ada
     * #4 Cleo
     * }</pre>
     * Hints
     * 1. {@code add} checks two rules before it adds: {@code this.players.size() >= this.maxPlayers} means full, and a loop over the players looks for one whose {@code getNumber()} is the new player's number. Either one returns {@code false}. Shirt numbers are {@code int} values, so {@code ==} compares them.
     * 2. {@code remove} loops over the indexes, and when {@code this.players.get(i).getNumber() == number}, removes index {@code i} and returns {@code true} at once. For toString, start with the first line and add {@code "\n" + player} for each player, as in step 5.
     */
    public static void main(String[] args) {
        Roster roster = new Roster("Otters", 3);
        System.out.println(roster.add(new Player("Ada", 7)));
        System.out.println(roster.add(new Player("Ben", 7)));
        System.out.println(roster.add(new Player("Ben", 9)));
        System.out.println(roster.add(new Player("Cleo", 4)));
        System.out.println(roster.add(new Player("Dan", 11)));
        System.out.println(roster.remove(9));
        System.out.println(roster.remove(5));
        System.out.println(roster);
    }
}
