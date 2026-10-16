// AI-Generated
package module42_exceptions_ai.step03_checked_exceptions_and_throws_ai;

public class Challenge03Ai {
    /**
     * {@code sum} has no {@code try}, and an unchecked exception needs no {@code throws}. What does this program print?
     * Hints
     * 1. When {@code parseInt("five")} throws, {@code sum} stops right there: no {@code added five}, no {@code 6}, and no {@code return sum}. The exception goes up to {@code total}, which called {@code sum} inside its {@code try} block.
     * 2. {@code total}'s {@code catch} block prints {@code bad part} and returns -1, which {@code main} prints.
     */
    public static void main(String[] args) {
        System.out.println(total("4,5"));
        System.out.println(total("4,five,6"));
    }

    public static int total(String text) {
        try {
            return sum(text.split(","));
        } catch (NumberFormatException e) {
            System.out.println("bad part");
            return -1;
        }
    }

    public static int sum(String[] parts) {
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
            System.out.println("added " + part);
        }
        return sum;
    }
}
