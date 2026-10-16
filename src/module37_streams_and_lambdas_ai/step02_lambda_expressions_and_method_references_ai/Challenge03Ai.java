// AI-Generated
package module37_streams_and_lambdas_ai.step02_lambda_expressions_and_method_references_ai;

import java.util.ArrayList;

public class Challenge03Ai {
    /**
     * {@code countStartingWith} should count the titles that start with the given text, but it doesn't compile. Read javac's message, and rewrite the method's body with a stream that uses {@code filter} and {@code count}, with no variable of your own for the count. Keep the header as it is. The check runs:
     * <pre>{@code
     * ArrayList<String> titles = new ArrayList<>();
     * titles.add("The Hobbit");
     * titles.add("Beloved");
     * titles.add("The Road");
     * titles.add("Theo");
     * System.out.println(countStartingWith(titles, "The "));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * {@code 2}
     * Hints
     * 1. javac says that {@code count} must be *effectively final*: a lambda can't change a variable of its method. The stream can count by itself.
     * 2. Let {@code filter} keep the titles for which {@code title.startsWith(start)} is true, and return what {@code count()} gives: {@code return titles.stream().filter(title -> title.startsWith(start)).count();}
     */
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("The Hobbit");
        titles.add("Beloved");
        titles.add("The Road");
        titles.add("Theo");
        System.out.println(countStartingWith(titles, "The "));
    }

    public static long countStartingWith(ArrayList<String> titles, String start) {
        long count = 0;
        titles.stream().forEach(title -> {
            if (title.startsWith(start)) {
                count++;
            }
        });
        return count;
    }
}
