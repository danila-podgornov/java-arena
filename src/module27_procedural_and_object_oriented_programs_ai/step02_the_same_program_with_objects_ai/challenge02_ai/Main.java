// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step02_the_same_program_with_objects_ai.challenge02_ai;

public class Main {
    /**
     * At a quiz night, a team gets 10 points for a right answer and loses 5 for a wrong one, but its score never goes below 0. The program in {@code Main.java} keeps two teams' scores procedurally. Rewrite it with objects. Write the class in {@code Team.java}:
     * <ul>
     * <li>{@code Team(String name)}: a team with 0 points.
     * <li>{@code answer(boolean right)}: adds 10 points for a right answer, and takes 5 off for a wrong one, but never below 0.
     * <li>{@code toString()}: returns the name and the points, like {@code Foxes: 15 points}.
     * </ul>
     * <p>Then change {@code main} so that it uses two Team objects instead of the four variables and the static method, which it doesn't need any more. The program prints what it does now: see the expected output below.
     * Expected output
     * <pre>{@code
     * Foxes: 15 points
     * Owls: 0 points
     * }</pre>
     * Hints
     * 1. The name and the points of one team become the private instance variables of Team. {@code answer} does what the static method did, but on {@code this.points}, and it returns nothing.
     * 2. In {@code main}, create {@code Team foxes = new Team("Foxes");} and one for the Owls, and turn each line like {@code firstPoints = answer(firstPoints, true);} into {@code foxes.answer(true);}. {@code System.out.println(foxes);} uses toString.
     */
    public static void main(String[] args) {
        String firstName = "Foxes";
        int firstPoints = 0;
        String secondName = "Owls";
        int secondPoints = 0;

        firstPoints = answer(firstPoints, true);
        secondPoints = answer(secondPoints, false);
        firstPoints = answer(firstPoints, false);
        secondPoints = answer(secondPoints, true);
        firstPoints = answer(firstPoints, true);
        secondPoints = answer(secondPoints, false);
        secondPoints = answer(secondPoints, false);

        System.out.println(firstName + ": " + firstPoints + " points");
        System.out.println(secondName + ": " + secondPoints + " points");
    }

    public static int answer(int points, boolean right) {
        if (right) {
            return points + 10;
        }
        points = points - 5;
        if (points < 0) {
            points = 0;
        }
        return points;
    }
}
