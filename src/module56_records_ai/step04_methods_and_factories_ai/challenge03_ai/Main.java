// AI-Generated
package module56_records_ai.step04_methods_and_factories_ai.challenge03_ai;

public class Main {
    /**
     * A timetable stores times of day as minutes after midnight, but shows them as hours and minutes. In {@code TimeOfDay.java}, add to the record {@code TimeOfDay(int hour, int minute)}:
     * <ul>
     * <li>a static factory {@code fromMinutes(int minutes)}, which makes the TimeOfDay that many minutes after midnight. It wraps around the day: 1440 minutes (24 hours) is midnight again, and -15 is 23:45;
     * <li>a static factory {@code midnight()}, which returns 00:00;
     * <li>{@code toMinutes()}, which returns how many minutes after midnight this time is;
     * <li>{@code plusMinutes(int minutes)}, which returns the time that many minutes later (or earlier, for a negative number), wrapping around the day too;
     * <li>{@code toString()}, which shows the time with two digits each, like {@code 08:05}.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * TimeOfDay departure = TimeOfDay.fromMinutes(485);
     * TimeOfDay delayed = departure.plusMinutes(70);
     * System.out.println(departure + " becomes " + delayed);
     * System.out.println(delayed.toMinutes() + " " + delayed.hour());
     * System.out.println(new TimeOfDay(23, 50).plusMinutes(25));
     * System.out.println(TimeOfDay.midnight().plusMinutes(-15));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 08:05 becomes 09:15
     * 555 9
     * 00:15
     * 23:45
     * }</pre>
     * Hints
     * 1. In {@code fromMinutes}, {@code minutes % 1440} wraps a time past midnight back into the day. For a negative number {@code %} gives a negative remainder (-15 % 1440 is -15), so add 1440 when it's below 0. Then the hour is {@code inDay / 60} and the minute {@code inDay % 60}.
     * 2. {@code toMinutes()} is {@code this.hour * 60 + this.minute}, and {@code plusMinutes} can reuse both: {@code return fromMinutes(this.toMinutes() + minutes);}. In {@code toString}, put a {@code "0"} in front of an hour or a minute under 10.
     */
    public static void main(String[] args) {
        TimeOfDay departure = TimeOfDay.fromMinutes(485);
        TimeOfDay delayed = departure.plusMinutes(70);
        System.out.println(departure + " becomes " + delayed);
        System.out.println(delayed.toMinutes() + " " + delayed.hour());
        System.out.println(new TimeOfDay(23, 50).plusMinutes(25));
        System.out.println(TimeOfDay.midnight().plusMinutes(-15));
    }
}
