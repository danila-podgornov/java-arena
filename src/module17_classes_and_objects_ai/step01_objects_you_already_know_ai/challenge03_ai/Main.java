// AI-Generated
package module17_classes_and_objects_ai.step01_objects_you_already_know_ai.challenge03_ai;

import java.util.Scanner;

public class Main {
    /**
     * {@code Poll.java} holds a class for a quick vote. Write {@code Main}: the first line of input is the question, and every line after it is a vote, {@code y} or {@code n}, until the line {@code end}. Create a Poll for the question, give it each vote with {@code voteYes()} or {@code voteNo()}, and at the end call {@code printResult()}. The poll does the counting, so {@code Main} needs no counters of its own. For the input {@code Pizza on Friday?}, {@code y}, {@code n}, {@code y} and {@code end}, one per line, the program prints: see the expected output below.
     * Expected output
     * <pre>{@code
     * Pizza on Friday?
     * Yes 2, no 1
     * }</pre>
     * Hints
     * 1. Create the poll before the loop, so the same poll gets every vote: {@code Poll poll = new Poll(question);}.
     * 2. In the loop, read a line and {@code break} at {@code end}. For {@code y} call {@code poll.voteYes();}, for {@code n} call {@code poll.voteNo();}. After the loop, {@code poll.printResult();}.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String question = scanner.nextLine();

    }
}
