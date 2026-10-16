// AI-Generated
package module22_primitive_and_reference_variables_ai.step03_values_and_references_as_parameters_ai.challenge02_ai;

public class Main {
    /**
     * What does this program print? Watch which aquarium each {@code add} goes to.
     * Hints
     * 1. {@code stock} adds 3 fish to {@code main}'s aquarium through the reference, so it has 8. {@code fish = 0;} changes only the method's own copy of the number, so {@code main}'s {@code fish} is still 3.
     * 2. In {@code swapTank}, the first {@code tank.add(1)} still goes to {@code main}'s aquarium. After {@code tank = new Aquarium(20);} the parameter points at a new aquarium, and the second {@code add} goes there.
     */
    public static void main(String[] args) {
        int fish = 3;
        Aquarium tank = new Aquarium(5);
        stock(tank, fish);
        System.out.println(fish);
        System.out.println(tank);
        swapTank(tank);
        System.out.println(tank);
    }

    public static void stock(Aquarium tank, int fish) {
        tank.add(fish);
        fish = 0;
    }

    public static void swapTank(Aquarium tank) {
        tank.add(1);
        tank = new Aquarium(20);
        tank.add(1);
    }
}
