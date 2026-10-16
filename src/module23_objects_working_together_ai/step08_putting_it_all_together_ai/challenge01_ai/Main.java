// AI-Generated
package module23_objects_working_together_ai.step08_putting_it_all_together_ai.challenge01_ai;

public class Main {
    /**
     * A robot moves on the grid, and {@code Position.java} is the class from above. {@code Robot.java} has the robot's name and position. Write two methods in it:
     * <ul>
     * <li>{@code move(String direction)} moves the robot one square: {@code up} adds 1 to y, {@code down} takes 1 from y, {@code right} adds 1 to x and {@code left} takes 1 from x. Any other direction does nothing. Use the position's {@code moved} method, and keep the new position it returns.
     * <li>{@code isAt(Position place)} returns {@code true} when the robot is at that place. Compare the positions with {@code equals}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Robot robo = new Robot("Robo", new Position(0, 0));
     * robo.move("up");
     * robo.move("up");
     * robo.move("right");
     * System.out.println(robo);
     * System.out.println(robo.isAt(new Position(1, 2)));
     * System.out.println(robo.isAt(new Position(2, 1)));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Robo at (1, 2)
     * true
     * false
     * }</pre>
     * Hints
     * 1. {@code moved} doesn't change the position: it returns a new one. Keep it in the robot's instance variable: {@code this.position = this.position.moved(0, 1);} for {@code up}, and the same with other numbers for the other directions.
     * 2. {@code isAt} compares the robot's position with the one it's given: {@code return this.position.equals(place);}. With {@code ==} it would be false, because the check's {@code new Position(1, 2)} is a different object.
     */
    public static void main(String[] args) {
        Robot robo = new Robot("Robo", new Position(0, 0));
        robo.move("up");
        robo.move("up");
        robo.move("right");
        System.out.println(robo);
        System.out.println(robo.isAt(new Position(1, 2)));
        System.out.println(robo.isAt(new Position(2, 1)));
    }
}
