// AI-Generated
package module17_classes_and_objects_ai.step02_writing_a_class_ai.challenge03_ai;

public class Main {
    /**
     * {@code Thermostat.java} works, but its indentation is a mess. Re-indent it: everything inside the class one level in (4 spaces), and the lines inside the constructor and the method one level more. In this challenge, <b>Check</b> also checks the indentation. The program prints: see the expected output below.
     * Expected output
     * {@code Bedroom: 19 degrees}
     * Hints
     * 1. The two variables and the two headers ({@code public Thermostat(...)} and {@code public void printSetting()}) are one level in: 4 spaces. The lines inside them are two levels in: 8 spaces.
     * 2. Each closing <code>}</code> lines up with the start of the line that opened its block. The class's last <code>}</code> has no spaces before it.
     */
    public static void main(String[] args) {
        Thermostat bedroom = new Thermostat("Bedroom", 19);
        bedroom.printSetting();
    }
}
