// AI-Generated
package module23_objects_working_together_ai.step04_equal_objects_ai.challenge03_ai;

public class LicensePlate {
    private String code;

    public LicensePlate(String code) {
        this.code = code;
    }

    public boolean equals(Object compared) {
        LicensePlate other = (LicensePlate) compared;
        return this.code == other.code;
    }

    public String toString() {
        return this.code;
    }
}
