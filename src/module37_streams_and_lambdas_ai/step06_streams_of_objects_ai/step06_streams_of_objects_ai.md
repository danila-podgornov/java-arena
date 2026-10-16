> [!info] AI-Generated

# Streams of objects

Streams work on lists of objects too, and that's where they're most useful. The lambdas call the objects' methods: a filter asks about a getter, and `map` turns each object into one of its values.

The cycling club from step 1 now keeps each ride as an object, with the rider's name and the distance:

**Main.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride("Noor", 42));
        rides.add(new Ride("Pablo", 65));
        rides.add(new Ride("Noor", 18));
        rides.add(new Ride("Kaia", 80));
        rides.add(new Ride("Pablo", 51));

        rides.stream()
                .filter(ride -> ride.getKm() > 50)
                .forEach(System.out::println);
    }
}
```

**Ride.java**

```java
public class Ride {
    private String rider;
    private int km;

    public Ride(String rider, int km) {
        this.rider = rider;
        this.km = km;
    }

    public String getRider() {
        return this.rider;
    }

    public int getKm() {
        return this.km;
    }

    @Override
    public String toString() {
        return this.rider + ": " + this.km + " km";
    }
}
```

**Output**

```text
Pablo: 65 km
Kaia: 80 km
Pablo: 51 km
```

The stream is a stream of Ride objects, so `ride` in the lambda is a Ride, and the lambda can call its methods. `forEach(System.out::println)` prints each ride with its `toString`.

## From objects to values

`map` can turn each ride into one of its values. The names of the club's riders, each once, in alphabetical order:

```java
List<String> riders = rides.stream()
        .map(ride -> ride.getRider())
        .distinct()
        .sorted()
        .collect(Collectors.toList());
System.out.println(riders);
```

For the five rides above, this prints `[Kaia, Noor, Pablo]`. After `map`, the stream holds Strings, so `distinct` and `sorted` work on the names.

A getter works as a method reference too: `Ride::getRider` is short for `ride -> ride.getRider()`, just as `String::toUpperCase` was a method of the value itself, named by its class.

## Sums and averages of a value

`mapToInt` with a getter turns the rides into their distances, as plain `int` values, ready for `sum` and `average`:

**Main.java**

```java
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Ride> rides = new ArrayList<>();
        rides.add(new Ride("Noor", 42));
        rides.add(new Ride("Pablo", 65));
        rides.add(new Ride("Noor", 18));
        rides.add(new Ride("Kaia", 80));
        rides.add(new Ride("Pablo", 51));

        double average = rides.stream()
                .mapToInt(Ride::getKm)
                .average()
                .getAsDouble();
        int noorsTotal = rides.stream()
                .filter(ride -> ride.getRider().equals("Noor"))
                .mapToInt(Ride::getKm)
                .sum();
        System.out.println("Average ride: " + average + " km");
        System.out.println("Noor: " + noorsTotal + " km");
    }
}
```

**Ride.java**

```java
public class Ride {
    private String rider;
    private int km;

    public Ride(String rider, int km) {
        this.rider = rider;
        this.km = km;
    }

    public String getRider() {
        return this.rider;
    }

    public int getKm() {
        return this.km;
    }

    @Override
    public String toString() {
        return this.rider + ": " + this.km + " km";
    }
}
```

**Output**

```text
Average ride: 51.2 km
Noor: 60 km
```

- The average is 256 / 5 = 51.2.
- The filter compares names with `equals`, as always for Strings, and then only Noor's rides reach `mapToInt`: 42 + 18 = 60.

## Lists of objects

`collect` works for objects as it does for numbers. `rides.stream().filter(ride -> ride.getKm() > 50).collect(Collectors.toList())` gives a `List<Ride>` of the long rides. The new list holds the same Ride objects as the old one, not copies (module 22): a change made to a ride through one list shows through the other.

One thing doesn't work yet: `sorted()` on a stream of Rides. Java knows how to order numbers and Strings, but not rides: by distance, or by name? Module 38 shows how to tell it. Until then, map the objects to values first, and sort those.

---

Source: [Streams of objects](https://javaarena.com/learn/streams/objects/) in the module [Streams and lambdas](https://javaarena.com/learn/streams/) on Java Arena.

This module follows section [10.1 Handling collections as streams](https://java-programming.mooc.fi/part-10/1-handling-collections-as-streams) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
