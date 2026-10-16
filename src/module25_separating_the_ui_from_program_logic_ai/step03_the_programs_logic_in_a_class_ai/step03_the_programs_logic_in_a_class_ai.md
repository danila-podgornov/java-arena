> [!info] AI-Generated

# The program's logic in a class

The practice log's `main` does two jobs at once. It talks with the user: it prints the prompt, reads commands and prints answers. And it does the work: it keeps the sessions, adds them up and finds the longest. The two are woven together, and each new command makes the knot bigger. The first step toward untangling them is to move the work into a class of its own:

**Main.java**

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PracticeLog log = new PracticeLog();
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Keep practicing!");
                break;
            }
            if (command.equals("log")) {
                int minutes = Integer.valueOf(scanner.nextLine());
                log.add(minutes);
                System.out.println("Logged " + minutes + " minutes");
            } else if (command.equals("total")) {
                System.out.println("Total: " + log.total() + " minutes");
            } else if (command.equals("longest")) {
                System.out.println("Longest: " + log.longest() + " minutes");
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

The program does exactly what it did before, but the jobs are now apart:

- `PracticeLog` is the program's **logic**: what the program knows and works out. It keeps the sessions and answers questions about them with return values. It never reads input and never prints anything.
- `main` is the **user interface**, or UI: the part that talks with the user. It reads the commands, calls the log's methods, and turns their answers into sentences.
- The loop in `main` now reads like a list of the commands. How the total is added up is no longer its business: `log.total()` says what it needs.

## Why the split helps

- Each part can be read and changed on its own. To change what a message says, you look at the UI. To change how the longest session is found, you look at `PracticeLog`, and the UI doesn't care.
- The logic can be used without anyone typing anything: `PracticeLog log = new PracticeLog(); log.add(30); System.out.println(log.total());`. That's how the checks on this site test your classes, and module 26 builds on it.
- The same class could serve another kind of user interface, such as an app with buttons, without a change. That's why it returns numbers and doesn't print sentences: how an answer is shown is for the UI to decide.

A quick test for a logic class: could a program without a keyboard or a screen use it? If the class has a Scanner or a `System.out.println` in it, it couldn't.

---

Source: [The program's logic in a class](https://javaarena.com/learn/text-ui/logic-class/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
