> [!info] AI-Generated

# Testing with different inputs

A program that gives the right answer for one input can still be wrong. Bugs like to hide in the inputs nobody tried. So test with a few kinds of input on purpose:

- **A typical case**, like the example in the task.
- **The edges**: the smallest and largest values that are allowed, 0, 1, an empty input or a single value, and the values right at a limit (if something changes at 18, try 17 and 18).
- **The unusual**: negative numbers, all values the same, the largest value first or last.

This program finds the largest number typed. It works for the example `3`, `9`, `4`:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.valueOf(scanner.nextLine());
        int largest = 0;
        for (int i = 0; i < count; i++) {
            int number = Integer.valueOf(scanner.nextLine());
            if (number > largest) {
                largest = number;
            }
        }
        System.out.println("Largest: " + largest);
    }
}
```

**Input**

```text
3
3
9
4
```

**Output**

```text
Largest: 9
```

Now try numbers that are all negative, `-5`, `-2`, `-8`: it prints `Largest: 0`, a number that wasn't even typed. Starting from 0 only works when some number is bigger than 0. The fix is to start from the first number itself, and compare the rest with it.

## Tracing by hand

For a short loop, you can also play the computer: write the variables in a table and fill in one row per round, without running anything. With the numbers `-5`, `-2`, `-8`:

| round | number | largest after the round |
|---|---|---|
| before the loop | | 0 |
| 1 | -5 | 0 |
| 2 | -2 | 0 |
| 3 | -8 | 0 |

The table shows the problem at once: `largest` never changes, because no number beats 0. Next to each row you can also write what the value *should* be: the first row where the two differ is where the bug is.

---

Source: [Testing with different inputs](https://javaarena.com/learn/debugging/testing-with-inputs/) in the module [Finding bugs](https://javaarena.com/learn/debugging/) on Java Arena.

This module follows section [3.1 Discovering errors](https://java-programming.mooc.fi/part-3/1-discovering-errors) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
