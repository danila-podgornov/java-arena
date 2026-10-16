// AI-Generated
package module44_type_parameters_generics_ai.step04_generic_interfaces_ai.challenge03_ai;

public class Main {
    /**
     * To change an order, a person types its booking reference, which must pass several rules at once. {@code Rule.java}, {@code MinLength.java}, {@code NoSpaces.java} and {@code Between.java} are ready. In {@code AllOf.java}, write the class {@code AllOf<T>}, which implements {@code Rule<T>} and stays generic. It keeps its rules in an {@code ArrayList<Rule<T>>} (a {@code List<Rule<T>>} variable that holds an ArrayList is fine too), and has:
     * <ul>
     * <li>a constructor {@code AllOf()}, which starts with no rules
     * <li>{@code add(Rule<T> rule)}, which adds a rule
     * <li>{@code allows(T value)}, which allows a value only when every rule in the list allows it. With no rules, it allows everything.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * AllOf<String> reference = new AllOf<>();
     * reference.add(new MinLength(4));
     * reference.add(new NoSpaces());
     * System.out.println(reference.allows("K7Q") + " " + reference.allows("K7Q 22X") + " " + reference.allows("K7Q22X"));
     * AllOf<Integer> pin = new AllOf<>();
     * System.out.println(pin.allows(7));
     * pin.add(new Between(1000, 9999));
     * System.out.println(pin.allows(7) + " " + pin.allows(2468));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * false false true
     * true
     * false true
     * }</pre>
     * Hints
     * 1. The header is {@code public class AllOf<T> implements Rule<T>}, like OneOf's. The instance variable is {@code private ArrayList<Rule<T>> rules;}, and {@code add} takes a {@code Rule<T>}.
     * 2. {@code allows} goes through the rules with {@code for (Rule<T> rule : this.rules)}, and returns {@code false} as soon as one rule doesn't allow the value. After the loop, every rule has allowed it, so it returns {@code true}, which is also the answer when there are no rules.
     */
    public static void main(String[] args) {
        AllOf<String> reference = new AllOf<>();
        reference.add(new MinLength(4));
        reference.add(new NoSpaces());
        System.out.println(reference.allows("K7Q") + " " + reference.allows("K7Q 22X") + " " + reference.allows("K7Q22X"));
        AllOf<Integer> pin = new AllOf<>();
        System.out.println(pin.allows(7));
        pin.add(new Between(1000, 9999));
        System.out.println(pin.allows(7) + " " + pin.allows(2468));
    }
}
