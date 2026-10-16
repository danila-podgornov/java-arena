// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step08_abstract_classes_and_abstract_methods_ai.challenge02_ai;

public class Main {
    /**
     * In a museum, every exhibit is kept in some room, but which room depends on the kind of exhibit. Fill in the two blanks, the same word in both, so that {@code Exhibit} can't be created with {@code new}, and its subclasses must write {@code room()}.
     * Hints
     * 1. The same word goes before {@code class} in the class's header, and before the return type of a method that has no body.
     * 2. {@code public abstract class Exhibit} and {@code public abstract String room();}. A method without a body is allowed only when it's abstract, and only an abstract class may have one.
     */
    public static void main(String[] args) {
        Exhibit lion = new Statue("Marble lion", 900);
        Exhibit bust = new Statue("Bronze bust", 40);
        System.out.println(lion.label());
        System.out.println(bust.label());
    }
}
