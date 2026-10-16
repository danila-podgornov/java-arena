> [!info] AI-Generated

# Sealed interfaces

Any class can implement an interface: that's what makes interfaces useful for things like `Comparable`, which classes everywhere implement. But some interfaces stand for a fixed list of kinds. In the chat app, the method `preview` of the last step had to end with a `return` for "something new", because javac can't know that ChatMessage has only three kinds. Since Java 17, an interface can be **sealed**: it lists, after the word `permits`, exactly the classes that may implement it.

## A floor plan's shapes

A floor plan app draws rooms of two shapes: rectangles, and circles for round tower rooms. Nothing else is allowed:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Shape kitchen = new Rectangle(4.0, 3.5);
        Shape tower = new Circle(2.0);
        System.out.println("Kitchen: " + kitchen.area() + " square meters");
        System.out.println("Tower room: " + tower.area() + " square meters");
    }
}
```

**Shape.java**

```java
public sealed interface Shape permits Rectangle, Circle {
    double area();
}
```

**Rectangle.java**

```java
public final class Rectangle implements Shape {
    private final double width;
    private final double depth;

    public Rectangle(double width, double depth) {
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double area() {
        return this.width * this.depth;
    }
}
```

**Circle.java**

```java
public final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
```

**Output**

```text
Kitchen: 14.0 square meters
Tower room: 12.566370614359172 square meters
```

`sealed` goes before `interface`, and the list of **permitted** classes comes after `permits`, separated by commas. The interface works as any other: a Shape variable can refer to a Rectangle or a Circle, and `area()` runs the object's own method.

## A class that isn't on the list

A third shape that isn't on the list doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Shape hall = new Triangle(3.0, 2.0);
        System.out.println(hall.area());
    }
}
```

**Shape.java**

```java
public sealed interface Shape permits Rectangle, Circle {
    double area();
}
```

**Rectangle.java**

```java
public final class Rectangle implements Shape {
    private final double width;
    private final double depth;

    public Rectangle(double width, double depth) {
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double area() {
        return this.width * this.depth;
    }
}
```

**Circle.java**

```java
public final class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
```

**Triangle.java**

```java
public final class Triangle implements Shape {
    private final double base;
    private final double height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public double area() {
        return this.base * this.height / 2;
    }
}
```

**What javac prints**

```text
Triangle.java:1: error: class is not allowed to extend sealed class: Shape (as it is not listed in its 'permits' clause)
public final class Triangle implements Shape {
             ^
1 error
```

javac says "class" and "extend" for interfaces too. To allow triangles, add `Triangle` to the list: `permits Rectangle, Circle, Triangle`. The list is in one place, so a reader sees at once every kind of Shape there is.

## final, sealed or non-sealed

Each permitted class must say whether the list goes on below it, with one of three words:

- `final`: no class can extend it. This is the usual choice, as above.
- `sealed`: it has a `permits` list of its own.
- `non-sealed`: any class can extend it again. Use it only when that's really what you want.

Without one of them, javac stops:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Shape tower = new Circle(2.0);
        System.out.println(tower.area());
    }
}
```

**Shape.java**

```java
public sealed interface Shape permits Rectangle, Circle {
    double area();
}
```

**Rectangle.java**

```java
public final class Rectangle implements Shape {
    private final double width;
    private final double depth;

    public Rectangle(double width, double depth) {
        this.width = width;
        this.depth = depth;
    }

    @Override
    public double area() {
        return this.width * this.depth;
    }
}
```

**Circle.java**

```java
public class Circle implements Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
```

**What javac prints**

```text
Circle.java:1: error: sealed, non-sealed or final modifiers expected
public class Circle implements Shape {
       ^
1 error
```

The permitted classes must also be in the same package as the sealed interface. In this module's programs, all classes are in the default package, so they are.

## Records are final already

A record can't be extended: every record is `final` without saying so. That makes records a natural fit for the permitted types. The floor plan's shapes as records:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Shape hall = new Rectangle(6.0, 2.0);
        System.out.println(hall);
        System.out.println(hall.area());
    }
}
```

**Shape.java**

```java
public sealed interface Shape permits Rectangle, Circle {
    double area();
}
```

**Rectangle.java**

```java
public record Rectangle(double width, double depth) implements Shape {
    @Override
    public double area() {
        return this.width * this.depth;
    }
}
```

**Circle.java**

```java
public record Circle(double radius) implements Shape {
    @Override
    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}
```

**Output**

```text
Rectangle[width=6.0, depth=2.0]
12.0
```

An abstract class can be sealed in the same way (`public sealed abstract class Shape permits Rectangle, Circle`), and then its permitted classes extend it. This module uses sealed interfaces. The next step shows what the closed list is good for: a switch that javac checks covers every kind.

---

Source: [Sealed interfaces](https://javaarena.com/learn/sealed-and-patterns/sealed-interfaces/) in the module [Pattern matching and sealed types](https://javaarena.com/learn/sealed-and-patterns/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
