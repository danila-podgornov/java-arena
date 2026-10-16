// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step04_overriding_methods_override_and_super_ai.challenge03_ai;

import java.util.ArrayList;

public class Main {
    /**
     * The library keeps a list of returned magazines. {@code Magazine} has an {@code equals}, and it gives the right answer when you call it yourself, but the list's {@code contains} and {@code indexOf} never use it: the program prints {@code false} and {@code -1}. Put {@code @Override} above {@code equals} and see what javac says. Then fix the header, and the rest of the method, so that {@code equals} overrides Object's: the classic way, with {@code instanceof} and a cast. The program should print: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * 0
     * true
     * }</pre>
     * Hints
     * 1. With {@code @Override}, javac says the method doesn't override anything: {@code equals(Magazine other)} has a different parameter from Object's {@code equals(Object)}, so it's an overload, and the list calls Object's version.
     * 2. Write it as {@code public boolean equals(Object compared)}: {@code true} for {@code this == compared}, {@code false} when {@code !(compared instanceof Magazine)}, and otherwise {@code Magazine other = (Magazine) compared;} and the comparison that's there now.
     */
    public static void main(String[] args) {
        ArrayList<Magazine> returned = new ArrayList<>();
        returned.add(new Magazine("Sky Watch", 12));
        returned.add(new Magazine("Garden Days", 3));
        System.out.println(returned.contains(new Magazine("Garden Days", 3)));
        System.out.println(returned.indexOf(new Magazine("Sky Watch", 12)));
        Magazine mine = new Magazine("Sky Watch", 12);
        System.out.println(mine.equals(new Magazine("Sky Watch", 12)));
    }
}
