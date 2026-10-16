// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step04_parameters_and_this_ai.challenge02_ai;

public class Main {
    /**
     * The volume of a {@code Speaker} goes from 0 to 10. Add a method {@code setLevel(int level)} that sets the volume. A level above 10 sets it to 10, and a level below 0 sets it to 0. The check sets the levels 7, 15 and -2, and prints the volume after each: see the expected output below.
     * Expected output
     * <pre>{@code
     * 7
     * 10
     * 0
     * }</pre>
     * Hints
     * 1. The parameter is called {@code level}, like the instance variable, so the object's own one is {@code this.level}.
     * 2. Check the limits first: {@code if (level > 10) { this.level = 10; } else if (level < 0) { this.level = 0; } else { this.level = level; }}
     */
    public static void main(String[] args) {
        Speaker speaker = new Speaker();
        speaker.setLevel(7);
        System.out.println("Volume: " + speaker.getLevel());
    }
}
