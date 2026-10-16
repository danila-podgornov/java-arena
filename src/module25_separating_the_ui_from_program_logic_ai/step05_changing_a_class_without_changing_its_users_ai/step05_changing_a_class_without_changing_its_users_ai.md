> [!info] AI-Generated

# Changing a class without changing its users

The practice log only ever answers two questions: the total and the longest session. For that, it doesn't need to keep every session. Two `int` variables, updated at every `add`, are enough, and they take as little memory after a thousand sessions as after one. Here's `PracticeLog` rewritten that way, with `Main` and `UserInterface` exactly as they were:

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

    public PracticeLog() {
        this.totalMinutes = 0;
        this.longestSession = 0;
    }

    public void add(int minutes) {
        this.totalMinutes = this.totalMinutes + minutes;
        if (minutes > this.longestSession) {
            this.longestSession = minutes;
        }
    }

    public int total() {
        return this.totalMinutes;
    }

    public int longest() {
        return this.longestSession;
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
25
log
40
total
log
15
longest
quit
```

**Output**

```text
> Logged 25 minutes
> Logged 40 minutes
> Total: 65 minutes
> Logged 15 minutes
> Longest: 40 minutes
> Keep practicing!
```

- `PracticeLog` has no list any more. `add` adds the minutes to the total, and when the new session is longer than the longest so far, it becomes the longest.
- Its public methods are the same as before: `add(int minutes)`, `total()` and `longest()`, with the same parameters, the same return types and the same answers. Those methods are all the user interface ever uses, so it didn't need a single change, and the program prints what it did.
- The instance variables are `private`, so no other class could have used the old list. That's what `private` is for: whatever is private can change without breaking anything outside the class.

## What must stay the same

The public methods are a promise to the rest of the program: this is what you can call, this is what it takes, and this is what it gives back. Everything inside may change: the instance variables, how an answer is worked out, the private methods. The promise breaks when a public method's name, parameters or return type change, or when its answers change meaning, for example if `total()` suddenly returned hours instead of minutes. Then every class that uses it has to change too.

A change inside has to give the same answers as before in every case, the unusual ones included. The new `longestSession` starts from 0, just as the old loop did, so even a log without any sessions answers the same, 0. That's easy to get wrong, as this step's last challenge shows.

Another change of this kind makes a class safer rather than smaller. A class that keeps two lists which must stay in step, such as the names of things in one list and their weights in another, is easy to break: remove from one list and forget the other, and every name after it gets the wrong weight. One list of objects, each with a name and a weight, can't get out of step. As long as the public methods stay the same, the class's users don't need to know about that change either.

---

Source: [Changing a class without changing its users](https://javaarena.com/learn/text-ui/changing-the-inside/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
