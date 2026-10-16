// AI-Generated
package module42_exceptions_ai.step02_choosing_what_to_catch_ai;

public class Challenge02Ai {
    /**
     * What does this program print? Keep in mind which exception class is a child of which.
     * Hints
     * 1. {@code 12 / 0} throws an ArithmeticException, and the first {@code catch} block matches it. A NumberFormatException isn't an ArithmeticException, but it is a RuntimeException, so the second block catches it.
     * 2. The {@code finally} block runs at the end of every call, whether an exception was thrown or not.
     */
    public static void main(String[] args) {
        check("4");
        check("0");
        check("four");
    }

    public static void check(String text) {
        try {
            int people = Integer.parseInt(text);
            System.out.println(12 / people);
        } catch (ArithmeticException e) {
            System.out.println("nobody");
        } catch (RuntimeException e) {
            System.out.println("not a number");
        } finally {
            System.out.println("done");
        }
    }
}
