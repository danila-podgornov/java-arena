> [!info] AI-Generated

# An object inside an object

An instance variable can hold an object too. You've done it all along: an instance variable of type `String` holds a String object. In the same way, its type can be one of your own classes. A parcel has a recipient and a weight, and it goes to an address, which is a thing of its own, with a street, a house number and a city:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Address address = new Address("Elm Street", 12, "Riverton");
        Parcel parcel = new Parcel("Amir", address, 1200);
        System.out.println(parcel);
        System.out.println(parcel.isGoingTo("Riverton"));
        System.out.println(parcel.isGoingTo("Lakeside"));
    }
}
```

**Parcel.java**

```java
public class Parcel {
    private String recipient;
    private Address address;
    private int grams;

    public Parcel(String recipient, Address address, int grams) {
        this.recipient = recipient;
        this.address = address;
        this.grams = grams;
    }

    public boolean isGoingTo(String city) {
        return this.address.getCity().equals(city);
    }

    public String toString() {
        return this.recipient + ", " + this.address + " (" + this.grams + " g)";
    }
}
```

**Address.java**

```java
public class Address {
    private String street;
    private int number;
    private String city;

    public Address(String street, int number, String city) {
        this.street = street;
        this.number = number;
        this.city = city;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return this.street + " " + this.number + ", " + this.city;
    }
}
```

**Output**

```text
Amir, Elm Street 12, Riverton (1200 g)
true
false
```

- `private Address address;` is an instance variable like the others, and its type is the class `Address`. The constructor stores the Address it's given, just as it stores the name and the weight.
- In `toString`, joining `this.address` to a String with `+` calls the address's own `toString`. The parcel doesn't need to know how an address is written out: that's the address's job.
- `isGoingTo` asks the address for its city with `this.address.getCity()`, and then compares the city it gets back with `equals`. Calls can follow each other like this: each one is made on what the one before it returned.
- A getter can return the inner object. With `public Address getAddress()` in Parcel, `parcel.getAddress().getCity()` asks the parcel for its address, and then the address for its city.

Keeping the address in a class of its own keeps both classes small, and a class for letters or for a delivery route could use the same Address class. If the constructor forgot to set `this.address`, it would stay `null`, and `isGoingTo` would crash with a NullPointerException (module 22).

## Making the inner object in the constructor

The caller doesn't have to build the inner object. A constructor can make it from the values it's given:

```java
public Parcel(String recipient, String street, int number, String city, int grams) {
    this.recipient = recipient;
    this.address = new Address(street, number, city);
    this.grams = grams;
}
```

With this constructor, `new Parcel("Amir", "Elm Street", 12, "Riverton", 1200)` makes the parcel and its address in one go. Either way, the parcel ends up with an Address object in its instance variable.

---

Source: [An object inside an object](https://javaarena.com/learn/object-interaction/object-inside-object/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
