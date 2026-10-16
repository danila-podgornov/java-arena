> [!info] AI-Generated

# Combining the patterns

Bigger programs combine the patterns: read several values, calculate from them, decide, and print a sentence that uses the results. Here are two prices, and the program says which is cheaper and by how much:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int shopA = Integer.valueOf(scanner.nextLine());
        int shopB = Integer.valueOf(scanner.nextLine());
        int difference = Math.abs(shopA - shopB);
        if (shopA < shopB) {
            System.out.println("Shop A is cheaper by " + difference);
        } else if (shopB < shopA) {
            System.out.println("Shop B is cheaper by " + difference);
        } else {
            System.out.println("Same price");
        }
    }
}
```

**Input**

```text
35
29
```

**Output**

```text
Shop B is cheaper by 6
```

The difference is worked out once, before the decision, and each branch uses it. The same plan works for most problems of this kind: read everything, calculate what the sentences need, then decide which sentence to print.

---

Source: [Combining the patterns](https://javaarena.com/learn/problem-patterns/combining-patterns/) in the module [Problem-solving patterns](https://javaarena.com/learn/problem-patterns/) on Java Arena.

This module follows section [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
