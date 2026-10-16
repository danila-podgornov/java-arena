// AI-Generated
package module09_loop_conditions_and_for_ai.step04_when_the_condition_is_checked_ai;

public class Challenge01Ai {
    /**
     * What does this program print? Trace {@code i} and {@code rounds} round by round.
     * Hints
     * 1. {@code i} goes 0, 3, 6, 9, and then one more round, because 9 is still below 10.
     * 2. The fourth round makes {@code i} 12 and {@code rounds} 4. Then {@code 12 < 10} is false.
     */
    public static void main(String[] args) {
        int i = 0;
        int rounds = 0;
        while (i < 10) {
            i += 3;
            rounds++;
        }
        System.out.println("Rounds: " + rounds);
        System.out.println("i: " + i);
    }
}
