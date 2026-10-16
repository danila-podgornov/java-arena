// AI-Generated
package module26_troubleshooting_and_unit_testing_ai.step01_bugs_and_troubleshooting_step_by_step_ai;

public class Challenge02Ai {
    /**
     * Here is a crash from a program you can't see:
     * <p>The program crashes with
     * <pre>{@code
     * Exception in thread "main" java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
     * 	at Shelf.bookAt(Shelf.java:18)
     * 	at Library.lastBookOn(Library.java:31)
     * 	at Main.main(Main.java:9)
     * }</pre>
     * <p>Fill in the blanks: the class whose code was running when it crashed, the method of {@code Library} that called it, and the line of {@code Library.java} that made the call.
     * Hints
     * 1. The top {@code at} line is where the crash happened, and the line under it is the method that called it.
     * 2. It crashed in {@code Shelf} (in its method {@code bookAt}), which was called by {@code lastBookOn} on line 31 of {@code Library.java}.
     */
    public static void main(String[] args) {
        String crashedClass = "___";
        String caller = "___";
        int callerLine = ___;
        System.out.println(crashedClass + " crashed, called by " + caller + " on line " + callerLine);
    }
}
