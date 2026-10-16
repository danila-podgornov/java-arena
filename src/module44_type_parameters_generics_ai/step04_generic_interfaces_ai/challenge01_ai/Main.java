// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge01_ai;

public class Main {
    /**
     * The form also asks for the buyer's age, which must be from 13 to 120. {@code Rule.java} is ready. In {@code Between.java}, write the class {@code Between}, which implements {@code Rule<Integer>}. Its constructor {@code Between(int min, int max)} takes the smallest and the largest value allowed, and {@code allows} allows a value from {@code min} to {@code max}, both included. The check runs:
     * <pre>{@code
     * Rule<Integer> age = new Between(13, 120);
     * System.out.println(age.allows(12) + " " + age.allows(13) + " " + age.allows(120) + " " + age.allows(121));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code false true true false}
     * Hints
     * 1. The header is {@code public class Between implements Rule<Integer>}. Keep {@code min} and {@code max} in two int instance variables.
     * 2. With T chosen as Integer, the method to write is {@code public boolean allows(Integer value)}, with {@code @Override} above it. {@code allows(int value)} wouldn't do: its parameter type isn't the interface's. The body is {@code return value >= this.min && value <= this.max;}.
     */
    public static void main(String[] args) {
        Rule<Integer> age = new Between(13, 120);
        System.out.println(age.allows(12) + " " + age.allows(13) + " " + age.allows(120) + " " + age.allows(121));
    }
}
