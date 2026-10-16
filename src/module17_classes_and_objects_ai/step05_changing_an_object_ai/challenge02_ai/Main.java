// AI-Generated
package module17_classes_and_objects_ai.step05_changing_an_object_ai.challenge02_ai;

public class Main {
    /**
     * A {@code TrafficLight} shows {@code red}, {@code green} or {@code yellow}. Its constructor, which has no parameters, starts it at red. Write the method {@code next()}, which moves the light on: red turns green, green turns yellow, and yellow turns red again. The check runs:
     * <pre>{@code
     * TrafficLight light = new TrafficLight();
     * light.printColor();
     * light.next();
     * light.printColor();
     * light.next();
     * light.printColor();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * red
     * green
     * yellow
     * }</pre>
     * Hints
     * 1. Compare the current color with {@code equals}, then set the next one: {@code if (this.color.equals("red")) { this.color = "green"; }}.
     * 2. Use {@code else if} and {@code else}, so that one call changes the color only once. With three separate {@code if}s, a single call would go all the way round: the first {@code if} turns red into green, the second turns that green into yellow, and the third turns the yellow back into red.
     */
    public static void main(String[] args) {
        TrafficLight light = new TrafficLight();
        light.printColor();
        light.next();
        light.printColor();
        light.next();
        light.printColor();
    }
}
