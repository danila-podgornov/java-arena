// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step02_extends_a_class_built_on_another_ai.challenge03_ai;

public class Main {
    /**
     * The school's trumpets and flutes were written before anyone thought of inheritance, so {@code Trumpet} and {@code Flute} both have the same code for the minutes played. Move that code into {@code Instrument}: its variable {@code minutesPlayed} and its methods {@code practice} and {@code getMinutesPlayed}. Then make Trumpet and Flute extend Instrument, and keep only their own things in them: the valve oilings in Trumpet, the cleanings in Flute. {@code practice} and {@code getMinutesPlayed} should be written only once, in Instrument. The program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Trumpet: 25 minutes, oiled 2 times
     * Flute: 55 minutes, cleaned 2 times
     * }</pre>
     * Hints
     * 1. Cut {@code minutesPlayed}, {@code practice} and {@code getMinutesPlayed} out of Trumpet, paste them into Instrument, and delete them from Flute too.
     * 2. Then change the headers to {@code public class Trumpet extends Instrument} and {@code public class Flute extends Instrument}. Main doesn't change: trumpets and flutes still have {@code practice}, now inherited.
     */
    public static void main(String[] args) {
        Trumpet trumpet = new Trumpet();
        trumpet.practice(25);
        trumpet.oilValves();
        trumpet.oilValves();
        Flute flute = new Flute();
        flute.practice(40);
        flute.practice(15);
        flute.clean();
        flute.clean();
        System.out.println("Trumpet: " + trumpet.getMinutesPlayed() + " minutes, oiled " + trumpet.getValveOilings() + " times");
        System.out.println("Flute: " + flute.getMinutesPlayed() + " minutes, cleaned " + flute.getCleanings() + " times");
    }
}
