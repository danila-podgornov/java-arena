> [!info] AI-Generated

# Arrays and methods

From here on, the examples create their arrays the short way: `int[] scores = {4, 9, 6};` makes an array of three ints that holds 4, 9 and 6. The last step of the module looks at it more closely.

A method can take an array as a parameter. The parameter's type is the array type, such as `int[] values`:

```java
public class Main {
    public static void main(String[] args) {
        int[] scores = {4, 9, 6};
        System.out.println("Total: " + total(scores));
        addBonus(scores, 10);
        for (int score : scores) {
            System.out.println(score);
        }
    }

    public static int total(int[] values) {
        int sum = 0;
        for (int value : values) {
            sum += value;
        }
        return sum;
    }

    public static void addBonus(int[] values, int bonus) {
        for (int i = 0; i < values.length; i++) {
            values[i] += bonus;
        }
    }
}
```

**Output**

```text
Total: 19
14
19
16
```

`addBonus` changed `main`'s array. As with lists in module 14, an array variable doesn't hold the elements themselves but a reference to the array. The method gets a copy of that reference, and the copy leads to the same array, so the change shows in `main` too. (Module 10's rule still holds: the parameter is a copy, but what's copied is the reference.)

Assignment works the same way as with lists. `int[] other = scores;` doesn't copy the array: it gives the same array a second name, and `other[0] = 1;` changes `scores[0]` too.

## Returning a new array

A method can also create an array and return it. The return type is the array type:

```java
public class Main {
    public static void main(String[] args) {
        int[] prices = {10, 25, 40};
        int[] sale = halved(prices);
        for (int i = 0; i < prices.length; i++) {
            System.out.println(prices[i] + " on sale: " + sale[i]);
        }
    }

    public static int[] halved(int[] values) {
        int[] result = new int[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = values[i] / 2;
        }
        return result;
    }
}
```

**Output**

```text
10 on sale: 5
25 on sale: 12
40 on sale: 20
```

`halved` makes a new array of the same length with `new`, fills it, and returns it. The original prices stay as they were. So a method that changes the array it's given is the right tool when the caller wants the change, and one that returns a new array is right when the original must be kept.

The checks in this step create an array and pass it to your method, for example `int[] values = {3, 8, 5, 10};` and then `System.out.println(countAbove(values, 4));`.

---

Source: [Arrays and methods](https://javaarena.com/learn/arrays/arrays-and-methods/) in the module [Arrays](https://javaarena.com/learn/arrays/) on Java Arena.

This module follows section [3.3 Arrays](https://java-programming.mooc.fi/part-3/3-arrays) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
