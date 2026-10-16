> [!info] AI-Generated

# Methods that return objects

A method can return an object, just as it returns a number or a String. You've seen some already: a getter such as `getAddress()` returns the object in an instance variable, and module 19's `findOldest` returned one of the pets in a list. This step is about methods that **make a new object** and return it:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        Photo photo = new Photo(800, 600);
        Photo turned = photo.rotated();
        Photo small = photo.scaled(25);
        System.out.println(photo);
        System.out.println(turned);
        System.out.println(small);
        System.out.println(photo.rotated().scaled(50));
    }
}
```

**Photo.java**

```java
public class Photo {
    private int width;
    private int height;

    public Photo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Photo rotated() {
        return new Photo(this.height, this.width);
    }

    public Photo scaled(int percent) {
        return new Photo(this.width * percent / 100, this.height * percent / 100);
    }

    public String toString() {
        return this.width + " x " + this.height + " pixels";
    }
}
```

**Output**

```text
800 x 600 pixels
600 x 800 pixels
200 x 150 pixels
300 x 400 pixels
```

- The return type is the class: `public Photo rotated()` returns a Photo.
- `return new Photo(this.height, this.width);` makes a new Photo from this photo's values and returns it. The photo the method was called on doesn't change: after both calls, `photo` is still 800 x 600.
- The caller keeps the new object in a variable, as in `Photo turned = photo.rotated();`, or uses it right away: `photo.rotated().scaled(50)` rotates the photo, and then scales the rotated one.
- Like any return value, the new object is lost if the caller doesn't use it. `photo.rotated();` on a line of its own changes nothing.

## Changing it, or returning a new one?

A class could also have a method that turns the photo itself around:

```java
public void rotate() {
    int oldWidth = this.width;
    this.width = this.height;
    this.height = oldWidth;
}
```

`photo.rotate()` changes that photo, and every variable that refers to it sees the change. `photo.rotated()` leaves it alone and gives back a new photo. Both are fine, and the names tell them apart. String methods never change the String they're called on: `word.toUpperCase()` returns the text in capitals, and `word` stays as it was.

## Returning an object that's already there

The returned object doesn't have to be new. This method returns whichever of two parcels is heavier, either the other one or the parcel it was called on, which is `this`:

```java
public Parcel heavierOf(Parcel other) {
    if (other.grams > this.grams) {
        return other;
    }
    return this;
}
```

No new parcel is made: the caller gets a reference to one of the two that already exist.

---

Source: [Methods that return objects](https://javaarena.com/learn/object-interaction/returning-objects/) in the module [Objects working together](https://javaarena.com/learn/object-interaction/) on Java Arena.

This module follows sections [5.4 Objects and references](https://java-programming.mooc.fi/part-5/4-objects-and-references), [5.5 Conclusion](https://java-programming.mooc.fi/part-5/5-conclusion) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
