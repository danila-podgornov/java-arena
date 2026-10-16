// AI-Generated
package module11_return_values_and_the_call_stack_ai.step05_methods_that_call_methods_ai;

public class Challenge01Ai {
    /**
     * Write {@code daysInYear(int year)}, which returns 366 for a leap year and 365 otherwise. Use the {@code isLeapYear} method that's already there (it follows the leap year rules from module 6). The check runs {@code System.out.println(daysInYear(2024));} and expects: see the expected output below.
     * Expected output
     * {@code 366}
     * Hints
     * 1. {@code isLeapYear(year)} gives {@code true} or {@code false}, so it can be the condition of an {@code if}.
     * 2. {@code if (isLeapYear(year)) { return 366; }} and then {@code return 365;}
     */
    public static void main(String[] args) {
        System.out.println(daysInYear(2024));
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
            return true;
        }
        if (year % 100 == 0) {
            return false;
        }
        return year % 4 == 0;
    }

    // Write the daysInYear method here.
}
