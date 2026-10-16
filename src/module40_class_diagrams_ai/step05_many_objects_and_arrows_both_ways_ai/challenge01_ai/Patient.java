// AI-Generated
package module40_class_diagrams_ai.step05_many_objects_and_arrows_both_ways_ai.challenge01_ai;

public class Patient {
    private String name;
    private int room;
    private double temperature;

    public Patient(String name, int room, double temperature) {
        this.name = name;
        this.room = room;
        this.temperature = temperature;
    }

    public String getName() {
        return this.name;
    }

    public double getTemperature() {
        return this.temperature;
    }

    @Override
    public String toString() {
        return this.name + ", room " + this.room + ", " + this.temperature + " degrees";
    }
}
