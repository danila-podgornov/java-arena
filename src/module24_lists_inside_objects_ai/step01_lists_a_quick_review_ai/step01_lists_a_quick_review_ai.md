> [!info] AI-Generated

# Lists, a quick review

Part 6 starts with a tool you've used since module 13, the list, and puts it somewhere new: inside an object. First, a quick look back at what you already know.

## A list of Strings

```java
ArrayList<String> stops = new ArrayList<>();
stops.add("Harbor");
stops.add("Market");
stops.add("Old Town");
System.out.println(stops.size() + " stops, the second is " + stops.get(1));
for (String stop : stops) {
    System.out.println("Next: " + stop);
}
```

**Output**

```text
3 stops, the second is Market
Next: Harbor
Next: Market
Next: Old Town
```

- `ArrayList<String>` is a list of Strings, and `new ArrayList<>()` makes a new, empty one.
- `add` puts a value at the end, `size()` tells how many values there are, and `get(1)` gives the value at index 1. Indexes start at 0.
- The for-each loop goes through the values in order.

Module 14 added more: `contains`, `indexOf`, `remove`, `isEmpty` and `clear`. A list of whole numbers is an `ArrayList<Integer>`.

## A list of objects

Module 19 put objects of your own classes on a list. The loop then gets one object at a time, and asks it for its values with its getters:

**Main.java**

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Emma", 474));
        books.add(new Book("Dracula", 418));
        books.add(new Book("Kindred", 264));

        int pages = 0;
        for (Book book : books) {
            System.out.println(book);
            pages = pages + book.getPages();
        }
        System.out.println("In all: " + pages + " pages");
    }
}
```

**Book.java**

```java
public class Book {
    private String title;
    private int pages;

    public Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }

    public String toString() {
        return this.title + ", " + this.pages + " pages";
    }
}
```

**Output**

```text
Emma, 474 pages
Dracula, 418 pages
Kindred, 264 pages
In all: 1156 pages
```

## Whose list is it?

In these programs, the list is a local variable of `main`. For one list, that's fine. Now picture a home with two bookshelves, one in the living room and one in the bedroom. `main` would need two lists, and two more variables for the rooms' names, and every method would take a list as a parameter: `printBooks(bedroom)`, `totalPages(livingRoom)`. Nothing ties a room's name to its list, and any line of the program could change any list.

Module 21 had the answer to this kind of mess: an object looks after its own data. A list is data too, so it can be an instance variable of an object:

```java
public class Bookshelf {
    private String room;
    private ArrayList<Book> books;

    // a constructor, and methods that add books, print them, count them...
}
```

Each Bookshelf then keeps its own room and its own books, and `main` only calls methods such as `shelf.add(book)`. The rest of this module builds classes like this one, a piece at a time. First, a warm-up with lists as you know them.

---

Source: [Lists, a quick review](https://javaarena.com/learn/objects-with-lists/lists-review/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
