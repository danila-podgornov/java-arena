// AI-Generated
package module36_polymorphism_ai.step01_hierarchies_one_object_many_types_ai.challenge01_ai;

public class Taxi extends Car implements Commercial {
    private String company;

    public Taxi(String plate, String company) {
        super(plate);
        this.company = company;
    }

    @Override
    public int toll() {
        return super.toll() - 2;
    }

    @Override
    public String company() {
        return this.company;
    }
}
