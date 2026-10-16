// AI-Generated
package module35_interfaces_ai.step05_lists_of_an_interface_and_interfaces_as_return_types_ai.challenge03_ai;

public class Main {
    /**
     * The player reads its queue from lines of text such as {@code memo,Groceries,45} or {@code show,Morning News,5}: the kind, the title, and the length, in seconds for a memo and in minutes for a show. Write the method {@code fromLine(String line)}, which makes a new VoiceMemo or a new RadioShow from the line and returns it. Its return type is Playable, so the caller doesn't need to know which class it gets. The kind is always {@code memo} or {@code show}. The check runs:
     * <pre>{@code
     * Playable first = fromLine("memo,Groceries,45");
     * Playable second = fromLine("show,Morning News,5");
     * first.play();
     * second.play();
     * System.out.println(first.seconds() + second.seconds());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Memo: Groceries
     * On air: Morning News
     * 345
     * }</pre>
     * Hints
     * 1. The header is {@code public static Playable fromLine(String line)}. {@code line.split(",")} gives the three parts, and {@code Integer.valueOf(parts[2])} turns the length into an int.
     * 2. If {@code parts[0]} equals {@code memo}, return {@code new VoiceMemo(parts[1], length)}; otherwise return {@code new RadioShow(parts[1], length)}. Both fit the return type Playable.
     */
    public static void main(String[] args) {
        Playable first = fromLine("memo,Groceries,45");
        Playable second = fromLine("show,Morning News,5");
        first.play();
        second.play();
        System.out.println(first.seconds() + second.seconds());
    }

    // Write the method fromLine here.
}
