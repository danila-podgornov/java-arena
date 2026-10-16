> [!info] AI-Generated

# Repeating a calculation

The loop variable can take part in the calculation. Here the loop adds up 1 + 2 + 3 + ... up to a number from the input:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int last = Integer.valueOf(scanner.nextLine());
        int sum = 0;
        for (int i = 1; i <= last; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }
}
```

**Input**

```text
4
```

**Output**

```text
Sum: 10
```

Traced, the sum goes 0, 1, 3, 6, 10. The pattern has the same pieces as summing input: a sum that starts at 0 before the loop, and one addition per round. Only now the added value is `i` itself, or anything calculated from it.

---

Source: [Repeating a calculation](https://javaarena.com/learn/for-loops/repeating-a-calculation/) in the module [Loop conditions and for](https://javaarena.com/learn/for-loops/) on Java Arena.

This module follows section [2.3 More loops](https://java-programming.mooc.fi/part-2/3-more-loops) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
