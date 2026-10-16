> [!info] AI-Generated

# A command program, procedurally

Programs that take commands are where the two styles differ the most. Module 25 wrote them both ways without naming the styles: first with everything in `main`, then with the work in a class. This step and the next one look at that change as a change of paradigm.

Here's a box office that sells tickets for one concert, in a hall of 200 seats, written procedurally. Everything is in `main`: the program's state is two local variables, and its rules are `if`s inside the branches:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seats = 200;
        int sold = 0;
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            if (command.equals("quit")) {
                System.out.println("Box office closed");
                break;
            }
            if (command.equals("sell")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (sold + count > seats) {
                    System.out.println("Sorry, tickets left: " + (seats - sold));
                } else {
                    sold = sold + count;
                    System.out.println("Sold! Tickets left: " + (seats - sold));
                }
            } else if (command.equals("refund")) {
                int count = Integer.valueOf(scanner.nextLine());
                if (count > sold) {
                    System.out.println("Sorry, tickets sold: " + sold);
                } else {
                    sold = sold - count;
                    System.out.println("Refunded! Tickets left: " + (seats - sold));
                }
            } else if (command.equals("status")) {
                System.out.println("Sold: " + sold + ", left: " + (seats - sold));
            } else {
                System.out.println("Unknown command: " + command);
            }
        }
    }
}
```

**Input**

```text
sell
150
sell
80
sell
50
refund
20
refund
300
status
quit
```

**Output**

```text
> Sold! Tickets left: 50
> Sorry, tickets left: 50
> Sold! Tickets left: 0
> Refunded! Tickets left: 20
> Sorry, tickets sold: 180
> Sold: 180, left: 20
> Box office closed
```

- `seats` and `sold` are the program's state. They're created before the loop, so they last from one command to the next (module 25).
- `sell` checks the limit before it changes anything. When the tickets asked for don't fit, it sells none of them and says how many are left. `refund` checks the other end: it can't take back more tickets than were sold, so `sold` never goes below 0.
- The number of tickets left isn't kept anywhere. It's worked out from the two variables, as `seats - sold`, in four places.

## How it grows

This is easy to follow: one loop, one branch per command, read from top to bottom. The trouble comes as the program grows:

- The rules are mixed in with the reading and the printing. To find out what a refund may do, you read the `refund` branch past its `nextLine` and between its `println`s.
- Every branch that changes `sold` needs its own copy of a check. A new command that sells tickets in another way needs one too, and if a copy is missing or wrong, the concert is overbooked. Nothing warns you.
- A second concert, such as an afternoon show with its own seats, means two more variables and a copy of every branch that uses them.
- The only way to try the rules is to run the whole command loop on a list of commands, whether they're typed or fed to the program as input. The rules can't be tried on their own.

Static methods would help a little, as in step 1: `sold = sell(sold, count, seats);` could keep the check in one place. But a method returns only one value, so that call can't also say whether the sale went through. `main` needs to know that to print the right message, and it would have to find out by comparing `sold` before and after the call. The next step moves the state and the rules into a class instead.

---

Source: [A command program, procedurally](https://javaarena.com/learn/paradigms/procedural-commands/) in the module [Procedural and object-oriented programs](https://javaarena.com/learn/paradigms/) on Java Arena.

This module follows section [7.1 Programming paradigms](https://java-programming.mooc.fi/part-7/1-programming-paradigms) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
