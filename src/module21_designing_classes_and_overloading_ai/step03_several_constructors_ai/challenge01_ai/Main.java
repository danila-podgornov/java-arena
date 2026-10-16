// AI-Generated
package module21_designing_classes_and_overloading_ai.step03_several_constructors_ai.challenge01_ai;

public class Main {
    /**
     * A library loan is usually for 14 days. {@code Loan.java} has a constructor that takes the book's title and the number of days. Add a second constructor, {@code Loan(String title)}, for a loan of 14 days. The check runs:
     * <pre>{@code
     * Loan usual = new Loan("Moby Dick");
     * Loan quick = new Loan("Atlas of Birds", 7);
     * System.out.println(usual);
     * System.out.println(quick);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Moby Dick, due in 14 days
     * Atlas of Birds, due in 7 days
     * }</pre>
     * Hints
     * 1. The new constructor has the same name and one parameter: <code>public Loan(String title) {</code>.
     * 2. It stores the title from the parameter, and the default for the days: {@code this.title = title;} and {@code this.days = 14;}.
     */
    public static void main(String[] args) {
        Loan usual = new Loan("Moby Dick");
        Loan quick = new Loan("Atlas of Birds", 7);
        System.out.println(usual);
        System.out.println(quick);
    }
}
