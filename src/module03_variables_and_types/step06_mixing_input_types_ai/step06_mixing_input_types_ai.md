> [!info] AI-Generated

# Mixing input types

A program often reads several kinds of values. The recipe is the same every time: read one line with `scanner.nextLine()`, then convert it to the type you need.

| To get | Write |
|---|---|
| a `String` | `scanner.nextLine()` |
| an `int` | `Integer.valueOf(scanner.nextLine())` |
| a `double` | `Double.valueOf(scanner.nextLine())` |
| a `boolean` | `Boolean.valueOf(scanner.nextLine())` |

Each read takes the next line of input, so the order of the reads has to match the order of the input.

```java
Scanner scanner = new Scanner(System.in);
String item = scanner.nextLine();
int count = Integer.valueOf(scanner.nextLine());
double weight = Double.valueOf(scanner.nextLine());
System.out.println(count + " x " + item + ", " + weight + " kg each");
```

**Input**

```text
melon
3
1.25
```

**Output**

```text
3 x melon, 1.25 kg each
```

---

Source: [Mixing input types](https://javaarena.com/learn/variables/mixing-input-types/) in the module [Variables and types](https://javaarena.com/learn/variables/) on Java Arena.

This module follows section [1.4 Variables](https://java-programming.mooc.fi/part-1/4-variables) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
