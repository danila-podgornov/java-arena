> [!info] AI-Generated

# Test-driven development

So far, the code came first and its tests afterwards. **Test-driven development**, or TDD for short, turns that around: before you write a piece of code, you write a test for it. The work goes in small rounds:

1. Write one test for something the class doesn't do yet.
2. Run the tests and see the new one fail. A test that passes before the code even exists isn't testing anything.
3. Write just enough code to make it pass, and no more.
4. Run all the tests. They should all pass, the old ones too.
5. Tidy up the code if it needs it, running the tests after each change. Then start the next round.

Here's a countdown for a kitchen timer, built this way.

## Round 1: the starting time

The first test says that a new countdown of 90 seconds has 90 seconds left. For the test to compile, `Countdown` needs a constructor and a method `secondsLeft()`, so they're written first as empty shells, with `secondsLeft()` returning 0 for now:

**Countdown.java**

```java
public class Countdown {
    public Countdown(int seconds) {
    }

    public int secondsLeft() {
        return 0;
    }
}
```

**CountdownTest.java**

```java
import static org.junit.Assert.*;

import org.junit.Test;

public class CountdownTest {
    @Test
    public void startsWithItsSeconds() {
        Countdown countdown = new Countdown(90);
        assertEquals(90, countdown.secondsLeft());
    }
}
```

**Output**

```text
CountdownTest: 1 test
  startsWithItsSeconds: FAILED
    java.lang.AssertionError: expected:<90> but was:<0>
    at CountdownTest.startsWithItsSeconds(CountdownTest.java:9)
0 of 1 test passed
```

The test fails, as it should. Now just enough code to pass it: the countdown keeps its seconds in an instance variable, and returns them.

```java
private int seconds;

public Countdown(int seconds) {
    this.seconds = seconds;
}

public int secondsLeft() {
    return this.seconds;
}
```

Run the tests again, and `startsWithItsSeconds` passes.

## Round 2: a tick

The next test: after one `tick()`, there's a second less.

```java
@Test
public void tickTakesOneSecond() {
    Countdown countdown = new Countdown(90);
    countdown.tick();
    assertEquals(89, countdown.secondsLeft());
}
```

It doesn't even compile, since there's no `tick` yet. That counts as failing too. An empty `public void tick() { }` makes it compile, and the test fails with `expected:<89> but was:<90>`. Then `this.seconds--;` inside `tick` makes it pass, and the first test still passes too.

## Round 3: never below zero

A timer that has run out stays at zero. That's the next test, and it fails:

**Countdown.java**

```java
public class Countdown {
    private int seconds;

    public Countdown(int seconds) {
        this.seconds = seconds;
    }

    public void tick() {
        this.seconds--;
    }

    public int secondsLeft() {
        return this.seconds;
    }
}
```

**CountdownTest.java**

```java
import static org.junit.Assert.*;

import org.junit.Test;

public class CountdownTest {
    @Test
    public void startsWithItsSeconds() {
        Countdown countdown = new Countdown(90);
        assertEquals(90, countdown.secondsLeft());
    }

    @Test
    public void tickTakesOneSecond() {
        Countdown countdown = new Countdown(90);
        countdown.tick();
        assertEquals(89, countdown.secondsLeft());
    }

    @Test
    public void stopsAtZero() {
        Countdown countdown = new Countdown(1);
        countdown.tick();
        countdown.tick();
        assertEquals(0, countdown.secondsLeft());
    }
}
```

**Output**

```text
CountdownTest: 3 tests
  startsWithItsSeconds: passed
  stopsAtZero: FAILED
    java.lang.AssertionError: expected:<0> but was:<-1>
    at CountdownTest.stopsAtZero(CountdownTest.java:24)
  tickTakesOneSecond: passed
2 of 3 tests passed
```

Just enough code to pass it is one `if`:

```java
public void tick() {
    if (this.seconds > 0) {
        this.seconds--;
    }
}
```

Now all three tests pass. The next round could add `isDone()`, then a way to add a minute, and so on: one test, then the code for it.

## Why work this way

- You decide what the code should do before you decide how. The test is the class's first user, so an awkward method name or parameter shows up early.
- Every piece of code has a test from the start, and the tests stay. When a later change breaks something that used to work, a test fails right away.
- The rounds are small. At any moment at most one test fails, and you know that the problem is in the few lines you just wrote.

Not everyone works test first. Many programmers write the tests right after the code, and that works too. What matters is that the tests get written, and that you have seen each one fail at least once, so you know it can.

---

Source: [Test-driven development](https://javaarena.com/learn/unit-testing/test-driven-development/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
