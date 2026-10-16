> [!info] AI-Generated

# Going through a grid

## An array of arrays

Java builds a two-dimensional array out of one-dimensional ones. An `int[][]` is an array whose elements are rows, and each row is an `int[]`. That's why `image[1][2]` has two pairs of brackets: `image[1]` is row 1, a whole array, and `[2]` picks an element of that row.

```java
int[][] image = {
    {0, 3, 7, 3},
    {3, 8, 9, 8},
    {0, 3, 7, 3}
};
System.out.println(image.length);
System.out.println(image[1].length);
int[] middle = image[1];
System.out.println(middle[2]);
System.out.println(Arrays.toString(image[2]));
```

**Output**

```text
3
4
9
[0, 3, 7, 3]
```

- `image.length` is the length of the outer array: the number of **rows**, 3.
- `image[1].length` is the length of row 1: the number of **columns** in that row, 4.
- `image[1]` is an ordinary `int[]`. It can be kept in an `int[]` variable, or printed with `Arrays.toString`, like any array.

## Nested loops

To visit every cell, put one loop inside another. The outer loop goes through the rows, and for each row, the inner loop goes through the columns of that row:

```java
int[][] image = {
    {0, 3, 7, 3},
    {3, 8, 9, 8},
    {0, 3, 7, 3}
};
for (int row = 0; row < image.length; row++) {
    for (int column = 0; column < image[row].length; column++) {
        if (column > 0) {
            System.out.print(" ");
        }
        System.out.print(image[row][column]);
    }
    System.out.println();
}
```

**Output**

```text
0 3 7 3
3 8 9 8
0 3 7 3
```

- The outer loop runs 3 times, once per row. Each time, the inner loop runs 4 times, once per column, so the body of the inner loop runs 12 times in all: once for each cell.
- `print` doesn't end the line, so the values of one row stay on one line. The `println()` after the inner loop ends the line. It's inside the outer loop, so it runs once per row.
- The `if` puts a space between two values, but not before the first one, so no line ends with a space.

The names `row` and `column` make it clear which index is which. Code you read elsewhere often says `i` and `j`, or `y` and `x`, where `y` is the row (counted from the top) and `x` the column.

## Filling a grid

The same two loops can fill a grid. Here every cell gets its row number times its column number, both counted from 1, which makes a multiplication table:

```java
int[][] table = new int[3][5];
for (int row = 0; row < table.length; row++) {
    for (int column = 0; column < table[row].length; column++) {
        table[row][column] = (row + 1) * (column + 1);
    }
}
System.out.println(Arrays.toString(table[0]));
System.out.println(Arrays.toString(table[2]));
System.out.println(table[1][4]);
```

**Output**

```text
[1, 2, 3, 4, 5]
[3, 6, 9, 12, 15]
10
```

## for-each over a grid

When you need the values but not their places, for-each loops are shorter. The outer loop goes through the rows, so its variable is an `int[]`. The inner loop goes through the values of that row:

```java
int[][] image = {
    {0, 3, 7, 3},
    {3, 8, 9, 8},
    {0, 3, 7, 3}
};
int bright = 0;
for (int[] row : image) {
    for (int value : row) {
        if (value >= 5) {
            bright++;
        }
    }
}
System.out.println(bright + " bright pixels");
```

**Output**

```text
5 bright pixels
```

## Rows and columns mixed up

The loop over the rows stops at `image.length`, and the loop over the columns at the length of a row. Swap the two, and a grid that isn't square crashes:

```java
public class Main {
    public static void main(String[] args) {
        int[][] image = new int[3][4];
        for (int row = 0; row < image[0].length; row++) {
            for (int column = 0; column < image.length; column++) {
                image[row][column] = 5;
            }
        }
        System.out.println("Done");
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
	at Main.main(Main.java:6)
```

The row loop stops at 4, the number of columns, but the grid has only 3 rows, so when `row` reaches 3, `image[3]` is past the end of the outer array. (The column loop, which stops at 3, would also have skipped column 3 without a word.) On a square grid the mistake doesn't show, so it's worth trying your code on a grid that has more columns than rows, or more rows than columns.

---

Source: [Going through a grid](https://javaarena.com/learn/multidimensional-arrays/going-through-a-grid/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
