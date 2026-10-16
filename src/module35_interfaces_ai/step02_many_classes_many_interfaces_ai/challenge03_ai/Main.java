// AI-Generated
package module35_interfaces_ai.step02_many_classes_many_interfaces_ai.challenge03_ai;

public class Main {
    /**
     * The app can dim some lights. {@code CeilingLight} and {@code DeskLamp} both say {@code implements Dimmable}, and both have {@code @Override} above their methods {@code setBrightness} and {@code getBrightness}. But {@code Dimmable.java} is still empty, so nothing compiles. Write the interface {@code Dimmable}, with the two methods: {@code setBrightness}, which takes a percentage as an {@code int} and returns nothing, and {@code getBrightness}, which returns the percentage as an {@code int}. Don't change the classes. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * 70 50
     * 100 0
     * }</pre>
     * Hints
     * 1. An interface lists only headers, each followed by a semicolon. Copy each header from one of the classes, leave out {@code public} and the body, and end it with {@code ;}.
     * 2. The interface has two lines inside its braces: {@code void setBrightness(int percent);} and {@code int getBrightness();}.
     */
    public static void main(String[] args) {
        CeilingLight ceiling = new CeilingLight();
        DeskLamp lamp = new DeskLamp();
        ceiling.setBrightness(70);
        lamp.setBrightness(70);
        System.out.println(ceiling.getBrightness() + " " + lamp.getBrightness());
        ceiling.setBrightness(120);
        lamp.setBrightness(10);
        System.out.println(ceiling.getBrightness() + " " + lamp.getBrightness());
    }
}
