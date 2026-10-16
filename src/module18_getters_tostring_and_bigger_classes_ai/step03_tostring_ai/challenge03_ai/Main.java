// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step03_tostring_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? Watch when each {@code toString} call happens.
     * Hints
     * 1. {@code "Was at " + oven} calls {@code toString} right there, while the oven is at 180 degrees. The String stored in {@code note} doesn't change when the oven does.
     * 2. The first line is printed before any heating, and the last one after {@code turnOff()}: both times {@code toString} returns {@code off}.
     */
    public static void main(String[] args) {
        Oven oven = new Oven();
        System.out.println(oven);
        oven.heat(100);
        oven.heat(80);
        String note = "Was at " + oven;
        oven.turnOff();
        System.out.println(note);
        System.out.println("Now " + oven);
    }
}
