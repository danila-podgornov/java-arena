// AI-Generated
package module29_larger_programs_ai.step04_questions_about_a_file_of_records_ai.challenge03_ai;

public class Day {
    private String date;
    private int rain;
    private int temperature;

    public Day(String date, int rain, int temperature) {
        this.date = date;
        this.rain = rain;
        this.temperature = temperature;
    }

    public int getRain() {
        return this.rain;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public String toString() {
        return this.date + " (" + this.temperature + " degrees, " + this.rain + " mm)";
    }
}
