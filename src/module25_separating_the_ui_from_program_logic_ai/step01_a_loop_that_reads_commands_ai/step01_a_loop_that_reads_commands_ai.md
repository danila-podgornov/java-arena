> [!info] AI-Generated

# A loop that reads commands

Many programs work like a conversation: the user types a command, the program answers, and then it waits for the next command, until the user types the one that ends it. The shopping list at the end of module 14 was one of them. This module is about writing such programs so that they stay easy to read and to change as they grow. It starts with everything in `main`, and then splits the program into a class that does the work and a class that talks with the user.

Here's the starting point, an info desk at a swimming pool. It knows two commands, and `quit`:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Bye!");
                break;
            }
            if (command.equals("hours")) {
                System.out.println("Open every day from 7 to 21");
            } else if (command.equals("price")) {
                System.out.println("A swim costs 6 euros");
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
```

**Input**

```text
hours
price
sauna
quit
```

**Output**

```text
> Open every day from 7 to 21
> A swim costs 6 euros
> Unknown command: sauna
> Bye!
```

- `while (true)` repeats until a `break` stops it. Each round reads one command and answers it.
- The `quit` check comes right after reading. `break` ends the loop, and since nothing comes after the loop, the program ends too.
- Each command has its own `if` or `else if`. The last `else` answers everything else, so a typo like `hour` gets a message. Without it, the program would say nothing, and the user couldn't tell whether anything happened.
- The command is read once in each round, into `command`, and every branch compares that same variable with `equals`.

## The prompt, and what the outputs show

`System.out.print("> ")` prints a **prompt**: a sign that the program is waiting for a command. It's printed with `print`, not `println`, so what the user types goes on the same line. In a terminal, the conversation above looks like this:

```text
> hours
Open every day from 7 to 21
> price
A swim costs 6 euros
> sauna
Unknown command: sauna
> quit
Bye!
```

As in module 2, the checks on this site give the program all of its input at the start, and the output doesn't show what was typed. So each answer comes right after its `> `, as in the output block above. Every program in this module works this way:

- Before reading a command, it prints `> ` with `print`. Each `> ` in an output is one command read, and the rest of that line is the program's answer.
- A command that needs a value, such as a name or a number, reads it from the next line, without a prompt of its own.

---

Source: [A loop that reads commands](https://javaarena.com/learn/text-ui/command-loop/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
