// AI-Generated
package module23_objects_working_together_ai.step07_several_objects_working_together_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? It uses {@code Team} and {@code Match} classes like the ones in the lesson. Watch when points are given, and which variables refer to the same team.
     * Hints
     * 1. Making a Match gives no points: only {@code givePoints()} does. After the first two matches, the draw has given each team 1 point, and the Foxes won the second match for 3 more.
     * 2. {@code favorite} refers to the same team as {@code foxes}. The third match is a Foxes win too, but its points come only when {@code third.givePoints()} runs, after the first two lines are printed.
     */
    public static void main(String[] args) {
        Team owls = new Team("Owls");
        Team foxes = new Team("Foxes");
        Team favorite = foxes;
        Match first = new Match(owls, foxes, 1, 1);
        Match second = new Match(foxes, owls, 2, 0);
        Match third = new Match(owls, favorite, 1, 3);
        first.givePoints();
        second.givePoints();
        System.out.println(owls);
        System.out.println(favorite);
        third.givePoints();
        System.out.println(foxes);
    }
}
