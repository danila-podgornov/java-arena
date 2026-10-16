// AI-Generated
package module36_polymorphism_ai.step03_a_program_built_on_polymorphism_ai.challenge01_ai;

public class Main {
    /**
     * The company also has salespeople. A salesperson gets 1800 a month, plus 5 percent of the month's sales, rounded down as integer division does. {@code Employee.java}, {@code SalariedEmployee.java} and {@code Payroll.java} are the lesson's. In {@code SalesEmployee.java}, write the class {@code SalesEmployee}, which extends Employee, with:
     * <ul>
     * <li>a constructor {@code SalesEmployee(String name)}; a new salesperson has sold nothing yet
     * <li>{@code recordSale(int amount)}, which adds a sale to the month's sales
     * <li>{@code monthlyPay()}, overridden to return 1800 plus 5 percent of the sales
     * </ul>
     * <p>Don't change Payroll: it already works with every kind of employee. The check runs:
     * <pre>{@code
     * Payroll payroll = new Payroll();
     * SalesEmployee lin = new SalesEmployee("Lin");
     * lin.recordSale(12000);
     * lin.recordSale(4500);
     * payroll.add(new SalariedEmployee("Rosa", 54000));
     * payroll.add(lin);
     * payroll.printSlips();
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Rosa: 4500
     * Lin: 2625
     * Total: 7125
     * }</pre>
     * Hints
     * 1. Start like HourlyEmployee: <code>public class SalesEmployee extends Employee {</code>, a private {@code int sales}, and a constructor that hands the name on with {@code super(name);} and sets the sales to 0. {@code recordSale} adds the amount to the sales.
     * 2. Override {@code monthlyPay()} with {@code @Override}, and return {@code 1800 + this.sales * 5 / 100}. Multiply before dividing: {@code this.sales / 100 * 5} would lose the part under 100.
     */
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        SalesEmployee lin = new SalesEmployee("Lin");
        lin.recordSale(12000);
        lin.recordSale(4500);
        payroll.add(new SalariedEmployee("Rosa", 54000));
        payroll.add(lin);
        payroll.printSlips();
    }
}
