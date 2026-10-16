// AI-Generated
package module22_primitive_and_reference_variables_ai.step03_values_and_references_as_parameters_ai.challenge03_ai;

public class Main {
    /**
     * At the end of each day, {@code endOfDay} prints the day's steps and should set the step counter back to 0 for the next day. But the second day's total includes the first day's steps too. Fix {@code endOfDay}: {@code StepCounter} has a method for this. The program then prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Today: 6500 steps
     * Today: 3000 steps
     * }</pre>
     * Hints
     * 1. {@code counter = new StepCounter();} only points the parameter at a new counter. {@code main}'s variable still points at the old one, with all its steps.
     * 2. Reset the counter itself, through the parameter: replace that line with {@code counter.reset();}.
     */
    public static void main(String[] args) {
        StepCounter counter = new StepCounter();
        counter.walk(4000);
        counter.walk(2500);
        endOfDay(counter);
        counter.walk(3000);
        endOfDay(counter);
    }

    public static void endOfDay(StepCounter counter) {
        System.out.println("Today: " + counter.getSteps() + " steps");
        counter = new StepCounter();
    }
}
