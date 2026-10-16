// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge02_ai;

public class Manager extends SalariedEmployee {
    public Manager(String name, int yearlySalary) {
        super(name, yearlySalary);
    }

    @Override
    public int monthlyPay() {
        return super.monthlyPay() + 400;
    }
}
