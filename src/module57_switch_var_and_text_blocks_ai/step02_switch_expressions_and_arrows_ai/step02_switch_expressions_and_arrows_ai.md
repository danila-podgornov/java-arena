> [!info] AI-Generated

# switch expressions and arrows

Since Java 14, a case can be written with an arrow, `->`, in place of the colon. An arrow case runs only what's after its arrow, and never falls through, so it needs no `break`:

```java
int button = 2;
switch (button) {
    case 1 -> System.out.println("Chips");
    case 2 -> System.out.println("Chocolate bar");
    case 4, 5 -> System.out.println("Water");
    default -> System.out.println("No such button");
}
```

**Output**

```text
Chocolate bar
```

After an arrow comes one statement, or a block in braces for several. Several values share a case with commas, `case 4, 5 ->`. One switch uses either colons or arrows, not both.

## A switch that gives a value

Most switches choose a value: the name of a snack, a price, a number of points. Since Java 14, a switch can be an **expression**, which gives a value like `a + b` does. The value of each case is what comes after its arrow:

```java
int button = 4;
String snack = switch (button) {
    case 1 -> "Chips";
    case 2 -> "Chocolate bar";
    case 3 -> "Apple";
    case 4, 5 -> "Water";
    default -> "nothing";
};
System.out.println("You get: " + snack);
```

**Output**

```text
You get: Water
```

- The whole `switch (...) { ... }` is the value given to `snack`, so the statement ends with a semicolon after the closing brace.
- Every case gives a value of the same kind, here a String.
- A switch expression can be used wherever a value can: assigned to a variable, printed, or returned, as in `return switch (button) { ... };`.

## Every value needs a case

A variable must get a value, so a switch expression must have a case for every value its selector can have. For an int, that means a `default`:

```java
public class Main {
    public static void main(String[] args) {
        int button = 4;
        String snack = switch (button) {
            case 1 -> "Chips";
            case 2 -> "Chocolate bar";
        };
        System.out.println(snack);
    }
}
```

**What javac prints**

```text
Main.java:4: error: the switch expression does not cover all possible input values
        String snack = switch (button) {
                       ^
1 error
```

A switch *statement* with arrows, like the first example of this step, has no such rule: a value without a case simply does nothing.

## Several statements: yield

When a case needs a few statements to work out its value, the arrow is followed by a block, and `yield` gives the block's value. Buttons 6 to 9 are sandwiches, which cost more on the weekend:

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(price(2, false));
        System.out.println(price(7, false));
        System.out.println(price(7, true));
    }

    public static int price(int button, boolean weekend) {
        return switch (button) {
            case 1, 2, 3 -> 150;
            case 4, 5 -> 120;
            case 6, 7, 8, 9 -> {
                int base = 350;
                if (weekend) {
                    base = base + 50;
                }
                yield base;
            }
            default -> 0;
        };
    }
}
```

**Output**

```text
150
350
400
```

`yield base;` ends the block, and `base` becomes the value of the switch. It's `yield`, not `return`: a `return` would try to leave the whole method, and javac doesn't allow it inside a switch expression. A block that reaches its end without a `yield` doesn't compile either: javac says "switch rule completes without providing a value".

---

Source: [switch expressions and arrows](https://javaarena.com/learn/switch-and-text/switch-expressions/) in the module [switch, var and text blocks](https://javaarena.com/learn/switch-and-text/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
