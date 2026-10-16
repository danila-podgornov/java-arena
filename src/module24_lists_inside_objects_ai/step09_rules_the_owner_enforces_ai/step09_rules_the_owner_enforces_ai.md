> [!info] AI-Generated

# Rules the owner enforces

So far every `add` put its object on the list, no questions asked. But the object that owns the list can also have rules about what goes on it. A parking garage has a fixed number of spots, and the same car can't be parked in it twice:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        ParkingGarage garage = new ParkingGarage(2);
        System.out.println(garage.park(new Car("ABC-123")));
        System.out.println(garage.park(new Car("ABC-123")));
        System.out.println(garage.park(new Car("XYZ-789")));
        System.out.println(garage.park(new Car("JKL-456")));
        garage.leave("ABC-123");
        System.out.println(garage.park(new Car("JKL-456")));
        System.out.println(garage);
    }
}
```

**ParkingGarage.java**

```java
import java.util.ArrayList;

public class ParkingGarage {
    private int spots;
    private ArrayList<Car> cars;

    public ParkingGarage(int spots) {
        this.spots = spots;
        this.cars = new ArrayList<>();
    }

    public boolean park(Car car) {
        if (this.cars.size() >= this.spots) {
            return false;
        }
        if (this.isParked(car.getPlate())) {
            return false;
        }
        this.cars.add(car);
        return true;
    }

    public boolean isParked(String plate) {
        for (Car car : this.cars) {
            if (car.getPlate().equals(plate)) {
                return true;
            }
        }
        return false;
    }

    public void leave(String plate) {
        for (int i = this.cars.size() - 1; i >= 0; i--) {
            if (this.cars.get(i).getPlate().equals(plate)) {
                this.cars.remove(i);
            }
        }
    }

    public String toString() {
        return this.cars.size() + "/" + this.spots + " spots taken: " + this.cars;
    }
}
```

**Car.java**

```java
public class Car {
    private String plate;

    public Car(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return this.plate;
    }

    public String toString() {
        return this.plate;
    }
}
```

**Output**

```text
true
false
true
false
true
2/2 spots taken: [XYZ-789, JKL-456]
```

- `park` checks its rules first, and adds the car only when all of them hold: there's a free spot, and no car with the same plate is parked. Each rule that fails returns `false` right away.
- The `boolean` it returns tells the caller whether the car got in. `main` prints it here; a real program could print `Garage full` instead.
- `park` uses another method of the same object, `this.isParked(...)`. Small methods like this one can be useful to the caller too: `garage.isParked("ABC-123")`.
- After `leave`, there's a free spot again, and the car that was turned away gets in.

The rules always hold because the list is private. The only way onto the list is through `park`, and `park` checks every car. No other part of the program can put a car in past the rules, however it's written.

## Don't hand out the list

Suppose ParkingGarage had a getter for its list:

```java
public ArrayList<Car> getCars() {
    return this.cars;
}
```

It returns a reference to the garage's own list, not a copy (module 22). With it, `garage.getCars().add(new Car("NEW-001"));` puts a car straight on the list, past every rule, even into a full garage. So keep the list to the class, and give the class methods for what the rest of the program needs: `park`, `leave`, `isParked`, a toString.

## The module's tools

| Tool | Example |
| --- | --- |
| A list as an instance variable | `private ArrayList<Book> books;` |
| Made in the constructor | `this.books = new ArrayList<>();` |
| A loop over the object's list | `for (Book book : this.books)` |
| A toString built in a loop | `text = text + "\n" + book;` |
| Removing while going through | an index loop that goes backwards |
| A total from the objects | `total = total + book.getPages();` |
| A search that may find nothing | returns the object, or `null` |
| A rule checked before adding | `if (this.cars.size() >= this.spots)` |

---

Source: [Rules the owner enforces](https://javaarena.com/learn/objects-with-lists/rules-for-adding/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
