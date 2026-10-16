> [!info] AI-Generated

# var for local variables

Apart from lambda parameters (module 37), every variable in this course has had its type written in front of its name. Since Java 10, a local variable (one declared inside a method) can be declared with `var` instead, and javac works out its type from the value it's given:

```java
var name = "Ada";
var age = 36;
var height = 1.65;
var languages = new ArrayList<String>();
languages.add("Java");
System.out.println(name.length() + age + " " + height + " " + languages);
```

**Output**

```text
39 1.65 [Java]
```

`name` is a String, `age` an int, `height` a double and `languages` an `ArrayList<String>`, exactly as if the types were written out. `var` isn't a type of its own, and it doesn't make Java a language where a variable can hold anything: the type is decided once, when the variable is declared, and stays.

```java
public class Main {
    public static void main(String[] args) {
        var count = 0;
        count = "many";
        System.out.println(count);
    }
}
```

**What javac prints**

```text
Main.java:4: error: incompatible types: String cannot be converted to int
        count = "many";
                ^
1 error
```

## Where var helps

`var` is at its best when the type is long and the right-hand side already shows it:

```java
HashMap<String, ArrayList<Integer>> scores = new HashMap<String, ArrayList<Integer>>();
var scores = new HashMap<String, ArrayList<Integer>>();
```

Both lines declare the same variable; the second says the type once. Note that the type arguments move to the right: `var scores = new HashMap<>();` would give javac nothing to work them out from, and it makes a `HashMap<Object, Object>`.

Where the right-hand side doesn't show the type, `var` makes code harder to read: in `var result = calculate(data);`, the reader has to look up `calculate` to know what `result` is. Many teams use `var` only when the type is plain to see.

## Where var isn't allowed

javac must be able to work out the type from the declaration itself, so `var` needs a value right away, and `null` doesn't say which type is meant:

```java
public class Main {
    public static void main(String[] args) {
        var total;
        var best = null;
        System.out.println("Done");
    }
}
```

**What javac prints**

```text
Main.java:3: error: cannot infer type for local variable total
        var total;
            ^
  (cannot use 'var' on variable without initializer)
Main.java:4: error: cannot infer type for local variable best
        var best = null;
            ^
  (variable initializer is 'null')
2 errors
```

`var` is only for local variables (the loop variables of `for` included) and a lambda's parameters. Instance and static variables, method parameters and return types still need their types written out: javac answers a `var` there with "'var' is not allowed here".

## var in loops, and a map's entries

A for-each loop's variable can be `var` too. That's handy for going through a map. So far, the course went through a map's keys with `keySet()` and looked up each value with `get`. A map's `entrySet()` gives its **entries** instead, each a key and its value together, with `getKey()` and `getValue()`. An entry's type is `Map.Entry<String, Integer>` here, a mouthful that `var` saves you from writing. A `TreeMap`, which module 31 mentioned, keeps its keys sorted, so the loop goes through them in alphabetical order:

```java
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        var stock = new TreeMap<String, Integer>();
        stock.put("water", 12);
        stock.put("apple", 4);
        stock.put("chips", 0);
        for (var entry : stock.entrySet()) {
            if (entry.getValue() == 0) {
                System.out.println(entry.getKey() + ": sold out");
            } else {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}
```

**Output**

```text
apple: 4
chips: sold out
water: 12
```

---

Source: [var for local variables](https://javaarena.com/learn/switch-and-text/var/) in the module [switch, var and text blocks](https://javaarena.com/learn/switch-and-text/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
