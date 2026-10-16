// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge02_ai;

public class Vehicle {
    private String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public int toll() {
        return 3;
    }

    @Override
    public String toString() {
        return this.plate + " pays " + this.toll();
    }
}
