> [!info] AI-Generated

# An object as a parameter

So far, the methods of your classes have taken numbers and Strings as parameters. A parameter can also be an object of one of your own classes, and then two objects can work together. Here a printer prints documents, and each document knows its own title and number of pages:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer(10);
        Document letter = new Document("Letter", 2);
        Document report = new Document("Report", 12);
        printer.print(letter);
        printer.print(report);
        printer.print(new Document("Poster", 1));
        System.out.println(printer);
    }
}
```

**Printer.java**

```java
public class Printer {
    private int paper;
    private int printed;

    public Printer(int paper) {
        this.paper = paper;
        this.printed = 0;
    }

    public void print(Document document) {
        if (document.getPages() <= this.paper) {
            this.paper = this.paper - document.getPages();
            this.printed++;
            System.out.println("Printed " + document.getTitle());
        } else {
            System.out.println("Not enough paper for " + document.getTitle());
        }
    }

    public String toString() {
        return this.printed + " documents printed, " + this.paper + " sheets left";
    }
}
```

**Document.java**

```java
public class Document {
    private String title;
    private int pages;

    public Document(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    public String getTitle() {
        return this.title;
    }

    public int getPages() {
        return this.pages;
    }
}
```

**Output**

```text
Printed Letter
Not enough paper for Report
Printed Poster
2 documents printed, 7 sheets left
```

- The parameter's type is the name of the class: `public void print(Document document)`. The method takes a Document and nothing else: `printer.print("Letter")` doesn't compile.
- Inside `print`, `document` is the Document it was given. The printer uses it through its public methods, `getTitle()` and `getPages()`, just as `main` would. Writing `document.pages` in `Printer` doesn't compile, because `pages` is private to the `Document` class.
- The call can give an object that's in a variable, as in `printer.print(letter)`, or a new one made right in the call: `printer.print(new Document("Poster", 1))`.
- `this.paper` is the printer's own variable, and `document.getPages()` asks the document. Each object keeps its own data, and the method brings the two together.

## The object itself, not a copy

As module 22 showed, a parameter of a class type holds a reference to an object, just like any other variable of that type: `printer.print(letter)` gives the method a reference to the very object in `letter`, not a copy of it. So when a method changes the object it was given, the change is still there after the method ends:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Phone phone = new Phone(15);
        Charger charger = new Charger(2);
        System.out.println(phone);
        charger.charge(phone, 30);
        System.out.println(phone);
        charger.charge(phone, 60);
        System.out.println(phone);
    }
}
```

**Charger.java**

```java
public class Charger {
    private int percentPerMinute;

    public Charger(int percentPerMinute) {
        this.percentPerMinute = percentPerMinute;
    }

    public void charge(Phone phone, int minutes) {
        phone.addBattery(minutes * this.percentPerMinute);
    }
}
```

**Phone.java**

```java
public class Phone {
    private int battery;

    public Phone(int battery) {
        this.battery = battery;
    }

    public void addBattery(int percent) {
        this.battery = this.battery + percent;
        if (this.battery > 100) {
            this.battery = 100;
        }
    }

    public String toString() {
        return "Battery " + this.battery + "%";
    }
}
```

**Output**

```text
Battery 15%
Battery 75%
Battery 100%
```

`charge` changes the phone through the phone's own method, `addBattery`, and `main` sees the new level in `phone`: the variable in `main` and the parameter refer to the same Phone. The charger can't set `battery` directly. Only Phone's own code can, and it makes sure the battery never goes over 100%.

---

Source: [An object as a parameter](https://javaarena.com/learn/object-interaction/object-as-parameter/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
