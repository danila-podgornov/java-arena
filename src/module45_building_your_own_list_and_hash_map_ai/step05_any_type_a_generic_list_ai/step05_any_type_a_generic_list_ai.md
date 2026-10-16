> [!info] AI-Generated

# Any type: a generic list

Playlist holds Strings, and nothing else. A list of whole numbers, or of objects of your own class, would be the same class again with another type in it. Module 44's type parameters are made for this: write the class once, as `SimpleList<T>`, with T wherever Playlist said String.

## The array is the snag

The instance variable becomes `private T[] values;`, an array of T. But creating it, the obvious way, doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SimpleList<String> songs = new SimpleList<>();
        System.out.println("A new list");
    }
}
```

**SimpleList.java**

```java
public class SimpleList<T> {
    private T[] values;
    private int size;

    public SimpleList() {
        this.values = new T[4];
        this.size = 0;
    }
}
```

**What javac prints**

```text
SimpleList.java:6: error: generic array creation
        this.values = new T[4];
                      ^
1 error
```

An array knows the type of its elements while the program runs: an array created as `new String[4]` stays an array of Strings. So to create an array, Java must know the element type at that moment. Type parameters don't last that long. javac uses T to check the code, and then the type argument is gone: the running program doesn't know whether a SimpleList was made for Strings or for Integers. So `new T[4]` can't be created.

The way around it is an array of Object, which can hold any object, since every class inherits from Object (module 34). Cast it to `T[]`, and the rest of the class can treat it as an array of T:

```java
this.values = (T[]) new Object[4];
```

Java's own ArrayList keeps an Object array inside as well.

## javac warns about the cast

With that line, the class compiles and runs, but javac prints a note:

```text
Note: SimpleList.java uses unchecked or unsafe operations.
Note: Recompile with -Xlint:unchecked for details.
```

It's a warning, not an error. "Unchecked" means that javac can't check this cast: it doesn't know what T will be, so it can't promise that the array really fits. Here the cast is safe, for a reason javac can't see: the array never leaves the class, and the only values that go into it come through `add(T value)`, which takes nothing but T.

To tell javac that you've checked it, put the annotation `@SuppressWarnings("unchecked")` above each method or constructor that has such a cast. Like `@Override`, it's a note to javac. It turns the warning off for that one method, and changes nothing else. The code in this course uses it, so that javac stays quiet. If you leave it out, you'll see the note, and the program still runs.

## SimpleList

Here's the whole class: Playlist with T in place of String, and a cast in the constructor and in `grow`, the two places that create an array:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SimpleList<String> songs = new SimpleList<>();
        songs.add("Night Train");
        songs.add("Paper Boats");
        System.out.println(songs + " " + songs.contains("Paper Boats"));

        SimpleList<Integer> minutes = new SimpleList<>();
        int[] lengths = {4, 3, 5, 6, 2};
        for (int length : lengths) {
            minutes.add(length);
        }
        int total = 0;
        for (int i = 0; i < minutes.size(); i++) {
            total += minutes.get(i);
        }
        System.out.println(minutes + ", " + total + " minutes in all");

        minutes.remove(1);
        minutes.remove(Integer.valueOf(6));
        System.out.println(minutes);
    }
}
```

**SimpleList.java**

```java
public class SimpleList<T> {
    private T[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public SimpleList() {
        this.values = (T[]) new Object[4];
        this.size = 0;
    }

    public void add(T value) {
        if (this.size == this.values.length) {
            grow();
        }
        this.values[this.size] = value;
        this.size++;
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        T[] bigger = (T[]) new Object[this.values.length * 2];
        for (int i = 0; i < this.size; i++) {
            bigger[i] = this.values[i];
        }
        this.values = bigger;
    }

    public int size() {
        return this.size;
    }

    public T get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + this.size);
        }
        return this.values[index];
    }

    public int indexOf(T value) {
        for (int i = 0; i < this.size; i++) {
            if (this.values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(T value) {
        return indexOf(value) >= 0;
    }

    public T remove(int index) {
        T removed = get(index);
        for (int i = index; i < this.size - 1; i++) {
            this.values[i] = this.values[i + 1];
        }
        this.values[this.size - 1] = null;
        this.size--;
        return removed;
    }

    public boolean remove(T value) {
        int index = indexOf(value);
        if (index < 0) {
            return false;
        }
        remove(index);
        return true;
    }

    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < this.size; i++) {
            if (i > 0) {
                text += ", ";
            }
            text += this.values[i];
        }
        return text + "]";
    }
}
```

**Output**

```text
[Night Train, Paper Boats] true
[4, 3, 5, 6, 2], 20 minutes in all
[4, 5, 2]
```

- One class, two lists: `SimpleList<String>` and `SimpleList<Integer>`. For each of them, javac reads every T as the type argument, so `minutes.get(i)` gives an Integer, and `total += minutes.get(i);` needs no cast.
- `indexOf` compares with `equals`, which every object has, so the search works for any type. Integer's `equals` compares the numbers. For a class of your own, write an `equals` (module 32): without one, `equals` is true only for the very same object, and `contains` can't find an equal copy.
- `toString` adds each value to the text, which calls the value's own `toString`.
- The type argument must be a reference type, not a primitive type, as module 44 showed: `SimpleList<Integer>`, not `SimpleList<int>`. Java turns `4` into an Integer when it goes in, and back into an int when it comes out.
- In a `SimpleList<Integer>`, `remove(1)` removes the value at index 1, because 1 is an int and `remove(int index)` takes an int as it is. `remove(Integer.valueOf(6))` gives an Integer, which matches `remove(T value)`. It's the same rule as for ArrayList in module 14, and now you can see where it comes from: the two methods in your own class.

---

Source: [Any type: a generic list](https://javaarena.com/learn/list-and-map-internals/generic-list/) in the module [Building your own list and hash map](https://javaarena.com/learn/list-and-map-internals/) on Java Arena.

This module follows section [12.2 ArrayList and hash table](https://java-programming.mooc.fi/part-12/2-arraylist-and-hashtable) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
