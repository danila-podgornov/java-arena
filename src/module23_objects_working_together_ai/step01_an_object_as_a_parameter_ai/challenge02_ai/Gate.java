// AI-Generated
package module23_objects_working_together_ai.step01_an_object_as_a_parameter_ai.challenge02_ai;

public class Gate {
    private String name;
    private int entries;

    public Gate(String name) {
        this.name = name;
        this.entries = 0;
    }

    public void enter(Passport passport) {
        passport.addStamp();
        this.entries++;
    }

    public String toString() {
        return this.name + ": " + this.entries + " entries";
    }
}
