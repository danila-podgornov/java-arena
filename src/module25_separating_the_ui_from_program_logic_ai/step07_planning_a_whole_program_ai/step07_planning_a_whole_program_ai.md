> [!info] AI-Generated

# Planning a whole program

You've now seen every piece of a program with a text user interface. When you write one from scratch, this order keeps each step small:

1. Write down the commands and what each one prints, best as a short example conversation.
2. Decide what the program must remember between commands. Those are the instance variables of the logic class.
3. For each command, decide what the logic must do or answer. Those are its public methods: parameters for what comes in, return values for what goes out, and no printing.
4. Write the logic class, and try it with a few calls in `main`, before there's any user interface.
5. Write the `UserInterface` class: a constructor that takes the Scanner and the logic object, and `start()` with the command loop, one branch per command.
6. Make `main` create the objects and call `start()`.

Here are the first four for a coat check at a theater. Guests leave their coat and get a ticket with the number of its hook, and the ticket gets them their coat back:

| Command | What it prints |
| --- | --- |
| `leave`, then a name | `Ana, your ticket is 1` |
| `collect`, then a ticket number | `Here's your coat, Ana`, or `No coat on hook 7` |
| `coats` | `Coats: 2` |
| `quit` | `Good night` |

The coat check remembers whose coat is on which hook. A list of names does that: the hook's number is one more than its index, and a hook that's free again holds `null`. A new coat goes on the first free hook, or on a new hook at the end. Before writing any user interface, `main` tries the class out:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        CoatCheck check = new CoatCheck();
        int ana = check.leave("Ana");
        int ben = check.leave("Ben");
        System.out.println(ana + " " + ben + " " + check.coats());
        System.out.println(check.collect(ana));
        System.out.println(check.collect(ana));
        System.out.println(check.leave("Cleo") + " " + check.coats());
    }
}
```

**CoatCheck.java**

```java
import java.util.ArrayList;

public class CoatCheck {
    private ArrayList<String> hooks;

    public CoatCheck() {
        this.hooks = new ArrayList<>();
    }

    public int leave(String owner) {
        for (int i = 0; i < this.hooks.size(); i++) {
            if (this.hooks.get(i) == null) {
                this.hooks.set(i, owner);
                return i + 1;
            }
        }
        this.hooks.add(owner);
        return this.hooks.size();
    }

    public String collect(int ticket) {
        if (ticket < 1 || ticket > this.hooks.size()) {
            return null;
        }
        String owner = this.hooks.get(ticket - 1);
        this.hooks.set(ticket - 1, null);
        return owner;
    }

    public int coats() {
        int count = 0;
        for (String owner : this.hooks) {
            if (owner != null) {
                count++;
            }
        }
        return count;
    }
}
```

**Output**

```text
1 2 2
Ana
null
1 2
```

- `leave` returns the ticket number, and `collect` returns the owner's name. The logic answers with values, and the user interface will turn them into sentences.
- `collect` returns `null` when there's no coat on that hook, or no such hook at all. That's the logic's way of saying "no coat". Printing `No coat on hook 7` is up to the user interface.
- After Ana collects her coat, her hook is free: the second `collect(ana)` finds it empty and returns `null`. Cleo's coat then goes on hook 1, the first free one.
- These few lines already show that the logic works. If the whole program then misbehaves, the mistake is most likely in the user interface.

This step ends the MOOC's section 6.2. The next module is about testing: checking automatically that a logic class such as `CoatCheck` gives the right answers.

---

Source: [Planning a whole program](https://javaarena.com/learn/text-ui/bigger-program/) in the module [Separating the UI from program logic](https://javaarena.com/learn/text-ui/) on Java Arena.

This module follows section [6.2 Separating the user interface from program logic](https://java-programming.mooc.fi/part-6/2-separating-user-interface-from-program-logic) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
