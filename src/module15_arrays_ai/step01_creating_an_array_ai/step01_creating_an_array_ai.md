> [!info] AI-Generated

# Creating an array

A list grows as you add to it. An **array** is a simpler collection: you say how big it is when you create it, and that size never changes. In return, every place in it exists from the start, ready to use.

```java
int[] numbers = new int[5];
numbers[2] = 7;
numbers[0] = 3;
System.out.println(numbers[0]);
System.out.println(numbers[2]);
System.out.println(numbers[4]);
```

**Output**

```text
3
7
0
```

- `int[]` is the type "array of ints". The square brackets make it an array.
- `new int[5]` creates an array with room for five ints. Their indexes are 0 to 4, as in a list.
- `numbers[2] = 7;` stores 7 at index 2. There's no `add`: the place is already there, and you assign to it.
- `numbers[2]` reads the value at index 2, where a list would say `list.get(2)`.

Index 4 was never given a value, and it holds 0. The array has exactly five places for as long as it exists: there's no way to make it hold a sixth value later.

## Default values

A new array isn't empty: every element starts with a default value. It's 0 for `int`, 0.0 for `double`, `false` for `boolean`, and `null` for `String`. (`null` means "no value here yet".)

```java
double[] prices = new double[3];
boolean[] done = new boolean[3];
String[] names = new String[3];
System.out.println(prices[0]);
System.out.println(done[1]);
System.out.println(names[2]);
```

**Output**

```text
0.0
false
null
```

## An element works like a variable

Each element behaves like a variable of the element type. You can use its value in a calculation, and change it with `=`, `+=` or `++`. The index can be any whole-number expression, such as a variable:

```java
int[] goals = new int[3];
goals[1] = 2;
goals[1]++;
goals[0] = goals[1] * 2;
int last = 2;
goals[last] += 5;
System.out.println(goals[0] + " " + goals[1] + " " + goals[2]);
```

**Output**

```text
6 3 5
```

---

Source: [Creating an array](https://javaarena.com/learn/arrays/creating-an-array/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
