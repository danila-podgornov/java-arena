// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge02_ai;

import java.util.ArrayList;

public class Main {
    /**
     * A manager is a salaried employee with 400 a month on top of the salary. Sam logs his hours after he's been added to the list. What does this program print?
     * Hints
     * 1. The list holds a reference to the object {@code sam} refers to, not a copy, so the 50 hours logged afterwards count in the list too.
     * 2. Ines is a Manager: her {@code monthlyPay()} runs SalariedEmployee's version with {@code super.monthlyPay()}, a twelfth of 60000, and adds 400. Rosa gets a twelfth of 48000.
     */
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>();
        HourlyEmployee sam = new HourlyEmployee("Sam", 20);
        staff.add(sam);
        staff.add(new Manager("Ines", 60000));
        staff.add(new SalariedEmployee("Rosa", 48000));
        sam.logHours(50);

        int total = 0;
        for (Employee employee : staff) {
            total += employee.monthlyPay();
        }
        System.out.println(staff.get(0));
        System.out.println(staff.get(1));
        System.out.println(total);
    }
}
