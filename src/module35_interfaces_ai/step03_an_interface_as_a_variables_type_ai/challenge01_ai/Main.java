// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge01_ai;

public class Main {
    /**
     * Step 2's laptop and headphones again: the laptop gains 1 percent a minute, the headphones 5, and neither goes above 100. What does this program print?
     * Hints
     * 1. {@code gadget} first refers to a Laptop, so the Laptop's {@code charge} runs. Later, {@code gadget = headphones;} doesn't copy anything.
     * 2. The Laptop gains 1 percent a minute: 20 plus 30 is 50. After {@code gadget = headphones;}, both variables refer to the same Headphones object, and the Headphones' {@code charge} runs. 10 plus 5 times 4 is 30, whichever variable you ask.
     */
    public static void main(String[] args) {
        Chargeable gadget = new Laptop(20);
        gadget.charge(30);
        System.out.println(gadget.batteryPercent());

        Headphones headphones = new Headphones(10);
        gadget = headphones;
        gadget.charge(4);
        System.out.println(gadget.batteryPercent() + " " + headphones.batteryPercent());
    }
}
