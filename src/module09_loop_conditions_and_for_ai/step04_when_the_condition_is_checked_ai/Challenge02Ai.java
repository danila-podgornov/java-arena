// AI-Generated
package module09_loop_conditions_and_for_ai.step04_when_the_condition_is_checked_ai;

public class Challenge02Ai {
    /**
     * What does this program print? Two variables change in each round.
     * Hints
     * 1. After each round: a 2 and b 9, then a 4 and b 8, then a 8 and b 7.
     * 2. Now {@code 8 < 7} is false, so the loop ends with a 8 and b 7.
     */
    public static void main(String[] args) {
        int a = 1;
        int b = 10;
        while (a < b) {
            a *= 2;
            b--;
        }
        System.out.println(a);
        System.out.println(b);
    }
}
