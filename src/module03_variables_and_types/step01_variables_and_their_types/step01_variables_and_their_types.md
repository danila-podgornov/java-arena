> [!info] AI-Generated

# Variables and their types

A variable holds a value under a name. Every Java variable also has a **type**, which says what kind of value it can hold. Four types cover most of what you'll need for now:

| Type | Holds | Examples |
|---|---|---|
| `int` | whole numbers | `3`, `-12`, `2026` |
| `double` | numbers with a decimal point | `0.45`, `-3.5`, `2.0` |
| `boolean` | true or false | `true`, `false` |
| `String` | text | `"apple"`, `"Hello!"` |

A variable is created by writing its type, its name and its first value:

```java
int apples = 12;
double price = 0.45;
boolean inStock = true;
String fruit = "apple";
System.out.println(fruit + ": " + apples + " at " + price);
System.out.println("In stock: " + inStock);
```

**Output**

```text
apple: 12 at 0.45
In stock: true
```

As the last two lines show, `+` joins numbers and booleans into text too: `"In stock: " + inStock` becomes `In stock: true`.

## The type decides what fits

A variable can only hold values that fit its type. Putting a decimal number into an `int` would lose the part after the point, so Java refuses to compile it:

```java
public class Main {
    public static void main(String[] args) {
        int price = 4.99;
        System.out.println(price);
    }
}
```

**What javac prints**

```text
Main.java:3: error: incompatible types: possible lossy conversion from double to int
        int price = 4.99;
                    ^
1 error
```

The other way round is fine: `double distance = 5;` compiles, because a whole number fits in a `double` without losing anything (it becomes `5.0`).

Note the capital `S` in `String`: it's a class, like `Scanner`, while `int`, `double` and `boolean` are built into the language and written in lower case.

---

Source: [Variables and their types](https://javaarena.com/learn/variables/variables-and-types/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
