> [!info] AI-Generated

# Counting in a loop

To count something in a loop, create a **counter** before the loop, starting at 0, and add one to it inside the loop each time the thing happens. After the loop, the counter holds the total.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String word = scanner.nextLine();
            if (word.equals("end")) {
                break;
            }
            count++;
        }
        System.out.println("Words: " + count);
    }
}
```

**Input**

```text
apple
pear
plum
end
```

**Output**

```text
Words: 3
```

`count++` is Java's shorthand for `count = count + 1`. There's also `count--`, which takes one away.

## Where the counter goes

The counter must be created **before** the loop. Created inside it, it would start again from 0 in every round, and it could never count past 1. The first challenge has exactly this mistake.

---

Source: [Counting in a loop](https://javaarena.com/learn/loops/counting/) in the module [Repeating with while](https://javaarena.com/learn/loops/) on Java Arena.

This module follows section [2.2 Repeating functionality](https://java-programming.mooc.fi/part-2/2-repeating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
