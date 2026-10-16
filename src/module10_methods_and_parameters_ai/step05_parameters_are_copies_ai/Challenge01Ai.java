// AI-Generated
package module10_methods_and_parameters_ai.step05_parameters_are_copies_ai;

public class Challenge01Ai {
    /**
     * What does this program print? Trace it line by line and type each line.
     * Hints
     * 1. The method prints first, with its own copy changed to 15.
     * 2. {@code main}'s {@code number} was never changed: it's still 5.
     */
    public static void main(String[] args) {
        int number = 5;
        addTen(number);
        System.out.println(number);
    }

    public static void addTen(int number) {
        number = number + 10;
        System.out.println("Inside: " + number);
    }
}
