// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge02_ai;

public class TankerTruck extends Truck {
    public TankerTruck(String plate, String company, int axles) {
        super(plate, company, axles);
    }

    @Override
    public int toll() {
        return super.toll() + 10;
    }
}
