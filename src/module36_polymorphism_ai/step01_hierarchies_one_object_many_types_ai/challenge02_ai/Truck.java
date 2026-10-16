// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge02_ai;

public class Truck extends Vehicle implements Commercial {
    private String company;
    private int axles;

    public Truck(String plate, String company, int axles) {
        super(plate);
        this.company = company;
        this.axles = axles;
    }

    @Override
    public int toll() {
        return 5 * this.axles;
    }

    @Override
    public String company() {
        return this.company;
    }
}
