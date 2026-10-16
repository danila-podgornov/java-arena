// AI-Generated
package module37_streams_and_lambdas_ai.step02_lambda_expressions_and_method_references_ai;

import java.util.ArrayList;

public class Challenge01Ai {
    /**
     * In {@code Main}, write the method {@code printLongTitles(ArrayList<String> titles, int limit)}. It prints, one per line, the titles that are longer than {@code limit} characters, in the list's order. Use a stream with {@code filter}, and end it with {@code forEach(System.out::println)}. The check runs:
     * <pre>{@code
     * ArrayList<String> titles = new ArrayList<>();
     * titles.add("Beloved");
     * titles.add("Emma");
     * titles.add("Middlemarch");
     * titles.add("Dune");
     * titles.add("Persuasion");
     * printLongTitles(titles, 7);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Middlemarch
     * Persuasion
     * }</pre>
     * Hints
     * 1. The header is {@code public static void printLongTitles(ArrayList<String> titles, int limit)}. Inside, the lambda may use {@code limit}, since the method never changes it.
     * 2. {@code titles.stream().filter(title -> title.length() > limit).forEach(System.out::println);}
     */
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Beloved");
        titles.add("Emma");
        titles.add("Middlemarch");
        titles.add("Dune");
        titles.add("Persuasion");
        printLongTitles(titles, 7);
    }

    // Write the method printLongTitles here.
}
