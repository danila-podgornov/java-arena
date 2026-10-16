// AI-Generated
package module18_getters_tostring_and_bigger_classes_ai.step01_methods_that_return_a_value_ai.challenge03_ai;

public class Main {
    /**
     * What does this program print? The water is in milliliters, and a cup is 250 of them.
     * Hints
     * 1. {@code kettle.cupsLeft();} on a line of its own returns 4, but nothing uses the value, so nothing is printed. The next line prints it.
     * 2. After pouring 300 ml, 700 ml is left, and {@code 700 / 250} is 2 in integer division. After pouring the other 700 ml, the water is 0.
     */
    public static void main(String[] args) {
        Kettle kettle = new Kettle(1000);
        kettle.cupsLeft();
        System.out.println(kettle.cupsLeft());
        kettle.pour(300);
        int cups = kettle.cupsLeft();
        System.out.println(cups + " cups");
        kettle.pour(700);
        System.out.println(kettle.isEmpty());
    }
}
