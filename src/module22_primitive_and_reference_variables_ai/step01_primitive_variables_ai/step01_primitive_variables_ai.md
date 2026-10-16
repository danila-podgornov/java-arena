> [!info] AI-Generated

# Primitive variables

Every Java variable is one of two kinds, and the kind decides what `=` copies, what a method can change, and what `==` compares. This module is about the difference, starting with the simpler kind.

## The primitive types

Java has eight **primitive types**. Four of them you've used all along:

| Type | Holds | Examples |
|---|---|---|
| `int` | whole numbers, from about -2.1 billion to 2.1 billion | `42`, `-7` |
| `double` | numbers with a decimal point | `3.75`, `-0.5` |
| `boolean` | true or false | `true`, `false` |
| `char` | one character, in single quotes | `'A'`, `'?'` |

You'll rarely need the other four: `long` holds whole numbers too big for an `int`, `float` is a less precise decimal number, and `byte` and `short` hold whole numbers with small ranges. All eight names start with a small letter.

Every other type is a **reference type**: `String`, `Scanner`, `ArrayList`, arrays such as `int[]`, and every class you write. Those are the next step.

## A primitive variable holds its value

A primitive variable holds the value itself. Picture a box with a number in it. Assigning one variable to another copies the value into the other box, and after that the two boxes have nothing to do with each other:

```java
int planned = 12;
int done = planned;
done = done - 5;
planned++;
System.out.println("Planned: " + planned);
System.out.println("Done: " + done);
```

**Output**

```text
Planned: 13
Done: 7
```

- `int done = planned;` copies the value 12 into `done`. It doesn't tie `done` to `planned` in any way.
- Changing `done` doesn't touch `planned`, and changing `planned` doesn't touch `done`.

The same goes for a value worked out from other variables. `int total = a + b;` stores the sum as it is at that moment, and if `a` changes later, `total` keeps the old sum.

## Swapping two values

Assigning puts a new value in the box, and the old one is gone. That's why swapping the values of two variables takes three steps and a third variable:

```java
int left = 3;
int right = 8;
int temp = left;
left = right;
right = temp;
System.out.println(left + " " + right);
```

**Output**

```text
8 3
```

With only `left = right;` and `right = left;`, the first line overwrites the 3, and both variables end up 8. `temp` keeps a copy of the old value until it's needed.

---

Source: [Primitive variables](https://javaarena.com/learn/references/primitive-variables/) in the module [Primitive and reference variables](https://javaarena.com/learn/references/) on Java Arena.

This module follows sections [5.3 Primitive and reference variables](https://java-programming.mooc.fi/part-5/3-primitive-and-reference-variables), [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
