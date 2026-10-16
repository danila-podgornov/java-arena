// AI-Generated
package module42_exceptions_ai.step01_catching_an_exception_try_and_catch_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Follow each round of the loop into the {@code try} block, and out of it.
     * Hints
     * 1. {@code Integer.parseInt("7x")} throws, so {@code total} doesn't change and the {@code println} after it is skipped. The empty text {@code ""} isn't a number either.
     * 2. A minus sign is fine: {@code -4} is a whole number. Each caught exception adds one to {@code bad}, and the loop goes on with the next reading.
     */
    public static void main(String[] args) {
        String[] readings = {"12", "7x", "30", "", "-4"};
        int total = 0;
        int bad = 0;
        for (String reading : readings) {
            try {
                total += Integer.parseInt(reading);
                System.out.println("added " + reading);
            } catch (NumberFormatException e) {
                bad++;
            }
        }
        System.out.println(total + " " + bad);
    }
}
