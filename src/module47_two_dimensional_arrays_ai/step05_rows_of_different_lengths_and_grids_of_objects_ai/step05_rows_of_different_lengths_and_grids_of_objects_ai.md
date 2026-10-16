> [!info] AI-Generated

# Rows of different lengths, and grids of objects

## Rows of different lengths

Step 2 showed that a grid is an array of rows, and each row an array of its own. Nothing says the rows must be equally long. A small clinic logs how many minutes each patient waited, day by day. Some days have more patients than others, and on a day the clinic is closed there are none:

```java
int[][] waits = {
    {12, 25, 8},
    {},
    {30, 15},
    {5, 20, 10, 18}
};
for (int day = 0; day < waits.length; day++) {
    System.out.print("Day " + (day + 1) + ":");
    for (int patient = 0; patient < waits[day].length; patient++) {
        System.out.print(" " + waits[day][patient]);
    }
    System.out.println();
}
```

**Output**

```text
Day 1: 12 25 8
Day 2:
Day 3: 30 15
Day 4: 5 20 10 18
```

The inner loop asks each row for its own length, `waits[day].length`, so it fits every row: 3 patients, none, 2 and 4. With `waits[0].length` instead, the inner loop would try 3 patients every day. That's too many for days 2 and 3 and too few for day 4. The program crashes on day 2, which has no patients at all, so it never gets any further. That's why the loops in this module say `grid[row].length`: it works for grids of every shape. (Step 3's column totals used `sales[0].length`, which is fine only when all rows are equally long.)

## Printing a whole grid

`Arrays.toString` doesn't help much with a grid:

```java
int[][] waits = {{12, 25}, {30}};
System.out.println(Arrays.toString(waits));
```

This prints something like `[[I@4e50df2e, [I@1d81eb93]`. The elements of the outer array are rows, and an array printed as itself shows only `[I@` and a code. The code says nothing about the values, and it can change from one run to the next and from one Java system to another. `Arrays.deepToString` goes into the rows too:

```java
int[][] waits = {
    {12, 25, 8},
    {},
    {30, 15}
};
System.out.println(Arrays.deepToString(waits));
```

**Output**

```text
[[12, 25, 8], [], [30, 15]]
```

It's a handy way to check what a grid holds while you work on a program, as `Arrays.toString` is for a one-dimensional array.

## Creating the rows one by one

`new int[4][]`, with the second size left out, creates only the outer array: four places for rows, each `null` until a row is put there. Then each row can be created with its own length:

```java
int[][] stairs = new int[4][];
for (int row = 0; row < stairs.length; row++) {
    stairs[row] = new int[row + 1];
    for (int column = 0; column < stairs[row].length; column++) {
        stairs[row][column] = column + 1;
    }
}
System.out.println(Arrays.deepToString(stairs));
```

**Output**

```text
[[1], [1, 2], [1, 2, 3], [1, 2, 3, 4]]
```

## A row is an array of its own

Each place of the outer array holds a reference to a row, just as an `int[]` variable does (module 15). So `grid[1] = grid[0];` doesn't copy row 0: afterwards both places lead to the same row, and a change made through one shows through the other.

```java
int[][] grid = {
    {1, 2},
    {3, 4}
};
grid[1] = grid[0];
grid[1][0] = 7;
System.out.println(Arrays.deepToString(grid));
```

**Output**

```text
[[7, 2], [7, 2]]
```

A real copy of a row is a new array of the same length, with the values copied over in a loop.

## Grids of Strings

The cells can be of any type. A tic-tac-toe board is a `String[][]`, and a new one holds `null` in every cell, which works well as "nothing here yet":

```java
String[][] board = new String[3][3];
board[1][1] = "X";
board[0][2] = "O";
board[2][0] = "X";
System.out.println(Arrays.deepToString(board));
int free = 0;
for (int row = 0; row < board.length; row++) {
    for (int column = 0; column < board[row].length; column++) {
        if (board[row][column] == null) {
            free++;
        }
    }
}
System.out.println(free + " free squares");
System.out.println("X".equals(board[0][0]) + " " + "X".equals(board[1][1]));
```

**Output**

```text
[[null, null, O], [null, X, null], [X, null, null]]
6 free squares
false true
```

`== null` finds an empty cell. Calling a method on an empty cell, such as `board[0][0].equals("X")`, would crash with a NullPointerException, since there's no String there to call it on. With the known String first, `"X".equals(board[0][0])` is simply `false` for an empty cell.

## Grids of your own objects

Objects of your own classes go in a grid the same way. A box of chocolates holds them in rows:

**Main.java**

```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Chocolate[][] box = new Chocolate[2][3];
        box[0][0] = new Chocolate("praline", 12);
        box[0][1] = new Chocolate("truffle", 15);
        box[1][2] = new Chocolate("nougat", 10);
        System.out.println(Arrays.deepToString(box));

        Chocolate eaten = box[0][1];
        box[0][1] = null;
        System.out.println("Ate the " + eaten + ", " + eaten.getGrams() + " g");
        System.out.println(Arrays.deepToString(box));
    }
}
```

**Chocolate.java**

```java
public class Chocolate {
    private String name;
    private int grams;

    public Chocolate(String name, int grams) {
        this.name = name;
        this.grams = grams;
    }

    public int getGrams() {
        return this.grams;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
```

**Output**

```text
[[praline, truffle, null], [null, null, nougat]]
Ate the truffle, 15 g
[[praline, null, null], [null, null, nougat]]
```

- `new Chocolate[2][3]` creates the grid, but no chocolates: all six places are `null`. Each chocolate is created with `new Chocolate(...)` and put in its place.
- `Arrays.deepToString` writes each object with its own `toString`, and `null` for an empty place.
- Setting a place to `null` empties it. The chocolate itself still exists as long as a variable, here `eaten`, refers to it.

---

Source: [Rows of different lengths, and grids of objects](https://javaarena.com/learn/multidimensional-arrays/rows-of-different-lengths/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
