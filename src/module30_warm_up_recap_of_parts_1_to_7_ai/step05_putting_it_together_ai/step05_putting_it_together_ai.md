> [!info] AI-Generated

# Putting it together

The last step puts the tools of the earlier steps into one program, the way module 29 did: a class for the data, a class for the logic, and a part that reads the input and prints the answers. This time the data class has an `equals`, and the logic class lets the list methods use it.

## The tools

| Tool | What it does | Taught in |
| --- | --- | --- |
| an `ArrayList` of objects | many objects, and loops that ask them questions | module 19, Objects in a list |
| `new Scanner(Paths.get(fileName))` in a `try` | reads a file, line by line | module 20, Reading files |
| `null` for "not found" | an answer the caller checks | module 22, Primitive and reference variables |
| `contains`, `indexOf` and `remove(value)` on a list of your own objects | search the list with the class's `equals` | module 23, Objects working together |
| a class that keeps a list as an instance variable | the logic, apart from the input and output | module 24, Lists inside objects |
| a loop that reads commands | a text user interface | module 25, Separating the UI from program logic |

## A worked example

The climbing gym of step 4 keeps its routes in a file, one per line: the wall, the color and the grade. Someone typed the red route on the north wall twice, the second time with another grade. A route is known by its wall and color, so the second line is the same route, and it must not end up in the list twice. At the front desk, climbers then log their ascents with the command `climb` and a line such as `north wall,red`.

`ClimbingRoute` is step 4's class, with its `equals`. Its getters are left out here, since this program doesn't use them.

**The file routes.csv**

```text
north wall,red,5
north wall,blue,3
overhang,green,4
north wall,red,6
slab,yellow,2
```

**Main.java**

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gym gym = readGym("routes.csv");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Gym closed");
                break;
            }
            if (command.equals("climb")) {
                String[] parts = scanner.nextLine().split(",");
                ClimbingRoute route = gym.find(parts[0], parts[1]);
                if (route == null) {
                    System.out.println("No " + parts[1] + " route on the " + parts[0]);
                } else {
                    route.climb();
                    System.out.println(route);
                }
            } else if (command.equals("routes")) {
                for (ClimbingRoute route : gym.routes()) {
                    System.out.println(route);
                }
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }

    public static Gym readGym(String fileName) {
        Gym gym = new Gym();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                ClimbingRoute route = new ClimbingRoute(parts[0], parts[1], Integer.valueOf(parts[2]));
                if (!gym.add(route)) {
                    System.out.println("Listed twice: " + route);
                }
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return gym;
    }
}
```

**Gym.java**

```java
import java.util.ArrayList;

public class Gym {
    private ArrayList<ClimbingRoute> routes;

    public Gym() {
        this.routes = new ArrayList<>();
    }

    public boolean add(ClimbingRoute route) {
        if (this.routes.contains(route)) {
            return false;
        }
        this.routes.add(route);
        return true;
    }

    public ClimbingRoute find(String wall, String color) {
        int index = this.routes.indexOf(new ClimbingRoute(wall, color, 0));
        if (index < 0) {
            return null;
        }
        return this.routes.get(index);
    }

    public ArrayList<ClimbingRoute> routes() {
        return this.routes;
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

**Input**

```text
climb
north wall,red
climb
overhang,green
climb
north wall,red
climb
slab,blue
routes
quit
```

**Output**

```text
Listed twice: red route on the north wall, grade 6, ascents: 0
> red route on the north wall, grade 5, ascents: 1
> green route on the overhang, grade 4, ascents: 1
> red route on the north wall, grade 5, ascents: 2
> No blue route on the slab
> red route on the north wall, grade 5, ascents: 2
blue route on the north wall, grade 3, ascents: 0
green route on the overhang, grade 4, ascents: 1
yellow route on the slab, grade 2, ascents: 0
> Gym closed
```

- `ClimbingRoute` is the data, `Gym` is the logic, and `main` reads the file and the commands. Gym holds the list and answers with return values, `false` and `null` included, but prints nothing: `main` turns the answers into messages.
- `add` asks `contains` first. `contains` compares with `equals`, so the fourth line of the file is found in the list, although it's a new object with another grade, and it's not added.
- `find` needs a route to search with, so it makes one from the wall and the color. The grade doesn't matter to `equals`, so 0 will do. `indexOf` gives the index of the equal route in the list, and `get` gives that route itself, not a copy, so `route.climb()` in `main` changes the route in the list. The `routes` command shows the count.
- `contains` and `indexOf` go through the list from the start, and compare each route with `equals` until one matches. A gym with a thousand routes can take a thousand comparisons for every search. Module 31's hash map finds a value by its key without going through the others.

---

Source: [Putting it together](https://javaarena.com/learn/recap/putting-it-together/) in the module [Warm-up: recap of parts 1 to 7](https://javaarena.com/learn/recap/) on Java Arena.

This module follows section [8.1 Short recap](https://java-programming.mooc.fi/part-8/1-recap) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
