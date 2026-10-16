> [!info] AI-Generated

# Choosing from the list

A loop over the list doesn't have to print every object. An `if` inside it picks the ones to print, and the getters give the values to test:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("Rex", 4));
        pets.add(new Pet("Misty", 2));
        pets.add(new Pet("Kiwi", 11));

        System.out.println("At least 3 years old:");
        printAtLeast(pets, 3);
        System.out.println("At least 10 years old:");
        printAtLeast(pets, 10);
    }

    public static void printAtLeast(ArrayList<Pet> pets, int minAge) {
        for (Pet pet : pets) {
            if (pet.getAge() >= minAge) {
                System.out.println(pet);
            }
        }
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
At least 3 years old:
Rex, 4 years old
Kiwi, 11 years old
At least 10 years old:
Kiwi, 11 years old
```

- `pet.getAge()` is the age of this round's pet. The condition can use any getter, and anything that works on the value it returns: `pet.getName().startsWith("K")`, or `pet.getName().equals(name)`.
- The getter is needed because `age` is private. `pet.age` in `Main` doesn't compile: javac says `age has private access in Pet`.
- The list can be a method's parameter, as in module 14. The method then works for any list of pets and any age.

## The limit from the user

Often the list is read first, and then the user says what to look for. The loop that reads the list stops at the empty line, so the next `nextLine()` reads the line after it:

```java
// ... the loop that reads the pets, until an empty line
int minAge = Integer.valueOf(scanner.nextLine());
printAtLeast(pets, minAge);
```

## When nothing matches

To say so when no object matched, count the matches while printing, and check the count after the loop:

```java
int count = 0;
for (Pet pet : pets) {
    if (pet.getAge() >= minAge) {
        System.out.println(pet);
        count++;
    }
}
if (count == 0) {
    System.out.println("No pets that old");
}
```

---

Source: [Choosing from the list](https://javaarena.com/learn/lists-of-objects/choosing-from-the-list/) in the module [Objects in a list](https://javaarena.com/learn/lists-of-objects/) on Java Arena.

This module follows section [4.2 Objects in a list](https://java-programming.mooc.fi/part-4/2-objects-in-a-list) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
