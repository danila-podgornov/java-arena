// AI-Generated
package module40_class_diagrams_ai.step03_from_code_to_a_box_ai.challenge01_ai;

public class Pickup {
    private String address;
    private double kilos;
    private boolean done;

    public Pickup(String address, double kilos) {
        this.address = address;
        this.kilos = kilos;
        this.done = false;
    }

    public String getAddress() {
        return this.address;
    }

    public double getKilos() {
        return this.kilos;
    }

    public boolean isDone() {
        return this.done;
    }

    public void markDone() {
        this.done = true;
    }

    @Override
    public String toString() {
        return this.address + ": " + this.kilos + " kg";
    }
}
