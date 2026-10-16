// AI-Generated
package module09_loop_conditions_and_for_ai.step04_when_the_condition_is_checked_ai;

public class Challenge03Ai {
    /**
     * What does this program print? The loop's variable also changes inside the block.
     * Hints
     * 1. Each round adds one inside the block, and the {@code for} line adds another one at the end of the round.
     * 2. So {@code i} is 0, then 2, then 4 when it's printed. After that it becomes 6, and {@code 6 < 6} is false.
     */
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            System.out.println(i);
            i++;
        }
    }
}
