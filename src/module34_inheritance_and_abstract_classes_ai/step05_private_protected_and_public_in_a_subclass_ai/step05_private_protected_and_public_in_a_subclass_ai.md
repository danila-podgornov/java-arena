> [!info] AI-Generated

# private, protected and public in a subclass

A subclass object holds everything its superclass has, private variables too. But the subclass's own code may use only what the superclass lets it use. This step is about those rules.

## private stays private

The bank from step 3 wants its savings accounts to earn interest. A first try at `addInterest` changes the balance directly:

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount("Mia", 500, 3);
        savings.addInterest();
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

    public void addInterest() {
        int interest = this.getBalance() * this.interestPercent / 100;
        this.balance += interest;
    }
}
```

**What javac prints**

```text
SavingsAccount.java:11: error: balance has private access in BankAccount
        this.balance += interest;
            ^
1 error
```

Every SavingsAccount object has a balance: it's in the BankAccount part of the object. But `private` means that only BankAccount's own code may use the variable, and SavingsAccount's code isn't BankAccount's code. The same goes for private methods: a subclass can't call them.

## Use the superclass's public methods

Usually the best fix is to use what BankAccount offers everyone. `getBalance()` gives the balance, and `deposit(...)` adds to it:

```java
public void addInterest() {
    int interest = this.getBalance() * this.interestPercent / 100;
    this.deposit(interest);
}
```

This way BankAccount stays the only class that changes the balance directly, and its rules still hold: `deposit` ignores an amount of 0 or less, so interest can't sneak in a negative amount.

## protected

Sometimes the public methods aren't enough. A checking account may go below zero, down to its overdraft limit. In the program below, BankAccount has a `withdraw` that refuses to take more than the balance, and none of its public methods can make a balance negative. So BankAccount marks the balance **protected**: its subclasses may use it directly.

**Main.java**

```java
public class Main {
    public static void main(String[] args) {
        BankAccount plain = new BankAccount("Leo", 100);
        plain.withdraw(150);
        System.out.println(plain.getBalance());

        CheckingAccount checking = new CheckingAccount("Ada", 100, 200);
        checking.withdraw(150);
        System.out.println(checking.getBalance());

        SavingsAccount savings = new SavingsAccount("Mia", 500, 3);
        savings.addInterest();
        System.out.println(savings.getBalance());
    }
}
```

**BankAccount.java**

```java
public class BankAccount {
    private String owner;
    protected int balance;

    public BankAccount(String owner, int balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance) {
            this.balance -= amount;
        }
    }
}
```

**CheckingAccount.java**

```java
public class CheckingAccount extends BankAccount {
    private int overdraftLimit;

    public CheckingAccount(String owner, int balance, int overdraftLimit) {
        super(owner, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.balance + this.overdraftLimit) {
            this.balance -= amount;
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

    public void addInterest() {
        int interest = this.getBalance() * this.interestPercent / 100;
        this.deposit(interest);
    }
}
```

**Output**

```text
100
-50
515
```

- The plain account refuses to pay out 150 from 100. CheckingAccount overrides `withdraw` with its own rule, and changes `this.balance` directly, which `protected` allows.
- SavingsAccount still uses the public methods. `protected` allows direct use; it doesn't require it.
- `protected` also lets in every class in the same **package**. A package is a group of classes that belong together, such as Java's own `java.util`. The programs in this course have no `package` line, so all their classes are in one package, the default one, and there even `Main` could use `balance` directly. So in these programs, `protected` is more a note to other programmers ("subclasses may use this") than a lock.

## The four levels

| Written before a variable or method | Who can use it |
| --- | --- |
| `private` | only the class itself |
| nothing | classes in the same package |
| `protected` | classes in the same package, and subclasses |
| `public` | every class |

A good habit: keep instance variables `private`, and let subclasses work through methods. Make a variable `protected` only when the subclasses really need it, as CheckingAccount did.

One more rule: an overriding method can't be less visible than the method it overrides. Object's `toString` is `public`, so a `toString` that is `private`, `protected` or has nothing written before it doesn't compile: javac says `attempting to assign weaker access privileges; was public`.

---

Source: [private, protected and public in a subclass](https://javaarena.com/learn/inheritance/protected/) in the module [Inheritance and abstract classes](https://javaarena.com/learn/inheritance/) on Java Arena.

This module follows section [9.1 Class inheritance](https://java-programming.mooc.fi/part-9/1-inheritance) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
