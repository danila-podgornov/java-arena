> [!info] AI-Generated

# Neighbors: the cells around a cell

In the game Minesweeper, a field of squares hides a few mines. Every square without a mine shows a number: how many of the squares around it hide a mine. A program can keep the mines in a `boolean[][]`, with `true` where a mine is, and work out each number from the grid.

## The eight cells around a cell

The cells around row `row`, column `column` are in the rows `row - 1` to `row + 1` and the columns `column - 1` to `column + 1`: a block of 3 by 3 cells, without the one in the middle.

| | column - 1 | column | column + 1 |
|---|---|---|---|
| **row - 1** | neighbor | neighbor | neighbor |
| **row** | neighbor | the cell itself | neighbor |
| **row + 1** | neighbor | neighbor | neighbor |

Two loops go through the block, and `continue` (from module 8) skips the cell in the middle. This version works in the middle of the field, and crashes at its edge:

```java
public class Main {
    public static void main(String[] args) {
        boolean[][] mines = {
            {true, false, false, false},
            {false, false, true, false},
            {true, true, false, false}
        };
        System.out.println(countAround(mines, 1, 1));
        System.out.println(countAround(mines, 1, 2));
        System.out.println(countAround(mines, 0, 3));
    }

    public static int countAround(boolean[][] mines, int row, int column) {
        int count = 0;
        for (int r = row - 1; r <= row + 1; r++) {
            for (int c = column - 1; c <= column + 1; c++) {
                if (r == row && c == column) {
                    continue;
                }
                if (mines[r][c]) {
                    count++;
                }
            }
        }
        return count;
    }
}
```

**Output**

```text
4
1
```

**The program crashes with**

```text
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index -1 out of bounds for length 3
	at Main.countAround(Main.java:20)
	at Main.main(Main.java:10)
```

Row 1, column 1 has four mines around it: up and to the left, to the right, below, and below to the left. Row 0, column 3 is in the top right corner. The rows around it start at -1, and `mines[-1]` doesn't exist.

## Staying inside the grid

A cell on the edge has fewer neighbors: 5 on a side, 3 in a corner. Before the program reads a cell, it checks both indexes: the row from 0 to `mines.length - 1`, and the column from 0 to the length of that row minus one. Here that check is a method of its own, which also gives the rule a name: outside the field, there are no mines.

```java
public class Main {
    public static void main(String[] args) {
        boolean[][] mines = {
            {true, false, false, false},
            {false, false, true, false},
            {true, true, false, false}
        };
        System.out.println(hasMine(mines, 2, 0));
        System.out.println(hasMine(mines, -1, 2));
        System.out.println(hasMine(mines, 1, 4));
    }

    public static boolean hasMine(boolean[][] mines, int row, int column) {
        if (row < 0 || row >= mines.length) {
            return false;
        }
        if (column < 0 || column >= mines[row].length) {
            return false;
        }
        return mines[row][column];
    }
}
```

**Output**

```text
true
false
false
```

The order of the checks matters: `mines[row].length` would itself crash for row -1, so the row is checked first. In one condition, `r >= 0 && r < mines.length && c >= 0 && c < mines[r].length && mines[r][c]` does the same: `&&` stops at the first part that's false, so the parts after a bad index are never run.

## Up, down, left and right

Some grids count only four neighbors: the cells above, below, to the left and to the right. Two small arrays can list the steps to each of them, the same index in both arrays making one step:

```java
int[] rowSteps = {-1, 1, 0, 0};
int[] columnSteps = {0, 0, -1, 1};
for (int i = 0; i < rowSteps.length; i++) {
    int r = row + rowSteps[i];
    int c = column + columnSteps[i];
    // check that r and c are inside the grid, then use grid[r][c]
}
```

Step -1 for the row is the cell above, step 1 below; step -1 for the column is the cell to the left, step 1 to the right. With eight pairs, the same loop would cover the diagonal neighbors too.

---

Source: [Neighbors: the cells around a cell](https://javaarena.com/learn/multidimensional-arrays/neighbors/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
