> [!info] AI-Generated

# Reading input in a loop

This module opens Java Programming II, the second half of the course. It has nothing new in it: it's a warm-up. Module 29 ended with a list of everything parts 1 to 7 covered, and this module puts that list to work. Each step reminds you of one group of tools and names the module that taught them, works through an example or two, and then gives you three challenges. If a tool feels rusty, the module named next to it has the full story.

## The tools

| Tool | What it does | Taught in |
| --- | --- | --- |
| `scanner.nextLine()` | reads one line of input as a String | module 2, Reading input and strings |
| `Integer.valueOf(line)` | turns text such as `"42"` into the int 42 | module 3, Variables and types |
| `/` between two ints | whole-number division: the decimals are dropped | module 4, Calculating with numbers |
| `%` | the remainder: what's left over after the division | module 6, Conditions and logic |
| `if`, `else if`, `else` | picks one branch | module 5, Making decisions |
| `while (true)` and `break` | repeats until something inside the loop ends it | module 8, Repeating with while |
| `continue` | skips the rest of this round, and goes on with the next one | module 8, Repeating with while |
| `for (int i = 0; i < n; i++)` | repeats a known number of times | module 9, Loop conditions and for |

## A worked example

A small car ferry crosses a lake. Its deck holds 4 cars, and bikes ride along in a rack of their own. Before the first crossing, the ferry worker counts the waiting vehicles: the first line of input is how many there are, and each line after it is one vehicle, `car` or `bike`. A car's fare is 12 euros, and a bike's 3.

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vehicles = Integer.valueOf(scanner.nextLine());
        int cars = 0;
        int bikes = 0;
        for (int i = 0; i < vehicles; i++) {
            String vehicle = scanner.nextLine();
            if (vehicle.equals("car")) {
                cars++;
            } else {
                bikes++;
            }
        }
        int fullTrips = cars / 4;
        int lastTrip = cars % 4;
        System.out.println("Cars: " + cars + ", bikes: " + bikes);
        System.out.println("Fares: " + (cars * 12 + bikes * 3) + " euros");
        if (lastTrip == 0) {
            System.out.println("Trips: " + fullTrips);
        } else {
            System.out.println("Trips: " + (fullTrips + 1) + ", the last one with " + lastTrip + " cars");
        }
    }
}
```

**Input**

```text
8
car
car
bike
car
car
bike
car
car
```

**Output**

```text
Cars: 6, bikes: 2
Fares: 78 euros
Trips: 2, the last one with 2 cars
```

- The first line says how many lines follow, so a `for` loop reads exactly that many, and no stop word is needed. The loop variable `i` only counts the rounds.
- `cars / 4` is the number of full trips: with two ints, the division drops the decimals, so 6 cars make 1 full trip, not 1.5. `cars % 4` is what's left over, the cars on a last trip that isn't full. When it's 0, every trip is full.
- `(cars * 12 + bikes * 3)` needs its parentheses. Without them, `+` would join each number to the text in turn instead of adding them up (module 4).

The other common way to read input, until a stop word, with a rule that skips values and counts that grow as the loop goes, is module 29's step "Statistics from input". The first challenge below practices it.

---

Source: [Reading input in a loop](https://javaarena.com/learn/recap/input-and-loops/) in the module [Warm-up: recap of parts 1 to 7](https://javaarena.com/learn/recap/) on Java Arena.

This module follows section [8.1 Short recap](https://java-programming.mooc.fi/part-8/1-recap) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
