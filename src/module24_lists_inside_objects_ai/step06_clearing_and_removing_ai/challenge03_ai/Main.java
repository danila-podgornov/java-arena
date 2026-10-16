// AI-Generated
package module24_lists_inside_objects_ai.step06_clearing_and_removing_ai.challenge03_ai;

public class Main {
    /**
     * A sign-up sheet for a school trip keeps a list of names, and someone may have signed up more than once by mistake. {@code SignUpSheet.java} has the list, {@code signUp(String name)} and toString. Write two methods:
     * <ul>
     * <li>{@code cancel(String name)} removes every entry of that name, and returns how many it removed.
     * <li>{@code reset()} empties the sheet.
     * </ul>
     * <p>The check runs:
     * <pre>{@code
     * SignUpSheet sheet = new SignUpSheet();
     * sheet.signUp("Ada");
     * sheet.signUp("Ben");
     * sheet.signUp("Ada");
     * sheet.signUp("Ada");
     * sheet.signUp("Cleo");
     * System.out.println(sheet.cancel("Ada"));
     * System.out.println(sheet);
     * System.out.println(sheet.cancel("Zoe"));
     * sheet.reset();
     * System.out.println(sheet);
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * 3
     * Signed up: [Ben, Cleo]
     * 0
     * Signed up: []
     * }</pre>
     * Hints
     * 1. {@code this.names.remove(name)} removes only the first copy. To remove them all and count them, loop over the indexes backwards, and when {@code this.names.get(i).equals(name)}, remove index {@code i} and add one to a counter.
     * 2. {@code reset} needs one line: {@code this.names.clear();}.
     */
    public static void main(String[] args) {
        SignUpSheet sheet = new SignUpSheet();
        sheet.signUp("Ada");
        sheet.signUp("Ben");
        sheet.signUp("Ada");
        sheet.signUp("Ada");
        sheet.signUp("Cleo");
        System.out.println(sheet.cancel("Ada"));
        System.out.println(sheet);
        System.out.println(sheet.cancel("Zoe"));
        sheet.reset();
        System.out.println(sheet);
    }
}
