> [!info] AI-Generated

# Read, decide, print

In the second pattern the input decides what the program prints. Between reading and printing there's an `if`:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int battery = Integer.valueOf(scanner.nextLine());
        if (battery < 20) {
            System.out.println("Charge soon");
        } else {
            System.out.println("Battery OK");
        }
    }
}
```

**Input**

```text
12
```

**Output**

```text
Charge soon
```

A decision can also change a value instead of printing: the `if` fixes up a variable, and one print line after it shows the result. This keeps the printing in one place:

```java
int speed = 140;
if (speed > 120) {
    speed = 120;
}
System.out.println("Speed: " + speed);
```

**Output**

```text
Speed: 120
```

---

Source: [Read, decide, print](https://javaarena.com/learn/problem-patterns/read-decide-print/) in the module [Problem-solving patterns](https://javaarena.com/learn/problem-patterns/) on Java Arena.

This module follows section [2.1 Recurring problems and patterns to solve them](https://java-programming.mooc.fi/part-2/1-problems-and-patterns) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
