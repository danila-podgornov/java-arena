> [!info] AI-Generated

# More assertions and good tests

The tests so far compared numbers with `assertEquals`. JUnit has more assertions, and a few habits make tests a lot more useful.

## assertTrue and assertFalse

`park()` returns `true` when the car got a spot, and `false` when the garage was full. For a method that returns a boolean, `assertTrue(...)` passes when the value is true, and `assertFalse(...)` when it's false:

```java
assertTrue(garage.park());
assertFalse(fullGarage.park());
```

`assertTrue(garage.park())` passes and fails in exactly the same cases as `assertEquals(true, garage.park())`, and reads better. Only the message on a failure differs: `assertEquals` says `expected:<true> but was:<false>`, while `assertTrue` says just `java.lang.AssertionError`, as you'll see below. To use all of JUnit's assertions without importing each one by name, write `import static org.junit.Assert.*;`.

`assertEquals` works for Strings and other objects too. It compares them with `equals`, so two different String objects with the same letters are equal.

## Comparing doubles

As module 18 showed, a double is often a tiny bit off: `0.1 + 0.2` is `0.30000000000000004`. And a garage with one car in three spots is 33.333333333333336% full, which nobody wants to type into a test. So for doubles, `assertEquals` takes a third value, the **delta**: how far apart the two values may be and still count as equal.

```java
assertEquals(33.33, garage.percentFull(), 0.01);
```

This passes when `percentFull()` returns anything within 0.01 of 33.33. Choose a delta smaller than any difference that would matter: for a percentage, 0.01 is plenty.

What about `assertEquals(33.33, garage.percentFull())`, without the delta? Such a call would compare the two doubles exactly, and pass or fail by the luck of the last digits. So JUnit has a version of `assertEquals` for two doubles that is there to stop this mistake: it fails the test every time, with the message `Use assertEquals(expected, actual, delta) to compare floating-point numbers`. It's marked **deprecated**, which means "don't use this", so javac also prints a note that the code uses something deprecated.

Here are all three in one test class. This Garage has `<=` in `park` where it should have `<`, a mistake right at the limit:

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
        if (this.parked <= this.spots) {
            this.parked++;
            return true;
        }
        return false;
    }

    public int freeSpots() {
        return this.spots - this.parked;
    }

    public double percentFull() {
        return 100.0 * this.parked / this.spots;
    }
}
```

**GarageTest.java**

```java
import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest {
    @Test
    public void carGetsASpotInAnEmptyGarage() {
        Garage garage = new Garage(2);
        assertTrue(garage.park());
    }

    @Test
    public void lastFreeSpotCanBeTaken() {
        Garage garage = new Garage(2);
        garage.park();
        assertTrue(garage.park());
    }

    @Test
    public void fullGarageSaysNo() {
        Garage garage = new Garage(2);
        garage.park();
        garage.park();
        assertFalse(garage.park());
    }

    @Test
    public void oneCarInThreeSpotsIsAThirdFull() {
        Garage garage = new Garage(3);
        garage.park();
        assertEquals(33.33, garage.percentFull(), 0.01);
    }
}
```

**Output**

```text
GarageTest: 4 tests
  carGetsASpotInAnEmptyGarage: passed
  fullGarageSaysNo: FAILED
    java.lang.AssertionError
    at GarageTest.fullGarageSaysNo(GarageTest.java:24)
  lastFreeSpotCanBeTaken: passed
  oneCarInThreeSpotsIsAThirdFull: passed
3 of 4 tests passed
```

When `assertTrue` or `assertFalse` fails, the report says only `java.lang.AssertionError`: there's no expected and actual value to show. So the test's name has to tell the story, and here it does: a full garage should say no, and it didn't.

Notice the two tests at the limit. `lastFreeSpotCanBeTaken` checks that the last spot can be used, and `fullGarageSaysNo` checks that the car after it is turned away. Together they pin the limit down exactly. With `<`, as it should be, both pass. With `<=`, a full garage takes one car too many, and `fullGarageSaysNo` fails. If the limit were off the other way, say `this.parked < this.spots - 1`, the last spot would be refused, and `lastFreeSpotCanBeTaken` would fail.

## Which tests to write

Module 12 listed the inputs worth trying: a typical case, the edges, and the unusual. With tests, every case you think of becomes a test that runs each time from then on. For a class, the edges are often:

- nothing at all: a new object, an empty list, a Scanner reading `""`;
- exactly one of something;
- zero, and negative numbers;
- exactly at a limit, and one past it.

Bugs gather at the edges, because that's where `<` or `<=`, or a loop's first and last round, make a difference.

## Good tests

- **One idea per test.** A test stops at its first failed assertion, so a test that checks five things hides the other four when one fails. Small tests each report on their own.
- **A name that says what it checks**, like `fullGarageSaysNo`, not `test3`. When it fails, the name alone tells you what's broken.
- **Work out the expected value yourself.** Copying what the code prints into the test only checks that the code does what it does.
- **Each test makes its own objects**, so it doesn't depend on what the other tests did.

---

Source: [More assertions and good tests](https://javaarena.com/learn/unit-testing/good-tests/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
