> [!info] AI-Generated

# Several type parameters, and a list of T

`HashMap<String, Integer>` takes two type arguments, one for the keys and one for the values. A class of yours can have as many type parameters as it needs, separated by commas. And a class with a type parameter can pass it on to the classes it uses, such as an ArrayList.

## Two type parameters

A sports app is full of values that come in twos: the home side and the away side of a match, a player and the number on their shirt, the goals of the two sides. One class can hold any two values:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Duo<String, String> match = new Duo<>("Harbor FC", "Mill Town");
        Duo<String, Integer> shirt = new Duo<>("Noor", 9);
        Duo<Integer, Integer> goals = new Duo<>(2, 1);

        System.out.println(match.getFirst() + " (home) against " + match.getSecond() + " (away)");
        System.out.println(shirt.getFirst() + " wears number " + shirt.getSecond());
        System.out.println("Goals in all: " + (goals.getFirst() + goals.getSecond()));

        Duo<String, String> returnMatch = match.swapped();
        System.out.println("Return match: " + returnMatch);
        Duo<Integer, String> byNumber = shirt.swapped();
        System.out.println("Number " + byNumber.getFirst() + " is " + byNumber.getSecond());
    }
}
```

**Duo.java**

```java
public class Duo<A, B> {
    private A first;
    private B second;

    public Duo(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public Duo<B, A> swapped() {
        return new Duo<>(this.second, this.first);
    }

    @Override
    public String toString() {
        return "(" + this.first + ", " + this.second + ")";
    }
}
```

**Output**

```text
Harbor FC (home) against Mill Town (away)
Noor wears number 9
Goals in all: 3
Return match: (Mill Town, Harbor FC)
Number 9 is Noor
```

- `Duo<A, B>` has two type parameters, A and B. Each use gives two type arguments, in the same order: in `Duo<String, Integer>`, A is String and B is Integer.
- The two can be the same type, as in `match` and `goals`, or different, as in `shirt`.
- `swapped()` returns a new Duo with the two values the other way around. Its return type, `Duo<B, A>`, says that the types swap places too: `shirt` is a `Duo<String, Integer>`, so `shirt.swapped()` is a `Duo<Integer, String>`. For a match, swapping gives the return match, where the away side plays at home.
- `return new Duo<>(...)` can use the diamond, because Java knows the method's return type.

## A list of T

A rotation is a list of people who take turns at a job, such as the lifeguards of a lake who take turns in its tower, starting over from the first when everyone has had a turn. A class for a rotation holds an ArrayList, and the type of its members is the rotation's own type parameter:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Rotation<String> tower = new Rotation<>();
        tower.add("Abena");
        tower.add("Joaquin");
        tower.add("Leilani");
        for (int day = 1; day <= 5; day++) {
            System.out.println("Day " + day + ": " + tower.next());
        }

        Rotation<Integer> keepers = new Rotation<>();
        keepers.add(1);
        keepers.add(12);
        System.out.println("Goalkeepers: " + keepers.next() + ", " + keepers.next() + ", " + keepers.next());
    }
}
```

**Rotation.java**

```java
import java.util.ArrayList;

public class Rotation<T> {
    private ArrayList<T> members;
    private int turn;

    public Rotation() {
        this.members = new ArrayList<>();
        this.turn = 0;
    }

    public void add(T member) {
        this.members.add(member);
    }

    public T next() {
        T member = this.members.get(this.turn);
        this.turn++;
        if (this.turn == this.members.size()) {
            this.turn = 0;
        }
        return member;
    }
}
```

**Output**

```text
Day 1: Abena
Day 2: Joaquin
Day 3: Leilani
Day 4: Abena
Day 5: Joaquin
Goalkeepers: 1, 12, 1
```

- `private ArrayList<T> members;` passes the rotation's T on to ArrayList: a `Rotation<String>` keeps an `ArrayList<String>`, and a `Rotation<Integer>` an `ArrayList<Integer>`.
- `new ArrayList<>()` in the constructor gets its type from the instance variable's type, `ArrayList<T>`.
- `next()` returns a T, the member whose turn it is, and moves the turn on, back to 0 after the last member.
- Rotation never looks inside its members: it stores them and hands them back. That's why it works for any type.

---

Source: [Several type parameters, and a list of T](https://javaarena.com/learn/generics/several-type-parameters/) in the module [Type parameters (generics)](https://javaarena.com/learn/generics/) on Java Arena.

This module follows section [12.1 Type parameters](https://java-programming.mooc.fi/part-12/1-type-parameters) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
