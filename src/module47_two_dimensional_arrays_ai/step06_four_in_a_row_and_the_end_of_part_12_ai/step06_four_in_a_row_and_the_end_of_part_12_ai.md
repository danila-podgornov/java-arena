> [!info] AI-Generated

# Four in a row, and the end of part 12

This last step builds a small board game with this module's tools, and then looks back at the whole of part 12.

## Two-dimensional arrays at a glance

| You want | Write |
| --- | --- |
| a grid of 3 rows and 4 columns | `int[][] grid = new int[3][4];` |
| a grid with its values | `int[][] grid = {{1, 2}, {3, 4}};` |
| the cell in row `r`, column `c` | `grid[r][c]` |
| the number of rows | `grid.length` |
| the number of cells in row `r` | `grid[r].length` |
| every cell | a loop over the rows, with a loop over the columns of the row inside it |
| the cells around a cell | the rows `r - 1` to `r + 1` and the columns `c - 1` to `c + 1`, each index checked first |
| rows of different lengths | `new int[3][]`, then each row with its own `new int[...]` |
| the whole grid as text | `Arrays.deepToString(grid)` |

## Four in a row

In the game Four in a row, two players take turns dropping pieces into the columns of an upright board, often 6 rows by 7 columns. A piece falls down its column to the lowest free place. The first player with four pieces in a line, across, up and down or diagonally, wins.

The board can be a `char[][]`, with `'.'` for a free place and a player's letter, `'X'` or `'O'`, for a piece. A new `char[][]` holds the character with code 0 in every cell, which doesn't print as anything useful, so the constructor fills the board with `'.'` first. Row 0 is the top row, as the board is printed, so the lowest free place in a column is found by going up the column from the bottom row, `board.length - 1`.

A line of four starts from some cell and takes the same step three times. A step is a number of rows and a number of columns, as in step 4: `0` rows and `1` column goes across, `1` and `0` goes down, `1` and `1` down to the right, and `1` and `-1` down to the left. Every cell on the way must be inside the board and hold the same piece.

## Array or hash map?

An array finds a cell straight from its indexes, with no `hashCode`, no `equals` and no bucket to search, as module 45's hash map has. On the other hand, a grid reserves room for every cell when it's created. A grid where nearly every place stays empty, such as a map of a whole city with a few marked spots, could keep only the cells that are used in a HashMap, with keys such as `"120,45"` for row 120, column 45. For a game board, where many cells are used and the size is small and fixed, the array is the simpler choice.

## The end of part 12

This step ends the material of the MOOC's twelfth part. Module 44 gave classes type parameters: a class written once with `<T>` and used as `Box<String>` or `Box<Integer>`, classes with several type parameters, and generic interfaces. A type argument is always a reference type (a class, an interface or an array type such as `int[]`), never a primitive type, so `int` becomes `Integer`. Module 45 had you build your own ArrayList and HashMap: a list on top of an array that grows, `remove` that moves the rest along, and a hash map with an array of buckets chosen by hash codes, which is why its lookups stay fast. Module 46 brought random numbers: `Random` and `nextInt`, ranges such as 1 to 6, seeds that give the same numbers again, `nextDouble` and `Math.random()`, shuffling and simulations. This module added grids: two-dimensional arrays, their rows and columns, nested loops and neighbors. Part 13 comes next, with graphical user interfaces. Part 12 ends with [the MOOC's summary page](https://java-programming.mooc.fi/part-12/5-summary) on its own site.

---

Source: [Four in a row, and the end of part 12](https://javaarena.com/learn/multidimensional-arrays/end-of-part-12/) in the module [Two-dimensional arrays](https://javaarena.com/learn/multidimensional-arrays/) on Java Arena.

This module follows sections [12.4 Multidimensional data](https://java-programming.mooc.fi/part-12/4-multidimensional-data), [12.5 Summary](https://java-programming.mooc.fi/part-12/5-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
