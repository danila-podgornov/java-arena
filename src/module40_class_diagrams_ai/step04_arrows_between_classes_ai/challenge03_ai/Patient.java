// AI-Generated
package module40_class_diagrams_ai.step04_arrows_between_classes_ai.challenge03_ai;

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

    @Override
    public String toString() {
        return this.name + ", room " + this.room + ", " + this.temperature + " degrees";
    }
}
