// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge01_ai;

public class Main {
    /**
     * Add a method {@code winner()} to {@code Match}. It returns the team that scored more goals, or {@code null} when the match is a draw ({@code null} means *no object*, module 22). It returns one of the match's own Team objects, not a new team. {@code Team.java} and {@code Main.java} are ready, and {@code main} prints the winner's name, or {@code Draw}. For the matches in {@code main}, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Owls
     * Bears
     * Draw
     * }</pre>
     * Hints
     * 1. The method returns a Team: <code>public Team winner() {</code>. Compare {@code this.homeGoals} and {@code this.awayGoals}.
     * 2. Return the team itself: {@code return this.home;} or {@code return this.away;}. When neither scored more, {@code return null;}.
     */
    public static void main(String[] args) {
        Team owls = new Team("Owls");
        Team foxes = new Team("Foxes");
        Team bears = new Team("Bears");
        printWinner(new Match(owls, foxes, 2, 1));
        printWinner(new Match(owls, bears, 0, 2));
        printWinner(new Match(foxes, bears, 1, 1));
    }

    public static void printWinner(Match match) {
        Team winner = match.winner();
        if (winner == null) {
            System.out.println("Draw");
        } else {
            System.out.println(winner.getName());
        }
    }
}
