> [!info] AI-Generated

# Objects from the user's input

The objects in a list don't have to be written into the program. A loop can read what the user types and create an object from each line. Here the user types tasks, one per line, and an empty line when there are no more:

**Main.java**

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Task> tasks = new ArrayList<>();

        while (true) {
            String description = scanner.nextLine();
            if (description.isEmpty()) {
                break;
            }
            tasks.add(new Task(description));
        }

        tasks.get(0).markDone();
        System.out.println(tasks.size() + " tasks");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
```

**Task.java**

```java
public class Task {
    private String description;
    private boolean done;

    public Task(String description) {
        this.description = description;
        this.done = false;
    }

    public void markDone() {
        this.done = true;
    }

    public String toString() {
        if (this.done) {
            return "[x] " + this.description;
        }
        return "[ ] " + this.description;
    }
}
```

**Input**

```text
water the plants
call the dentist
buy stamps
(an empty line)
```

**Output**

```text
3 tasks
[x] water the plants
[ ] call the dentist
[ ] buy stamps
```

- The loop is the `while (true)` loop you know: read a line, stop at the empty line, and otherwise use the line.
- `new Task(description)` creates a new object in every round, and `add` puts it in the list. The variable `description` lasts only one round, but the list still refers to every object.
- `tasks.get(0).markDone()` changes the first object in the list. Like the list variables in module 14, the list refers to its objects: nothing is copied, so `tasks.get(0)` is the very task that was added, and the change shows when the list is printed. (With no tasks at all, `get(0)` would crash; a real program would check `tasks.isEmpty()` first.)

## Check before you create

The `if` with `break` comes before `new Task(...)`. If `add` came first, the empty line would become a task of its own: the list would end with a task that has no description, and the count would be one too high.

## Input that ends with an empty line

The input of a program like this one ends with an empty line: that's what stops the loop. The task cards show it as "(an empty line)". When you run such a program with your own input, end it with an empty line too. If the input runs out before it, `nextLine()` has nothing left to read and the program stops with an error.

---

Source: [Objects from the user's input](https://javaarena.com/learn/lists-of-objects/objects-from-input/) in the module [Objects in a list](https://javaarena.com/learn/lists-of-objects/) on Java Arena.

This module follows section [4.2 Objects in a list](https://java-programming.mooc.fi/part-4/2-objects-in-a-list) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
