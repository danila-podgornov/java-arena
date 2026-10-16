> [!info] AI-Generated

# Searching a list

Is a value in the list, and where? Go through the indexes and compare each value with the one you're looking for. Keep the index of the match in a variable that starts at -1: no real index is -1, so it means "not found yet".

```java
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> shelf = new ArrayList<>();
        shelf.add("atlas");
        shelf.add("cookbook");
        shelf.add("diary");
        shelf.add("novel");

        String wanted = scanner.nextLine();
        int found = -1;
        for (int i = 0; i < shelf.size(); i++) {
            if (shelf.get(i).equals(wanted)) {
                found = i;
                break;
            }
        }

        if (found == -1) {
            System.out.println("No " + wanted + " on the shelf");
        } else {
            System.out.println("The " + wanted + " is at index " + found);
        }
    }
}
```

**Input**

```text
diary
```

**Output**

```text
The diary is at index 2
```

- `shelf.get(i)` is a String, so it's compared with `equals`, as always for Strings.
- `break` stops the search at the first match. Without it, the loop would go on, and `found` would end up as the index of the last match.
- Only after the loop is it certain that the value isn't there: `found` is still -1.

For numbers, keep the value you're looking for in an `int` variable, and `numbers.get(i) == wanted` compares the numbers.

## Every match

To find all the places a value appears, leave out the `break`, and act on each match inside the loop. Here each six is printed and counted:

```java
ArrayList<Integer> rolls = new ArrayList<>();
rolls.add(3);
rolls.add(6);
rolls.add(2);
rolls.add(6);
rolls.add(6);
rolls.add(1);

int sixes = 0;
for (int i = 0; i < rolls.size(); i++) {
    if (rolls.get(i) == 6) {
        System.out.println("Six on roll " + (i + 1));
        sixes++;
    }
}
System.out.println("Sixes: " + sixes);
```

**Output**

```text
Six on roll 2
Six on roll 4
Six on roll 5
Sixes: 3
```

Lists have ready-made methods for some searches, such as `indexOf` and `contains`, and the next module introduces them. Writing the loop yourself shows how they work, and a loop can do more than they can, like finding every match.

---

Source: [Searching a list](https://javaarena.com/learn/lists/searching/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
