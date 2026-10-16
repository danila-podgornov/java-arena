> [!info] AI-Generated

# A class of your own

A class bundles values that belong together with the methods that work on them. Most classes in this course have had the same parts: private instance variables, a constructor, getters, methods that change the object, and a `toString`. Some also have an `equals`.

## The tools

| Tool | What it does | Taught in |
| --- | --- | --- |
| `public class Plank` in the file `Plank.java`, with `private` instance variables | a class of your own | module 17, Classes and objects |
| a constructor, with `this.length = length;` | sets up a new object | module 17, Classes and objects |
| a method that changes an instance variable | changes the object | module 17, Classes and objects |
| getters such as `getLength()`, and `toString()` | give values out, and the text `println` shows | module 18, Getters, toString and bigger classes |
| `==` on two objects | are they the very same object? | module 22, Primitive and reference variables |
| `public boolean equals(Object compared)` | what "equal" means for this class | module 23, Objects working together |

## A worked example

At a climbing gym, each wall has one route of each color, so a route is known by its wall and the color of its holds. It also has a grade, and the gym counts its ascents: how many times someone has climbed it to the top.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        ClimbingRoute route = new ClimbingRoute("north wall", "red", 5);
        route.climb();
        route.climb();
        System.out.println(route);

        ClimbingRoute written = new ClimbingRoute("north wall", "red", 5);
        System.out.println(route == written);
        System.out.println(route.equals(written));
        System.out.println(route.equals(new ClimbingRoute("north wall", "blue", 5)));
    }
}
```

**ClimbingRoute.java**

```java
public class ClimbingRoute {
    private String wall;
    private String color;
    private int grade;
    private int ascents;

    public ClimbingRoute(String wall, String color, int grade) {
        this.wall = wall;
        this.color = color;
        this.grade = grade;
        this.ascents = 0;
    }

    public String getWall() {
        return this.wall;
    }

    public String getColor() {
        return this.color;
    }

    public int getGrade() {
        return this.grade;
    }

    public int getAscents() {
        return this.ascents;
    }

    public void climb() {
        this.ascents++;
    }

    public boolean equals(Object compared) {
        if (this == compared) {
            return true;
        }
        if (!(compared instanceof ClimbingRoute)) {
            return false;
        }
        ClimbingRoute other = (ClimbingRoute) compared;
        return this.wall.equals(other.wall) && this.color.equals(other.color);
    }

    public String toString() {
        return this.color + " route on the " + this.wall + ", grade " + this.grade + ", ascents: " + this.ascents;
    }
}
```

**Output**

```text
red route on the north wall, grade 5, ascents: 2
false
true
false
```

- The constructor's parameters have the same names as the instance variables. `this.wall` is the object's variable, and `wall` alone is the parameter (module 18).
- `climb()` returns nothing: it changes the object's state. The getters only hand values out.
- `route == written` is false: two `new`s make two objects, whatever they hold. `equals` compares what's in them, in the way the class decides.
- The `equals` is module 23's, step by step: the exact header `public boolean equals(Object compared)`, the check for the very same object, the `instanceof` check, the cast, and then the comparison. Strings are compared with `equals`, and numbers with `==`.
- This `equals` compares only the wall and the color, the values that tell routes apart. The ascents change every day, and they don't make it another route.
- The list methods `contains`, `indexOf` and `remove(value)` use `equals` too (module 23), so a list of routes can find a route by its wall and color.

Module 32 comes back to `equals`, and adds its partner, `hashCode`.

---

Source: [A class of your own](https://javaarena.com/learn/recap/classes-and-objects/) in the module [Warm-up: recap of parts 1 to 7](https://javaarena.com/learn/recap/) on Java Arena.

This module follows section [8.1 Short recap](https://java-programming.mooc.fi/part-8/1-recap) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
