> [!info] AI-Generated

# Putting it all together

This module's tools often turn up together, even in a single class. Here they are side by side:

| Tool | Example |
| --- | --- |
| An object as a parameter | `printer.print(document)` |
| An object as an instance variable | `private Address address;` |
| A parameter of the class's own type | `big.isHeavierThan(small)` |
| Equal contents, not the same object | `mine.equals(yours)` |
| List methods that use `equals` | `booked.contains(new Seat("B", 7))` |
| A method that returns a new object | `photo.rotated()` |

A position on a grid of squares uses three of them. A position can make the position next to it, tell how many steps away another position is, and tell whether it's equal to another:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Position start = new Position(0, 0);
        Position shop = new Position(3, -2);
        Position next = start.moved(1, 0);
        System.out.println(next);
        System.out.println(start.stepsTo(shop));
        System.out.println(next.moved(2, -2).equals(shop));
        System.out.println(start);
    }
}
```

**Position.java**

```java
public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position moved(int dx, int dy) {
        return new Position(this.x + dx, this.y + dy);
    }

    public int stepsTo(Position other) {
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof Position)) {
            return false;
        }
        Position other = (Position) compared;
        return this.x == other.x && this.y == other.y;
    }

    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}
```

**Output**

```text
(1, 0)
5
true
(0, 0)
```

- `moved` returns a new Position, so `start` stays at (0, 0), as the last line shows.
- `stepsTo` takes another Position and reads its private `x` and `y`. It counts the steps from square to square along the rows and columns, without going diagonally: 3 steps across and 2 steps down make 5.
- `next.moved(2, -2)` is a new object, never the one in `shop`, but its contents are the same, so `equals` says they're equal. With the `equals` every class gets, it would say false.

This step's challenges build on the class: a robot that moves around the grid, and a treasure hunt with a list of positions.

## The end of part 5

This step ends the material of the MOOC's fifth part. Part 5 went deeper into object-oriented programming. You planned classes and gave methods and constructors several versions by overloading them. You saw that a variable of a primitive type, such as an `int`, holds its value, while a variable of a class type holds a reference to an object. Two variables can refer to the same object, and a reference can be `null`, which means no object at all. In this module, objects started working together: as parameters, as instance variables of other objects, compared with `equals`, found in lists and returned from methods. Next, part 6 puts lists inside objects. Part 5 closes with [the MOOC's conclusion page](https://java-programming.mooc.fi/part-5/5-conclusion) on its own site, for reading only.

---

Source: [Putting it all together](https://javaarena.com/learn/object-interaction/end-of-part-5/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
