// AI-Generated
package module49_gui_event_handling_ai.step04_logic_in_a_class_of_its_own_ai.challenge01_ai;

public class Main {
    /**
     * A sign-up page checks whether a username is free, against the names already taken. Write the class {@code UsernameChecker}, without anything from JavaFX, with:
     * <ul>
     * <li>a constructor that takes no parameters: at first, no name is taken
     * <li>{@code addTaken(String name)}, which marks a name as taken
     * <li>{@code isFree(String name)}, which returns {@code true} when the name has at least 3 characters and isn't taken
     * <li>{@code message(String name)}, which returns {@code At least 3 characters} for a name of fewer than 3 characters, the name and {@code  is taken} for a taken one ({@code ada is taken}), and the name and {@code  is free} otherwise ({@code ada_l is free})
     * </ul>
     * <p>Capital letters don't matter when comparing names: after {@code addTaken("Ada")}, {@code ADA} and {@code ada} are taken too. The message shows the name as it was given. The check runs:
     * <pre>{@code
     * UsernameChecker checker = new UsernameChecker();
     * checker.addTaken("admin");
     * checker.addTaken("Ada");
     * System.out.println(checker.message("ad"));
     * System.out.println(checker.message("ADA"));
     * System.out.println(checker.message("ada_l"));
     * System.out.println(checker.isFree("Admin") + " " + checker.isFree("linus"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * At least 3 characters
     * ADA is taken
     * ada_l is free
     * false true
     * }</pre>
     * Hints
     * 1. Keep the taken names in an {@code ArrayList<String>}, made in the constructor. Store each name in small letters ({@code name.toLowerCase()}), and compare in small letters too: {@code this.taken.contains(name.toLowerCase())}.
     * 2. {@code message} checks the length first, then whether the name is taken: {@code return name + " is taken";}. {@code isFree} is {@code true} when both checks pass.
     */
    public static void main(String[] args) {
        UsernameChecker checker = new UsernameChecker();
        checker.addTaken("admin");
        checker.addTaken("Ada");
        System.out.println(checker.message("ad"));
        System.out.println(checker.message("ADA"));
        System.out.println(checker.message("ada_l"));
        System.out.println(checker.isFree("Admin") + " " + checker.isFree("linus"));
    }
}
