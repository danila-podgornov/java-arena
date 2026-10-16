> [!info] AI-Generated

# Remembering between commands

The info desk answers every command the same way, whatever came before it. Most programs have to remember something from one command to the next: a count, a total, the names typed so far. Variables do that, with one rule: a variable that must last from command to command is created **before** the loop. A variable created inside the loop's braces is made new in every round and forgotten at the end of it.

A musician logs practice sessions. `log` is followed by a line with the minutes practiced, `total` adds up all the sessions, and `longest` finds the longest one:

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> sessions = new ArrayList<>();
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Keep practicing!");
                break;
            }
            if (command.equals("log")) {
                int minutes = Integer.valueOf(scanner.nextLine());
                sessions.add(minutes);
                System.out.println("Logged " + minutes + " minutes");
            } else if (command.equals("total")) {
                int total = 0;
                for (int minutes : sessions) {
                    total = total + minutes;
                }
                System.out.println("Total: " + total + " minutes");
            } else if (command.equals("longest")) {
                int longest = 0;
                for (int minutes : sessions) {
                    if (minutes > longest) {
                        longest = minutes;
                    }
                }
                System.out.println("Longest: " + longest + " minutes");
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

- `sessions` is created before the loop, so every round adds to the same list, and `total` sees every session logged so far. Created inside the loop, it would start empty in every round, and `total` would always say 0 minutes.
- `log` reads the minutes from the line after the command, as the previous step described: `Integer.valueOf(scanner.nextLine())`.
- `total` and `longest` are created inside their own branches. They're only needed while that one answer is worked out, so they're worked out again from the list each time.

## Small solutions, put together

The program looks long, but each part of it is something you've written before:

1. Read commands until `quit`, and answer unknown ones: the loop of the previous step.
2. Remember each session: add it to a list.
3. Add up the values of a list.
4. Find the largest value of a list.

That's a good way into any bigger program: list the small problems it's made of, solve them one at a time, and try each one before going on. Here you could first write the loop with only `quit` and the unknown-command answer, then `log` and `total`, and `longest` last. Each piece stays small enough to check at a glance.

## What to remember

Remember what later commands need. A list of sessions is one way to do it. But `total` and `longest` could also be answered with two `int` variables, updated at every `log`, without keeping the sessions at all. A list is needed when a command needs every value again, for example to print all the sessions. Step 5 comes back to this choice.

---

Source: [Remembering between commands](https://javaarena.com/learn/text-ui/remembering/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
