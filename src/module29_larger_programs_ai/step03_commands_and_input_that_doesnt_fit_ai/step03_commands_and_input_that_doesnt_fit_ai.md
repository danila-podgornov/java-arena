> [!info] AI-Generated

# Commands, and input that doesn't fit

The command programs of module 25 trusted their users. Real users mistype a command, ask for something that isn't there, or type `five` where a number should be. A program shouldn't crash then, and it shouldn't quietly do something wrong either: it should say what's wrong and wait for the next command. Three kinds of bad input come up in almost every command program:

| Bad input | Example | The answer |
| --- | --- | --- |
| An unknown command | `lend` | `Unknown command: lend` |
| A name that isn't there | `log`, then `Cleo`, who isn't a volunteer | `No volunteer called Cleo` |
| A number that isn't valid | `five`, or `40` hours in one shift | `Hours must be a whole number from 1 to 12` |

A food bank's volunteers log the hours they help out. The plan is step 1's: `Volunteer` for the data, `FoodBank` for the logic, and `UserInterface` for the commands, as in module 25. The volunteers are added in `main`, and the commands are:

- `log`, then a name and a number of hours: adds the hours to that volunteer. A shift is 1 to 12 hours.
- `total`: prints the hours of all the volunteers added up.
- `quit`: ends the program.

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodBank bank = new FoodBank();
        bank.add(new Volunteer("Ada"));
        bank.add(new Volunteer("Ben"));
        UserInterface ui = new UserInterface(scanner, bank);
        ui.start();
    }
}
```

**Volunteer.java**

```java
public class Volunteer {
    private String name;
    private int hours;

    public Volunteer(String name) {
        this.name = name;
        this.hours = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHours() {
        return this.hours;
    }

    public void addHours(int hours) {
        this.hours += hours;
    }

    public String toString() {
        return this.name + ": " + this.hours + " hours";
    }
}
```

**FoodBank.java**

```java
import java.util.ArrayList;

public class FoodBank {
    private ArrayList<Volunteer> volunteers;

    public FoodBank() {
        this.volunteers = new ArrayList<>();
    }

    public void add(Volunteer volunteer) {
        this.volunteers.add(volunteer);
    }

    public Volunteer find(String name) {
        for (Volunteer volunteer : this.volunteers) {
            if (volunteer.getName().equals(name)) {
                return volunteer;
            }
        }
        return null;
    }

    public int totalHours() {
        int total = 0;
        for (Volunteer volunteer : this.volunteers) {
            total += volunteer.getHours();
        }
        return total;
    }
}
```

**UserInterface.java**

```java
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private FoodBank bank;

    public UserInterface(Scanner scanner, FoodBank bank) {
        this.scanner = scanner;
        this.bank = bank;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Thank you!");
                break;
            }
            if (command.equals("log")) {
                String name = this.scanner.nextLine();
                int hours = this.toNumber(this.scanner.nextLine());
                Volunteer volunteer = this.bank.find(name);
                if (volunteer == null) {
                    System.out.println("No volunteer called " + name);
                } else if (hours < 1 || hours > 12) {
                    System.out.println("Hours must be a whole number from 1 to 12");
                } else {
                    volunteer.addHours(hours);
                    System.out.println(volunteer);
                }
            } else if (command.equals("total")) {
                System.out.println("Total: " + this.bank.totalHours() + " hours");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    private int toNumber(String text) {
        try {
            return Integer.valueOf(text);
        } catch (Exception e) {
            return -1;
        }
    }
}
```

**Input**

```text
log
Ada
4
log
Cleo
3
log
Ben
five
log
Ben
5
lend
total
quit
```

**Output**

```text
> Ada: 4 hours
> No volunteer called Cleo
> Hours must be a whole number from 1 to 12
> Ben: 5 hours
> Unknown command: lend
> Total: 9 hours
> Thank you!
```

Each kind of bad input has its own place:

- **An unknown command** falls through every `if` and `else if` to the last `else`. Without that `else`, a typo gets no answer at all.
- **A name that isn't there:** the logic class says so with its return value. `find` returns `null`, and the user interface turns that into a message. FoodBank still doesn't print anything.
- **A number that isn't valid:** turning typed text into a number is the user interface's job, so it checks the number too, before the logic gets it.

## Read the whole command first

`log` takes three lines: the command, the name and the hours. The user interface reads all of them **before** it checks anything. Suppose it checked the name first and skipped the rest of the command when the name was wrong. The hours, `3`, would still be waiting in the input, and the next round would read them as a command: `Unknown command: 3`. Every command reads the same number of lines, whatever is wrong with them.

## Is it a number?

`Integer.valueOf("five")` throws a NumberFormatException, and without a `catch` the program would crash. Module 20's `try` and `catch` turn the crash into an answer. The helper method `toNumber` returns the number, or `-1` when the text isn't a whole number:

```java
private int toNumber(String text) {
    try {
        return Integer.valueOf(text);
    } catch (Exception e) {
        return -1;
    }
}
```

- When `Integer.valueOf` succeeds, `return` hands the number back right away. When it throws, Java jumps to the `catch` block, and that returns `-1`.
- `-1` works as a signal because no valid number of hours is negative. The range check after it catches `-1` together with `0`, `40` and every other number outside 1 to 12, so one message covers them all.
- The method is `private` (module 18): it's a helper for the user interface itself, and no other class needs it.

---

Source: [Commands, and input that doesn't fit](https://javaarena.com/learn/larger-programs/commands-and-bad-input/) in the module [Larger programs](https://javaarena.com/learn/larger-programs/) on Java Arena.

This module follows sections [7.3 Larger programming exercises](https://java-programming.mooc.fi/part-7/3-larger-exercises), [7.4 Conclusion](https://java-programming.mooc.fi/part-7/4-java-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
