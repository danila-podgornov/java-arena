// AI-Generated
package module57_switch_var_and_text_blocks_ai.step03_switch_on_strings_and_enums_ai.challenge03_ai;

public class Main {
    /**
     * A puzzle game sets the player's lives and time limit by the difficulty. The designer has just added a fourth difficulty, {@code EXPERT}, to the enum in {@code Difficulty.java}, and now {@code Main.java} doesn't compile: javac says that the switch expressions don't cover all possible input values. Press Run to see it. Fix both methods: an expert game gives 1 life and 60 seconds. Don't add a {@code default}. The check runs:
     * {@code System.out.println("Lives: " + startingLives(Difficulty.EXPERT) + ", time: " + timeLimit(Difficulty.EXPERT) + " seconds");}
     * <p>which prints: see the expected output below.
     * Expected output
     * {@code Lives: 1, time: 60 seconds}
     * Hints
     * 1. javac names two lines, one per switch expression. Each is missing a case for the new constant.
     * 2. Add {@code case EXPERT -> 1;} to {@code startingLives} and {@code case EXPERT -> 60;} to {@code timeLimit}.
     */
    public static void main(String[] args) {
        for (Difficulty difficulty : Difficulty.values()) {
            System.out.println(difficulty + ": lives " + startingLives(difficulty) + ", time " + timeLimit(difficulty) + " seconds");
        }
    }

    public static int startingLives(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY -> 5;
            case NORMAL -> 3;
            case HARD -> 2;
        };
    }

    public static int timeLimit(Difficulty difficulty) {
        return switch (difficulty) {
            case EASY, NORMAL -> 300;
            case HARD -> 180;
        };
    }
}
