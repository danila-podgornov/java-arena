> [!info] AI-Generated

# Processing many lines

Real data comes in many lines. The `while (true)` loop from module 8, which reads until a signal to stop, works here too. This time the signal is an empty line, and each line before it is split and used:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        int highest = 0;
        String priciest = "";
        while (true) {
            String line = scanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] parts = line.split(",");
            int price = Integer.valueOf(parts[1]);
            total += price;
            if (price > highest) {
                highest = price;
                priciest = parts[0];
            }
        }
        System.out.println("Total: " + total);
        System.out.println("Most expensive: " + priciest + " (" + highest + ")");
    }
}
```

**Input**

```text
bread,3
cheese,7
milk,2
(an empty line)
```

**Output**

```text
Total: 12
Most expensive: cheese (7)
```

- `line.isEmpty()` is true for the empty line at the end of the input, where the user pressed Enter without typing anything, and `break` ends the loop. `line.equals("")` does the same, but `line == ""` isn't reliable, for the reasons in the step on comparing.
- The total and the highest price are updated in every round. Each line is used once and then forgotten, so the program needs no list.
- To know which product was the most expensive, its name is kept in a variable of its own, updated together with the price.

Starting `highest` at 0 works because prices are never negative. For values that can be below zero, such as temperatures, start from a number that no real value can beat, or from the first line's value.

## Other ways to stop

The signal to stop can be anything the data never contains. Instead of an empty line, it's often a word such as `end`, checked with `line.equals("end")`.

When the lines are already in an array, there's nothing to read and no signal to wait for: a for-each loop goes through the lines, and its body is the same as above.

```java
for (String line : lines) {
    String[] parts = line.split(",");
    int price = Integer.valueOf(parts[1]);
    // ... the same as in the while loop
}
```

---

Source: [Processing many lines](https://javaarena.com/learn/strings/processing-many-lines/) in the module [Working with strings](https://javaarena.com/learn/strings/) on Java Arena.

This module follows sections [3.4 Using strings](https://java-programming.mooc.fi/part-3/4-using-strings), [3.5 Summary](https://java-programming.mooc.fi/part-3/5-increasing-amounts-of-data) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
