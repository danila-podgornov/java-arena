> [!info] AI-Generated

# Base case and return value

The methods of step 1 printed something and returned nothing. A recursive method can also return a value, and that's where recursion gets useful: the method builds its answer from the answer to a smaller problem.

## Counting digits

How many digits does a whole number have? A number below 10 has one digit. A larger number has one digit more than the number without its last digit, and `n / 10` drops the last digit (module 4): 4096 has one digit more than 409.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(digits(7));
        System.out.println(digits(4096));
    }

    public static int digits(int n) {
        if (n < 10) {
            return 1;
        }
        return 1 + digits(n / 10);
    }
}
```

**Output**

```text
1
4
```

Read the method as two sentences: "a number below 10 has 1 digit" and "any other number has 1 more digit than `n / 10`". The base case answers the smallest problem directly; the recursive case trusts the recursive call to give the right answer for the smaller problem, and adds its own part.

## Following the calls

`digits(4096)` can't return until it knows `digits(409)`, which waits for `digits(40)`, which waits for `digits(4)`. That one is a base case, and returns 1. Then the waiting calls finish, from the newest to the oldest, each adding 1 to what it got back:

```text
digits(4096) = 1 + digits(409)
                   digits(409) = 1 + digits(40)
                                     digits(40) = 1 + digits(4)
                                                      digits(4) = 1
                                     digits(40) = 1 + 1 = 2
                   digits(409) = 1 + 2 = 3
digits(4096) = 1 + 3 = 4
```

Two questions check a recursive method:

1. Is every base case answered correctly, without a recursive call?
2. Does every other input get closer to a base case with each call? Here, dividing by 10 makes any number of 10 or more smaller, so the calls end up below 10.

If both are true, and the recursive case is right whenever the smaller call returns the right answer, the method is right for every input.

## Where the base case comes from

Choose the smallest input for which the answer is obvious. For a sum of the numbers from 1 to n, that's n = 0: there's nothing to add, and the sum is 0. Picking 0 rather than 1 also makes the method work when it's called with 0.

---

Source: [Base case and return value](https://javaarena.com/learn/recursion/base-case-and-return/) in the module [Recursion](https://javaarena.com/learn/recursion/) on Java Arena.

An extra module, not part of the University of Helsinki's course. Lesson text: [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/).
