// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge01_ai;

import java.util.ArrayList;

public class Payroll {
    private ArrayList<Employee> employees;

    public Payroll() {
        this.employees = new ArrayList<>();
    }

    public void add(Employee employee) {
        this.employees.add(employee);
    }

    public int total() {
        int total = 0;
        for (Employee employee : this.employees) {
            total += employee.monthlyPay();
        }
        return total;
    }

    public void printSlips() {
        for (Employee employee : this.employees) {
            System.out.println(employee);
        }
        System.out.println("Total: " + this.total());
    }
}
