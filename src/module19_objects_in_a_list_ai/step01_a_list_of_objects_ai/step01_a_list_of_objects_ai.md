> [!info] AI-Generated

# A list of objects

The lists in part 3 held Strings and Integers. The type in the angle brackets can be any class, including the ones you write yourself. Here's a `Pet` class, with a name, an age, two getters and a `toString`, and a list of pets:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 2));
        Pet kiwi = new Pet("Kiwi", 11);
        pets.add(kiwi);

        System.out.println(pets.size() + " pets");
        for (Pet pet : pets) {
            System.out.println(pet);
        }
        System.out.println("The first one is " + pets.get(0).getName());
    }
}
```

**Pet.java**

```java
public class Pet {
    private String name;
    private int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String toString() {
        return this.name + ", " + this.age + " years old";
    }
}
```

**Output**

```text
3 pets
Rex, 4 years old
Misty, 2 years old
Kiwi, 11 years old
The first one is Rex
```

- `ArrayList<Pet> pets = new ArrayList<>();` creates a list for `Pet` objects. Like every new list, it starts empty.
- `pets.add(new Pet("Rex", 4));` creates a pet and adds it in one go. The object needs no variable of its own: the list refers to it. Adding a pet that has a variable, like `kiwi`, works the same way.
- In the for-each loop, `pet` is a `Pet`: in each round, the next object in the list. `System.out.println(pet)` prints what the object's `toString` returns.
- `pets.get(0)` is a `Pet` too, so you can call its methods straight away: `pets.get(0).getName()`.

`size()`, `get(index)` and `remove(index)` work just as they did with Strings. The methods that look for a value, such as `contains` and `indexOf`, are different: `pets.contains(new Pet("Rex", 4))` is `false`, because the new pet is another object than the Rex in the list, even though its name and age are the same. (A later module shows how a class can change that.) To find a pet by its name or age, go through the list and ask each pet with a getter, as step 5 does.

The list takes only pets: `pets.add("Rex")` doesn't compile, because a String isn't a `Pet`.

Printing an object whose class has no `toString` shows only the class name, an `@` and a code that can change from run to run. That's why the classes in this module have a `toString`.

---

Source: [A list of objects](https://javaarena.com/learn/lists-of-objects/a-list-of-objects/) in the module [Objects in a list](https://javaarena.com/learn/lists-of-objects/) on Java Arena.

This module follows section [4.2 Objects in a list](https://java-programming.mooc.fi/part-4/2-objects-in-a-list) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
