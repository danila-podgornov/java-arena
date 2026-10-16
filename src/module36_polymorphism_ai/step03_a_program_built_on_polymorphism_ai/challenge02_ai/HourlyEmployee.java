// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge02_ai;

public class HourlyEmployee extends Employee {
    private int hourlyRate;
    private int hours;

    public HourlyEmployee(String name, int hourlyRate) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = 0;
    }

    public void logHours(int hours) {
        this.hours += hours;
    }

    @Override
    public int monthlyPay() {
        return this.hourlyRate * this.hours;
    }
}
