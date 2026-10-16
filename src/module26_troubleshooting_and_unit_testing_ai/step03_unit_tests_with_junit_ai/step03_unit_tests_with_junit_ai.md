> [!info] AI-Generated

# Unit tests with JUnit

The `check` method of the last step is a test written by hand. Java programmers usually write their tests with a library instead, and a widely used one is **JUnit**. This module uses JUnit 4, the version the MOOC uses. (JUnit 5, the newer version, works much the same way, with different imports and a few different names and details. For example, `@Before`, which comes later in this module, is `@BeforeEach` there, and doubles can be compared without a delta.)

JUnit tests are methods in a class of their own, a **test class**, next to the class they test. Here a parking garage has a number of spots, and cars park and leave. The page shows the garage and its test class, and then the report of running the tests:

**Garage.java**

```java
public class Garage {
    private int spots;
    private int parked;

    public Garage(int spots) {
        this.spots = spots;
        this.parked = 0;
    }

    public boolean park() {
        if (this.parked < this.spots) {
            this.parked++;
            return true;
        }
        return false;
    }

    public void leave() {
        if (this.parked > 0) {
            this.parked--;
        }
    }

    public int freeSpots() {
        return this.spots - this.parked;
    }
}
```

**GarageTest.java**

```java
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GarageTest {
    @Test
    public void newGarageHasEverySpotFree() {
        Garage garage = new Garage(3);
        assertEquals(3, garage.freeSpots());
    }

    @Test
    public void parkingTakesOneSpot() {
        Garage garage = new Garage(3);
        garage.park();
        assertEquals(2, garage.freeSpots());
    }

    @Test
    public void fullGarageTakesNoMoreCars() {
        Garage garage = new Garage(2);
        garage.park();
        garage.park();
        garage.park();
        assertEquals(0, garage.freeSpots());
    }
}
```

**Output**

```text
GarageTest: 3 tests
  fullGarageTakesNoMoreCars: passed
  newGarageHasEverySpotFree: passed
  parkingTakesOneSpot: passed
3 of 3 tests passed
```

JUnit runs the tests and collects their results. The report above is how Java Arena shows those results. On your own computer, an editor shows the same results in a window of its own.

Piece by piece:

- The test class is an ordinary public class. By custom it's named after the class it tests, with `Test` at the end: `GarageTest` tests `Garage`.
- `import org.junit.Test;` brings in `@Test`, and `import static org.junit.Assert.assertEquals;` brings in JUnit's method `assertEquals`, so the tests can call it by its short name. (A **static import** brings in a static method of another class. Without it, every call would be written `Assert.assertEquals(...)`.)
- `@Test` on the line before a method marks the method as a test. It's an **annotation**: a note on the method, which JUnit reads. A test method is `public void` and takes no parameters.
- There's no `main`. JUnit finds the methods marked `@Test` and runs each one on its own. Each test makes a Garage of its own, so one test can't spoil another, and the order they run in doesn't matter. (JUnit picks the order itself. Java Arena's report lists the tests in alphabetical order.)
- `assertEquals(expected, actual)` compares two values: first the value the test expects, then the code that gives the real value. When they're equal, the test goes on. When they aren't, the test stops right there and fails.
- The report lists every test with `passed` or `FAILED`, and then how many passed.

A test uses the class the way any other code would. `park()` returns true or false, and these tests don't use that value, which is fine.

## When a test fails

Now someone "simplifies" `park` and forgets about the full garage. The tests are the same:

**Garage.java**

```java
public class Garage {
    private int spots;
    private int parked;

    public Garage(int spots) {
        this.spots = spots;
        this.parked = 0;
    }

    public boolean park() {
        this.parked++;
        return true;
    }

    public void leave() {
        if (this.parked > 0) {
            this.parked--;
        }
    }

    public int freeSpots() {
        return this.spots - this.parked;
    }
}
```

**GarageTest.java**

```java
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GarageTest {
    @Test
    public void newGarageHasEverySpotFree() {
        Garage garage = new Garage(3);
        assertEquals(3, garage.freeSpots());
    }

    @Test
    public void parkingTakesOneSpot() {
        Garage garage = new Garage(3);
        garage.park();
        assertEquals(2, garage.freeSpots());
    }

    @Test
    public void fullGarageTakesNoMoreCars() {
        Garage garage = new Garage(2);
        garage.park();
        garage.park();
        garage.park();
        assertEquals(0, garage.freeSpots());
    }
}
```

**Output**

```text
GarageTest: 3 tests
  fullGarageTakesNoMoreCars: FAILED
    java.lang.AssertionError: expected:<0> but was:<-1>
    at GarageTest.fullGarageTakesNoMoreCars(GarageTest.java:25)
  newGarageHasEverySpotFree: passed
  parkingTakesOneSpot: passed
2 of 3 tests passed
```

The failed test has two more lines:

- `java.lang.AssertionError: expected:<0> but was:<-1>`: an assertion failed. The test expected 0 free spots, and the garage said -1: it let a third car into two spots.
- `at GarageTest.fullGarageTakesNoMoreCars(GarageTest.java:25)`: the line of the test where it failed.

The test's name tells what went wrong before you read any further: a full garage took one more car. So the place to look is `park`. The other two tests still pass. Each test checks one thing, so a failure points at one thing.

That's also why the order of the two values matters. Written the other way around, `assertEquals(garage.freeSpots(), 0)` fails just the same, but its message says `expected:<-1> but was:<0>`, which sends you looking for the wrong problem. The expected value goes first.

If the code a test calls crashes, the test fails too, and the report shows the exception, such as `java.lang.ArithmeticException: / by zero`, with the line of your own code where it happened.

In a project on your own computer, test classes usually live in a folder of their own (in the MOOC's projects, `src/test/java`), and the editor has a button that runs them. Here, the test class is one more tab, and "Run my tests" runs it.

---

Source: [Unit tests with JUnit](https://javaarena.com/learn/unit-testing/junit/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
