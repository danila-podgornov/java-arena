// AI-Generated
package module35_interfaces_ai.step01_an_interface_a_promise_of_methods_ai.challenge01_ai;

public class Main {
    /**
     * The garden sprinkler joins the app. {@code Switchable.java} is ready. In {@code Sprinkler.java}, write the class {@code Sprinkler}, which implements Switchable, with:
     * <ul>
     * <li>a constructor {@code Sprinkler(String zone)}; a new sprinkler is off
     * <li>{@code turnOn()}, {@code turnOff()} and {@code isOn()}, each with {@code @Override} above it
     * <li>{@code toString()}, which returns {@code Sprinkler (front lawn): on} or {@code Sprinkler (front lawn): off}, with the sprinkler's own zone
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * Sprinkler sprinkler = new Sprinkler("front lawn");
     * System.out.println(sprinkler);
     * sprinkler.turnOn();
     * System.out.println(sprinkler.isOn());
     * System.out.println(sprinkler);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Sprinkler (front lawn): off
     * true
     * Sprinkler (front lawn): on
     * }</pre>
     * Hints
     * 1. Start with <code>public class Sprinkler implements Switchable {</code>, and give the class two instance variables: the zone, and a boolean that says whether the sprinkler is on.
     * 2. Each of the three methods is {@code public}, with {@code @Override} above it: {@code turnOn} sets the boolean to {@code true}, {@code turnOff} sets it to {@code false}, and {@code isOn} returns it. {@code toString} returns one text or the other, depending on the boolean.
     */
    public static void main(String[] args) {
        Sprinkler sprinkler = new Sprinkler("front lawn");
        System.out.println(sprinkler);
        sprinkler.turnOn();
        System.out.println(sprinkler.isOn());
        System.out.println(sprinkler);
    }
}
