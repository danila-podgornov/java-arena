// AI-Generated
package module21_designing_classes_and_overloading_ai.step05_methods_with_the_same_name_ai.challenge01_ai;

public class Main {
    /**
     * An {@code Odometer} counts the kilometers a car has driven, and {@code add(int km)} adds a trip. Add a second method, {@code add(int hours, int speed)}, for a trip of {@code hours} hours at {@code speed} kilometers an hour. It adds {@code hours * speed} kilometers by calling {@code add(int km)}. The check runs:
     * <pre>{@code
     * Odometer odometer = new Odometer();
     * odometer.add(35);
     * odometer.add(2, 80);
     * System.out.println(odometer);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 195 km}
     * Hints
     * 1. The new method has the same name and two int parameters: <code>public void add(int hours, int speed) {</code>.
     * 2. It works out the kilometers and passes them on to the other {@code add}: {@code this.add(hours * speed);}.
     */
    public static void main(String[] args) {
        Odometer odometer = new Odometer();
        odometer.add(35);
        odometer.add(2, 80);
        System.out.println(odometer);
    }
}
