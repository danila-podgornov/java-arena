// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step02_extends_a_class_built_on_another_ai.challenge01_ai;

public class Main {
    /**
     * The school also lends pianos, and a piano needs tuning after every 60 minutes of playing. {@code Instrument.java} is ready. In {@code Piano.java}, write the class {@code Piano}, which extends Instrument and adds two methods:
     * <ul>
     * <li>{@code tune()}, which remembers how many minutes the piano had been played when it was tuned
     * <li>{@code needsTuning()}, which returns {@code true} when the piano has been played for at least 60 minutes since it was last tuned. A new piano counts as just tuned.
     * </ul>
     * <p>Use the inherited {@code getMinutesPlayed()}. The check runs:
     * <pre>{@code
     * Piano piano = new Piano();
     * piano.practice(45);
     * System.out.println(piano.needsTuning());
     * piano.practice(30);
     * System.out.println(piano.needsTuning());
     * piano.tune();
     * System.out.println(piano.needsTuning());
     * System.out.println(piano.getMinutesPlayed());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * false
     * true
     * false
     * 75
     * }</pre>
     * Hints
     * 1. Start with <code>public class Piano extends Instrument {</code>. Piano needs one variable of its own: the minutes played at the last tuning, which starts at 0 like any int instance variable.
     * 2. {@code tune()} stores {@code this.getMinutesPlayed()} in that variable. {@code needsTuning()} returns {@code this.getMinutesPlayed() - this.minutesAtTuning >= 60}.
     */
    public static void main(String[] args) {
        Piano piano = new Piano();
        piano.practice(45);
        System.out.println(piano.needsTuning());
        piano.practice(30);
        System.out.println(piano.needsTuning());
        piano.tune();
        System.out.println(piano.needsTuning());
        System.out.println(piano.getMinutesPlayed());
    }
}
