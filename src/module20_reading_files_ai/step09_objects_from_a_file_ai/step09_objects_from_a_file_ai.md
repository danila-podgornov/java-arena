> [!info] AI-Generated

# Objects from a file

In the previous step, each line's values were used right away and then forgotten. When the program needs them later, each line becomes an **object**: a class holds one record's values together, and a list holds the objects. Reading the file then takes one loop, and after it the program answers its questions from the list:

**The file trails.txt**

```text
Coast Path,14
Pine Loop,6
Ridge Walk,9
```

**Main.java**

```java
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Trail> trails = new ArrayList<>();
        try (Scanner scanner = new Scanner(Paths.get("trails.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                trails.add(new Trail(parts[0], Integer.valueOf(parts[1])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Trails: " + trails.size());
        System.out.println("Ten kilometers or less:");
        for (Trail trail : trails) {
            if (trail.getLength() <= 10) {
                System.out.println(trail);
            }
        }
    }
}
```

**Trail.java**

```java
public class Trail {
    private String name;
    private int length;

    public Trail(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }

    public String toString() {
        return this.name + " (" + this.length + " km)";
    }
}
```

**Output**

```text
Trails: 3
Ten kilometers or less:
Pine Loop (6 km)
Ridge Walk (9 km)
```

- Each line is split, and its parts go to the constructor in the order of its parameters: `new Trail(parts[0], Integer.valueOf(parts[1]))`. The new object goes straight into the list.
- The list is made before the `try`, so it's still there after it. If the file can't be read, the list simply stays empty.
- After the loop, the file is done with. The questions (how many, which ones, the longest) are answered from the list, with the tools of module 19.

## Reading in a method

A method that reads the file and returns the list keeps `main` short, and it can read any file of trails:

```java
public static ArrayList<Trail> readTrails(String fileName) {
    ArrayList<Trail> trails = new ArrayList<>();
    try (Scanner scanner = new Scanner(Paths.get(fileName))) {
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            trails.add(new Trail(parts[0], Integer.valueOf(parts[1])));
        }
    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    }
    return trails;
}
```

`main` then starts with `ArrayList<Trail> trails = readTrails("trails.txt");`.

## The end of part 4

This step ends the material of the MOOC's fourth part. Part 4 was the start of object-oriented programming: you wrote classes of your own, created objects from them with constructors, gave them methods such as getters and `toString`, and kept many objects in a list. This module then brought in data from outside the program: files, read line by line and turned into numbers, records and objects. Classes and files together let a program work with as much data as it's given. The MOOC closes the part with [a summary page](https://java-programming.mooc.fi/part-4/4-summary) on its own site, for reading only.

---

Source: [Objects from a file](https://javaarena.com/learn/reading-files/objects-from-a-file/) in the module [Reading files](https://javaarena.com/learn/reading-files/) on Java Arena.

This module follows sections [4.3 Files and reading data](https://java-programming.mooc.fi/part-4/3-files-and-reading-data), [4.4 Summary](https://java-programming.mooc.fi/part-4/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
