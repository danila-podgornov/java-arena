// AI-Generated
package module21_designing_classes_and_overloading_ai.step05_methods_with_the_same_name_ai.challenge03_ai;

public class Main {
    /**
     * An {@code Alarm} is set with {@code set(int hours, int minutes)}. Add a second {@code set} method, {@code set(String time)}, that takes the time as text, like {@code "6:45"}: split it at the {@code :}, turn both parts into numbers, and call {@code set(int hours, int minutes)} with them. The check runs:
     * <pre>{@code
     * Alarm alarm = new Alarm();
     * alarm.set(7, 30);
     * System.out.println(alarm);
     * alarm.set("6:05");
     * System.out.println(alarm);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Alarm at 7:30
     * Alarm at 6:05
     * }</pre>
     * Hints
     * 1. The header is <code>public void set(String time) {</code>. Inside it, {@code String[] parts = time.split(":");} gives the hours in {@code parts[0]} and the minutes in {@code parts[1]}, as text.
     * 2. {@code Integer.valueOf} turns each part into a number ({@code "05"} becomes 5). Then {@code this.set(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));} runs the other {@code set}.
     */
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        alarm.set(7, 30);
        System.out.println(alarm);
        alarm.set("6:05");
        System.out.println(alarm);
    }
}
