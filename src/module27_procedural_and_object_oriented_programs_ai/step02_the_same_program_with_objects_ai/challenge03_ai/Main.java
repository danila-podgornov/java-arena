// AI-Generated
package module27_procedural_and_object_oriented_programs_ai.step02_the_same_program_with_objects_ai.challenge03_ai;

public class Main {
    /**
     * Going the other way helps you see both styles. In a board game, each turn has a time limit. {@code TurnTimer.java} is an object version: {@code tick(int seconds)} counts the seconds down, never below 0, and {@code isOver()} tells when the time is up. {@code main} uses it. Leave {@code TurnTimer.java} as it is, to compare.
     * <p>Rewrite {@code main} procedurally, without the TurnTimer class. Keep the seconds left in an {@code int} variable in {@code main}, and write two static methods in {@code Main}:
     * <ul>
     * <li>{@code tick(int seconds, int passed)} returns the seconds left after {@code passed} more seconds, but never below 0.
     * <li>{@code isOver(int seconds)} returns {@code true} when no seconds are left, and {@code false} otherwise.
     * </ul>
     * <p>The program prints what it does now: see the expected output below.
     * Expected output
     * <pre>{@code
     * 35 seconds left
     * 15 seconds left
     * Time's up!
     * }</pre>
     * Hints
     * 1. The object's instance variable becomes a local variable of {@code main}: {@code int seconds = 60;}. Each {@code timer.tick(25);} becomes {@code seconds = tick(seconds, 25);}, which stores the answer.
     * 2. {@code tick} gets the seconds as a parameter, takes {@code passed} off, sets the result to 0 if it's below 0, and returns it. {@code isOver(int seconds)} returns {@code seconds == 0}.
     */
    public static void main(String[] args) {
        TurnTimer timer = new TurnTimer(60);
        timer.tick(25);
        System.out.println(timer.getSeconds() + " seconds left");
        timer.tick(20);
        System.out.println(timer.getSeconds() + " seconds left");
        timer.tick(30);
        if (timer.isOver()) {
            System.out.println("Time's up!");
        } else {
            System.out.println(timer.getSeconds() + " seconds left");
        }
    }
}
