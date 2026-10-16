// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge02_ai;

public class SalariedEmployee extends Employee {
    private int yearlySalary;

    public SalariedEmployee(String name, int yearlySalary) {
        super(name);
        this.yearlySalary = yearlySalary;
    }

    @Override
    public int monthlyPay() {
        return this.yearlySalary / 12;
    }
}
