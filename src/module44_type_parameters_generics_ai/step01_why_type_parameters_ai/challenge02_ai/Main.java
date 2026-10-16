// AI-Generated
package module44_type_parameters_generics_ai.step01_why_type_parameters_ai.challenge02_ai;

public class Main {
    /**
     * Two boxes from the storeroom both hold a seven: one as a String, the other as an Integer. {@code Box} is the class from this step. What does this program print?
     * Hints
     * 1. For {@code label}, a {@code Box<String>}, {@code getContent()} returns a String, and a String plus a number joins them: {@code "7" + 1} is {@code 71}. For {@code count}, a {@code Box<Integer>}, it returns an Integer, so {@code + 1} adds.
     * 2. {@code label.getContent() + count.getContent()} is a String plus an Integer, which joins them into {@code 77}. {@code count} doubles to 14.
     */
    public static void main(String[] args) {
        Box<String> label = new Box<String>("7");
        Box<Integer> count = new Box<Integer>(7);
        System.out.println(label.getContent() + 1);
        System.out.println(count.getContent() + 1);
        label.setContent(label.getContent() + count.getContent());
        count.setContent(count.getContent() * 2);
        System.out.println(label.getContent() + " " + count.getContent());
    }
}
