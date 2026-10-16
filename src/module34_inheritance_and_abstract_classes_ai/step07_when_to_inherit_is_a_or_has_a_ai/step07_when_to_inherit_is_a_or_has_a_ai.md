> [!info] AI-Generated

# When to inherit: is a, or has a?

`extends` is easy to write, and it saves code, so it's tempting to use it whenever one class could use another's methods. But it says something strong: every object of the subclass *is* an object of the superclass, and can be used wherever one is expected (step 6). When that isn't true, inheritance causes trouble.

## A misuse

A courier's parcels need the street and city they go to. `Address` already has a street, a city, a getter and a `toString`, so someone writes `Parcel extends Address` to get them all for free:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Parcel parcel = new Parcel("9 Dock Road", "Hull", 1800);
        System.out.println(parcel.getCity() + ", " + parcel.getGrams() + " g");
        System.out.println(parcel);

        ArrayList<Address> friends = new ArrayList<>();
        friends.add(new Address("12 Oak Road", "York"));
        friends.add(parcel);
        System.out.println(friends.size() + " addresses");
    }
}
```

**Address.java**

```java
public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return this.street + ", " + this.city;
    }
}
```

**Parcel.java**

```java
public class Parcel extends Address {
    private int grams;

    public Parcel(String street, String city, int grams) {
        super(street, city);
        this.grams = grams;
    }

    public int getGrams() {
        return this.grams;
    }
}
```

**Output**

```text
Hull, 1800 g
9 Dock Road, Hull
2 addresses
```

It compiles and runs, and that's the trouble. The class says "a parcel is an address", which isn't true, and Java believes it:

- A parcel went into a list of friends' addresses, and nothing stopped it. Any method that takes an Address takes a parcel too.
- A parcel prints as a bare address. Whatever Address gets later, such as a postcode or a method that formats an envelope, every Parcel gets too, whether it fits or not.
- A parcel has two addresses: where it goes, and where it comes from, for returns. `extends` gives it one Address part, and a class can extend only one class.

## The fix: has a

A parcel **has** an address, two in fact. "Has a" means an instance variable, as in modules 23 and 24. Module 23's Parcel already did this: it kept its Address in one. Here it keeps two:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Address shop = new Address("3 Market Street", "Leeds");
        Parcel parcel = new Parcel(shop, new Address("9 Dock Road", "Hull"), 1800);
        System.out.println(parcel);
        System.out.println(parcel.getTo());
    }
}
```

**Address.java**

```java
public class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    @Override
    public String toString() {
        return this.street + ", " + this.city;
    }
}
```

**Parcel.java**

```java
public class Parcel {
    private Address from;
    private Address to;
    private int grams;

    public Parcel(Address from, Address to, int grams) {
        this.from = from;
        this.to = to;
        this.grams = grams;
    }

    public Address getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return this.grams + " g from " + this.from.getCity() + " to " + this.to.getCity();
    }
}
```

**Output**

```text
1800 g from Leeds to Hull
9 Dock Road, Hull
```

Now a parcel has room for both addresses, it prints as a parcel, and `friends.add(parcel)` no longer compiles: `incompatible types: Parcel cannot be converted to Address`. Parcel uses Address's methods through its variables (`this.to.getCity()`), and offers only the methods that make sense for a parcel. Building a class from objects it holds is called **composition**.

## Is a, and has a

Say the sentence out loud, with "every":

- "Every parcel is a shipment." True: `Parcel extends Shipment` fits, if the courier has a class for everything it ships. So do "every film is a library item" and "every knight is an adventurer".
- "Every parcel is an address." False. "A parcel has an address" is true, so it's an instance variable.
- "An account has an owner", "an archer has a bow", "a playlist has songs": instance variables, and a list for the songs.

A class can do both. A parcel is a shipment, and it has addresses:

```java
public class Parcel extends Shipment {
    private Address from;
    private Address to;
    private int grams;
    ...
}
```

Some rules of thumb:

- Use `extends` only when "every X is a Y" is true, and every public method of Y makes sense for an X: an X must work wherever a Y is expected.
- Wanting another class's methods is not enough of a reason. If you only want to use them, hold an object of that class and call its methods.
- When in doubt, choose "has a". A class can extend only one class, and an object can never change its class. But it can swap an object it holds: an archer can switch to a new bow.

---

Source: [When to inherit: is a, or has a?](https://javaarena.com/learn/inheritance/is-a-has-a/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
