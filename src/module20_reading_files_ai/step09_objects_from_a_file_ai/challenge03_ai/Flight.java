// AI-Generated
package module20_reading_files_ai.step09_objects_from_a_file_ai.challenge03_ai;

public class Flight {
    private String code;
    private int delay;

    public Flight(String code, int delay) {
        this.code = code;
        this.delay = delay;
    }

    public String getCode() {
        return this.code;
    }

    public int getDelay() {
        return this.delay;
    }

    public String toString() {
        return this.code + " (" + this.delay + " min late)";
    }
}
