> [!info] AI-Generated

# Constructors and super(...)

Step 2's classes had no constructors, so they got the default ones. Most classes have constructors that take values: a bank account needs an owner and a starting balance. How does a subclass hand values to its superclass's constructor?

## super(...)

A bank has plain accounts, and savings accounts that also earn interest at some rate. (Amounts are in whole dollars here, to keep the numbers short.)

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Mia", 500, 3);
        savings.deposit(100);
        System.out.println(savings.getOwner());
        System.out.println(savings.getBalance());
        System.out.println(savings.getInterestPercent());
    }
}
```

**BankAccount.java**

```java
public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }
}
```

**SavingsAccount.java**

```java
public class SavingsAccount extends BankAccount {
    private int interestPercent;

    public SavingsAccount(String owner, int balance, int interestPercent) {
        super(owner, balance);
        this.interestPercent = interestPercent;
    }

    public int getInterestPercent() {
        return this.interestPercent;
    }
}
```

**Output**

```text
Mia
600
3
```

- A subclass doesn't inherit constructors. `SavingsAccount` writes its own, which takes all three values.
- `super(owner, balance);` calls BankAccount's constructor with the owner and the balance. It sets up the BankAccount part of the object. It has to be BankAccount's constructor that does this: `owner` and `balance` are private to BankAccount, so SavingsAccount's code can't set them itself.
- After it, the constructor sets up what SavingsAccount adds, the interest rate.
- `super(...)` works like module 21's `this(...)`, which called another constructor of the same class. And the same rule holds: it must be the first statement of the constructor. In Java 21, the version this course runs, nothing may come before it.

## The parent's part comes first

A line printed in each constructor shows the order:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Mia", 500, 3);
        BankAccount plain = new BankAccount("Leo", 80);
    }
}
```

**BankAccount.java**

```java
public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
        System.out.println("Opening an account for " + owner);
    }
}
```

**SavingsAccount.java**

```java
public class SavingsAccount extends BankAccount {
    private int interestPercent;

    public SavingsAccount(String owner, int balance, int interestPercent) {
        super(owner, balance);
        this.interestPercent = interestPercent;
        System.out.println("Adding interest of " + interestPercent + "%");
    }
}
```

**Output**

```text
Opening an account for Mia
Adding interest of 3%
Opening an account for Leo
```

`new SavingsAccount(...)` runs SavingsAccount's constructor. Its first line runs BankAccount's constructor all the way through, and only then does the rest of SavingsAccount's constructor run. An object is built from the top down: first the parent's part, then the child's. (BankAccount's constructor, in turn, first runs Object's, which does nothing you can see.)

## When super(...) is missing

If a constructor doesn't start with `super(...)` or `this(...)`, Java puts `super();` there for you: a call to the superclass's constructor without parameters. That's what happened in step 2. Violin had no constructor at all, so it got the default one, which does nothing but call `super()`, and Instrument had the default constructor too.

BankAccount has no constructor without parameters. So a SavingsAccount constructor that forgets `super(...)` doesn't compile:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Mia", 500, 3);
    }
}
```

**BankAccount.java**

```java
public class BankAccount {
    private String owner;
    private int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }
}
```

**SavingsAccount.java**

```java
public class SavingsAccount extends BankAccount {
    private int interestPercent;

    public SavingsAccount(String owner, int balance, int interestPercent) {
        this.interestPercent = interestPercent;
    }
}
```

**What javac prints**

```text
SavingsAccount.java:4: error: constructor BankAccount in class BankAccount cannot be applied to given types;
    public SavingsAccount(String owner, int balance, int interestPercent) {
                                                                          ^
  required: String,int
  found:    no arguments
  reason: actual and formal argument lists differ in length
1 error
```

javac points at the `{` that opens the constructor's body, where the hidden `super();` would be: BankAccount's constructor needs a String and an int, and it was given nothing. The fix is the line `super(owner, balance);`.

---

Source: [Constructors and super(...)](https://javaarena.com/learn/inheritance/super-constructor/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
