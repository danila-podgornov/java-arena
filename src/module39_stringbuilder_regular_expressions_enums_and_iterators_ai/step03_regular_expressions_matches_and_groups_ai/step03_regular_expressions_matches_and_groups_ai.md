> [!info] AI-Generated

# Regular expressions: matches, | and groups

Is `KTX-0415` a booking code of the right form? Is `9021O` a postcode, or a typo with the letter O in it? Checking the form of a string with `charAt` and loops takes many lines. A **regular expression**, or **regex** for short, describes a form in one short String, and String's method `matches` checks whether a string has that form.

## matches

```java
System.out.println("yes".matches("yes"));
System.out.println("Yes".matches("yes"));
System.out.println("yes!".matches("yes"));
```

**Output**

```text
true
false
false
```

- Letters and digits in a regex stand for themselves, so the regex `yes` describes exactly the text yes.
- Upper and lower case differ, as they do for `equals`.
- The **whole** string must fit the regex: `yes!` has a `!` left over.

So far, that's what `equals` does. The rest of this step and the next are what `equals` can't do.

## Alternation: |

A `|` means "or". The regex `yes|y|ok` describes three texts, and a string matches if it's any one of them:

```java
String[] answers = {"yes", "y", "ok", "okay", "no"};
for (String answer : answers) {
    System.out.println(answer + ": " + answer.matches("yes|y|ok"));
}
```

**Output**

```text
yes: true
y: true
ok: true
okay: false
no: false
```

`okay` begins with `ok`, but the whole string has to fit one of the three.

## Groups: ( )

A `|` splits the whole regex in two. A ferry sells four kinds of tickets: `adult single`, `adult return`, `child single` and `child return`. The regex `adult|child single|return` would mean three choices: `adult`, `child single` or `return`. Parentheses make a **group**, and a `|` inside a group chooses only there:

```java
String ticket = "(adult|child) (single|return)";
System.out.println("child return".matches(ticket));
System.out.println("adult single".matches(ticket));
System.out.println("adult".matches(ticket));
System.out.println("senior single".matches(ticket));
```

**Output**

```text
true
true
false
false
```

The regex describes four texts: one of the words in the first group, a space, and one of the words in the second group. A group can be a part of a word, too: `gr(a|e)y` matches both gray and grey.

```java
System.out.println("grey".matches("gr(a|e)y") + " " + "gray".matches("gr(a|e)y") + " " + "groy".matches("gr(a|e)y"));
```

**Output**

```text
true true false
```

## Characters with a meaning of their own

`|`, `(` and `)` aren't matched as themselves: they're part of the regex's own language. So are a few more characters, `. * + ? [ { ^ $ \`, and also `]` and `}` when they close a `[` or a `{`. Step 4 gives most of them their meaning. (`^` and `$` mark the start and the end of the text, which `matches` checks anyway.) Letters, digits, spaces, dashes and colons are plain characters. To match a special character as itself, put `\\` in front of it in the Java String: in a regex, a backslash takes the special meaning away, and in a Java String, `\\` is how you write one backslash.

```java
System.out.println("(1)".matches("\\(1\\)"));
```

**Output**

```text
true
```

---

Source: [Regular expressions: matches, | and groups](https://javaarena.com/learn/useful-techniques/regular-expressions/) in the module [StringBuilder, regular expressions, enums and iterators](https://javaarena.com/learn/useful-techniques/) on Java Arena.

This module follows sections [10.3 Other useful techniques](https://java-programming.mooc.fi/part-10/3-other-useful-techniques), [10.4 Summary](https://java-programming.mooc.fi/part-10/4-summary) of [Java Programming](https://java-programming.mooc.fi) by Arto Hellas, Matti Luukkainen and contributors (Agile Education Research group, University of Helsinki), licensed under [CC BY-NC-SA 4.0](https://creativecommons.org/licenses/by-nc-sa/4.0/). The explanations and exercises here are written for Java Arena and shared under the same license. Java Arena is not affiliated with or endorsed by the University of Helsinki.
