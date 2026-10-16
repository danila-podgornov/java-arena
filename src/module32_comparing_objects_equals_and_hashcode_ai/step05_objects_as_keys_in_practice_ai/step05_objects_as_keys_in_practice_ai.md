> [!info] AI-Generated

# Objects as keys in practice

Everything is in place now: a key class with `equals` and `hashCode`, and a `HashMap` that uses it. This step puts them to work in a small program, and deals with one more thing: the order in which to print what's in the map.

## A game board

A board game is played on a grid of squares, with columns A to F and rows 1 to 6, and each player has a token of a color. The game keeps the tokens in a `HashMap<Square, String>`, from a square to the color of the token on it. Square is the class from steps 1 and 3, now with both methods. The class `Board` places tokens, looks up squares, moves tokens and prints them all:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.place(new Square("C", 2), "red");
        board.place(new Square("A", 1), "blue");
        board.place(new Square("B", 3), "green");
        board.move(new Square("B", 3), new Square("D", 4));
        System.out.println(board.tokenAt(new Square("D", 4)));
        System.out.println(board.tokenAt(new Square("B", 3)));
        board.printTokens();
    }
}
```

**Board.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board {
    private HashMap<Square, String> tokens;

    public Board() {
        this.tokens = new HashMap<>();
    }

    public void place(Square square, String color) {
        this.tokens.put(square, color);
    }

    public String tokenAt(Square square) {
        if (this.tokens.containsKey(square)) {
            return this.tokens.get(square);
        }
        return "empty";
    }

    public void move(Square from, Square to) {
        if (this.tokens.containsKey(from)) {
            String color = this.tokens.get(from);
            this.tokens.remove(from);
            this.tokens.put(to, color);
        }
    }

    public void printTokens() {
        ArrayList<String> lines = new ArrayList<>();
        for (Square square : this.tokens.keySet()) {
            lines.add(square + " " + this.tokens.get(square));
        }
        Collections.sort(lines);
        for (String line : lines) {
            System.out.println(line);
        }
    }
}
```

**Square.java**

```java
public class Square {
    private String column;
    private int row;

    public Square(String column, int row) {
        this.column = column;
        this.row = row;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Square)) {
            return false;
        }
        Square other = (Square) compared;
        return this.column.equals(other.column) && this.row == other.row;
    }

    public int hashCode() {
        return 31 * this.column.hashCode() + this.row;
    }

    public String toString() {
        return this.column + this.row;
    }
}
```

**Output**

```text
green
empty
A1 blue
C2 red
D4 green
```

- Every method is given a Square made with `new`, never the object that was put in. `containsKey`, `get`, `put` and `remove` still find the right key, because Square has both `equals` and `hashCode`.
- `remove(key)` takes a key and its value out of the map (module 31). `move` gets the color, removes the old square, and puts the token on the new one.
- `tokenAt` checks `containsKey` first, so an empty square gives `empty` instead of `null`.

## The order of the keys

`printTokens` goes through the keys with `keySet()`, as in module 31. A hash map goes through its keys in an order set by their hash codes, not in the order they were added, and it's no order to rely on. With keys of your own class, it depends on how `hashCode` is written. So `printTokens` makes its own order: it builds a line for each token, puts the lines in a list, and sorts the list with `Collections.sort` (module 28). Square names sort well as Strings on this board: the column's letter first, then the row, which is always one digit.

Two other ways to get an order you can count on:

- Keep the keys in an `ArrayList` too, next to the map, in the order they were added. Go through the list, and get each value from the map.
- Go through the keys you want in the order you want, such as the squares of one row from A to F, and look each one up with a new Square and `containsKey` or `get`.

One warning: never go through, or print, a hash map whose keys have no `hashCode` of their own. Their hash codes are Java's default ones, which can change from run to run, and the order would change with them.

## Keys that don't change

A key goes into the bucket of the hash code it has when it's put in. If the key object changed later, its hash code would change too, and the map would look for it in the wrong bucket. So key classes usually have no setters: none of the key classes in this module can be changed once an object is made. That's why `move` doesn't change a Square: it removes the old key and puts in a new one.

---

Source: [Objects as keys in practice](https://javaarena.com/learn/equals-hashcode/objects-as-keys/) in the module [Comparing objects: equals and hashCode](https://javaarena.com/learn/equals-hashcode/) on Java Arena.

This module follows section [8.3 Similarity of objects](https://java-programming.mooc.fi/part-8/3-similarity-of-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
