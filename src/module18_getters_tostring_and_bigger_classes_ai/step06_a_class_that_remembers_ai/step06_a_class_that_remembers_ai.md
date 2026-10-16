> [!info] AI-Generated

# A class that remembers

Objects are good at remembering. A class can collect numbers one at a time and answer questions about them whenever it's asked: how many there have been, their total, their average, the largest. This log of bike trips does that:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        TripLog log = new TripLog();
        log.add(12);
        log.add(40);
        log.add(5);
        System.out.println("Trips: " + log.tripCount());
        System.out.println("Total: " + log.totalKm() + " km");
        System.out.println("Longest: " + log.longestKm() + " km");
        System.out.println("Average: " + log.averageKm() + " km");
    }
}
```

**TripLog.java**

```java
public class TripLog {
    private int count;
    private int total;
    private int longest;

    public TripLog() {
        this.count = 0;
        this.total = 0;
        this.longest = 0;
    }

    public void add(int km) {
        this.count++;
        this.total = this.total + km;
        if (km > this.longest) {
            this.longest = km;
        }
    }

    public int tripCount() {
        return this.count;
    }

    public int totalKm() {
        return this.total;
    }

    public int longestKm() {
        return this.longest;
    }

    public double averageKm() {
        if (this.count == 0) {
            return 0.0;
        }
        return (double) this.total / this.count;
    }
}
```

**Output**

```text
Trips: 3
Total: 57 km
Longest: 40 km
Average: 19.0 km
```

- The log doesn't keep the trips themselves, only what it needs for its answers: how many trips, their sum, and the longest so far. Each `add` updates all three. (Later in the course, an object gets a list of its own.)
- The average isn't stored: `averageKm()` works it out when it's asked, from the count and the total. `(double)` turns the total into a `double` before the division, so the decimals aren't lost (module 4).
- `averageKm()` checks for an empty log first. With no trips there's no average, and the method returns 0.0 instead of dividing by zero.

The class does the bookkeeping, and `main` only gives it numbers and asks questions. The same class works whether the numbers are written in the code, as here, or typed in by a user. What a log like this remembers depends on the questions it has to answer: the challenges below keep track of other things than a count and a total.

---

Source: [A class that remembers](https://javaarena.com/learn/object-methods/a-class-that-remembers/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
