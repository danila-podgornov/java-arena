// AI-Generated
package module56_records_ai.step01_declaring_a_record_ai.challenge02_ai;

public class Main {
    /**
     * A weather service keeps temperature readings, each with the station's name and the temperature in degrees Celsius. {@code Reading} is a record, in {@code Reading.java}. In {@code Main.java}, write the method {@code report(Reading reading)}, which prints one line: the station, a colon, the temperature, the word {@code degrees} and a comma, and then {@code below freezing} when it's under 0, {@code at freezing} when it's exactly 0, and {@code above freezing} otherwise. Read the values with the record's accessors. The check runs:
     * <pre>{@code
     * report(new Reading("Oulu", -4.5));
     * report(new Reading("Turku", 0.0));
     * report(new Reading("Helsinki", 3.2));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Oulu: -4.5 degrees, below freezing
     * Turku: 0.0 degrees, at freezing
     * Helsinki: 3.2 degrees, above freezing
     * }</pre>
     * Hints
     * 1. The accessors are {@code reading.station()} and {@code reading.celsius()}. They're methods, so they need the parentheses.
     * 2. Choose the words first with an if, else if and else on {@code reading.celsius()}, then print the line: {@code reading.station() + ": " + reading.celsius() + " degrees, " + feel}.
     */
    public static void main(String[] args) {
        report(new Reading("Oulu", -4.5));
        report(new Reading("Turku", 0.0));
        report(new Reading("Helsinki", 3.2));
    }

    public static void report(Reading reading) {

    }
}
