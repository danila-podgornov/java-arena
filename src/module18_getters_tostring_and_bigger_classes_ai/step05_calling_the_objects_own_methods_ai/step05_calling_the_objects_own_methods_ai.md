> [!info] AI-Generated

# Calling the object's own methods

A method can call the other methods of its own object. Inside the class, `this.isFull()` calls `isFull` on the same object the current method was called on. This bus uses that:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bus bus = new Bus(2);
        bus.board();
        System.out.println(bus);
        bus.board();
        bus.board();
        System.out.println(bus);
    }
}
```

**Bus.java**

```java
public class Bus {
    private int seats;
    private int passengers;

    public Bus(int seats) {
        this.seats = seats;
        this.passengers = 0;
    }

    public int seatsLeft() {
        return this.seats - this.passengers;
    }

    public boolean isFull() {
        return this.seatsLeft() == 0;
    }

    public void board() {
        if (this.isFull()) {
            System.out.println("Sorry, the bus is full");
        } else {
            this.passengers++;
        }
    }

    public String toString() {
        return this.passengers + " on board, seats left: " + this.seatsLeft();
    }
}
```

**Output**

```text
1 on board, seats left: 1
Sorry, the bus is full
2 on board, seats left: 0
```

- `seatsLeft()` works out the free seats. `isFull()` asks `seatsLeft()` instead of doing the sum again, and `board()` asks `isFull()` before it lets anyone on.
- Each rule is written in one place. If the bus took standing passengers one day, only `seatsLeft` would change, and `isFull`, `board` and `toString` would all follow.
- `this.` in front of the call can be left out: inside the class, `isFull()` means the same. As with instance variables, writing it shows that the method belongs to this object.

A method that only the class itself needs can be `private`, like the instance variables. If nothing outside the bus used `seatsLeft`, it could be `private int seatsLeft()`: `isFull` and `toString` could still call it, but `main` couldn't.

---

Source: [Calling the object's own methods](https://javaarena.com/learn/object-methods/calling-own-methods/) in the module [Getters, toString and bigger classes](https://javaarena.com/learn/object-methods/) on Java Arena.

This module follows section [4.1 Introduction to object-oriented programming](https://java-programming.mooc.fi/part-4/1-introduction-to-object-oriented-programming) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
