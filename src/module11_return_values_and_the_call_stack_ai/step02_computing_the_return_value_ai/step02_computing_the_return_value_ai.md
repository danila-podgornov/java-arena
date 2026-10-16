> [!info] AI-Generated

# Computing the return value

The returned value is usually calculated, often from the parameters:

```java
public class Main {
    public static void main(String[] args) {
        int area = rectangleArea(4, 3);
        System.out.println("Area: " + area);
        System.out.println("Two rooms: " + (rectangleArea(4, 3) + rectangleArea(5, 2)));
    }

    public static int rectangleArea(int width, int height) {
        int area = width * height;
        return area;
    }
}
```

**Output**

```text
Area: 12
Two rooms: 22
```

`return` can give back any expression of the right type: `return width * height;` would do the same without the variable.

A method that returns its result, instead of printing it, is more useful: the caller decides what to do with the value, whether that's printing it, adding it to something or comparing it. `rectangleArea` works for one room, for two, or in a loop over a whole house.

The checks in this step print what your method returns. If the method also prints something itself, that extra output makes the check fail, so leave the printing to the caller.

---

Source: [Computing the return value](https://javaarena.com/learn/return-values/computing-return-values/) in the module [Return values and the call stack](https://javaarena.com/learn/return-values/) on Java Arena.

This module follows sections [2.4 Methods and dividing the program into smaller parts](https://java-programming.mooc.fi/part-2/4-methods), [2.5 End questionnaire](https://java-programming.mooc.fi/part-2/5-end-questionnaire) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
