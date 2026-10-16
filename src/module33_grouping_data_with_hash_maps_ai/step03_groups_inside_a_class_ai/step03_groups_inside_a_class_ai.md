> [!info] AI-Generated

# Groups inside a class

So far, the map of lists was passed to methods as a parameter. In a real program it usually lives inside a class, as an instance variable, the way module 24 kept a list inside an object. The class's methods are then the only way to change it. The rest of the program says what it wants done, like `register.join("Debate", "Amira")`, and doesn't need to know that there's a map of lists inside.

Here's a register of the school's clubs. `Main` is a test drive:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        ClubRegister register = new ClubRegister();
        register.join("Robotics", "Priya");
        register.join("Debate", "Amira");
        register.join("Debate", "Jonas");
        register.join("Art", "Leo");
        System.out.println(register.clubNames());
        System.out.println(register.members("Debate"));

        register.leave("Debate", "Amira");
        register.leave("Art", "Leo");
        System.out.println(register.members("Debate"));
        System.out.println(register.clubNames());
        System.out.println(register.members("Art"));
    }
}
```

**ClubRegister.java**

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ClubRegister {
    private HashMap<String, ArrayList<String>> clubs;

    public ClubRegister() {
        this.clubs = new HashMap<>();
    }

    public void join(String club, String student) {
        if (!this.clubs.containsKey(club)) {
            this.clubs.put(club, new ArrayList<>());
        }
        this.clubs.get(club).add(student);
    }

    public ArrayList<String> members(String club) {
        return this.clubs.getOrDefault(club, new ArrayList<>());
    }

    public void leave(String club, String student) {
        if (this.clubs.containsKey(club)) {
            ArrayList<String> members = this.clubs.get(club);
            members.remove(student);
            if (members.isEmpty()) {
                this.clubs.remove(club);
            }
        }
    }

    public ArrayList<String> clubNames() {
        ArrayList<String> names = new ArrayList<>(this.clubs.keySet());
        Collections.sort(names);
        return names;
    }
}
```

**Output**

```text
[Art, Debate, Robotics]
[Amira, Jonas]
[Jonas]
[Debate, Robotics]
[]
```

- The constructor creates the map. Without that line, `this.clubs` would be `null`, and the first `join` would crash (module 22).
- `join` and `members` are step 1's `join` and `membersOf`, with `this.clubs` in place of a parameter.
- `leave` uses the list's `remove(student)`, which removes the first copy of the student and does nothing if the student isn't there (module 14). When the last member leaves, `this.clubs.remove(club)` takes the club out of the map too. Without that, a club with an empty list would stay in the map, and in `clubNames`, forever.
- `clubNames` returns a new, sorted list of the keys. It's a list of its own: sorting it, or anything the caller does with it, doesn't change the map. The names come out in alphabetical order whatever order the map keeps its keys in.
- ClubRegister prints nothing. Its methods return their answers, and `Main` decides what to print.

One thing to be aware of: `members` returns the list that's in the map, so code outside the class could change it, for example with `register.members("Debate").clear()`. A class that wants to guard its data can return a copy instead: `new ArrayList<>(list)` makes a new list with the same elements as `list`.

---

Source: [Groups inside a class](https://javaarena.com/learn/grouping/groups-in-a-class/) in the module [Grouping data with hash maps](https://javaarena.com/learn/grouping/) on Java Arena.

This module follows sections [8.4 Grouping data using hash maps](https://java-programming.mooc.fi/part-8/4-grouping-data-using-hash-maps), [8.5 Fast data fetching and grouping information](https://java-programming.mooc.fi/part-8/5-fast-data-fetching-and-grouping-information) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
