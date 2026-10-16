// AI-Generated
package module39_stringbuilder_regular_expressions_enums_and_iterators_ai.step04_quantifiers_and_character_classes_ai;

public class Challenge02Ai {
    /**
     * What does this program print?
     * Hints
     * 1. {@code [0-9]{4,6}} is four to six digits, and nothing else: seven digits are too many, and a space isn't a digit.
     * 2. {@code [A-Z][a-z]*} is one capital letter followed by any number of small letters, zero too. The last regex is {@code [A-Z][a-z]*(-[A-Z][a-z]*)?}: a name, and optionally a dash and a second name.
     */
    public static void main(String[] args) {
        String pin = "[0-9]{4,6}";
        System.out.println("0815".matches(pin) + " " + "123".matches(pin));
        System.out.println("1234567".matches(pin) + " " + "12 34".matches(pin));
        String name = "[A-Z][a-z]*";
        System.out.println("Bo".matches(name) + " " + "B".matches(name) + " " + "bo".matches(name));
        System.out.println("Ann-Marie".matches(name + "(-" + name + ")?"));
    }
}
