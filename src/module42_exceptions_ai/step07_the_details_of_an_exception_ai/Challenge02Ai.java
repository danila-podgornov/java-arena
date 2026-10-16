// AI-Generated
package module42_exceptions_ai.step07_the_details_of_an_exception_ai;

public class Challenge02Ai {
    /**
     * An elevator program for a building with floors 0 to 5. What does it print? Mind which lines print {@code e} and which print {@code e.getMessage()}.
     * Hints
     * 1. {@code 3rd} isn't a number. The first {@code catch} block prints the exception itself: its class with the package, a colon, and the message {@code For input string: "3rd"}.
     * 2. 7 is a number, but the program throws its own IllegalArgumentException, and the second block prints only its message. An exception made without a message has {@code null} as its message, and printing it shows only its class.
     */
    public static void main(String[] args) {
        String[] inputs = {"3rd", "7"};
        for (String input : inputs) {
            try {
                int floor = Integer.parseInt(input);
                if (floor > 5) {
                    throw new IllegalArgumentException("No floor " + floor);
                }
                System.out.println("Going to " + floor);
            } catch (NumberFormatException e) {
                System.out.println(e);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        IllegalStateException stuck = new IllegalStateException();
        System.out.println(stuck.getMessage() + " / " + stuck);
    }
}
