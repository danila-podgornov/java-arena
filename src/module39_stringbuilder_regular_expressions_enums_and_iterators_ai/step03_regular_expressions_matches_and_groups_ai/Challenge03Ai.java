// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step03_regular_expressions_matches_and_groups_ai;

public class Challenge03Ai {
    /**
     * The text UI of a notes app, like the ones in module 25, understands six commands: {@code add note}, {@code add task}, {@code remove note}, {@code remove task}, {@code list} and {@code quit}. Write the method {@code isCommand(String line)}, which returns whether a line is one of them, with a single call to {@code matches}. The check runs:
     * <pre>{@code
     * System.out.println(isCommand("add task"));
     * System.out.println(isCommand("list"));
     * System.out.println(isCommand("list task"));
     * System.out.println(isCommand("add"));
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * true
     * true
     * false
     * false
     * }</pre>
     * Hints
     * 1. Four of the commands are two words: {@code add} or {@code remove}, a space, and {@code note} or {@code task}. That part is two groups, as for the ferry's tickets. The other two commands are single words.
     * 2. Put the three choices together with {@code |} outside the groups: {@code (add|remove) (note|task)|list|quit}.
     */
    public static void main(String[] args) {
        System.out.println(isCommand("add task"));
        System.out.println(isCommand("list"));
        System.out.println(isCommand("list task"));
        System.out.println(isCommand("add"));
    }

    public static boolean isCommand(String line) {
        return false;
    }
}
