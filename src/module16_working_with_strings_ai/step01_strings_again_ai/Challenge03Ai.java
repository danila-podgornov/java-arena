// AI-Generated
package module16_working_with_strings_ai.step01_strings_again_ai;

public class Challenge03Ai {
    /**
     * What does this program print? Watch which results are kept.
     * Hints
     * 1. {@code city.toUpperCase();} on a line of its own makes a new string and throws it away, so {@code city} is still {@code Lima}.
     * 2. After {@code city = city.toUpperCase();} the variable holds {@code LIMA}. On the last line, the number 4 is joined to the text {@code lima}.
     */
    public static void main(String[] args) {
        String city = "Lima";
        city.toUpperCase();
        System.out.println(city);
        city = city.toUpperCase();
        System.out.println(city);
        System.out.println(city.length() + city.toLowerCase());
    }
}
