// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge02_ai;

public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public abstract int monthlyPay();

    @Override
    public String toString() {
        return this.name + ": " + this.monthlyPay();
    }
}
