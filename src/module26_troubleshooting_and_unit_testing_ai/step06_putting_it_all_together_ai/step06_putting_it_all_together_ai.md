> [!info] AI-Generated

# Putting it all together

This module's tools, side by side:

| Tool | Example |
| --- | --- |
| Input for a Scanner, written in the code | `new Scanner("12\n8\n")` |
| A test method | `@Test public void parkingTakesOneSpot()` |
| Compare with the expected value | `assertEquals(2, garage.freeSpots())` |
| Compare doubles, with a delta | `assertEquals(33.33, garage.percentFull(), 0.01)` |
| Check a boolean | `assertTrue(garage.park())`, `assertFalse(garage.park())` |
| The same start for every test | `@Before` |

The last one is new. When every test starts by making the same object, the test class can do that in one place: a method marked `@Before` runs before each test. It puts the object in an instance variable of the test class, and the tests use it from there.

Here it is in the tests of a coin flip log. Someone flips a coin and writes down each result, `heads` or `tails`, one per line, and the log reads them from a Scanner. The tests give it Strings, so the idea of the second step and JUnit work together:

**FlipLog.java**

```java
import java.util.Scanner;

public class FlipLog {
    private int heads;
    private int tails;

    public FlipLog() {
        this.heads = 0;
        this.tails = 0;
    }

    public void readFlips(Scanner scanner) {
        while (scanner.hasNextLine()) {
            String flip = scanner.nextLine();
            if (flip.equals("heads")) {
                this.heads++;
            } else if (flip.equals("tails")) {
                this.tails++;
            }
        }
    }

    public int headsCount() {
        return this.heads;
    }

    public int tailsCount() {
        return this.tails;
    }

    public boolean mostlyHeads() {
        return this.heads > this.tails;
    }
}
```

**FlipLogTest.java**

```java
import static org.junit.Assert.*;

import java.util.Scanner;
import org.junit.Before;
import org.junit.Test;

public class FlipLogTest {
    private FlipLog log;

    @Before
    public void setUp() {
        this.log = new FlipLog();
    }

    @Test
    public void countsBothSides() {
        this.log.readFlips(new Scanner("heads\ntails\nheads\n"));
        assertEquals(2, this.log.headsCount());
        assertEquals(1, this.log.tailsCount());
    }

    @Test
    public void otherLinesAreIgnored() {
        this.log.readFlips(new Scanner("edge\n\nheads\n"));
        assertEquals(1, this.log.headsCount());
        assertEquals(0, this.log.tailsCount());
    }

    @Test
    public void moreHeadsIsMostlyHeads() {
        this.log.readFlips(new Scanner("heads\ntails\nheads\n"));
        assertTrue(this.log.mostlyHeads());
    }

    @Test
    public void tieIsNotMostlyHeads() {
        this.log.readFlips(new Scanner("tails\nheads\n"));
        assertFalse(this.log.mostlyHeads());
    }
}
```

**Output**

```text
FlipLogTest: 4 tests
  countsBothSides: passed
  moreHeadsIsMostlyHeads: passed
  otherLinesAreIgnored: passed
  tieIsNotMostlyHeads: passed
4 of 4 tests passed
```

- `import org.junit.Before;` brings in `@Before`, and `java.util.Scanner` is imported as in any class that uses it.
- `private FlipLog log;` is an instance variable of the test class, and `setUp()`, marked `@Before`, gives it a new FlipLog.
- JUnit makes a new FlipLogTest object for every test, and runs `setUp()` on it before the test. So every test gets a new, empty FlipLog of its own: the three flips of `countsBothSides` never reach `tieIsNotMostlyHeads`.
- Each test gives `readFlips` exactly the input it's about, from an empty line to a tie, with no typing.

## The end of part 6

This step ends the material of the MOOC's sixth part. Part 6 put lists inside objects: a class kept a list in an instance variable, and its methods decided what could be done with it. Then programs were split in two, with the program's logic in classes of its own and a user interface class that reads the commands and prints the answers, so that each part can change without the other. This module was about knowing that it all works: reading a stack trace, troubleshooting step by step, giving code its input from a String, and unit tests with JUnit, written after the code or before it. Next, part 7 looks at different ways to structure a program, and at algorithms for sorting and searching. Part 6 closes with [the MOOC's page on complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) on its own site, for reading only.

---

Source: [Putting it all together](https://javaarena.com/learn/unit-testing/end-of-part-6/) in the module [Troubleshooting and unit testing](https://javaarena.com/learn/unit-testing/) on Java Arena.

This module follows sections [6.3 Introduction to testing](https://java-programming.mooc.fi/part-6/3-introduction-to-testing), [6.4 Complex programs](https://java-programming.mooc.fi/part-6/4-complex-programs) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
