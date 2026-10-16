// AI-Generated
package module34_inheritance_and_abstract_classes_ai.step05_private_protected_and_public_in_a_subclass_ai.challenge02_ai;

public class Main {
    /**
     * A museum's exhibits have a condition from 0 to 100, which drops as they age. Only a restorer may raise it again, so {@code Exhibit} has no public method for that. Paintings can be restored. In {@code Exhibit.java}, make {@code condition} protected (not public). Then, in {@code Painting.java}, write the method {@code restore()}, which raises the condition by 30, but never above 100. The check runs:
     * <pre>{@code
     * Painting dawn = new Painting("Harbor at Dawn", 50);
     * dawn.restore();
     * System.out.println(dawn);
     * dawn.restore();
     * System.out.println(dawn);
     * dawn.age(15);
     * System.out.println(dawn.getCondition());
     * }</pre>
     * <p>and expects: see the expected output below.
     * Expected output
     * <pre>{@code
     * Harbor at Dawn, condition 80
     * Harbor at Dawn, condition 100
     * 85
     * }</pre>
     * Hints
     * 1. In Exhibit.java, the line becomes {@code protected int condition;}. Then Painting's code can use {@code this.condition} as if it were its own.
     * 2. {@code restore()} adds 30 with {@code this.condition += 30;}, and then, if the condition is over 100, sets it to 100, just as {@code age} keeps it from going below 0.
     */
    public static void main(String[] args) {
        Painting dawn = new Painting("Harbor at Dawn", 50);
        dawn.restore();
        System.out.println(dawn);
        dawn.restore();
        System.out.println(dawn);
        dawn.age(15);
        System.out.println(dawn.getCondition());
    }
}
