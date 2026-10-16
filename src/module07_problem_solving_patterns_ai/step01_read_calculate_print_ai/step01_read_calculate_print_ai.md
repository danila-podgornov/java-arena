> [!info] AI-Generated

# Read, calculate, print

Many programs have the same three parts, whatever they're about:

1. **Read** the input into variables.
2. **Calculate** the result from them.
3. **Print** the result.

Here the input is a temperature in Celsius, and the result is the same temperature in Fahrenheit:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 1. Read
        int celsius = Integer.valueOf(scanner.nextLine());
        // 2. Calculate
        double fahrenheit = celsius * 9 / 5.0 + 32;
        // 3. Print
        System.out.println(celsius + " C is " + fahrenheit + " F");
    }
}
```

**Input**

```text
25
```

**Output**

```text
25 C is 77.0 F
```

When a new problem looks hard, start by naming the three parts: what does the program get, what does it work out, and what does it show? Each part is often just a line or two.

Keeping the calculation in its own variable (`fahrenheit`) makes the print line short and gives the result a name.

---

Source: [Read, calculate, print](https://javaarena.com/learn/problem-patterns/read-calculate-print/) in the module [Problem-solving patterns](https://javaarena.com/learn/problem-patterns/) on Java Arena.

This module follows section [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
