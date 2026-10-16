> [!info] AI-Generated

# A class for the user interface

The logic of the practice log is now in `PracticeLog`, but `main` still holds the whole user interface: the loop, the reading and the printing. The next move gives the user interface a class of its own too, called `UserInterface`. Its constructor takes the two things it works with, a Scanner and the logic object, and its method `start()` runs the command loop. What's left of `main` only puts the program together:

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

**PracticeLog.java**

```java
import java.util.ArrayList;

public class PracticeLog {
    private ArrayList<Integer> sessions;

    public PracticeLog() {
        this.sessions = new ArrayList<>();
    }

    public void add(int minutes) {
        this.sessions.add(minutes);
    }

    public int total() {
        int total = 0;
        for (int minutes : this.sessions) {
            total = total + minutes;
        }
        return total;
    }

    public int longest() {
        int longest = 0;
        for (int minutes : this.sessions) {
            if (minutes > longest) {
                longest = minutes;
            }
        }
        return longest;
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

- `UserInterface` keeps the Scanner and the log in instance variables. The constructor gets them as parameters, and from then on every method of the class can use them as `this.scanner` and `this.log`.
- `start()` holds the loop that used to be in `main`. It returns when the user quits, and then `main` ends too.
- `main` creates the objects, gives the user interface what it needs, and starts it. It's four lines long, and it stays that short however many commands the program gets.
- `PracticeLog` didn't change at all. It never knew who was calling it.

## Why the Scanner is a parameter

The user interface could create a Scanner of its own. It's given one instead, for two reasons:

- A program should have only one Scanner reading `System.in`. A Scanner reads the input in chunks: to give you one line, it may take in more of what's waiting, and keep the rest for its next calls. A second Scanner on `System.in` would never see what the first one took in, so it could miss lines.
- The user interface then works with any Scanner. As module 20 showed, a Scanner can read a String, so the whole program can run from commands written in the code, without anyone typing:

```java
PracticeLog log = new PracticeLog();
UserInterface ui = new UserInterface(new Scanner("log\n30\nlog\n45\nquit\n"), log);
ui.start();
System.out.println(log.total());
```

This runs `log` twice and then `quit`, so it prints the three answers, and then `75`. The log was created outside the user interface and handed to it, so `log` here and `this.log` in the user interface refer to the same PracticeLog object. That's why the code that created it can still ask it for the total after `start()` has returned. Some of the hidden checks in this module run your user interface in this way.

---

Source: [A class for the user interface](https://javaarena.com/learn/text-ui/user-interface-class/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
