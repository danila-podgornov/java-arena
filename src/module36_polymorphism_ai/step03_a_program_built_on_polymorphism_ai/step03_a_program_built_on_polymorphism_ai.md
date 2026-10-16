> [!info] AI-Generated

# A program built on polymorphism

Steps 1 and 2 looked at the types an object has, what a variable of each type lets you call, and how to check for a type with `instanceof` and cast to it. This step builds a small program around the idea that makes polymorphism worth having: code that works with one general type, and objects that each do their own thing.

## A payroll

A company pays its staff every month, but not all in the same way. A salaried employee gets a twelfth of a yearly salary. An hourly employee gets an hourly rate times the hours logged. `Employee` is an abstract class that knows the name and leaves the pay to each kind of employee, and `Payroll` keeps them all in one list:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Payroll payroll = new Payroll();
        payroll.add(new SalariedEmployee("Rosa", 54000));

        HourlyEmployee sam = new HourlyEmployee("Sam", 22);
        sam.logHours(80);
        sam.logHours(35);
        payroll.add(sam);

        payroll.add(new SalariedEmployee("Omar", 61200));
        payroll.printSlips();
    }
}
```

**Employee.java**

```java
public abstract class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract int monthlyPay();

    @Override
    public String toString() {
        return this.name + ": " + this.monthlyPay();
    }
}
```

**SalariedEmployee.java**

```java
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
```

**HourlyEmployee.java**

```java
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
```

**Payroll.java**

```java
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
```

**Output**

```text
Rosa: 4500
Sam: 2530
Omar: 5100
Total: 12130
```

- Payroll knows only Employee. `add` takes an Employee, the list is an `ArrayList<Employee>`, and `total` calls `monthlyPay()` on each. It never asks which kind of employee it has.
- Each kind brings its own `monthlyPay()`. Employee's `toString` calls `this.monthlyPay()`, and the object's own version runs, so each slip shows the right pay.
- `sam` is an HourlyEmployee variable, because `main` needs `logHours`, which only hourly employees have. Handed to `add`, the same object is just an Employee to the payroll. Each part of the program uses the type that has what it needs, and no more.
- `monthlyPay()` is abstract, since there's no pay for "an employee" in general. javac won't compile a class that extends Employee without one, unless that class is abstract too. A class further down, such as one that extends SalariedEmployee, can use the version it inherits.

## A new kind of employee

The company takes on interns, who get a fixed 900 a month. That's one new class:

```java
public class Intern extends Employee {
    public Intern(String name) {
        super(name);
    }

    @Override
    public int monthlyPay() {
        return 900;
    }
}
```

And that's the whole change. Payroll isn't touched: with `payroll.add(new Intern("Kai"));` in `main`, the slips get a line `Kai: 900`, and the total grows by 900. Payroll was written before interns existed, and it works with them, as it will with every class that extends Employee.

## Without polymorphism

Compare a Payroll that works out the pay itself with `instanceof` (with getters for each kind's numbers):

```java
public int total() {
    int total = 0;
    for (Employee employee : this.employees) {
        if (employee instanceof SalariedEmployee) {
            SalariedEmployee salaried = (SalariedEmployee) employee;
            total += salaried.getYearlySalary() / 12;
        } else if (employee instanceof HourlyEmployee) {
            HourlyEmployee hourly = (HourlyEmployee) employee;
            total += hourly.getHourlyRate() * hourly.getHours();
        }
    }
    return total;
}
```

- The pay rules have moved out of the classes they belong to, into Payroll.
- Interns need another `else if`, here and in every other method that works out pay. Forget one, and interns quietly get 0.
- With a `monthlyPay()` in each class, each rule lives next to its own data, and a new kind of employee is one new class.

## A list of an interface type

The general type can just as well be an interface. A notification service sends emails, text messages and app alerts. They have nothing in common but being sent, so they share an interface, and no superclass other than Object:

```java
public interface Notification {
    String deliver();
}
```

An `ArrayList<Notification>` can hold all of them, and a loop can call `deliver()` on each, which returns the message as that kind sends it. The last task of this step builds that.

---

Source: [A program built on polymorphism](https://javaarena.com/learn/polymorphism/one-list-many-kinds/) in the module [Polymorphism](https://javaarena.com/learn/polymorphism/) on Java Arena.

This module follows sections [9.3 Object polymorphism](https://java-programming.mooc.fi/part-9/3-object-polymorphism), [9.4 Summary](https://java-programming.mooc.fi/part-9/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
