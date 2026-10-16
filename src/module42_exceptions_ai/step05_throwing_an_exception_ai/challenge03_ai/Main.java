// AI-Generated
package module42_exceptions_ai.step05_throwing_an_exception_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * {@code Transfer.java} is the class from the lesson, with one more check and a getter. The sender and the receiver must be different people, or the constructor throws an IllegalArgumentException with the message {@code Can't send money to yourself}, and {@code getAmount()} returns the amount.
     * <p>Write {@code main}. It reads lines until an empty line. Each line has a sender, a receiver and an amount, separated by commas, such as {@code Maya,Leo,40}. For each line, create a Transfer and print {@code Sent: } and the transfer. When the constructor refuses, print {@code Refused: } and its message. When the amount isn't a whole number, print {@code Refused: } and the amount in quotes, followed by {@code  is not an amount}. At the end, print {@code Sent in all: }, the sum of the amounts sent, and {@code  dollars}. Every line has three parts.
     * <p>A NumberFormatException is an IllegalArgumentException too, so mind the order of the {@code catch} blocks. For the input shown, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Sent: Maya -> Leo: 40 dollars
     * Refused: The amount must be positive, not -5
     * Refused: "ten" is not an amount
     * Refused: Can't send money to yourself
     * Sent in all: 40 dollars
     * }</pre>
     * Hints
     * 1. Split each line at the commas, and create the Transfer inside a {@code try} block, with {@code Integer.parseInt(parts[2])} as the amount. Add the amount to the sum only after the transfer was created.
     * 2. Two {@code catch} blocks: {@code NumberFormatException} first, then {@code IllegalArgumentException}. The other way around, javac refuses: the first block would already catch every NumberFormatException.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}
