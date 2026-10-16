// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step02_stringbuilder_building_a_text_piece_by_piece_ai;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. {@code append("s")} gives {@code cats}, and it returns the same StringBuilder, so {@code insert(0, "3 ")} adds to its front: {@code 3 cats}, which is 6 characters long, the space included.
     * 2. {@code reverse()} turns the whole text around, the space too. {@code same = text} makes no copy: both variables refer to the one StringBuilder, so the {@code !} shows up when {@code text} is printed.
     */
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder("cat");
        text.append("s").insert(0, "3 ");
        System.out.println(text + " " + text.length());
        text.reverse();
        System.out.println(text);
        StringBuilder same = text;
        same.append("!");
        System.out.println(text);
    }
}
