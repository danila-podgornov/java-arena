// AI-Generated
package module36_polymorphism_ai.step02_instanceof_and_casts_ai.challenge02_ai;

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
