// AI-Generated
package module24_lists_inside_objects_ai.step07_totals_from_the_objects_on_the_list_ai.challenge02_ai;

public class Main {
    /**
     * {@code Squad.java} has a method {@code averageGoals()}, but it has two bugs. For a squad whose players scored 3 and 4 goals it returns {@code 3.0}, not {@code 3.5}, and for a squad with no players it crashes. Fix it, so it returns the average with its decimals, and 0 for a squad with no players. {@code Player.java} and {@code Main.java} are ready, and when the method is fixed the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3.5
     * 0.0
     * }</pre>
     * Hints
     * 1. {@code this.totalGoals()} and {@code this.players.size()} are both {@code int} values, so the division drops the decimals before the result becomes a {@code double}. With no players, it divides by zero, and an {@code int} division by zero crashes.
     * 2. Check {@code if (this.players.isEmpty()) { return 0; }} first. Then {@code return (double) this.totalGoals() / this.players.size();}: the cast turns the total into a {@code double} before the division, as in the lesson's {@code averagePages}.
     */
    public static void main(String[] args) {
        Squad squad = new Squad();
        squad.add(new Player("Ana", 3));
        squad.add(new Player("Bo", 4));
        System.out.println(squad.averageGoals());
        Squad empty = new Squad();
        System.out.println(empty.averageGoals());
    }
}
