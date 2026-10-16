// AI-Generated
package module37_streams_and_lambdas_ai.step02_lambda_expressions_and_method_references_ai;

import java.util.ArrayList;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. The first filter keeps the titles whose length is odd, and {@code substring(0, 3)} is a title's first three letters. The second stream starts again from the whole list, and {@code ||} lets a title through when either test is true.
     * 2. Walden and Hamlet have 6 letters, Candide and Ulysses have 7, so the first stream prints Can and Uly. Walden starts with W and Hamlet ends with t; Candide and Ulysses do neither.
     */
    public static void main(String[] args) {
        ArrayList<String> titles = new ArrayList<>();
        titles.add("Walden");
        titles.add("Hamlet");
        titles.add("Candide");
        titles.add("Ulysses");

        titles.stream().filter(title -> {
            int length = title.length();
            return length % 2 == 1;
        }).forEach(title -> {
            System.out.println(title.substring(0, 3));
        });
        titles.stream()
                .filter(title -> title.startsWith("W") || title.endsWith("t"))
                .forEach(System.out::println);
    }
}
