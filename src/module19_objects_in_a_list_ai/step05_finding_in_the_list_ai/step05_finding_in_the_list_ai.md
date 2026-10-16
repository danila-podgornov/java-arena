> [!info] AI-Generated

# Finding in the list

Module 13 found the largest number in a list: keep the largest one so far in a variable, and replace it whenever a larger one comes along. With objects, the variable holds a whole object. After the loop you have the largest value and also whose it is:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 2));
        pets.add(new Pet("Kiwi", 11));

        System.out.println("Oldest: " + findOldest(pets));
        printPet(pets, "Misty");
        printPet(pets, "Bo");
    }

    public static Pet findOldest(ArrayList<Pet> pets) {
        Pet oldest = pets.get(0);
        for (Pet pet : pets) {
            if (pet.getAge() > oldest.getAge()) {
                oldest = pet;
            }
        }
        return oldest;
    }

    public static void printPet(ArrayList<Pet> pets, String name) {
        for (Pet pet : pets) {
            if (pet.getName().equals(name)) {
                System.out.println("Found: " + pet);
                return;
            }
        }
        System.out.println("No pet called " + name);
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
Oldest: Kiwi, 11 years old
Found: Misty, 2 years old
No pet called Bo
```

- `Pet oldest = pets.get(0);` starts from the first pet, which is always a real candidate. The loop compares every pet's age with the oldest one so far, and when a pet is older, it becomes the new `oldest`.
- `findOldest` returns a `Pet`: a method can return an object, like any other value. The caller gets the whole pet, and can print it or call its getters.
- With `>`, the first of two pets of the same age stays the oldest; with `>=`, the later one would win.
- `get(0)` needs at least one pet in the list. When the list might be empty, check `pets.isEmpty()` first.

## Finding one by name

`printPet` goes through the list until a pet's name `equals` the name it's looking for (with `==`, Strings aren't compared reliably). The `return` ends the method as soon as the pet is found. Only when the loop gets through the whole list without finding it does the last line run.

---

Source: [Finding in the list](https://javaarena.com/learn/lists-of-objects/finding-in-the-list/) in the module [Objects in a list](https://javaarena.com/learn/lists-of-objects/) on Java Arena.

This module follows section [4.2 Objects in a list](https://java-programming.mooc.fi/part-4/2-objects-in-a-list) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
