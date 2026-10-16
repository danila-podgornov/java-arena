> [!info] AI-Generated

# Rows, columns and totals

A mattress company has three stores. Its sales table has a row for each store and a column for each month from January to April, and each cell is the number of mattresses that store sold that month:

```java
String[] stores = {"Riverside", "Station", "Market"};
String[] months = {"Jan", "Feb", "Mar", "Apr"};
int[][] sales = {
    {12, 15, 9, 20},
    {8, 11, 14, 10},
    {20, 18, 22, 25}
};
```

The names are in two ordinary arrays that match the grid: `stores[row]` names a row, and `months[column]` names a column. This step answers the questions a spreadsheet answers: the total of each row, the total of each column, and the largest value and where it is.

## The total of each row

A store's total is the sum of one row. The sum must start from 0 again for every row, so it's created inside the outer loop:

```java
String[] stores = {"Riverside", "Station", "Market"};
int[][] sales = {
    {12, 15, 9, 20},
    {8, 11, 14, 10},
    {20, 18, 22, 25}
};
for (int row = 0; row < sales.length; row++) {
    int total = 0;
    for (int column = 0; column < sales[row].length; column++) {
        total += sales[row][column];
    }
    System.out.println(stores[row] + ": " + total);
}
```

**Output**

```text
Riverside: 56
Station: 43
Market: 85
```

With `int total = 0;` before the outer loop instead, each line would go on from the store before it, and print 56, 99 and 184. The last of these is the total of the whole table, which is useful too, but it's not what each line says.

## The total of each column

A month's total goes down a column. The loops trade places: the outer loop goes through the columns, and the inner one through the rows. The number of columns is the length of a row, `sales[0].length`:

```java
String[] months = {"Jan", "Feb", "Mar", "Apr"};
int[][] sales = {
    {12, 15, 9, 20},
    {8, 11, 14, 10},
    {20, 18, 22, 25}
};
for (int column = 0; column < sales[0].length; column++) {
    int total = 0;
    for (int row = 0; row < sales.length; row++) {
        total += sales[row][column];
    }
    System.out.println(months[column] + ": " + total);
}
```

**Output**

```text
Jan: 40
Feb: 44
Mar: 45
Apr: 55
```

The cell is still `sales[row][column]`, row first: only the order of the loops changed. `sales[0].length` assumes that every row is as long as the first one. That's true of this table and of every grid made with `new int[3][4]`. Step 5 meets grids where it isn't.

## The largest value, and where it is

Module 15's search for the largest value works on a grid too. It just remembers two indexes instead of one:

```java
String[] stores = {"Riverside", "Station", "Market"};
String[] months = {"Jan", "Feb", "Mar", "Apr"};
int[][] sales = {
    {12, 15, 9, 20},
    {8, 11, 14, 10},
    {20, 18, 22, 25}
};
int best = sales[0][0];
int bestRow = 0;
int bestColumn = 0;
for (int row = 0; row < sales.length; row++) {
    for (int column = 0; column < sales[row].length; column++) {
        if (sales[row][column] > best) {
            best = sales[row][column];
            bestRow = row;
            bestColumn = column;
        }
    }
}
System.out.println("Best: " + stores[bestRow] + " in " + months[bestColumn] + ", " + best + " mattresses");
```

**Output**

```text
Best: Market in Apr, 25 mattresses
```

As in module 15, the search starts from a real value, the first cell, and not from 0. With `>`, the first of two equal values wins, and "first" means first in the order the loops go: row by row, and from left to right in each row.

## Totals in an array

A method can return all the column totals at once, in a new array with one element for each column. Here the loops go in the usual order, and each value is added to the total of its own column, `totals[column]`:

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] sales = {
            {12, 15, 9, 20},
            {8, 11, 14, 10},
            {20, 18, 22, 25}
        };
        System.out.println(Arrays.toString(columnTotals(sales)));
    }

    public static int[] columnTotals(int[][] grid) {
        int[] totals = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                totals[column] += grid[row][column];
            }
        }
        return totals;
    }
}
```

**Output**

```text
[40, 44, 45, 55]
```

A new int array starts with zeros, so every total starts from 0 without an extra loop.

---

Source: [Rows, columns and totals](https://javaarena.com/learn/multidimensional-arrays/rows-columns-and-totals/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
