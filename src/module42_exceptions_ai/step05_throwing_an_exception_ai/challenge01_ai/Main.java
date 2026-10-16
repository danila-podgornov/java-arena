// AI-Generated
package module42_exceptions_ai.step05_throwing_an_exception_ai.challenge01_ai;

public class Main {
    /**
     * An oven can be set from 50 to 250 degrees. In {@code Oven.java}, write the class {@code Oven} with:
     * <ul>
     * <li>a constructor {@code Oven(int degrees)}
     * <li>{@code setDegrees(int degrees)}, which changes the setting
     * <li>{@code getDegrees()}, which returns it
     * </ul>
     * <p>The constructor and {@code setDegrees} both refuse a temperature below 50 or above 250 with an IllegalArgumentException whose message is {@code No oven setting for 300 degrees}, with the refused value in it. A refused {@code setDegrees} keeps the old setting. The check runs:
     * <pre>{@code
     * Oven oven = new Oven(180);
     * try {
     *     oven.setDegrees(300);
     * } catch (IllegalArgumentException e) {
     *     System.out.println(e.getMessage());
     * }
     * System.out.println(oven.getDegrees());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * No oven setting for 300 degrees
     * 180
     * }</pre>
     * Hints
     * 1. The constructor and {@code setDegrees} both start with a check, as Transfer's constructor does: when the value is below 50 or above 250, throw an IllegalArgumentException before anything is set.
     * 2. The check is {@code if (degrees < 50 || degrees > 250) { throw new IllegalArgumentException("No oven setting for " + degrees + " degrees"); }}. Set {@code this.degrees} only after it: when it throws, the method stops and the old setting stays.
     */
    public static void main(String[] args) {
        Oven oven = new Oven(180);
        try {
            oven.setDegrees(300);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(oven.getDegrees());
    }
}
