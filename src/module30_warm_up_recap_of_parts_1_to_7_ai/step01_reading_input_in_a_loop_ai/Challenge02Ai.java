// AI-Generated
package module30_warm_up_recap_of_parts_1_to_7_ai.step01_reading_input_in_a_loop_ai;

public class Challenge02Ai {
    /**
     * A climber works through the gym's walls, numbered 1 to 6, in order. What does this program print?
     * Hints
     * 1. {@code continue} in a {@code for} loop still runs {@code wall++}, so the even walls are skipped and the loop goes on with the next wall. {@code meters} is a running total: it prints the meters so far, not only this wall's.
     * 2. {@code break} at wall 5 ends the loop at once, before wall 5 is counted. The last line prints the totals after walls 1 and 3.
     */
    public static void main(String[] args) {
        int walls = 0;
        int meters = 0;
        for (int wall = 1; wall <= 6; wall++) {
            if (wall % 2 == 0) {
                continue;
            }
            if (wall == 5) {
                break;
            }
            walls++;
            meters += wall * 4;
            System.out.println("Wall " + wall + ": " + meters + " m");
        }
        System.out.println(walls + " walls, " + meters + " m");
    }
}
