// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge02_ai;

public class Passport {
    private String owner;
    private int stamps;

    public Passport(String owner) {
        this.owner = owner;
        this.stamps = 0;
    }

    public void addStamp() {
        this.stamps++;
    }

    public String toString() {
        return this.owner + ", stamps: " + this.stamps;
    }
}
