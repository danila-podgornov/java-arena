// AI-Generated
package module36_polymorphism_ai.step04_choosing_a_design_and_the_end_of_part_9_ai.challenge01_ai;

public class Bat extends Enemy implements Flying {
    private int altitude;

    public Bat(String name, int altitude) {
        super(name, 8);
        this.altitude = altitude;
    }

    @Override
    public int altitude() {
        return this.altitude;
    }
}
