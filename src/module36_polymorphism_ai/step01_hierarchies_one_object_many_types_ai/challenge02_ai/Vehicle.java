// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge02_ai;

public class Vehicle {
    private String plate;

    public Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return this.plate;
    }

    public int toll() {
        return 3;
    }

    @Override
    public String toString() {
        return this.plate + " pays " + this.toll();
    }
}
