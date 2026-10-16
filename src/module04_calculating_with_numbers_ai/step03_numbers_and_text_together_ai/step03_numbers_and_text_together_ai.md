> [!info] AI-Generated

# Numbers and text together

`+` has two jobs: it adds numbers, and it joins text. Java decides which one each `+` does, working **from left to right**. As soon as one side is a String, the `+` joins, and the result is a String again.

```java
int a = 3;
int b = 4;
System.out.println("Total: " + a + b);
System.out.println("Total: " + (a + b));
System.out.println(a + b + " is the total");
```

**Output**

```text
Total: 34
Total: 7
7 is the total
```

- In the first line, `"Total: " + a` is text, `Total: 3`, and adding `b` to text joins it: `Total: 34`.
- In the second line the parentheses make `a + b` a calculation first.
- In the third line the two numbers come first, so they're added before any text appears.

## Numbers have limits

An `int` can hold values up to 2147483647. A calculation that goes past the limit doesn't stop with an error: it wraps around to the negative end of the range and counts on from there, which is called **overflow**. One past the limit is the most negative `int`:

```java
int big = 2147483647;
big = big + 1;
System.out.println(big);
```

**Output**

```text
-2147483648
```

The numbers in this course stay far from that limit, but it's worth knowing that it exists.

---

Source: [Numbers and text together](https://javaarena.com/learn/calculating/printing-formulas/) in the module [Calculating with numbers](https://javaarena.com/learn/calculating/) on Java Arena.

This module follows section [1.5 Calculating with numbers](https://java-programming.mooc.fi/part-1/5-calculating) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
