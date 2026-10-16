// AI-Generated
package module42_exceptions_ai.step07_the_details_of_an_exception_ai;

public class Challenge01Ai {
    /**
     * Here's a crash from a booking program you can't see. Fill in the blanks: the class whose code threw the exception, the line it was thrown on, and the line of {@code main} where it all started.
     * <p>The program crashes with
     * <pre>{@code
     * Exception in thread "main" java.lang.IllegalStateException: seat 12 is taken
     * 	at SeatMap.reserve(SeatMap.java:14)
     * 	at TicketOrder.<init>(TicketOrder.java:9)
     * 	at Main.main(Main.java:6)
     * }</pre>
     * <p>The program then prints: see the expected output below.
     * Expected output
     * {@code Thrown in SeatMap on line 14, started on line 6 of main}
     * Hints
     * 1. The top {@code at} line is where the exception was thrown: the class and the method come before the parentheses, the file and the line inside them.
     * 2. The bottom line is in {@code main}. {@code <init>} in the middle line is a constructor: TicketOrder's constructor called {@code reserve}.
     */
    public static void main(String[] args) {
        String thrownIn = "___";
        int thrownOn = ___;
        int mainLine = ___;
        System.out.println("Thrown in " + thrownIn + " on line " + thrownOn + ", started on line " + mainLine + " of main");
    }
}
