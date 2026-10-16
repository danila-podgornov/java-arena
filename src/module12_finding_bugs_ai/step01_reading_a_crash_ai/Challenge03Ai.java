// AI-Generated
package module12_finding_bugs_ai.step01_reading_a_crash_ai;

public class Challenge03Ai {
    /**
     * Here is a crash from a program you can't see:
     * <p>The program crashes with
     * <pre>{@code
     * Exception in thread "main" java.lang.ArithmeticException: / by zero
     * 	at Main.average(Main.java:14)
     * 	at Main.report(Main.java:9)
     * 	at Main.main(Main.java:4)
     * }</pre>
     * <p>Fill in the blanks: the method the crash happened in, and the line of {@code main} that started the call.
     * Hints
     * 1. The first {@code at} line is where the crash happened; the last one is in {@code main}.
     * 2. The method is {@code average}, and {@code main} was on line 4.
     */
    public static void main(String[] args) {
        String crashedIn = "___";
        int mainLine = ___;
        System.out.println(crashedIn + " was called from line " + mainLine);
    }
}
