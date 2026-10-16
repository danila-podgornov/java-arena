> [!info] AI-Generated

# Adding a feature

Programs grow. A musician using the practice log would like to know the length of an average session, and a new user would like to see which commands there are. With the logic and the user interface apart, each part of a new feature has a clear place:

- What the program must know or work out goes into the logic class: new instance variables, new methods.
- The new command, and the sentence it prints, go into the user interface: one more `else if`.

For `average`, the log needs the number of sessions, which it doesn't keep yet. So it gets one more instance variable, counted up in `add`, and a new method that divides. For `help`, nothing needs working out, so it only changes the user interface. The lines marked `// new`, and the whole `average` method, are all that changed:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PracticeLog log = new PracticeLog();
        UserInterface ui = new UserInterface(scanner, log);
        ui.start();
    }
}
```

**PracticeLog.java**

```java
public class PracticeLog {
    private int totalMinutes;
    private int longestSession;
    private int sessions; // new

    public PracticeLog() {
        this.totalMinutes = 0;
        this.longestSession = 0;
        this.sessions = 0; // new
    }

    public void add(int minutes) {
        this.totalMinutes = this.totalMinutes + minutes;
        if (minutes > this.longestSession) {
            this.longestSession = minutes;
        }
        this.sessions++; // new
    }

    public int total() {
        return this.totalMinutes;
    }

    public int longest() {
        return this.longestSession;
    }

    public double average() { // new
        if (this.sessions == 0) {
            return 0;
        }
        return (double) this.totalMinutes / this.sessions;
    }
}
```

**UserInterface.java**

```java
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;
    private PracticeLog log;

    public UserInterface(Scanner scanner, PracticeLog log) {
        this.scanner = scanner;
        this.log = log;
    }

    public void start() {
        while (true) {
            System.out.print("> ");
            String command = this.scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Keep practicing!");
                break;
            }
            if (command.equals("log")) {
                int minutes = Integer.valueOf(this.scanner.nextLine());
                this.log.add(minutes);
                System.out.println("Logged " + minutes + " minutes");
            } else if (command.equals("total")) {
                System.out.println("Total: " + this.log.total() + " minutes");
            } else if (command.equals("longest")) {
                System.out.println("Longest: " + this.log.longest() + " minutes");
            } else if (command.equals("average")) { // new
                System.out.println("Average: " + this.log.average() + " minutes"); // new
            } else if (command.equals("help")) { // new
                System.out.println("Commands: log, total, longest, average, help, quit"); // new
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
```

**Input**

```text
log
30
log
45
average
help
quit
```

**Output**

```text
> Logged 30 minutes
> Logged 45 minutes
> Average: 37.5 minutes
> Commands: log, total, longest, average, help, quit
> Keep practicing!
```

- `average()` returns a `double`, and the cast `(double)` makes the division keep its decimals, as module 4 showed. With no sessions yet, it returns 0 instead of dividing by 0.
- `average()` returns a number, and that's all. The words `Average:` and `minutes` are the user interface's business, just like the words around the total.
- `help` changed only the user interface. A feature that only changes what is shown, such as a new message or a list of the commands, stays in the user interface. `Main` didn't change at all.

## Try the logic first

When a feature needs new logic, write the method first, and try it with a few calls before any command uses it: `log.add(30); log.add(45); System.out.println(log.average());` should print `37.5`. When it gives the right answers, the user interface only has to call it and print the result. If something is then wrong, you know where to look.

---

Source: [Adding a feature](https://javaarena.com/learn/text-ui/adding-a-feature/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
