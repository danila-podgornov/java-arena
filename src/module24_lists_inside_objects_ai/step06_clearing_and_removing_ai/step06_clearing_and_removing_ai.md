> [!info] AI-Generated

# Clearing and removing

An object's list can shrink as well as grow. There are three usual ways: empty the whole list, remove one object, or remove every object that matches a rule.

## Emptying the list

The list's own `clear()` does it:

```java
public void clear() {
    this.books.clear();
}
```

Another way is to replace the list with a new, empty one: `this.books = new ArrayList<>();`. Either way the shelf is empty afterwards.

## Removing one object

A method can pass an object on to the list's `remove`:

```java
public void remove(Book book) {
    this.books.remove(book);
}
```

`remove` looks for the book with `equals` (module 23). Book has no `equals` of its own, so the one every class gets finds only the very same object: the caller must give a book that's on the shelf, not a new Book with the same title. Often it's handier to remove by a value, such as the title. This method removes the first book with that title, and tells whether it found one:

```java
public boolean removeTitle(String title) {
    for (int i = 0; i < this.books.size(); i++) {
        if (this.books.get(i).getTitle().equals(title)) {
            this.books.remove(i);
            return true;
        }
    }
    return false;
}
```

`this.books.remove(i)` removes by index, since `i` is an `int` (module 14). The loop never goes on after a removal, because `return true` ends the method right away.

## Removing every object that matches

Module 14 warned about this one: removing inside a for-each loop. It crashes inside a class just as it does in `main`:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Bookshelf shelf = new Bookshelf("Attic");
        shelf.add(new Book("Poems", "Dickinson", 96));
        shelf.add(new Book("Emma", "Austen", 474));
        shelf.add(new Book("Dracula", "Stoker", 418));
        shelf.removeShorterThan(100);
        System.out.println(shelf);
    }
}
```

**Bookshelf.java**

```java
import java.util.ArrayList;

public class Bookshelf {
    private String room;
    private ArrayList<Book> books;

    public Bookshelf(String room) {
        this.room = room;
        this.books = new ArrayList<>();
    }

    public void add(Book book) {
        this.books.add(book);
    }

    public void removeShorterThan(int pages) {
        for (Book book : this.books) {
            if (book.getPages() < pages) {
                this.books.remove(book);
            }
        }
    }

    public String toString() {
        return this.room + ": " + this.books;
    }
}
```

**Book.java**

```java
public class Book {
    private String title;
    private String author;
    private int pages;

    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public int getPages() {
        return this.pages;
    }

    public String toString() {
        return this.title + " by " + this.author + ", " + this.pages + " pages";
    }
}
```

**The program crashes with**

```text
Exception in thread "main" java.util.ConcurrentModificationException
	at Bookshelf.removeShorterThan(Bookshelf.java:17)
	at Main.main(Main.java:7)
```

Line 17 of `Bookshelf.java` is the for-each line: the list changed while the loop was going through it. The fix is the same as in module 14, an index loop that goes backwards:

```java
public void removeShorterThan(int pages) {
    for (int i = this.books.size() - 1; i >= 0; i--) {
        if (this.books.get(i).getPages() < pages) {
            this.books.remove(i);
        }
    }
}
```

Going from the end, a removal only moves books the loop has already checked. With this version, the attic shelf keeps Emma and Dracula.

---

Source: [Clearing and removing](https://javaarena.com/learn/objects-with-lists/clearing-and-removing/) in the module [Lists inside objects](https://javaarena.com/learn/objects-with-lists/) on Java Arena.

This module follows section [6.1 Objects on a list and a list as part of an object](https://java-programming.mooc.fi/part-6/1-objects-within-objects) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
