> [!info] AI-Generated

# The switch statement

This module is an extra: the MOOC doesn't cover it. It shows three pieces of Java that the course never needed, but that you'll meet in a lot of Java code written today: `switch`, which picks one of several branches by a value; `var`, which lets the compiler work out a local variable's type; and text blocks with `String.format`, for text of several lines and for lining up columns. None of them lets a program do something it couldn't do before. They make some code shorter, and often easier to read.

## One value, many branches

A snack machine has numbered buttons. With the tools of the course, a program that names the snack behind a button is a chain of `if` and `else if`:

```java
int button = 3;
if (button == 1) {
    System.out.println("Chips");
} else if (button == 2) {
    System.out.println("Chocolate bar");
} else if (button == 3) {
    System.out.println("Apple");
} else {
    System.out.println("No such button");
}
```

**Output**

```text
Apple
```

Every condition compares the same variable with a different value. The `switch` statement says exactly that:

```java
int button = 3;
switch (button) {
    case 1:
        System.out.println("Chips");
        break;
    case 2:
        System.out.println("Chocolate bar");
        break;
    case 3:
        System.out.println("Apple");
        break;
    default:
        System.out.println("No such button");
}
```

**Output**

```text
Apple
```

- `switch (button)` works out the value in the parentheses once. Then the program jumps to the `case` label with the same value, here `case 3:`, and runs the statements after it.
- `break` ends the switch: the program goes on after its closing brace.
- `default:` is where the program jumps when no label matches. It's optional: without it, a value that matches no label does nothing.
- A label is a constant: a literal such as `3`, `'x'` or `"tea"`, or a `final` variable given a literal. Two labels of one switch can't have the same value; javac stops with "duplicate case label".
- A switch on constants works on an `int` (and on the smaller whole-number types and `char`), on a String (since Java 7, step 3) and on an enum (step 3). It doesn't work on a `double`, a `long` or a `boolean`: `switch (price)` with a double price gives javac's error "selector type double is not allowed".

## Falling through

Here's what happens when a `break` is missing:

```java
int button = 1;
switch (button) {
    case 1:
        System.out.println("Chips");
    case 2:
        System.out.println("Chocolate bar");
        break;
    case 3:
        System.out.println("Apple");
        break;
}
```

**Output**

```text
Chips
Chocolate bar
```

A `case` label only marks where the program starts. Once it's running the statements of a case, it keeps going, past the next label and into the next case's statements, until a `break` (or the end of the switch). This is called **falling through**. A forgotten `break` is the classic switch bug: javac says nothing, and the program does too much. The arrow labels of step 2 don't fall through, which is one reason they're preferred today.

## Several values, one branch

Falling through has one honest use: several labels in a row share the statements after the last of them. Buttons 4 and 5 are both water, still and sparkling:

```java
int button = 5;
switch (button) {
    case 1:
        System.out.println("Chips");
        break;
    case 4:
    case 5:
        System.out.println("Water");
        break;
    default:
        System.out.println("Something else");
}
```

**Output**

```text
Water
```

`case 4:` has no statements of its own, so it falls straight through to `case 5:`. Since Java 14, the same can be written on one line, with the values separated by commas: `case 4, 5:`.

---

Source: [The switch statement](https://javaarena.com/learn/switch-and-text/switch-statements/) in the module [switch, var and text blocks](https://javaarena.com/learn/switch-and-text/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
