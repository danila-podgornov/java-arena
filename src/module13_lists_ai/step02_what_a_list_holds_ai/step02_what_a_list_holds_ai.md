> [!info] AI-Generated

# What a list holds

The type between `<` and `>` says what goes into the list. A list of whole numbers is an `ArrayList<Integer>`, a list of decimal numbers an `ArrayList<Double>`, and a list of true and false values an `ArrayList<Boolean>`:

```java
ArrayList<Integer> scores = new ArrayList<>();
scores.add(12);
scores.add(7);
scores.add(12);
System.out.println(scores);

ArrayList<Double> prices = new ArrayList<>();
prices.add(4.5);
prices.add(3.0);
System.out.println(prices);
```

**Output**

```text
[12, 7, 12]
[4.5, 3.0]
```

Only values of that type fit: `scores.add("twelve")` doesn't compile, because `"twelve"` is a String, not a whole number.

## Integer, not int

Why `Integer` and not `int`? A list can only hold **objects**, and `int`, `double` and `boolean` aren't objects: they're **primitive** types, plain values built into the language. Each of them has an object partner, written with a capital letter: `Integer` for `int`, `Double` for `double` and `Boolean` for `boolean`. A primitive type in a list doesn't compile:

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<int> scores = new ArrayList<>();
        scores.add(12);
        System.out.println(scores);
    }
}
```

**What javac prints**

```text
Main.java:5: error: unexpected type
        ArrayList<int> scores = new ArrayList<>();
                  ^
  required: reference
  found:    int
1 error
```

`required: reference` means javac wants an object type there. Write `ArrayList<Integer>` instead.

Otherwise you rarely notice the difference, because Java converts between the two by itself. `scores.add(12)` turns the `int` 12 into an `Integer`, and a value you take out of the list can go straight into an `int` variable (the next step shows how).

One catch: Java turns an `int` into an `Integer`, but never into a `Double`. In an `ArrayList<Double>`, write whole numbers with a decimal point: `prices.add(3.0)` works, `prices.add(3)` doesn't compile.

Strings are objects already, so a list of text is simply an `ArrayList<String>`.

---

Source: [What a list holds](https://javaarena.com/learn/lists/what-a-list-holds/) in the module [Lists](https://javaarena.com/learn/lists/) on Java Arena.

This module follows section [3.2 Lists](https://java-programming.mooc.fi/part-3/2-lists) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
