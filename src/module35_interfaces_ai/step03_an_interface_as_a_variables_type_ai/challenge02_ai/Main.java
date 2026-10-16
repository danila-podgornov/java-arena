// AI-Generated
package module35_interfaces_ai.step03_an_interface_as_a_variables_type_ai.challenge02_ai;

public class Main {
    /**
     * Fill in the blank, a type, so that the program compiles. The one variable refers to a laptop first and to headphones later.
     * Hints
     * 1. A {@code Laptop} variable can't refer to headphones, and a {@code Headphones} variable can't refer to a laptop. What type do both classes share?
     * 2. Both classes implement {@code Chargeable}, and the program calls only Chargeable's methods on {@code gadget}.
     */
    public static void main(String[] args) {
        ___ gadget = new Laptop(30);
        gadget.charge(20);
        System.out.println(gadget.batteryPercent());
        gadget = new Headphones(30);
        gadget.charge(4);
        System.out.println(gadget.batteryPercent());
    }
}
