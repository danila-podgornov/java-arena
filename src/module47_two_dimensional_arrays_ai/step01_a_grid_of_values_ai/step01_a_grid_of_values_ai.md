> [!info] AI-Generated

# A grid of values

An array keeps its values in a line, and one index says where a value is. Some data goes in two directions. A cinema's seats are in rows, and each row has seats from left to right. A spreadsheet has rows and columns, and so does a picture made of pixels. For data like that, Java has **two-dimensional arrays**, where each value has two indexes: its row and its column.

Here the values are the brightness of the pixels of a tiny picture, from 0 for black to 9 for white:

```java
int[][] image = new int[3][4];
image[1][2] = 9;
image[0][3] = 4;
System.out.println(image[1][2]);
System.out.println(image[0][3]);
System.out.println(image[2][0]);
```

**Output**

```text
9
4
0
```

- `int[][]` is the type "two-dimensional array of ints". Two pairs of brackets, two indexes.
- `new int[3][4]` creates a grid of 3 rows with 4 columns each: 12 ints, all 0 to start with.
- `image[1][2] = 9;` stores 9 in row 1, column 2. The row comes first, then the column.
- `image[1][2]` reads the value back. Both indexes start from 0, as always.

This is the grid after the two assignments:

| | column 0 | column 1 | column 2 | column 3 |
|---|---|---|---|---|
| **row 0** | 0 | 0 | 0 | 4 |
| **row 1** | 0 | 0 | 9 | 0 |
| **row 2** | 0 | 0 | 0 | 0 |

The order of the indexes matters: `image[2][1]` is row 2, column 1, a different cell from `image[1][2]`. Here it still holds 0.

## A cell works like a variable

Each cell behaves like a variable of the element type, just as the elements of an array do. You can use its value in a calculation and change it with `=`, `+=`, `++` or `--`, and the indexes can be any whole-number expressions:

```java
int[][] image = new int[3][4];
image[1][2] = 9;
image[1][2]--;
int row = 2;
image[row][row + 1] = image[1][2] / 2;
System.out.println(image[1][2] + " " + image[2][3]);
```

**Output**

```text
8 4
```

## Default values

A new grid starts with the same default values as a new array: 0 for `int`, 0.0 for `double`, `false` for `boolean` and `null` for `String`. That suits a cinema's seat map. In a `boolean[][]` where `true` means booked, every seat starts free:

```java
boolean[][] booked = new boolean[5][8];
booked[2][3] = true;
booked[2][4] = true;
System.out.println(booked[2][3]);
System.out.println(booked[2][5]);
System.out.println(booked[0][0]);
```

**Output**

```text
true
false
false
```

People count rows and seats from 1, but the indexes start from 0. The ticket for row 3, seat 4 is `booked[2][3]`, so a program that reads seats the way people write them subtracts one from each number: `booked[row - 1][seat - 1]`.

## The short way

When you know the values as you write the program, list them row by row: braces around each row, commas between the rows, and braces around them all.

```java
int[][] image = {
    {0, 3, 7, 3},
    {3, 8, 9, 8},
    {0, 3, 7, 3}
};
System.out.println(image[1][1]);
System.out.println(image[2][2]);
```

**Output**

```text
8
7
```

The first row in braces is row 0, the next one row 1, and so on. Java counts the rows, and the values in each, to make a grid of the right size. As with a one-dimensional array, the braces alone work only in the line that declares the variable.

---

Source: [A grid of values](https://javaarena.com/learn/multidimensional-arrays/a-grid-of-values/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
