> [!info] AI-Generated

# Questions about a file of records

Many programs start from a file. The data is read once, each line into an object, and then the program answers questions about it. Step 1's plan fits here too: a class for one record, a class for the logic that holds the list and answers the questions, and the input part, which now reads a file as well as the keyboard.

A holiday company rents out cabins, and its file has one cabin per line: the name, the number of beds and the price of a night, separated by commas. The first line is a header (module 20), and someone left a line unfinished. The program reads the size of a group from the keyboard and answers three questions: which cabins have enough beds, how many beds there are in all, and which cabin is the cheapest one that fits the group.

**The file cabins.csv**

```text
name,beds,price
Birch,4,90
Lakeside,6,140
Old Mill,2
Pine Hill,6,120
Fox Den,8,180
```

**Main.java**

```java
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CabinList cabins = readCabins("cabins.csv");
        Scanner scanner = new Scanner(System.in);
        int people = Integer.valueOf(scanner.nextLine());
        System.out.println("Cabins with " + people + " beds or more:");
        for (Cabin cabin : cabins.withBeds(people)) {
            System.out.println(cabin);
        }
        System.out.println("Beds in all: " + cabins.totalBeds());
        Cabin cheapest = cabins.cheapestFor(people);
        if (cheapest == null) {
            System.out.println("No cabin fits " + people);
        } else {
            System.out.println("Cheapest for " + people + ": " + cheapest);
        }
    }

    public static CabinList readCabins(String fileName) {
        CabinList cabins = new CabinList();
        try (Scanner scanner = new Scanner(Paths.get(fileName))) {
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split(",");
                if (parts.length < 3) {
                    continue;
                }
                cabins.add(new Cabin(parts[0], Integer.valueOf(parts[1]), Integer.valueOf(parts[2])));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return cabins;
    }
}
```

**Cabin.java**

```java
public class Cabin {
    private String name;
    private int beds;
    private int price;

    public Cabin(String name, int beds, int price) {
        this.name = name;
        this.beds = beds;
        this.price = price;
    }

    public int getBeds() {
        return this.beds;
    }

    public int getPrice() {
        return this.price;
    }

    public String toString() {
        return this.name + " (" + this.beds + " beds, " + this.price + " euros)";
    }
}
```

**CabinList.java**

```java
import java.util.ArrayList;

public class CabinList {
    private ArrayList<Cabin> cabins;

    public CabinList() {
        this.cabins = new ArrayList<>();
    }

    public void add(Cabin cabin) {
        this.cabins.add(cabin);
    }

    public ArrayList<Cabin> withBeds(int people) {
        ArrayList<Cabin> fitting = new ArrayList<>();
        for (Cabin cabin : this.cabins) {
            if (cabin.getBeds() >= people) {
                fitting.add(cabin);
            }
        }
        return fitting;
    }

    public int totalBeds() {
        int total = 0;
        for (Cabin cabin : this.cabins) {
            total += cabin.getBeds();
        }
        return total;
    }

    public Cabin cheapestFor(int people) {
        Cabin cheapest = null;
        for (Cabin cabin : this.cabins) {
            if (cabin.getBeds() < people) {
                continue;
            }
            if (cheapest == null || cabin.getPrice() < cheapest.getPrice()) {
                cheapest = cabin;
            }
        }
        return cheapest;
    }
}
```

**Input**

```text
5
```

**Output**

```text
Cabins with 5 beds or more:
Lakeside (6 beds, 140 euros)
Pine Hill (6 beds, 120 euros)
Fox Den (8 beds, 180 euros)
Beds in all: 24
Cheapest for 5: Pine Hill (6 beds, 120 euros)
```

## Reading: one line, one object

`readCabins` is module 20's reading loop, with one check added. `Old Mill,2` splits into only two parts, and `parts[2]` would throw an exception. Inside the `try`, that would end the reading at that line, and the cabins after it would be lost. `parts.length < 3` catches the line first, and `continue` skips it, so Pine Hill and Fox Den are still read. That's why the beds add up to 24: Old Mill isn't in the list.

One record per line keeps the reading simple: every line is split in the same way, and every line becomes one object. The method returns the whole CabinList, so `main` starts with a single line, and the questions never see the file at all.

## Three kinds of questions

Most questions about records are one of three kinds, and each has its own loop shape:

- **A filter**: the records that match a condition. `withBeds` puts them in a new list and returns it, so the caller decides what to do with them: print them, count them or ask more questions about them.
- **A total**: add up one value of every record, as in `totalBeds`.
- **The best match**: of the records that match, the one that's best in some way. `cheapestFor` combines the two others. `continue` skips the cabins that are too small, and the rest compete as in step 1's `longest`: the best so far starts as `null`, and a cabin takes its place when it's cheaper. When no cabin fits, the method returns `null`, and `main` prints `No cabin fits 9` for a group of 9.

---

Source: [Questions about a file of records](https://javaarena.com/learn/larger-programs/questions-about-a-file/) in the module [Larger programs](https://javaarena.com/learn/larger-programs/) on Java Arena.

This module follows sections [7.3 Larger programming exercises](https://java-programming.mooc.fi/part-7/3-larger-exercises), [7.4 Conclusion](https://java-programming.mooc.fi/part-7/4-java-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
